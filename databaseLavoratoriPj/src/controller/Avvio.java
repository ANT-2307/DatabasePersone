package controller;

import model.Persona;
import view.GestoreIO;

public class Avvio {

	public static void main(String[] args) {
		
		CrudService crud=new CrudService();
		GestoreIO gio=new GestoreIO();
		
		boolean flag=true;
		while (flag) {
			Persona persona=null;
			boolean risultatoOp=false;
			gio.menu();
			int scelta=gio.leggiInt("Scegli un opzione: ");
			switch(scelta) {
			case 1:
				persona=new Persona();
				gio.formPersona(persona);
				risultatoOp=crud.setPersona(persona);
				gio.checkOp("Inserimento", risultatoOp);
				gio.leggiStringa("Premi un tasto per continuare: ");
				break;
			case 2: //Da aggiungere: vedi per tipo
				gio.visualizzaDbPersone(crud.getPersone());
				gio.leggiStringa("Premi un tasto per continuare: ");
				break;
			case 3: 
				int idCercata=gio.leggiInt("Inserisci l'id della persona da cercare: ");
				gio.schedaPersona(crud.getPersona(idCercata));
				gio.leggiStringa("Premi un tasto per continuare: ");
				break;
			case 4:
				break;
			case 5:
				int idRimozione=gio.leggiInt("Inserisci l'id della persona da rimuovere: ");
				risultatoOp=crud.rimuoviPersona(idRimozione);
				gio.checkOp("Rimozione", risultatoOp);
				break;
			case 6:
				gio.leggiStringa("Grazie per aver usato questo programma! Premi un tasto per continuare: ");
				flag=false;
				break;
			default:
				gio.leggiStringa("Opzione non contemplata!! Premi un tasto per continuare: ");
				flag=false;
				break;
			}
		}
	}

}
