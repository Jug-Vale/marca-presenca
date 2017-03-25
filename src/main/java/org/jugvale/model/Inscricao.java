package org.jugvale.model;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Inscricao {
	
	private int id;
	private Evento evento;
	private Participante participante;
	
	private boolean compareceu;
	
	public Inscricao() {}
	

	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}


	public boolean isCompareceu() {
		return compareceu;
	}
	public void setCompareceu(boolean compareceu) {
		this.compareceu = compareceu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
