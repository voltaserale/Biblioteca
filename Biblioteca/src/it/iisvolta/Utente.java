package it.iisvolta;

public class Utente {
	private int id;
	private String nome;
	private String cognome;
	private String telefono;
	
	public Utente(int id, String nome, String cognome, String telefono) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getTelefono() {
		return telefono;
	}
	
	
	
}
