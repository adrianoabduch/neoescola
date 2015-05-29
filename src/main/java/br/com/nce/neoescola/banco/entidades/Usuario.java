package br.com.nce.neoescola.banco.entidades;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.nce.neoescola.tipo.TipoPerfil;

@Entity
public class Usuario extends BaseEntidadeEscola {

	private String email;
	
	private String senha;

	@Enumerated(EnumType.ORDINAL)
	private TipoPerfil perfil;
	
	private Integer tentativaserradas;
	
	private Boolean bloqueado;

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

	public TipoPerfil getPerfil() {
		return perfil;
	}

	public void setPerfil(TipoPerfil perfil) {
		this.perfil = perfil;
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
	
}
