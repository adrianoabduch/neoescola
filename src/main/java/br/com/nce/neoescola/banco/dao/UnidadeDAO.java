package br.com.nce.neoescola.banco.dao;

import java.util.List;

import br.com.nce.neoescola.banco.entidades.Unidade;

public interface UnidadeDAO extends GenericEntidadeEscolaDAO<Unidade> {
	
	public List<Unidade> buscaListaPorNome(String nome);
	
}
