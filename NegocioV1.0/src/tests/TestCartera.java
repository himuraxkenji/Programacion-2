package tests;

import negocio.*;

public class TestCartera {
	
	public static void main(String[] args) {
		
		Producto p1 ;
		try {
			p1 = new Cartera(10, "123", "Aaron");
			
		}catch(ExcepcionesNegocio e) {
			System.err.println(e.getMessage());
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		System.out.println("Halo");
		
		
	}
	
	
}
