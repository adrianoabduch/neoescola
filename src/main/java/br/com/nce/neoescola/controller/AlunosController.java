package br.com.nce.neoescola.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.nce.neoescola.banco.dao.AlunoDAO;
import br.com.nce.neoescola.banco.entidades.Aluno;
import br.com.nce.neoescola.seguranca.Permissao;
import br.com.nce.neoescola.tipo.TipoPerfil;

@Controller
@Permissao( {TipoPerfil.ADMINISTRADOR} )
public class AlunosController {
	
	private String nome;
	
	private AlunoDAO alunoDAO;
	
	/**
	 * @deprecated CDI eyes only
	 */
	protected AlunosController() {
		this(null);
	}
	
	@Inject
	public AlunosController(AlunoDAO alunoDAO) {
		this.alunoDAO = alunoDAO;
	}
	
	@Get("/alunos")
	@Permissao( {TipoPerfil.ADMINISTRADOR, TipoPerfil.DOCENTE, TipoPerfil.SECRETARIA_TODOS, TipoPerfil.SECRETARIA_CADASTROS} )
	public List<Aluno> lista() {
		return alunoDAO.buscaTodos();
	}
	
	@Get("/alunos/{id}")
	@Permissao( {TipoPerfil.ADMINISTRADOR, TipoPerfil.DOCENTE, TipoPerfil.SECRETARIA_TODOS, TipoPerfil.SECRETARIA_CADASTROS} )
	public Aluno dadosAluno(Long id) {
		return alunoDAO.buscaPorId(id);
	}
	
	@Post("/alunos")
	@Permissao( {TipoPerfil.ADMINISTRADOR, TipoPerfil.DOCENTE, TipoPerfil.SECRETARIA_TODOS, TipoPerfil.SECRETARIA_CADASTROS} )
	public void adiciona(Aluno aluno) {
		alunoDAO.salvar(aluno);
	}

}
