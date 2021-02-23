package com.m2iformation.exercices_io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Exercice2 {


		public static void main(String[] args) {
			// TODO Auto-generated method stub

			try (BufferedReader br = new BufferedReader(new FileReader("input.txt")); BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt", true))) {
				
				String ligne;
				while ((ligne = br.readLine()) != null) {
				bw.write(ligne);
				bw.write('\n');
				}
				
			} catch (FileNotFoundException f) {
				f.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

}
