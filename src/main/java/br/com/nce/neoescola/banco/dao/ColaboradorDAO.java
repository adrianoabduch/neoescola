package br.com.nce.neoescola.banco.dao;

import br.com.nce.neoescola.banco.entidades.Colaborador;

public interface ColaboradorDAO extends GenericEntidadeEscolaDAO<Colaborador> {
	
	public Colaborador buscaPorUsuarioId(Long usuarioId);
	
}
