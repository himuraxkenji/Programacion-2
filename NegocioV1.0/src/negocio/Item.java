package negocio;

public class Item {
	
	private Producto miProducto;
	private int cantidad;
	
	public Item(Producto miProducto, int cantidad) throws ExcepcionesNegocio{
		
		if (cantidad <= 0 ) 
			throw new ValidaCantidadException("Cantidad no valida");
			
		this.cantidad = cantidad;
		this.miProducto = miProducto;
		
	}
	
	public double getSubtotal(String fecha) throws ExcepcionesNegocio {
		
		return miProducto.getPrecio(fecha) * cantidad;
		
	}

	@Override
	public String toString() {
		return "\nItem\nMi Producto = " + miProducto + "\nCantidad = " + cantidad ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((miProducto == null) ? 0 : miProducto.hashCode());
		return result;
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
		if (miProducto == null) {
			if (other.miProducto != null)
				return false;
		} else if (!miProducto.equals(other.miProducto))
			return false;
		return true;
	}
	
	
	
	
	
}
