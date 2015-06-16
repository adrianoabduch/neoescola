package br.com.nce.neoescola.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.brutauth.auth.annotations.CustomBrutauthRules;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.nce.neoescola.banco.dao.AlunoDAO;
import br.com.nce.neoescola.banco.dao.UnidadeDAO;
import br.com.nce.neoescola.banco.entidades.Aluno;
import br.com.nce.neoescola.rules.AlunoRule;
import br.com.nce.neoescola.rules.LogadoRule;
import br.com.nce.neoescola.rules.SecretariaCadastrosRule;
import br.com.nce.neoescola.rules.SecretariaOuDocenteRule;
import br.com.nce.neoescola.seguranca.UsuarioLogado;

@Controller
@CustomBrutauthRules( {LogadoRule.class} )
public class AlunosController {
	
	private AlunoDAO alunoDAO;
	private UsuarioLogado usuarioLogado;
	private Result result;
	private UnidadeDAO unidadeDAO;
	
	/**
	 * @deprecated CDI eyes only
	 */
	protected AlunosController() {
	}
	
	@Inject
	public AlunosController(AlunoDAO alunoDAO, UnidadeDAO unidadeDAO,
			UsuarioLogado usuarioLogado, Result result) {
		this.alunoDAO = alunoDAO;
		this.unidadeDAO = unidadeDAO;
		this.usuarioLogado = usuarioLogado;
		this.result = result;
	}
	
	@Get("/alunos")
	@CustomBrutauthRules( {SecretariaOuDocenteRule.class} )
	public List<Aluno> lista() throws Exception {
		return alunoDAO.buscaTodos();
	}
	
	@Get("/alunos/{id}")
	@CustomBrutauthRules( {SecretariaOuDocenteRule.class} )
	public Aluno verAluno(Long id) {
		return alunoDAO.buscaPorId(id);
	}
	
	@Get("/alunos/editar/{id}")
	@CustomBrutauthRules( {SecretariaCadastrosRule.class} )
	public Aluno editarAluno(Long id) throws Exception {
		return alunoDAO.buscaPorId(id);
	}
	
	@Get("/alunos/meusDados")
	@CustomBrutauthRules( {AlunoRule.class} )
	public Aluno verAluno() {
		return alunoDAO.buscaPorId(usuarioLogado.getAluno().getId());
	}
	
	@Get("/alunos/novo")
	@CustomBrutauthRules( {SecretariaCadastrosRule.class} )
	public Aluno novoAluno() {
		return new Aluno();
	}
	
	@Post("/alunos")
	@CustomBrutauthRules( {SecretariaCadastrosRule.class} )
	public void salvar(Aluno aluno) {
		alunoDAO.salvar(aluno);
	}
	
}
