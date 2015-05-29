package br.com.nce.neoescola.seguranca;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.nce.neoescola.tipo.TipoPerfil;

@Retention(RetentionPolicy.RUNTIME)
@Target( {ElementType.TYPE, ElementType.METHOD} )
public @interface Permissao {

	TipoPerfil[] value();
	
}
