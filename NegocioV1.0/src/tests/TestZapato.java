package tests;

import negocio.*;

public class TestZapato {
	
	public static void main(String[] args) {
	
		Producto p1 = null;
		Producto p2 = null;
		
		try {
			p1 = new Zapato(Genero.Femenino, "45", "123", "Adriel");
			p1.addPrecio(10, "2017-10-20");
			p2 = new Zapato(Genero.Femenino, "45", "121", "Adriel");
		} catch (ExcepcionesNegocio e) {
			System.err.println(e.getMessage());
		}
			
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		
	}
	

	
}
