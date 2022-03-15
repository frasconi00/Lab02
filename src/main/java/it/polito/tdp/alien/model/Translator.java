package it.polito.tdp.alien.model;

import java.util.HashMap;
//import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
//import java.util.Set;
import java.util.Map;

public class Translator {
	
	private Map<String, List<String>> dizionario;
	
	public Translator() {
		this.dizionario = new HashMap<>();
	}
	
	public void add(String parolaAliena, String traduzione) {
		if(!dizionario.containsKey(parolaAliena)) {
			dizionario.put(parolaAliena, new LinkedList<String>());
		}
		dizionario.get(parolaAliena).add(traduzione);
	}
	
	public List<String> traduci(String parolaAliena) {
		if(dizionario.containsKey(parolaAliena)) {
			return dizionario.get(parolaAliena);
		} else return null;
	}
	
	
	
	

}
