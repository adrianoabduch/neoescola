package br.com.nce.neoescola.banco.dao;

import javax.inject.Inject;

import org.hibernate.Session;

import br.com.nce.neoescola.banco.entidades.Contrato;

public class ContratoDAOImpl extends GenericDAOImpl<Contrato> implements ContratoDAO {

	@Inject
	public ContratoDAOImpl(Session session) {
		super(session);
	}
	
	
}
