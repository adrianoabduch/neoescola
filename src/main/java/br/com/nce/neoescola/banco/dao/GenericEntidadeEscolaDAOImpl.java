package br.com.nce.neoescola.banco.dao;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.nce.neoescola.banco.entidades.BaseEntidadeEscola;
import br.com.nce.neoescola.seguranca.UsuarioLogado;

/**
 * DAO Genérico com os métodos básicos de um DAO. Todo DAO de uma entidade filha de escola do sistema deve estender este DAO.
 * @author Adriano
 *
 * @param <T>
 */
public class GenericEntidadeEscolaDAOImpl<T extends BaseEntidadeEscola> implements GenericDAO<T> {

	private final Session session;
	
	private final Class<T> classe;

	private UsuarioLogado usuarioLogado;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GenericEntidadeEscolaDAOImpl(Class classe, Session session, UsuarioLogado usuarioLogado) {
		this.classe = classe;
		this.session = session;
		this.usuarioLogado = usuarioLogado;
	}
	
	public Session getSession() {
		return session;
	}
	
	public T buscaPorId(Long id) {
		if(id == null)
			return null;
		
		@SuppressWarnings("unchecked")
		T entidade = (T) session.get(classe, id);

		return entidade;
	}
	
	/**
	 * Salva com transação controlada pelo VRaptor. Deve ser usado por classes controladas
	 * com o vraptor (controllers, components etc)
	 */
	@Transactional
	public T salvar(T entidade) {
		session.saveOrUpdate(entidade);
		return entidade;
	}
	
	/**
	 * Salva com transação criada manualmente. Deve ser usado para testes e afins.
	 * @param entidade
	 * @return
	 */
	public T _salvar(T entidade) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(entidade);
		tx.commit();
		
		return entidade;
	}

	/**
	 * Devolve uma criteria já filtrando com o ID da escola do usuário logado.
	 * @return Criteria
	 */
	public Criteria createCriteria() {
		Criteria c = getSession().createCriteria(classe);
		c.createAlias("escola", "escola");
		c.add(Restrictions.eq("escola.id", usuarioLogado.getUsuario().getEscola().getId()));
		
		return c;
	}
	
}
