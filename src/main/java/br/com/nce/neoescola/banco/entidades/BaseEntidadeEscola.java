package br.com.nce.neoescola.banco.entidades;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * Superclasse para as todas as entidades filhas de uma escola.
 * @author Adriano
 *
 */
@MappedSuperclass
public class BaseEntidadeEscola extends BaseEntidade {

	@ManyToOne
	@JoinColumn(name="escolaid")
	private Escola escola;

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}
	
}
