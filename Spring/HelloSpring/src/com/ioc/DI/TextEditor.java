package com.ioc.DI;


public class TextEditor {
	private SpellChecker spellChecker;
	private String tName;

	public TextEditor() {}
	public TextEditor(SpellChecker spellChecker) {
		System.out.println("Inside TextEditor constructor.");
		this.spellChecker = spellChecker;
	}
	public TextEditor(SpellChecker spellChecker, String tName) {
		System.out.println("Inside TextEditor constructor.tName"+tName);
		this.spellChecker = spellChecker;
	}
	public TextEditor(int year, String name){
		System.out.println("year:"+year+",name:"+name);
	}

	public void spellCheck() {
		spellChecker.checkSpelling();
	}
	

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}
	
	
}
