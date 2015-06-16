package br.com.nce.neoescola.tipo;

public enum TipoPerfil implements Tipo {
	BACKOFFICE,
	ALUNO,
	DOCENTE,
	ADMINISTRADOR,
	SECRETARIA;
	
	public String getDescricao() {
		return TipoUtils.getDescricao(this);
	}

	@Override
	public String toString() {
		return getDescricao();
	}
	

}
