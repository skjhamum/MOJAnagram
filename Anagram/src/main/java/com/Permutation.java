package com;
import java.util.ArrayList;
import java.util.List;


public class Permutation {
	
	List<String> permutation;
	
	 public static List<String> generatePermutation(String angString)
	 {
		 Permutation ana = new Permutation();
		 ana.permutation= new ArrayList<String>();
		 return ana.anag(angString, "");
	 }
	
	 public List<String> anag(String s1, String s2)  {
		   if(s1.length() == 0)
			   permutation.add(s2);
		   
		   for(int i = 0; i < s1.length(); i++) {
			   anag(s1.substring(0, i) + s1.substring(i+1, s1.length()), s1.charAt(i) + s2);
		   }
		   return permutation;
		 }
	 

}
