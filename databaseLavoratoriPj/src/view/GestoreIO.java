package view;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

import model.Persona;
import model.Dipendente;
import model.Manager;

public class GestoreIO {

	@SuppressWarnings("resource")
	public String leggiStringa(String messaggio) {
		System.out.println(messaggio);
		Scanner input=new Scanner(System.in);
		return input.nextLine();
	}

	@SuppressWarnings("resource")
	public int leggiInt(String messaggio) {
		System.out.println(messaggio);
		Scanner input=new Scanner(System.in);
		return Integer.parseInt(input.nextLine());
	}

	@SuppressWarnings("resource")
	public double leggiDouble(String messaggio) {
		System.out.println(messaggio);
		Scanner input=new Scanner(System.in);
		return Double.parseDouble(input.nextLine());
	}

	public Date leggiDate(String messaggio) {
		System.out.println(messaggio);
		int anno= leggiInt("Inserisci l'anno: ");
		int mese=leggiInt("Inserisci il mese: ");
		int giorno= leggiInt("Inserisci il giorno: ");
		LocalDate ld= LocalDate.of(anno, mese, giorno);
		return Date.valueOf(ld);
	}

	public void menu() {
		System.out.println("****MENU****");
		System.out.println("1) Inserisci una persona: ");
		System.out.println("2) Visualizza le persone: ");
		System.out.println("3) Cerca una persona: ");
		System.out.println("4) Modifica una persona: ");
		System.out.println("5) Rimuovi una persona: ");
		System.out.println("6) Esci: ");
		System.out.println("************");
	}

	public void formPersona(Persona newPers) {
		newPers.setNome(leggiStringa("Inserisci il nome: "));
		newPers.setCognome(leggiStringa("Inserisci il cognome: "));
		newPers.setDataDiNascita(leggiDate("Inserisci la data di nascita: "));
		if (newPers instanceof Dipendente) {
			((Dipendente) newPers).setStipendio(leggiInt("Inserisci lo stipendio: "));
			if (newPers instanceof Manager) {
				((Manager) newPers).setAreaResp("Inserisci l'area di responsabilità: ");
			}
		}
	}

	public void schedaPersona(Persona p) {
		if (p!=null) {
			System.out.println("**********");
			System.out.println("ID: "+p.getId());
			System.out.println("NOME: "+p.getNome());
			System.out.println("COGNOME: "+p.getCognome());
			SimpleDateFormat sdf= new SimpleDateFormat();
			System.out.println("DATA DI NASCITA: "+sdf.format(p.getDataDiNascita()));
			if (p instanceof Dipendente) {
				System.out.println(((Dipendente)p).getStipendio());
				if (p instanceof Manager) {
					System.out.println(((Manager) p).getAreaResp());
				}
			}
		}
		else 
			System.err.println("Persona non trovata!!");
		}
	
	public void visualizzaDbPersone(HashMap<Integer,Persona> dbPersone) {
		for(Persona val:dbPersone.values()) {
			schedaPersona(val);
		}
	}
	
	public void checkOp(String nomeOp, boolean risultatoOp) {
		if (risultatoOp) {
			System.out.println(nomeOp+" eseguito/a con successo!!");
		}
		else {
			System.out.println(nomeOp+" annullato/a!!");
		}
	}
	
	public void duplica(Persona personaOriginale) {
		Persona personaDuplicata=new Persona();
		personaDuplicata.setId(personaOriginale.getId());
		personaDuplicata.setNome(personaOriginale.getNome());
		personaDuplicata.setCognome(personaOriginale.getCognome());
		personaDuplicata.setDataDiNascita(personaOriginale.getDataDiNascita());
		if (personaOriginale instanceof Dipendente) {
			((Dipendente)personaDuplicata).setStipendio(((Dipendente)personaOriginale).getStipendio());
			if (personaOriginale instanceof Manager) {
				
			}
		}
	}
}
