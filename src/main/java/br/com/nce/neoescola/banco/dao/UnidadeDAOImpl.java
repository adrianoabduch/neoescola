package br.com.nce.neoescola.banco.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.nce.neoescola.banco.entidades.Unidade;
import br.com.nce.neoescola.seguranca.UsuarioLogado;

public class UnidadeDAOImpl extends GenericEntidadeEscolaDAOImpl<Unidade> implements UnidadeDAO {

	@Inject
	public UnidadeDAOImpl(Session session, UsuarioLogado usuarioLogado) {
		super(Unidade.class, session, usuarioLogado);
	}

	@Override
	public List<Unidade> buscaListaPorNome(String nome) {
		Criteria c = createCriteria();
		c.add(Restrictions.ilike("nome", nome));
		
		return c.list();
	}
	
	
	
	
}
