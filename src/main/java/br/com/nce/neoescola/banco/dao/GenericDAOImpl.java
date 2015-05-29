package br.com.nce.neoescola.banco.dao;

import java.lang.reflect.ParameterizedType;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.nce.neoescola.banco.entidades.BaseEntidade;

/**
 * DAO Genérico com os métodos básicos de um DAO. Todo DAO de uma entidade não filha de escola do sistema deve estender este DAO.
 * @author Adriano
 *
 * @param <T>
 */
public class GenericDAOImpl<T extends BaseEntidade> implements GenericDAO<T> {

	private final Session session;
	
	private Class<T> persistentClass;
	
	public GenericDAOImpl(Session session) {
		this.session = session;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getPersistentClass() {
		if(this.persistentClass == null) {
			this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0];
		}
		return persistentClass;
	}

	public Session getSession() {
		return session;
	}
	
	public T buscaPorId(Long id) {
		if(id == null)
			return null;
		
		@SuppressWarnings("unchecked")
		T entidade = (T) session.get(getPersistentClass(), id);

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
	
	public Criteria createCriteria() {
		Criteria c = getSession().createCriteria(getPersistentClass());
		return c;
	}
	
}
