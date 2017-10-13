package negocio;

import java.util.*;

public class Factura {
	
	private Set<Item> misItems = new HashSet<Item>();
	private String fecha;
	private Cliente miCliente;
	
	public Factura(Cliente miCliente, String pFecha) throws ExcepcionesNegocio {
		
		ValidarFecha(pFecha);
		
		this.fecha = pFecha;
		
		this.miCliente = miCliente;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public Cliente getCliente() {
		return miCliente;
	}
	
	public double getTotal() throws ExcepcionesNegocio {
		
		double aux = 0;
		for (Item item : misItems) 
			aux += item.getSubtotal(fecha);
		
		return aux;
	}
	
	public boolean addItem(Producto miProducto, int cantidad) throws ExcepcionesNegocio {
		
		Item iAux = new Item(miProducto, cantidad);
		
		if (misItems.isEmpty()) {
			misItems.add(iAux);
			return true;
		}
		
		misItems.add(iAux);
		return true;
	}
	
	
	public boolean removeItem(Producto miProducto) throws ExcepcionesNegocio {
		
		Item i1 = new Item(miProducto, 1);
			
		if (misItems.isEmpty()) {
			System.out.println("No hay productos que borrar.");
			return false;
		}
		misItems.remove(i1);
		
		
		//System.out.println("El producto no esta en la lista");
		return true;
	}

	@Override
	public String toString() {
		return "Factura " + "\nCliente:" + miCliente + " -------- Fecha: " + fecha + "\nMis Items: \n" + misItems;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((miCliente == null) ? 0 : miCliente.hashCode());
		result = prime * result + ((misItems == null) ? 0 : misItems.hashCode());
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
	
	
	// Metodos Privados
	
	private boolean ValidarFecha(String fecha) throws ExcepcionesNegocio{
		
		if (fecha.length() != 10)
			throw new ValidaFechaException("Formato no valido");
		if (fecha.charAt(4) != '-'|| fecha.charAt(7)!= '-')
			throw new ValidaFechaException("Formato no valido");
		if (Integer.parseInt(fecha.substring(0, 4)) < 2017 )
				throw new ValidaFechaException("Año no valido");
		if(Integer.parseInt(fecha.substring(5, 7)) <= 0 || Integer.parseInt(fecha.substring(5, 7)) > 12  ) 
				throw new ValidaFechaException("Mes fuera de rango");
		
		switch(Integer.parseInt(fecha.substring(5, 7) )) {
				case 1:case 3:case 5: case 7: case 8: case 10: case 12:
					if (Integer.parseInt(fecha.substring(8, 10)) > 31|| Integer.parseInt(fecha.substring(8, 10)) <= 0){
						throw new ValidaFechaException("Dia fuera de rango");
					}
					break;
				case 4: case 6: case 9: case 11:
					if (Integer.parseInt(fecha.substring(8, 10)) > 30|| Integer.parseInt(fecha.substring(8, 10)) <= 0){
						throw new ValidaFechaException("Dia fuera de rango");
					}
					break;
				case 2:
					if (bisiesto(Integer.parseInt(fecha.substring(0, 4))) && Integer.parseInt(fecha.substring(8, 10)) > 29|| Integer.parseInt(fecha.substring(8, 10)) <= 0 )
						throw new ValidaFechaException("Dia fuera de rango");
					
					if (Integer.parseInt(fecha.substring(8, 10)) > 28|| Integer.parseInt(fecha.substring(8, 10)) <= 0) 
						throw new ValidaFechaException("Dia fuera de rango");
					
			}
		return true;
		
	}
	
	private boolean bisiesto(int year) {
	    return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
	
	
	
	
	
}
