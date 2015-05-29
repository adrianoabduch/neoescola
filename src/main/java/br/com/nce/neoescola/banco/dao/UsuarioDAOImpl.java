package br.com.nce.neoescola.banco.dao;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.nce.neoescola.banco.entidades.Usuario;

public class UsuarioDAOImpl extends GenericDAOImpl<Usuario> implements UsuarioDAO {

	@Inject
	public UsuarioDAOImpl(Session session) {
		super(session);
	}
	
	public Usuario buscaUsuarioPorEmailESenha(Usuario usuario) {
		Query query = getSession().createQuery("from Usuario where email = :email and senha = :senha") ;
			query.setParameter("email", usuario.getEmail()) ;
			query.setParameter("senha", usuario.getSenha()) ;
		
		return (Usuario) query.uniqueResult() ;
	}
	
}
