package br.com.nce.neoescola.tipo;

public enum TipoPerfil implements Tipo {
	ALUNO,
	DOCENTE,
	ADMINISTRADOR,
	SECRETARIA_TODOS,
	SECRETARIA_CADASTROS,
	SECRETARIA_BIBLIOTECA,
	SECRETARIA_FINANCEIRO,
	SECRETARIA_ALMOXARIFADO,
	SECRETARIA_RELATORIOS;
	
	public String getDescricao() {
		return TipoUtils.getDescricao(this);
	}

	@Override
	public String toString() {
		return getDescricao();
	}
	

}
