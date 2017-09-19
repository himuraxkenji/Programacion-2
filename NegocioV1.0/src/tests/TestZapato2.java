package tests;

import negocio.*;

public class TestZapato2 {

	public static void main(String[] args) {
		
		//Producto z1 = new Zapato(Genero.Masculino, "42", "123", "Zapatillas");
		Zapato z2 = new Zapato(Genero.Femenino, "42", "123", "Zapato");
		
		System.out.println(z2.getPrecio("2016-12-12"));
		
		z2.addPrecio(100, "2014-12-12");
		
		z2.addPrecio(300, "2016-12-12");
		
		z2.addPrecio(400, "2016-13-12");
		
		z2.addPrecio(500, "2016-14-12");
		
		System.out.println("---------------------------");
		
		System.out.println(z2.getPrecio("2012-14-12")); // 100
			
		System.out.println(z2.getPrecio("2014-14-12")); // 100
		
		System.out.println(z2.getPrecio("2016-13-11")); //300
		
		System.out.println(z2.getPrecio("2018-14-12")); // 500
		
		
		
	}
	
}
