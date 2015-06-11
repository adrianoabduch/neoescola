package br.com.nce.neoescola.commons;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class SenhaUtils {

	private static char letrMinChrVetor[] = {
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
		'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	
	private static char numChrVetor[] = {
		'1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
	
	private static String senhasComuns[] = {
		"12345", "123456", "654321", "54321", "abcde", "abcdef", "edcba", "fedcba"
	};
	
	private static int tamanhoMinimo = 8;
	
	
	/**
	 * Gera string para senhas.
	 * @param tamanho
	 * @return
	 */
	/*public static String gerarSenha(int tam) {
		Random intRdn = new Random();
		StringBuffer senha = new StringBuffer(tam);
		for (int i = 0; i < tam; i++)
			senha.append(chrVetor[intRdn.nextInt(62)]);
		return senha.toString();
	}*/
	public static String gerarSenha(int tamanho) {
		Random intRdn = new Random();
		StringBuffer senha = new StringBuffer(tamanho);
		for (int i = 0; i < 2; i++) {
			senha.append(letrMinChrVetor[intRdn.nextInt(26)]);
		}
		for (int i = 2; i < tamanho; i++) {
			senha.append(numChrVetor[intRdn.nextInt(10)]);
		}
		return senha.toString();
	}
	
	public static String codificaSenha(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String senhaCodificada = "";
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
		StringBuilder hexString = new StringBuilder();
		
		for (byte b : messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
		
		String senhahex = hexString.toString();
	
		return senhahex;
	}
	
	/**
	 * @param senha
	 * @return Menssagem de erro
	 */
	public static boolean validarSenha(String senha) {
		if (senha != null) {
			if (senha.length() < tamanhoMinimo) {
//				return "A senha deve ter no mínimo " + tamanhoMinimo + " caracteres.";
				return false;
			} else {
				// Verifica repetições
				char[] passArray = senha.toCharArray();
				char aux = passArray[0];
				boolean valido = true;
				boolean sequencia = true;
				for (char passChar : passArray) {
					if (passChar != aux)
						sequencia = false;
				}
				if (sequencia)
					valido = false;
				// Verifica sequências comuns
				for (String comum : senhasComuns) {
					if (senha.equalsIgnoreCase(comum) || senha.contains(comum) || senha.contains(comum.toUpperCase())) {
						valido = false;
					}
				}
				if (!valido) {
//					return "A senha não deve conter sequências comuns.";
					return false;
				}
			}
		}
		return true;
	}
}