package br.com.nce.neoescola.rules;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.brutauth.auth.annotations.CustomBrutauthRules;
import br.com.caelum.brutauth.auth.annotations.HandledBy;
import br.com.caelum.brutauth.auth.rules.CustomBrutauthRule;
import br.com.nce.neoescola.seguranca.UsuarioLogado;

@RequestScoped
@HandledBy(SemPermissaoHandler.class)
public class SecretariaFinanceiroRule implements CustomBrutauthRule {

	@Inject
	private UsuarioLogado usuarioLogado;

	public boolean isAllowed() {
		if(usuarioLogado.getUsuario() != null)
			return Boolean.TRUE.equals(usuarioLogado.getUsuario().getSecretariaFinanceiro()
					|| Boolean.TRUE.equals(usuarioLogado.getUsuario().getAdministrador()));
		
		return false;
	}
	
}
