package tests;

import negocio.ExcepcionesNegocio;
import negocio.Precio;

public class TestPrecio {

	public static void main(String[] args) {

		Precio p1 ;
		
		try {
			p1 = new Precio(1, "2017-10-02");
		} catch (ExcepcionesNegocio e) {
			System.err.println(e.getMessage());
		}
	}

}
