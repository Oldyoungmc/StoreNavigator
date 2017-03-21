package HelperAlgorithms;

import java.util.Arrays;
import java.util.LinkedList;

public class HelperAlgorithms {

	
	static int[] permutation;
	
	public HelperAlgorithms() {
		// TODO Auto-generated constructor stub
	}
	
	private static int factorial(int n){
		int fact = 1;
		for (int i = 1; i <= n; i++){
			fact *= i;
		}
		return fact;
	}
	
	
	public static String[][] permutateList(String[] list){
		int n = list.length;
		String[][] permutations = new String[factorial(n)][];
		permutations[0] = list;
		int index = 1;
		permutation = new int[n];
		for(int i = 0; i < n; i++){
			permutation[i] = i;
		}

		System.out.println(Arrays.toString(permutation));
		while(nextPerm()){
			String[] perm = new String[n];
			int[] permint = new int[n];
			System.arraycopy(permutation, 0, permint, 0, n);
			for (int i = 0; i < n; i++){
				perm[i] = list[permint[i]];
			}
			permutations[index] = perm;
			index++;
		}
		return permutations;
	}
	
	private static boolean nextPerm(){
		int k = findK();
		if(k < 0){
			return false;
		}
		int h = findH(k);
		swap(k, h);
		reverse(k+1);
		return true;
	}
	
	private static int findK(){
		for(int i = permutation.length-2; i >= 0; i--){
			if(permutation[i] < permutation[i+1]){
				return i;
			}
		}
		return -1;
	}
	
	private static int findH(int k) {
		int h = k + 1;
		for (int i = k + 2; i < permutation.length; i++) {
			if (permutation[i] > permutation[k] && permutation[i] < permutation[h]) { 
				h=i;
			} 
		}
		return h; 
	}
	
	private static void swap(int k, int h){
		int tmp = permutation[k];
		permutation[k] = permutation[h];
		permutation[h] = tmp;
	}
	
	private static void reverse(int k){
		int i = permutation.length-1;
		while(i>k){
			int tmp = permutation[k];
			permutation[k] = permutation[i];
			permutation[i] = tmp;
			k += 1;
			i -= 1;
		}
	}

	
	public String[] getMissingLetterWords(String s){
		String[] list = new String[s.length()+1];
		list[0] = s;
		list[1] = s.substring(1);
		int index = 2;
		for (int i = 1; i < s.length(); i++){
			list[index] = s.substring(0, i).concat(s.substring(i+1));
			index++;
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
