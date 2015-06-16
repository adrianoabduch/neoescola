package br.com.nce.neoescola.banco.entidades;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.nce.neoescola.tipo.TipoPerfil;

@Entity
public class Usuario extends BaseEntidadeEscola {

	private String email;
	
	private String senha;

	private Integer tentativaserradas;
	
	private Boolean bloqueado;
	
	private Boolean backoffice = false;
	private Boolean aluno = false;
	private Boolean administrador = false;
	private Boolean docente = false;
	private Boolean secretaria = false;
	private Boolean secretariaBiblioteca = false;
	private Boolean secretariaCadastros = false;
	private Boolean secretariaFinanceiro = false;
	private Boolean secretariaAlmoxariado = false;
	private Boolean secretariaRelatorios = false;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getTentativaserradas() {
		return tentativaserradas;
	}

	public void setTentativaserradas(Integer tentativaserradas) {
		this.tentativaserradas = tentativaserradas;
	}

	public Boolean getBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(Boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public Boolean getBackoffice() {
		return backoffice;
	}

	public void setBackoffice(Boolean backoffice) {
		this.backoffice = backoffice;
	}

	public Boolean getAluno() {
		return aluno;
	}

	public void setAluno(Boolean aluno) {
		this.aluno = aluno;
	}

	public Boolean getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Boolean administrador) {
		this.administrador = administrador;
	}

	public Boolean getDocente() {
		return docente;
	}

	public void setDocente(Boolean docente) {
		this.docente = docente;
	}

	public Boolean getSecretaria() {
		return secretaria;
	}

	public void setSecretaria(Boolean secretaria) {
		this.secretaria = secretaria;
	}

	public Boolean getSecretariaBiblioteca() {
		return secretariaBiblioteca;
	}

	public void setSecretariaBiblioteca(Boolean secretariaBiblioteca) {
		this.secretariaBiblioteca = secretariaBiblioteca;
	}

	public Boolean getSecretariaCadastros() {
		return secretariaCadastros;
	}

	public void setSecretariaCadastros(Boolean secretariaCadastros) {
		this.secretariaCadastros = secretariaCadastros;
	}

	public Boolean getSecretariaFinanceiro() {
		return secretariaFinanceiro;
	}

	public void setSecretariaFinanceiro(Boolean secretariaFinanceiro) {
		this.secretariaFinanceiro = secretariaFinanceiro;
	}

	public Boolean getSecretariaAlmoxariado() {
		return secretariaAlmoxariado;
	}

	public void setSecretariaAlmoxariado(Boolean secretariaAlmoxariado) {
		this.secretariaAlmoxariado = secretariaAlmoxariado;
	}

	public Boolean getSecretariaRelatorios() {
		return secretariaRelatorios;
	}

	public void setSecretariaRelatorios(Boolean secretariaRelatorios) {
		this.secretariaRelatorios = secretariaRelatorios;
	}
	
}
