package com.m2iformation;

import java.util.Scanner;

public class ExoEtoilesRectangle {

	public static void main(String[] args) 
	{
		int hauteur, largeur, i, j;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Entrez la hauteur : ");
		hauteur = sc.nextInt();	
		
		System.out.print("Entrez la largeur : ");
		largeur = sc.nextInt();		
		
		System.out.println();
			
		for(i = 1; i <= hauteur; i++)
		{
			for(j = 1; j <= largeur; j++)
			{
				System.out.print("* "); 
			}
			System.out.print("\n"); 
		}	
		
		sc.close();
	}
}
