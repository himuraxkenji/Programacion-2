package tests;

import negocio.*;

public class TestItems {
	
	public static void main(String[] args) {
		
		Item i1 = null;
		Item i2 = null;
		
		try {
			Producto p1 = new Zapato(Genero.Femenino, "42", "0001", "Zapatilla");
			p1.addPrecio(10, "2017-10-10");
			p1.addPrecio(19, "2017-10-11");
			i1 = new Item(p1, 10);
		} catch (ExcepcionesNegocio e) {
			System.err.println(e.getMessage());
		}
		
		
		
		
		
	}

}
