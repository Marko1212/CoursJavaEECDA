package com.m2iformation.exercices_io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercice3 {

	 public static void main(String[] args) {

	        String inputText;

	        try (Scanner sc = new Scanner(System.in); BufferedWriter bw = new BufferedWriter(new FileWriter("outputFromConsole.txt", true))) {

	            while (true) {

	                inputText = sc.nextLine();

	                if (inputText.equals("EXIT")) {
	                    break;
	                }

	                bw.write(inputText);

	                bw.write("\n");

	            }

	        } catch (FileNotFoundException f) {
				f.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	        
	 }
	        
	        

}
