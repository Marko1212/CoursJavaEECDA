package com.m2iformation.learning_io;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MyBufferedWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("text.txt", true))) {
			
			//sur Windows il faut mieux mettre \r\n pour le retour à la ligne (même si ça marche ici avec juste \n)
			bw.newLine();
			bw.write(" Hello world");
			bw.newLine();
			bw.write(" Hello world");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			
	}

	}

}
