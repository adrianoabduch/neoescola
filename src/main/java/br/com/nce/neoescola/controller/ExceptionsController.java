package br.com.nce.neoescola.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import br.com.caelum.brutauth.auth.annotations.Public;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.nce.neoescola.commons.ExceptionData;

@Controller
public class ExceptionsController {
	
	private Result result;
	private HttpServletRequest request;

	/**
	 * @deprecated CDI eyes only
	 */
	public ExceptionsController() {
	}
	
	@Inject
	public ExceptionsController(Result result, HttpServletRequest request) {
		this.result = result;
		this.request = request;
		
	}
	
	
	@Public
	@Get("/erro")
	public void erro() {
		
		ExceptionData exceptionData = ExceptionData.fromRequest(request);
		
		result.include(exceptionData);
	}

}
