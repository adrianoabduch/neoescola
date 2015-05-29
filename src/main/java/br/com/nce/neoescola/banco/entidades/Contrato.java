package br.com.nce.neoescola.banco.entidades;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Contrato extends BaseEntidade {

	//Informações da escola
	private String nomeFantasia;
	private String razaoSocial;
	
	@OneToOne(mappedBy="contrato")
	@Cascade(CascadeType.SAVE_UPDATE)
	private Escola escola;
	
	//Informações do contratante
	private String primeiroNome;
	private String sobreNome;
	private String email;
	
	//Informações do contrato/solicitação
	private Integer numeroAlunosSolicitado;
	private Integer numeroAlunosContratado;

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getNumeroAlunosSolicitado() {
		return numeroAlunosSolicitado;
	}

	public void setNumeroAlunosSolicitado(Integer numeroAlunosSolicitado) {
		this.numeroAlunosSolicitado = numeroAlunosSolicitado;
	}

	public Integer getNumeroAlunosContratado() {
		return numeroAlunosContratado;
	}

	public void setNumeroAlunosContratado(Integer numeroAlunosContratado) {
		this.numeroAlunosContratado = numeroAlunosContratado;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}
	
}
