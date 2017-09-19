package tests;

import negocio.*;

public class TestZapato {
	
	public static void main(String[] args) {
	
		Producto z1 = new Zapato(Genero.Masculino, "42", "123", "Zapatillas");
		Zapato z2 = new Zapato(Genero.Femenino, "42", "123", "Zapato");
		
		System.out.println(z2.getCodigo() + " " + z2.getNombre() + " " + z2.getTalle() + " " + z2.getMiGenero());
		System.out.println("---------------------------------");
		System.out.println(z2);
		System.out.println("---------------------------------");
		z2.addPrecio(200, "2016-12-12");
		z2.addPrecio(200, "2016-12-12");
		z2.addPrecio(300, "2017-12-12");
		
		System.out.println("---------------------------------");
		System.out.println(z2);
		
		z2.addPrecio(500, "2017-12-13");
		System.out.println("---------------------------------");
		System.out.println(z2.getLastPrecio());
		
		z2.addPrecio(600, "2018-12-12");
		
		System.out.println("---------------------------------");

		System.out.println(z2.getLastPrecio());
		System.out.println("---------------------------------");

		System.out.println(z2.getPrecio("2018-12-20"));
		
		
		
	}
	

	
}
