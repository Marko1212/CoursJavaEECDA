package com.m2iformation.exercices_io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exercice1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
			
			String ligne;
			while ((ligne = br.readLine()) != null) {
			System.out.println(ligne);
			}
			
		} catch (FileNotFoundException f) {
			f.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
