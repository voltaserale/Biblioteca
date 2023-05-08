package it.iisvolta;

public class Libro {
	private String isbn;
	private String titolo;
	private String autore;
	private int annoPubblicazione;
	private int nrCopie;
	
	
	public Libro(String isbn, String titolo, String autore, int annoPublicazione, int nrCopie) {
		super();
		this.isbn = isbn;
		this.titolo = titolo;
		this.autore = autore;
		this.annoPubblicazione = annoPublicazione;
		this.nrCopie = nrCopie;
	}


	public int getNrCopie() {
		return nrCopie;
	}


	public void setNrCopie(int nrCopie) {
		this.nrCopie = nrCopie;
	}


	public String getIsbn() {
		return isbn;
	}


	public String getTitolo() {
		return titolo;
	}


	public String getAutore() {
		return autore;
	}


	public int getAnnoPubblicazione() {
		return annoPubblicazione;
	}
	
	
	
}
