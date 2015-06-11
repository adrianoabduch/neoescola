package br.com.nce.neoescola.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Result;

public class ErrosController {
	
	private Result result;

	/**
	 * @deprecated CDI eyes only
	 */
	public ErrosController() {
	}
	
	@Inject
	public ErrosController(Result result) {
		this.result = result;
	}
	
	public void erro() {
		
	}

}
