package br.com.nce.neoescola.banco.dao;

import javax.inject.Inject;

import org.hibernate.Session;

import br.com.nce.neoescola.banco.entidades.Escola;

public class EscolaDAOImpl extends GenericDAOImpl<Escola> implements EscolaDAO {

	@Inject
	public EscolaDAOImpl(Session session) {
		super(session);
	}
	
	
}
