package br.com.nce.neoescola.rules;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.brutauth.auth.handlers.RuleHandler;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.nce.neoescola.controller.LoginController;

@RequestScoped
public class LogadoHandler implements RuleHandler {
	
	private Validator validator;
	private Result result;

	/**
	 * @deprecated CDI eyes only
	 */
	protected LogadoHandler() {
	}
	
	@Inject
	public LogadoHandler(Validator validator, Result result) {
		this.validator = validator;
		this.result = result;
	}
	
	@Override
	public void handle() {
		result.include("error", "Você não está logado.");
		result.redirectTo(LoginController.class).formulario();
	}

}
