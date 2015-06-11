package br.com.nce.neoescola.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.nce.neoescola.banco.dao.AlunoDAO;
import br.com.nce.neoescola.banco.dao.ColaboradorDAO;
import br.com.nce.neoescola.banco.dao.ContratoDAO;
import br.com.nce.neoescola.banco.dao.EscolaDAO;
import br.com.nce.neoescola.banco.dao.UsuarioDAO;
import br.com.nce.neoescola.banco.entidades.Aluno;
import br.com.nce.neoescola.banco.entidades.Colaborador;
import br.com.nce.neoescola.banco.entidades.Contrato;
import br.com.nce.neoescola.banco.entidades.Escola;
import br.com.nce.neoescola.banco.entidades.Usuario;
import br.com.nce.neoescola.seguranca.Publico;
import br.com.nce.neoescola.tipo.TipoPerfil;

@Controller
public class BackofficeController {
	
	private ContratoDAO contratoDAO;
	private EscolaDAO escolaDAO;
	private UsuarioDAO usuarioDAO;
	private ColaboradorDAO colaboradorDAO;
	private AlunoDAO alunoDAO;
	
	/**
	 * @deprecated CDI eyes only
	 */
	public BackofficeController() {
		this(null, null, null, null, null);
	}
	
	@Inject
	public BackofficeController(ContratoDAO contratoDAO, EscolaDAO escolaDAO,
				UsuarioDAO usuarioDAO, ColaboradorDAO colaboradorDAO, AlunoDAO alunoDAO) {
		this.contratoDAO = contratoDAO;
		this.escolaDAO = escolaDAO;
		this.usuarioDAO = usuarioDAO;
		this.colaboradorDAO = colaboradorDAO;
		this.alunoDAO = alunoDAO;
	}
	
	@Publico
	@Get("/backoffice/geraContratoTeste/{senha}")
	public void geraContratoTeste(Long senha) {
		
		if(senha != 2805)
			return;
		
		//Cria o contrato
		Contrato c = new Contrato();
		c.setNomeFantasia("Colégio ABCdário");
		c.setRazaoSocial("ABCdário LTDA");
		c.setPrimeiroNome("Gerald");
		c.setSobreNome("de Rívia");
		c.setNumeroAlunosSolicitado(200);
		c.setNumeroAlunosContratado(200);
		c.setEmail("contato@colegioabcdario.com.br");
		
		//Cria a escola, por enquanto está manual.
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
		aluno2.setPrimeiroNome("Harleen");
		aluno2.setSobrenome("Francis Quinzel");
		
		Usuario u = new Usuario();
		u.setEmail("ciri@colegioabcdario.com.br");
		u.setSenha("123");
		u.setPerfil(TipoPerfil.ADMINISTRADOR);
		
		
//		Salva o contrato
		contratoDAO.salvar(c);
		
//		Adiciona o contrato na escola e salva a escola
		e.setContrato(c);
		escolaDAO.salvar(e);
		
//		Adiciona a escola no usuário administrativo e salva o usuário
		u.setEscola(e);
		usuarioDAO.salvar(u);
		
//		Adiciona o usuário administrativo e a escola
//		no colaborador que contratou e salva o colaborador 
		colaborador.setEscola(e);
		colaborador.setUsuario(u);
		colaboradorDAO.salvar(colaborador);
		
//		Adiciona a escola no aluno e salva o aluno
		aluno.setEscola(e);
		alunoDAO.salvar(aluno);
		aluno2.setEscola(e);
		alunoDAO.salvar(aluno2);
	}

}
