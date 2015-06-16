package br.com.nce.neoescola.controller;

import javax.inject.Inject;

import br.com.caelum.brutauth.auth.annotations.Public;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

@Controller
public class RulesController {
	
	private Result result;

	/**
	 * @deprecated CDI eyes only
	 */
	public RulesController() {
	}
	
	@Inject
	public RulesController(Result result) {
		this.result = result;
		
	}
	
	@Public
	@Get("/acesso/erro")
	public void erro() {
	}

}
