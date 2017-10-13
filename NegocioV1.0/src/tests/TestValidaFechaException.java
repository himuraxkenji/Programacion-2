package tests;

import negocio.*;

public class TestValidaFechaException {
	
	public static void main(String[] args) {
		
		try {
			Precio p1 = new Precio(2, "2017-04-30");
			System.out.println("Fecha valida :D");
			System.out.println( p1.getFecha());
		}
		catch (ExcepcionesNegocio e) {
			System.err.println(e.getMessage());
		}
		finally {
			System.out.println(p1);
		}
		
	}
}
