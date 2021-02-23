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
			
			fos.write(" Coucou c'est nous".getBytes(StandardCharsets.UTF_8));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			
	}

	}
}
