package br.com.nce.neoescola.banco.entidades;

import javax.persistence.Entity;

@Entity
public class Unidade extends BaseEntidadeEscola {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
