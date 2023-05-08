package it.iisvolta;

import java.util.ArrayList;
import java.util.Scanner;

import it.edu.iisvolta.Console;



public class Main {

	public static void main(String[] args) {
		ArrayList<Libro> elencoLibri=new ArrayList<Libro>();
		ArrayList<Utente> elencoUtenti=new ArrayList<Utente>();
		ArrayList<Prestito> elencoPrestiti=new ArrayList<Prestito>();
		String scelta;
		Scanner s=new Scanner(System.in);
		  boolean trovato;
		int NrUtenti=0,nrPrestiti=0;
		do {
            Console.clear();
            System.out.println("GESTIONE BIBLIOTECA\n");
            System.out.println("1 - visualizza libri");
            System.out.println("2 - inserisci libro");            
            System.out.println("3 - visualizza utenti");
            System.out.println("4 - inserisci utente");     
            System.out.println("5 - visualizza prestiti");
            System.out.println("6 - inserisci prestito");
            System.out.println("7 - imposta restituzione prestito");
            System.out.println("9 - Esci\n");
            System.out.print("Inserisci la tua scelta: ");
            scelta=s.nextLine();
            
            switch(scelta) {
                case "1":  // visualizza l'elenco dei libri
                    System.out.println("Elenco libri:");
                    for(Libro l:elencoLibri) {                    
                        System.out.println("ISBN: "+l.getIsbn());
                        System.out.println("Titolo: "+l.getTitolo());
                        System.out.println("Autore: "+l.getAutore());
                        System.out.println("Anno: "+l.getAnnoPubblicazione());
                        System.out.println("Nr Copie: "+l.getNrCopie());
                        System.out.println();
                    }
                    break;
                case "2":       //aggiungi libro
                    String isbn,titolo,autore;
                    int annoPubblicazione, nrCopie;                  
                    System.out.print("Inserisci il codice isbn: ");
                    isbn=s.nextLine();
                    
                    trovato=false;
                    //verifico che il codice non sia già presente
                    for(Libro l:elencoLibri) {
                        if (isbn.equals(l.getIsbn()))
                            trovato=true;       //il codice esiste
                    } 
                    if (!trovato)       //posso aggiungere il libro
                    {                        
                        System.out.print("Inserisci il titolo: ");
                        titolo=s.nextLine();
                        System.out.print("Inserisci l'autore: ");
                        autore=s.nextLine();
                        System.out.print("Inserisci l'anno di pubblicazione: ");
                        annoPubblicazione =Integer.parseInt(s.nextLine());
                        System.out.print("Inserisci il numero di copie: ");
                        nrCopie =Integer.parseInt(s.nextLine());
                        elencoLibri.add(new Libro(isbn,titolo,autore,annoPubblicazione,nrCopie));
                    }
                    else //il codice già esiste
                        System.out.println("Il codice è già esistente!");
                    break;
                 case "3":      //elenco utenti                   
                	 System.out.println("Elenco utenti:");
                     for(Utente u:elencoUtenti) {                    
                         System.out.println("Id: "+u.getId());
                         System.out.println("Nome: "+u.getNome());
                         System.out.println("Cognome: "+u.getCognome());
                         System.out.println("Telefono: "+u.getTelefono());                        
                         System.out.println();
                     }
                     break;
                    
                case "4":      //Inserisci utente
                	 String nome,cognome,nrTelefono;
                   
                     System.out.print("Inserisci il nome: ");
                     nome=s.nextLine();
                     System.out.print("Inserisci il cognome: ");
                     cognome=s.nextLine();
                     System.out.print("Inserisci il telefono: ");
                     nrTelefono=s.nextLine();
                     trovato=false;
                     //verifico che l'utente non sia già presente
                     for(Utente u:elencoUtenti) {
                         if (nome.equals(u.getNome()) && 
                             cognome.equals(u.getCognome()) &&
                             nrTelefono.equals(u.getTelefono()))  
                             trovato=true;       //l'utente esiste
                     } 
                     if (!trovato)       //posso aggiungere l'utente
                     {   
                    	 NrUtenti++;	//l'id dell'utente è automatico
                         elencoUtenti.add(new Utente(NrUtenti, nome, cognome, nrTelefono));
                    	 
                         //OPPURE:
                         /*
                    	 Utente u=new Utente(NrUtenti, nome, cognome, nrTelefono);
                    	 elencoUtenti.add(u);
                    	 */
                     }
                     else 
                         System.out.println("L'utente già esiste!");
                     break;
                case "5":      //Visualizza prestiti
                	System.out.println("Elenco prestiti:");
                    for(Prestito p:elencoPrestiti) {                    
                        System.out.println("Nr: "+p.getNr());
                        System.out.println("Titolo: "+p.getLibro().getTitolo());
                        System.out.println("Utente: "+p.getUtente().getNome()+" "+p.getUtente().getCognome());
                        System.out.println("Data inizio: "+p.getDataInizio());
                        System.out.println("Data fine: "+p.getDataFine());
                        System.out.println();
                    }
                    break;
                case "6":      //Inserisci prestito   
                	System.out.print("Inserisci il codice isbn del libro: ");
                    isbn=s.nextLine();
                    Utente utentePrestito=null;
                    Libro libroDaPrestare=null;
                    trovato=false;
                    //verifico che il codice non sia già presente
                    for(Libro l:elencoLibri) {
                        if (isbn.equals(l.getIsbn())){
                        	trovato=true;       //il codice esiste
                        	libroDaPrestare=l;
                        }                            
                    } 
                    if (!trovato)
                    	System.out.println("Libro non trovato!");
                    else
                    {
                    	int idUtente;
                    	System.out.print("Inserisci l'id dell'utente: ");
                        idUtente=Integer.parseInt(s.nextLine());
                        
                        trovato=false;
                        //verifico che il codice non sia già presente
                        for(Utente u:elencoUtenti) {
                            if (idUtente==u.getId()) 
                            {
                                trovato=true;       //il codice esiste
                                utentePrestito=u;
                            }
                        } 
                        if (!trovato)
                        	System.out.println("Utente non trovato!");
                        else
                        {
                        	nrPrestiti++;
                        	Prestito p=new Prestito(nrPrestiti, utentePrestito, libroDaPrestare);
                        	elencoPrestiti.add(p);
                        }
                    }
                    break;
                case "7":      //Imposta restituzione   
                	int idPrestito;
                	System.out.print("Inserisci l'id del prestito: ");
                	idPrestito=Integer.parseInt(s.nextLine());
                    
                    trovato=false;
                    //verifico che il codice non sia già presente
                    for(Prestito p:elencoPrestiti) {
                        if (p.getNr()==idPrestito) 
                        {
                            trovato=true;       //il codice esiste                            
                            p.impostaRestituzione();
                        }
                    } 
                    if (!trovato)
                    	System.out.println("Prestito non trovato!");
            }
            
            System.out.println("Premi Enter per continuare...");
            s.nextLine();
        } while(!scelta.equals("9"));
s.close();
	}

}
