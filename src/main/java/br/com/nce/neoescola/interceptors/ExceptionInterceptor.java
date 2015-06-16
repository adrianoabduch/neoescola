package br.com.nce.neoescola.interceptors;

import javax.inject.Inject;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.nce.neoescola.controller.ExceptionsController;
import br.com.nce.neoescola.seguranca.UsuarioLogado;

@Intercepts
public class ExceptionInterceptor implements Interceptor {
	
	private Result result;
	private UsuarioLogado usuarioLogado;

	/**
	 * @deprecated CDI eyes only
	 */
	protected ExceptionInterceptor() {
	}

	@Inject
	public ExceptionInterceptor(Result result, UsuarioLogado usuarioLogado) {
		this.result = result;
		this.usuarioLogado = usuarioLogado;
	}

	@Override
	public boolean accepts(ControllerMethod arg0) {
		return true;
	}

	@Override
	public void intercept(InterceptorStack stack, 
			ControllerMethod method, Object instance) throws InterceptionException {
		
		result.on(Exception.class)
		.include("method", method.getMethod())
		.include("controller", method.getController())
		.include("usuario_logado", usuarioLogado)
		.redirectTo(ExceptionsController.class).erro();
		
		stack.next(method, instance);
		
	}

}
