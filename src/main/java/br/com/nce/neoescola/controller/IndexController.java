package br.com.nce.neoescola.controller;

import javax.inject.Inject;

import org.postgresql.util.Base64;

import br.com.caelum.brutauth.auth.annotations.Public;
import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Endereco;
import br.com.caelum.stella.boleto.Pagador;
import br.com.caelum.stella.boleto.bancos.Itau;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;
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
	
	@Public
	@Path("/")
	public void index() {
		result.include("variable", getBoleto());
	}
	
	@Public
	public String getBoleto() {
//		Long id = 1L;
//		
//		String y = usuarioDAO.buscaPorId(id).getEmail();
//		if(y != null)
//			return y;
		
		Datas datas = Datas.novasDatas()
                .comDocumento(13, 06, 2015)
                .comProcessamento(13, 06, 2015)
                .comVencimento(15, 6, 2015);  

        Endereco enderecoBeneficiario = Endereco.novoEndereco()
                .comLogradouro("Av Itaberaba, 3628")  
                .comBairro("Itaberaba")  
                .comCep("02859-000")  
                .comCidade("São Paulo")  
                .comUf("SP");  

        //Quem emite o boleto
        Beneficiario beneficiario = Beneficiario.novoBeneficiario()  
                .comNomeBeneficiario("Colégio Vaz S/C LTDA")  
                .comAgencia("8137").comDigitoAgencia("")  
                .comCodigoBeneficiario("1234")  
                .comDigitoCodigoBeneficiario("4321")  
                .comNumeroConvenio("5678")  
                .comCarteira("109")  
                .comEndereco(enderecoBeneficiario)
                .comNossoNumero("9000206");  

        Endereco enderecoPagador = Endereco.novoEndereco()
                .comLogradouro("Av dos testes, 111 apto 333")  
                .comBairro("Bairro Teste")  
                .comCep("01234-111")  
                .comCidade("São Paulo")  
                .comUf("SP");  

        //Quem paga o boleto
        Pagador pagador = Pagador.novoPagador()  
                .comNome("Adriano Amado Abduch")  
                .comDocumento("111.222.333-12")
                .comEndereco(enderecoPagador);

        Banco banco = new Itau();  
        
        Boleto boleto = Boleto.novoBoleto()  
                .comBanco(banco)  
                .comDatas(datas)  
                .comBeneficiario(beneficiario)  
                .comPagador(pagador)  
                .comValorBoleto("50.00")  
                .comNumeroDoDocumento("1234")  
                .comInstrucoes("instrucao 1", "instrucao 2", "instrucao 3", "instrucao 4", "instrucao 5")  
                .comLocaisDePagamento("local 1", "local 2");  
		
		
		
		
		GeradorDeBoleto g = new GeradorDeBoleto(boleto);
		String x = Base64.encodeBytes(g.geraPNG());
		
		
		return x;
	}
	
}