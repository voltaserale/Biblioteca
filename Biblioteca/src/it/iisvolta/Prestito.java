package it.iisvolta;

import java.time.LocalDate;


public class Prestito {
	private int nr;
	private LocalDate dataInizio;
	private LocalDate dataFine;
	
	private Utente utente;
	private Libro libro;
	
	public Prestito(int nr, Utente utente, Libro libro) {
		super();
		this.nr = nr;
		this.utente = utente;
		this.libro = libro;
		dataInizio=LocalDate.now();		//data inizio impostata automaticamente ad oggi
		//dataFine=null;
	}

	
	
	public int getNr() {
		return nr;
	}



	public LocalDate getDataInizio() {
		return dataInizio;
	}



	public LocalDate getDataFine() {
		return dataFine;
	}



	public Utente getUtente() {
		return utente;
	}



	public Libro getLibro() {
		return libro;
	}



	public void impostaRestituzione() {
		dataFine=LocalDate.now();
	}
	
	
}
