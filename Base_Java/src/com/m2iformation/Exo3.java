package com.m2iformation;

import java.util.Arrays;

public class Exo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[] notes = {1, 4, 10, 15, 15, 20, 19, 17};
		
		Arrays.sort(notes);
        
        
        
        int min = notes[0];
        System.out.println("Le nombre le plus petit est " + min);
        
        int max= notes[notes.length - 1];
        System.out.println("Le nombre le plus grand est " + max);

	}

}
