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
public class UnidadesController {
	
	private UsuarioLogado usuarioLogado;
	private Result result;
	private UnidadeDAO unidadeDAO;
	
	/**
	 * @deprecated CDI eyes only
	 */
	protected UnidadesController() {
	}
	
	@Inject
	public UnidadesController(UnidadeDAO unidadeDAO,
			UsuarioLogado usuarioLogado, Result result) {
		this.unidadeDAO = unidadeDAO;
		this.usuarioLogado = usuarioLogado;
		this.result = result;
	}
	
	@Post
	@Path("/unidades/todas.json")
	public void todasJson() {
		result.use(Results.json()).withoutRoot()
			.from(unidadeDAO.buscaTodos())
			.serialize();
	}
}
