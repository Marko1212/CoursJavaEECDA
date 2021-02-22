package com.m2iformation.learning_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MyFileInputStream {
	public static void main(String[] args) {
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(new File("text.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
