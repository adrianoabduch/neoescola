package br.com.nce.neoescola.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.nce.neoescola.banco.dao.UsuarioDAOImpl;

@Controller
public class IndexController {

	private UsuarioDAOImpl usuarioDAO;
	
	private final Result result;
	
//	public IndexController(UsuarioDAOImpl usuarioDAO) {
//		this.usuarioDAO = usuarioDAO;
//	}
	
	/**
	 * @deprecated CDI eyes only
	 */
	protected IndexController() {
		this(null);
	}
	
	@Inject
	public IndexController(Result result) {
		this.result = result;
	}
	
	@Path("/teste")
	public void index() {
		result.include("variable", "VRaptor4!");
	}
	
	public String testa() {
		System.out.println("testeteste teste teste teste testeteste");
		return "teste";
	}
	
//	@Get("/{id}")
//	public String teste() {
//		Long id = 1L;
//		
//		String y = usuarioDAO.buscaPorId(id).getEmail();
//		if(y != null)
//			return y;
//		
//		Datas datas = Datas.novasDatas()
//                .comDocumento(1, 5, 2008)
//                .comProcessamento(1, 5, 2008)
//                .comVencimento(2, 5, 2008);  
//
//        Endereco enderecoBeneficiario = Endereco.novoEndereco()
//                .comLogradouro("Av das Empresas, 555")  
//                .comBairro("Bairro Grande")  
//                .comCep("01234-555")  
//                .comCidade("São Paulo")  
//                .comUf("SP");  
//
//        //Quem emite o boleto
//        Beneficiario beneficiario = Beneficiario.novoBeneficiario()  
//                .comNomeBeneficiario("José Alves de Souza Neto")  
//                .comAgencia("0133").comDigitoAgencia("3")  
//                .comCodigoBeneficiario("1007220")  
//                .comDigitoCodigoBeneficiario("4")  
//                .comNumeroConvenio("1207113")  
//                .comCarteira("18")  
//                .comEndereco(enderecoBeneficiario)
//                .comNossoNumero("9000206");  
//
//        Endereco enderecoPagador = Endereco.novoEndereco()
//                .comLogradouro("Av dos testes, 111 apto 333")  
//                .comBairro("Bairro Teste")  
//                .comCep("01234-111")  
//                .comCidade("São Paulo")  
//                .comUf("SP");  
//
//        //Quem paga o boleto
//        Pagador pagador = Pagador.novoPagador()  
//                .comNome("Adriano Amado Abduch")  
//                .comDocumento("111.222.333-12")
//                .comEndereco(enderecoPagador);
//
//        Banco banco = new Bradesco();  
//        
//        Boleto boleto = Boleto.novoBoleto()  
//                .comBanco(banco)  
//                .comDatas(datas)  
//                .comBeneficiario(beneficiario)  
//                .comPagador(pagador)  
//                .comValorBoleto("50.00")  
//                .comNumeroDoDocumento("1234")  
//                .comInstrucoes("instrucao 1", "instrucao 2", "instrucao 3", "instrucao 4", "instrucao 5")  
//                .comLocaisDePagamento("local 1", "local 2");  
//		
//		
//		
//		
//		GeradorDeBoleto g = new GeradorDeBoleto(boleto);
//		String x = Base64.encodeBytes(g.geraPNG());
//		
//		
//		return x;
//	}
	
}

