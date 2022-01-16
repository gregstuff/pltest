package com.example.restapp.model;

import java.util.List;

public class NamesInRange {

	private List<String> names;
	private int numCharacters;

	public NamesInRange(List<String> names, int numCharacters) {
		this.names = names;
		this.numCharacters = numCharacters;
	}

	public int getNumCharacters() {
		return numCharacters;
	}

	public void setNumCharacters(int numCharacters) {
		this.numCharacters = numCharacters;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

}
