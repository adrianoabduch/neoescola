package br.com.nce.neoescola.banco.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;


/**
 * DAO Genérico com os métodos básicos de um DAO. Todo DAO do sistema deve estender este DAO.
 * @author Adriano
 *
 * @param <T>
 */
public interface GenericDAO<T> {

	public T buscaPorId(Long id);
	
	public Session getSession();
	
	/**
	 * Salva com transação controlada pelo VRaptor. Deve ser usado por classes controladas
	 * com o vraptor (controllers, components etc)
	 */
	public T salvar(T entidade);

	/**
	 * Salva com transação criada manualmente. Deve ser usado para testes e afins.
	 * @param entidade
	 * @return
	 */
	public T _salvar(T entidade);

	public Criteria createCriteria();
	
}
