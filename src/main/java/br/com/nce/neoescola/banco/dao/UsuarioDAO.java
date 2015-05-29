package br.com.nce.neoescola.banco.dao;

import br.com.nce.neoescola.banco.entidades.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario> {

	Usuario buscaUsuarioPorEmailESenha(Usuario usuario);
	
}
