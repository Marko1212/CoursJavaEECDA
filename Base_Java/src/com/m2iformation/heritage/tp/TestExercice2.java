package com.m2iformation.heritage.tp;

public class TestExercice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Compte compte1=new Compte(7000);
		 CompteEpargne compte2=new CompteEpargne();
		 ComptePayant compte3 = new ComptePayant(5000);

		 compte1.deposer(12000);
		 compte1.retirer(6000);
		 System.out.println(compte1);
		 
		 compte2.deposer(4500);
		 compte2.retirer(1000);
		 System.out.println(compte2);
				 
		 compte2.calculInteret();
		 System.out.println(compte2);
		 
		 
		 compte3.deposer(13000);
		 compte3.retirer(10000);
		 System.out.println(compte3);
		 
		

		 
	}

}
