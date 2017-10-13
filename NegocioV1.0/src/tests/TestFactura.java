package tests;

import java.util.*;
import negocio.*;

public class TestFactura {

	public static void main(String[] args) {
		
		Cliente c1 = null;
		Producto p1 = null;
		Producto p2 = null;
		List<Item> i1 = new ArrayList<Item>();
		Factura f1 = null;
		
		try {
			c1 = new Cliente("Riperto", "Adriel");
			p1 = new Zapato(Genero.Masculino, "42", "0001", "Puma");
			p1.addPrecio(200, "2017-09-11");
			p1.addPrecio(250, "2017-10-11");
			p2 = new Cartera(10, "0002", "Adidas");
			p2.addPrecio(150, "2017-09-11");
			p2.addPrecio(200, "2017-10-11");
		} catch (ExcepcionesNegocio e) {
			System.err.println(e.getMessage());
		}
		
		try {
			i1.add(new Item(p1, 1));
			i1.add(new Item(p2, 1));
			System.out.println(i1.get(0).hashCode());
			System.out.println(i1.get(1).hashCode());
		} catch (ExcepcionesNegocio e) {
			System.err.println(e.getMessage());			
		}
		
		try {
			f1 = new Factura(c1, "2017-10-11");
			f1.addItem(p1, 1);
			f1.addItem(p2, 2);
			f1.removeItem(p1);
			System.out.println(f1.getTotal());
		} catch (ExcepcionesNegocio e) {
			System.err.println(e.getMessage());
		}		
		
		System.out.println(f1.getFecha());
		System.out.println(f1.getCliente());
	}

}
