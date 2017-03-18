package HelperAlgorithms;

import java.util.Arrays;
import java.util.LinkedList;

public class HelperAlgorithms {

	public HelperAlgorithms() {
		// TODO Auto-generated constructor stub
	}
	
	public LinkedList<String> getStringPermutations(String s){
		LinkedList<String> list = new LinkedList<>();
		if (s.length() > 0 && !s.isEmpty() && checkForSpecialChars(s)){
			//TODO
		}
		
		return list;
	}
	
	public LinkedList<String> getMissingLetterWords(String s){
		LinkedList<String> list = new LinkedList<>();
		list.add(s.substring(1));
		for (int i = 1; i < s.length(); i++){
			list.add(s.substring(0, i).concat(s.substring(i+1)));
		}
		return list;
	}


	private boolean checkForSpecialChars(String s){
		LinkedList<String> specialChars = new LinkedList<>(Arrays.asList("!","@","$","#","%","^","&","*","(","(","_","+","=","[","{","]","}"));
		for (String cha : specialChars){
			if (s.contains(cha)){
				return false;
			}
		}
		return true;
	}
}
