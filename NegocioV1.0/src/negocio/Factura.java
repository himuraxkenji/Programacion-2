package negocio;

import java.util.*;

public class Factura {
	
	private List<Item> misItems = new ArrayList<Item>();
	private String fecha;
	private Cliente miCliente;
	
	private List<Producto> productos = new ArrayList<Producto>();
	
	
	public Factura(Cliente miCliente, String pFecha) {
		this.miCliente = miCliente;
		this.fecha = pFecha;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public Cliente getCliente() {
		return miCliente;
	}
	
	public double getTotal() {
		
		double aux = 0;
		for (Item item : misItems) 
			aux += item.getSubtotal(fecha);
		
		return aux;
	}
	
	public boolean addItem(Producto miProducto, int cantidad) {
		
		Item iAux = new Item(miProducto, cantidad);
		
		if (misItems.isEmpty()) {
			misItems.add(iAux);
			productos.add(miProducto);
		}
		
		for (Item item : misItems) {
			for (Producto producto : productos) {
				if (producto.equals(miProducto)) {
					item.getSubtotal(fecha)
				}
			}
		}
		
		misItems.add(iAux);
		return true;
	}
	
	/*
	public boolean removeItem(Producto miProducto) {
		
		for (int i = 0; i < misItems.size(); i++) {
			if () {
				System.out.println("Holu ;");
			}
		}
		
		return misItems.contains(miProducto);
	}
*/
	@Override
	public String toString() {
		return "Factura [misItems=" + misItems + ", fecha=" + fecha + ", miCliente=" + miCliente + "]";
	}
	
	
	
	
	
}
