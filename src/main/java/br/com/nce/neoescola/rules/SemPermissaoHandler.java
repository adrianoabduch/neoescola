package br.com.nce.neoescola.rules;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.brutauth.auth.handlers.RuleHandler;
import br.com.caelum.vraptor.Result;
import br.com.nce.neoescola.controller.LoginController;
import br.com.nce.neoescola.controller.RulesController;

@RequestScoped
public class SemPermissaoHandler implements RuleHandler {

	private Result result;

	/**
	 * @deprecated CDI eyes only
	 */
	public SemPermissaoHandler() {
	}

	@Inject
	public SemPermissaoHandler(Result result) {
		this.result = result;
	}
	
	@Override
	public void handle() {
		result.include("error", "Você não tem permissão para realizar esta ação.");
		result.redirectTo(RulesController.class).erro();
		
	}

}
