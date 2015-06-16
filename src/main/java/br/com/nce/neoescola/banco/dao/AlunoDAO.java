package br.com.nce.neoescola.banco.dao;

import java.util.List;

import br.com.nce.neoescola.banco.entidades.Aluno;

public interface AlunoDAO extends GenericEntidadeEscolaDAO<Aluno> {
	
	public Aluno buscaPorUsuarioId(Long usuarioId);
	
}
