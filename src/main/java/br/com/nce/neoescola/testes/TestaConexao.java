package br.com.nce.neoescola.testes;

import org.hibernate.Session;

import br.com.nce.neoescola.banco.dao.UsuarioDAO;
import br.com.nce.neoescola.banco.dao.UsuarioDAOImpl;

public class TestaConexao {
	
//	private UsuarioDAO usuarioDAO;
//	
//	public TestaConexaoController(UsuarioDAO usuarioDAO) {
//		this.usuarioDAO = usuarioDAO;
//	}
	
	public static void main(String[] args) {
		
		Session session = CriadorDeSessionParaTeste.abreSession();
		
		UsuarioDAO dao = new UsuarioDAOImpl(session);
		
//		Usuario u = new Usuario();
//		u.setAdministrativo(true);
//		u.setAluno(true);
//		u.setEmail("adrianoaduch@gmail.com.br");
//		u.setSenha("123456");
//		
//		dao.salva(u);
		
		System.out.println(dao.buscaPorId(4L).getEmail());
//		System.out.println(dao.findAll().get(0).getEmail());
		
		session.close();
	}
	
	
	
	
}
