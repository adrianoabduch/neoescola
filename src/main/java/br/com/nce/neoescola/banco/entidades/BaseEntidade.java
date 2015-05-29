package br.com.nce.neoescola.banco.entidades;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

/**
 * Superclasse para as todas as entidades que não sejam filhas de uma escola.
 * @author Adriano
 *
 */
@MappedSuperclass
public class BaseEntidade {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NEOESCOLA_SEQUENCE")
	@SequenceGenerator(name = "NEOESCOLA_SEQUENCE", sequenceName = "neoescola_sequence", allocationSize = 10)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
