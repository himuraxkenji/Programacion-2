package negocio;

import java.util.*;

public class Factura {
	
	private List<Item> misItems = new ArrayList<Item>();
	private String fecha;
	private Cliente miCliente;
	
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
			return true;
		}
		
		for (Item item : misItems) {
			if (item.equals(miProducto)) {
					return false;
			}
		}
		
		misItems.add(iAux);
		return true;
	}
	
	
	public boolean removeItem(Producto miProducto) {
		
		if (misItems.isEmpty()) {
			System.out.println("No hay productos que borrar.");
			return false;
		}
		
		
		for (int i = 0; i < misItems.size(); i++) {
			if (misItems.equals(miProducto)) {
				misItems.remove(miProducto);
				return true;
			}
		}
		
		System.out.println("El producto no esta en la lista");
		return false;
	}

	@Override
	public String toString() {
		return "Factura [misItems=" + misItems + ", fecha=" + fecha + ", miCliente=" + miCliente + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Factura other = (Factura) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (miCliente == null) {
			if (other.miCliente != null)
				return false;
		} else if (!miCliente.equals(other.miCliente))
			return false;
		if (misItems == null) {
			if (other.misItems != null)
				return false;
		} else if (!misItems.equals(other.misItems))
			return false;
		return true;
	}
	
	
	
	
	
	
}
