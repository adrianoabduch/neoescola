package br.com.nce.neoescola.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
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
	
	/**
	 * @deprecated CDI eyes only
	 */
	public LoginController() {
		this(null, null, null, null, null);
	}

	@Inject
	public LoginController(UsuarioDAO usuarioDAO, AlunoDAO alunoDAO, ColaboradorDAO colaboradorDAO, 
			UsuarioLogado usuarioLogado, Result result) {
		this.usuarioDAO = usuarioDAO;
		this.alunoDAO = alunoDAO;
		this.colaboradorDAO = colaboradorDAO;
		this.usuarioLogado = usuarioLogado;
		this.result = result;
	}
	
	@Publico
	@Post("/autentica")
	public void autentica(Usuario usuario) {
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
			result.redirectTo(IndexController.class).testa();
		} else {
			result.redirectTo(this).formulario();
		}
	}
	
	@Publico
	@Get("/sistema")
	public void formulario () {
		logger.info("Entrou no formulário, deveria chamar o jsp");
	}
	
	@Get("/logout")
    public void logout() {
        usuarioLogado.logout();
        result.redirectTo(this).formulario();
    }
	

}
