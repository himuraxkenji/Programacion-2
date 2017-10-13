package tests;

import aerolinea.*;

public class TestCiudad {

	public static void main(String[] args) {
		
		Ciudad c1 = null;
		
		try {
			c1 = new Ciudad(null);
			//System.out.println(c1);
		}catch (PasajeroMalFormadoException e) {
			
			System.out.println(e.getMessage());
			
		}
		
		System.out.println("Si");
		
	}
}
