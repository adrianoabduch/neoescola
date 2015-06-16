package br.com.nce.neoescola.testes;

import org.hibernate.Session;

import br.com.nce.neoescola.banco.dao.AlunoDAO;
import br.com.nce.neoescola.banco.dao.AlunoDAOImpl;
import br.com.nce.neoescola.banco.dao.ColaboradorDAO;
import br.com.nce.neoescola.banco.dao.ColaboradorDAOImpl;
import br.com.nce.neoescola.banco.dao.ContratoDAO;
import br.com.nce.neoescola.banco.dao.ContratoDAOImpl;
import br.com.nce.neoescola.banco.dao.EscolaDAO;
import br.com.nce.neoescola.banco.dao.EscolaDAOImpl;
import br.com.nce.neoescola.banco.dao.UsuarioDAO;
import br.com.nce.neoescola.banco.dao.UsuarioDAOImpl;
import br.com.nce.neoescola.banco.entidades.Aluno;
import br.com.nce.neoescola.banco.entidades.Colaborador;
import br.com.nce.neoescola.banco.entidades.Contrato;
import br.com.nce.neoescola.banco.entidades.Escola;
import br.com.nce.neoescola.banco.entidades.Usuario;
import br.com.nce.neoescola.tipo.TipoPerfil;

public class GeraContratoTeste {

	public static void main(String[] args) {
		
		//Abre a session e gera os DAOS
		Session s = CriadorDeSessionParaTeste.abreSession();
		ContratoDAO contratoDAO = new ContratoDAOImpl(s);
		EscolaDAO escolaDAO = new EscolaDAOImpl(s);
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl(s);
		ColaboradorDAO colaboradorDAO = new ColaboradorDAOImpl(s, null);
		AlunoDAO alunoDAO = new AlunoDAOImpl(s, null);
		
		//Cria o contrato
		Contrato c = new Contrato();
		c.setNomeFantasia("Colégio ABCdário");
		c.setRazaoSocial("ABCdário LTDA");
		c.setPrimeiroNome("Gerald");
		c.setSobreNome("de Rívia");
		c.setNumeroAlunosSolicitado(200);
		c.setNumeroAlunosContratado(200);
		c.setEmail("contato@colegioabcdario.com.br");
		
		//Cria a escola
		Escola e = new Escola();
		e.setNomeFantasia(c.getNomeFantasia());
		e.setRazaoSocial(c.getRazaoSocial());

		Colaborador colaborador = new Colaborador();
		colaborador.setPrimeiroNome("Cirilla");
		colaborador.setSobrenome("Fiona Elen Rianno");
		
		Aluno aluno = new Aluno();
		aluno.setPrimeiroNome("Triss");
		aluno.setSobrenome("Merigold de Maribor");
		Aluno aluno2 = new Aluno();
		aluno.setPrimeiroNome("Harleen");
		
		Usuario u = new Usuario();
		u.setEmail("ciri@colegioabcdario.com.br");
		u.setSenha("123");
		
		
//		Salva o contrato
		contratoDAO._salvar(c);
		
//		Adiciona o contrato na escola e salva a escola
		e.setContrato(c);
		escolaDAO._salvar(e);
		
//		Adiciona a escola no usuário administrativo e salva o usuário
		u.setEscola(e);
		usuarioDAO._salvar(u);
		
//		Adiciona o usuário administrativo e a escola
//		no colaborador que contratou e salva o colaborador 
		colaborador.setEscola(e);
		colaborador.setUsuario(u);
		colaboradorDAO._salvar(colaborador);
		
//		Adiciona a escola no aluno e salva o aluno
		aluno.setEscola(e);
		alunoDAO._salvar(aluno);
		aluno2.setEscola(e);
		alunoDAO._salvar(aluno2);
	}
	
}
