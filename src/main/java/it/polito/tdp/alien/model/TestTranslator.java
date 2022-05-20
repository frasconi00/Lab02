package it.polito.tdp.alien.model;

public class TestTranslator {

	public static void main(String[] args) {
		
		Translator model = new Translator();
		model.add("hello", "ciao");
		model.add("hello", "salve");
		
		model.ricercaWildcard("hell");

	}

}
