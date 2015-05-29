package br.com.nce.neoescola.banco.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.nce.neoescola.banco.entidades.Aluno;
import br.com.nce.neoescola.seguranca.UsuarioLogado;

public class AlunoDAOImpl extends GenericEntidadeEscolaDAOImpl<Aluno> implements AlunoDAO {

	@Inject
	public AlunoDAOImpl(Session session, UsuarioLogado usuarioLogado) {
		super(Aluno.class, session, usuarioLogado);
	}
	
	@SuppressWarnings("unchecked")
	public List<Aluno> buscaTodos() {
		Criteria c = getSession().createCriteria(Aluno.class);
		
		return c.list();
	}
	
	public Aluno buscaPorUsuarioId(Long usuarioId) {
		Criteria criteria = createCriteria();
		criteria.createAlias("usuario", "usuario");
		Restrictions.eq("usuario.id", usuarioId);
		
		return (Aluno) criteria.uniqueResult();
	}
	
	
	
}
