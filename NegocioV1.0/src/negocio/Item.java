package negocio;

public class Item {
	
	private Producto miProducto;
	private int cantidad;
	
	public Item(Producto miProducto, int cantidad) {
		
		this.miProducto = miProducto;
		this.cantidad = cantidad;
	}
	
	public double getSubtotal(String fecha) {
		
		return miProducto.getPrecio(fecha) * cantidad;
	}

	@Override
	public String toString() {
		return "\nItem\nMi Producto = " + miProducto + "\nCantidad = " + cantidad ;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (cantidad != other.cantidad)
			return false;
		if (miProducto == null) {
			if (other.miProducto != null)
				return false;
		} else if (!miProducto.equals(other.miProducto))
			return false;
		return true;
	}
	
	
	
	
	
}
