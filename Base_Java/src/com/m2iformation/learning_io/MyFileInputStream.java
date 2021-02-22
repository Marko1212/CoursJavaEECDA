package com.m2iformation.learning_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MyFileInputStream {
	public static void main(String[] args) {
		
		/*FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(new File("text.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			} */
		
		try(FileInputStream fis = new FileInputStream(new File("text.txt"))) {
			
			byte[] buffer = new byte[8];
			
			int n = 0;
			
			while( (n = fis.read(buffer)) >= 0) {
					System.out.print(new String (buffer, StandardCharsets.UTF_8));
			}
			
		} catch (FileNotFoundException f) {
			f.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
