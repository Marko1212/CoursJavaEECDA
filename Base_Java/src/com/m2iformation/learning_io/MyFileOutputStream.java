package com.m2iformation.learning_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MyFileOutputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (FileOutputStream fos = new FileOutputStream("text.txt", true)) {
			
			//sur Windows il faut mieux mettre \r\n pour le retour à la ligne (même si ça marche ici avec juste \n)
			fos.write("\n Coucou c'est nous".getBytes(StandardCharsets.UTF_8));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			
	}

	}
}
