package com.ioc.DI.annotation.JSR250;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

public class HelloWorld {
	private String message;
	private SpellChecker spellChecker;

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	@Resource(name= "resourceSpellChecker")
	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		System.out.println("Your Message : " + message);
		return message;
	}

	@PostConstruct
	public void init() {
		System.out.println("Bean is going through init.");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Bean will destroy now.");
	}
}
