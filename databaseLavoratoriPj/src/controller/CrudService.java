package controller;

import java.util.HashMap;

import model.Persona;

public class CrudService {

	HashMap<Integer,Persona> dbPersone;

	int id=0;

	public boolean setPersona(Persona p) {
		id++;
		dbPersone.put(id, p);
		return true;
	}

	public HashMap<Integer,Persona> getPersone(){
		return dbPersone;
	}

	public Persona getPersona(int id) {
		if (dbPersone.get(id)!=null) {
			return dbPersone.get(id);
		}
		else
			return null;
	}

	
	
	public boolean rimuoviPersona(int id) {
		if (dbPersone.get(id)!=null) {
			dbPersone.remove(id);
			return true;
		}
		else
			return false;
	}
	
}
