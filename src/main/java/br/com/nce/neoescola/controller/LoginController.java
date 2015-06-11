package br.com.nce.neoescola.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Severity;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.nce.neoescola.banco.dao.AlunoDAO;
import br.com.nce.neoescola.banco.dao.ColaboradorDAO;
import br.com.nce.neoescola.banco.dao.UsuarioDAO;
import br.com.nce.neoescola.banco.entidades.Aluno;
import br.com.nce.neoescola.banco.entidades.Colaborador;
import br.com.nce.neoescola.banco.entidades.Usuario;
import br.com.nce.neoescola.seguranca.Publico;
import br.com.nce.neoescola.seguranca.UsuarioLogado;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	private UsuarioDAO usuarioDAO;
	private UsuarioLogado usuarioLogado;
	private Result result;
	private AlunoDAO alunoDAO;
	private ColaboradorDAO colaboradorDAO;

	private Validator validator;
	
	/**
	 * @deprecated CDI eyes only
	 */
	public LoginController() {
		this(null, null, null, null, null, null);
	}

	@Inject
	public LoginController(UsuarioDAO usuarioDAO, AlunoDAO alunoDAO, ColaboradorDAO colaboradorDAO, 
			UsuarioLogado usuarioLogado, Result result, Validator validator) {
		this.usuarioDAO = usuarioDAO;
		this.alunoDAO = alunoDAO;
		this.colaboradorDAO = colaboradorDAO;
		this.usuarioLogado = usuarioLogado;
		this.result = result;
		this.validator = validator;
	}
	
	@Publico
	@Post("/autentica")
	public void autentica(Usuario usuario) {
		
//		validator.ensure(SenhaUtils.validarSenha(usuario.getSenha()), 
//			new SimpleMessage("senha", "Senha inválida.", Severity.ERROR, "teste"));
//			
//		validator.onErrorForwardTo(this).formulario();
		
		Usuario autenticado = usuarioDAO.buscaUsuarioPorEmailESenha(usuario);
		if(autenticado != null) {
			usuarioLogado.efetuaLogin(autenticado);
			Aluno aluno = alunoDAO.buscaPorUsuarioId(autenticado.getId());
			if(aluno != null) {
				usuarioLogado.setAluno(aluno);
			} else {
				Colaborador colaborador = colaboradorDAO.buscaPorUsuarioId(autenticado.getId());
				usuarioLogado.setColaborador(colaborador);
			}
			
			result.redirectTo(AlunosController.class).lista();
			
		} else {
			validator.add(new SimpleMessage("Erro de login.", "Usuário não encontrado.", Severity.ERROR, null));
			validator.onErrorRedirectTo(this).formulario();
		}
	}
	
	@Publico
	@Get("/login")
	public void formulario () {
	}
	
	@Get("/logout")
    public void logout() {
        usuarioLogado.logout();
        result.redirectTo(this).formulario();
    }
	

}
