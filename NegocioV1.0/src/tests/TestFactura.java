package tests;

import negocio.*;

public class TestFactura {
	
	public static void main(String[] args) {
		
		Factura f1 = new Factura(new Cliente("Adriel"), "2016-12-12");
		
		f1.addItem(new Zapato(Genero.Femenino, "12", "123", "zapas"), 10);
		
		System.out.println(f1);
		
		System.out.println(f1.addItem(new Zapato(Genero.Femenino, "12", "123", "zapas"), 10));
		//f1.addItem(, cantidad)
		
		System.out.println("--------------------");
		
		System.out.println(f1.removeItem(new Zapato(Genero.Femenino, "12", "123", "zapas")));
	}

}
