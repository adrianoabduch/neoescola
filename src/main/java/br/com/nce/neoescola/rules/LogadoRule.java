package br.com.nce.neoescola.rules;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.brutauth.auth.annotations.HandledBy;
import br.com.caelum.brutauth.auth.rules.CustomBrutauthRule;
import br.com.nce.neoescola.seguranca.UsuarioLogado;

@RequestScoped
@HandledBy(LogadoHandler.class)
public class LogadoRule implements CustomBrutauthRule {

	private UsuarioLogado usuarioLogado;

	/**
	 * @deprecated CDI eyes only
	 */
	protected LogadoRule() {
	}
	
	@Inject
	public LogadoRule(UsuarioLogado usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	public boolean isAllowed() {
		return usuarioLogado.isLogado();
	}
	
}
