package com.m2iformation;

import java.util.Scanner;

public class Calculatrice {

	  public static void main(String[] args) {

	    Scanner lecteur = new Scanner(System.in);
	    System.out.print("Entrez deux nombres : ");

	    // nextDouble() reads the next double from the keyboard
	    double first = lecteur.nextDouble();
	    double second = lecteur.nextDouble();

	    System.out.print("Entrez un op�rateur (+, -, *, /) : ");
	    char operator = lecteur.next().charAt(0);

	    double result;

	    switch (operator) {
	      case '+':
	        result = first + second;
	        break;

	      case '-':
	        result = first - second;
	        break;

	      case '*':
	        result = first * second;
	        break;

	      case '/':
	    	if (second == 0) {
	    		System.out.println("La division par 0 est interdite!");
	    		lecteur.close();
	    		return;
	    	}
	        result = first / second;
	        break;

	      // operator doesn't match any case constant (+, -, *, /)
	      default:
	        System.out.printf("Erreur! L'op�rateur %s n'est pas correct!", operator);
	        lecteur.close();
	        return;
	    }

	    System.out.println(first + " " + operator + " " + second + " = " + result);
	    lecteur.close();
	  }
	}
