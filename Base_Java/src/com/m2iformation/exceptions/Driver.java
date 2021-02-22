package com.m2iformation.exceptions;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
		System.out.println(3/0);
		} catch (Exception e) {
		System.out.println("Tu ne peux pas diviser par 0!!");
		e.printStackTrace();
		} finally {
			System.out.println("je suis dans le finally");
		}
		System.out.println("hello");
		
		

		FeuSignalisation feu = new FeuSignalisation();
		
		try {
			feu.changeColor("blue");
		} catch (Exception e) {
			// TODO Auto-generated catch block
		 System.out.println(e.getMessage());
		}
		
		
	}


	
	
	
}
