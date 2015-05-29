package br.com.nce.neoescola.tipo;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class TipoUtils {

	private static final String TIPOS_PROPERTIES_BASE_NAME = "br.com.projetoescola.messages.tipos";
	
	/**
	 * Cache do nome de cada tipo. Impede a construção da string inúmeras vezes.
	 */
	private static final Map<Object, String> KEYS_CACHE = new HashMap<Object, String>();
	
	public static <E extends Enum<E>> String getDescricao(Enum<E> tipo) {
		if(!KEYS_CACHE.containsKey(tipo)) {
			StringBuilder sb = new StringBuilder(tipo.getClass().getName().length() + 1 + tipo.name().length());
			sb.append(tipo.getClass().getName());
			sb.append('.');
			sb.append(tipo.name());
			String key = sb.toString();
			KEYS_CACHE.put(tipo, key);
			return getDescricao(key);
		} else {
			return getDescricao(KEYS_CACHE.get(tipo));
		}
	}
	
	public static String getDescricao(String key) {
		ResourceBundle rb = ResourceBundle.getBundle(TIPOS_PROPERTIES_BASE_NAME);
		return rb.getString(key);
	}
}
