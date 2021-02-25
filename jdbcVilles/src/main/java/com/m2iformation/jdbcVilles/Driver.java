package com.m2iformation.jdbcVilles;

import com.m2iformation.jdbcVilles.services.VilleService;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new VilleService().findAll());
		}

}
