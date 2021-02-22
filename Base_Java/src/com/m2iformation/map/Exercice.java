package com.m2iformation.map;
import java.util.*;


public class Exercice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> listeEntiers = new ArrayList<>();
		
		listeEntiers.add(4);
		listeEntiers.add(2);
		listeEntiers.add(10);
		listeEntiers.add(9);
		listeEntiers.add(12);
		listeEntiers.add(0);
		listeEntiers.add(-5);
		
		System.out.println(listeEntiers);
		
		System.out.println(findMax(listeEntiers));
		
		System.out.println(findMaxAlgo(listeEntiers));

		swapElements(listeEntiers, 0, 2);
		
		System.out.println(listeEntiers);
		
		swapElementsAlgo(listeEntiers, 0, 2);
		
		System.out.println(listeEntiers);
	}
	
	public static int findMaxAlgo(List<Integer> list) {
		int max = list.get(0);
		for (Integer element: list) {
			if (element > max) {
				max = element;
			}
		}
		
		return max;
	}
	
	
	public static int findMax(List<Integer> list) {
		return Collections.max(list);
	}
	
	public static void swapElements(List<Integer> list, int index1, int index2) {
		Collections.swap(list, index1, index2);
		
	}
	
	public static void swapElementsAlgo(List<Integer> list, int index1, int index2) {
		int valeur1 = list.get(index1);
		int valeur2 = list.get(index2);
		
		list.set(index1, valeur2);
		list.set(index2, valeur1);
	
		
		
	}

}
