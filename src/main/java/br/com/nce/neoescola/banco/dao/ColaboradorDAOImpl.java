package br.com.nce.neoescola.banco.dao;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.nce.neoescola.banco.entidades.Colaborador;
import br.com.nce.neoescola.seguranca.UsuarioLogado;

public class ColaboradorDAOImpl extends GenericEntidadeEscolaDAOImpl<Colaborador> implements ColaboradorDAO {

	@Inject
	public ColaboradorDAOImpl(Session session, UsuarioLogado usuarioLogado) {
		super(Colaborador.class, session, usuarioLogado);
	}
	
	public Colaborador buscaPorUsuarioId(Long usuarioId) {
		Criteria criteria = createCriteria();
		criteria.createAlias("usuario", "usuario");
		Restrictions.eq("usuario.id", usuarioId);
		
		return (Colaborador) criteria.uniqueResult();
	}
	
}
