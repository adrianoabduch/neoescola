package br.com.nce.neoescola.seguranca;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import br.com.nce.neoescola.banco.entidades.Aluno;
import br.com.nce.neoescola.banco.entidades.Colaborador;
import br.com.nce.neoescola.banco.entidades.Usuario;

@SessionScoped
public class UsuarioLogado implements Serializable {
	
	private Usuario usuario;
	private Aluno aluno;
	private Colaborador colaborador;
	
	public void efetuaLogin(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void logout() {
		this.usuario = null;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	//-- Fim dos getters & setters
	
	public boolean isAluno() {
		return aluno != null;
	}
	
	public boolean isColaboradr() {
		return colaborador != null;
	}
	
	public String getNomeCompleto() {
		if(isAluno())
			return getAluno().getNomeCompleto();
		
		return getColaborador().getNomeCompleto();
	}


}
