package br.com.nce.neoescola.commons;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.validator.SimpleMessage;

public class MensagensSucesso {
	
	private List<SimpleMessage> mensagens;
	
	public MensagensSucesso() {
		mensagens = new ArrayList<SimpleMessage>();
	}
	
	public MensagensSucesso(SimpleMessage message) {
		mensagens = new ArrayList<SimpleMessage>();
		mensagens.add(message);
	}
	
	public void add(SimpleMessage message) {
		this.mensagens.add(message);
	}
	
	public void remove(SimpleMessage message) {
		this.mensagens.remove(message);
	}
	
	public Object[] getMensagensArray() {
		return this.mensagens.toArray();
	}

}
