package br.com.nce.neoescola.seguranca;

import java.util.Arrays;
import java.util.Collection;

import javax.inject.Inject;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.view.Results;
import br.com.nce.neoescola.controller.LoginController;
import br.com.nce.neoescola.tipo.TipoPerfil;

@Intercepts
public class LoginInterceptor implements Interceptor {
	
	private UsuarioLogado usuarioLogado;
	private Result result;

	/**
	 * @deprecated CDI eyes only
	 */
	protected LoginInterceptor() {
		this(null, null);
	}
	
	@Inject
	public LoginInterceptor(UsuarioLogado usuarioLogado, Result result) {
		this.usuarioLogado = usuarioLogado;
		this.result = result;
	}
	
	private boolean hasAccess(Permissao permissao) {
	    if (permissao == null) {
	       return true;
	    }

	    Collection<TipoPerfil> perfilList = Arrays.asList(permissao.value());

    	return perfilList.contains(usuarioLogado.getUsuario().getPerfil());
    	
	}

	public boolean accepts(ControllerMethod method) {
		return !(method.getMethod().isAnnotationPresent(Publico.class) ||
	               method.getController().getType().isAnnotationPresent(Publico.class));
	}

	public void intercept(InterceptorStack stack, ControllerMethod method, Object instance) throws InterceptionException {
		Permissao methodPermission = method.getMethod().getAnnotation(Permissao.class);
	    Permissao controllerPermission = method.getController().getType().getAnnotation(Permissao.class);
	    
	    if(usuarioLogado.getUsuario() == null) {
	    	result.redirectTo(LoginController.class).formulario();
	    	return;
	    }
	    
	    if (this.hasAccess(methodPermission) && this.hasAccess(controllerPermission)) {
	       stack.next(method, instance);
	    } else {
	       result.use(Results.http()).sendError(403, "Você não tem permissão para tal ação!");
	    }
	}
	

}
