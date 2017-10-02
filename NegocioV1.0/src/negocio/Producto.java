package negocio;

import java.util.*;

public abstract class Producto {

	private String codigo;
	private String nombre; 
	private List<Precio> misPrecios = new ArrayList<Precio>();
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean addPrecio(double valor, String fecha) throws ExcepcionesNegocio {
		
		if (misPrecios.isEmpty() || comparaFecha(fecha)) {
			misPrecios.add(new Precio(valor, fecha));
			return true;
		}
		else {
			System.out.println("Fecha no valida");
		}
		
		return false;
		
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getLastPrecio(){
		
		return misPrecios.get(misPrecios.size()-1).getValor();
		
	}
	
	public double getPrecio(String fecha) {
		return comparaFechaDos(fecha);
	}
	
	@Override
	public String toString() {
		return "Producto \nCodigo = " + codigo + "\nNombre = " + nombre + "\nMis Precios = " + misPrecios;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (misPrecios == null) {
			if (other.misPrecios != null)
				return false;
		} else if (!misPrecios.equals(other.misPrecios))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	// METODOS PRIVADOS
	
	private boolean comparaFecha(String fecha){
		
		for (Precio precio : misPrecios) {
			
			if (precio.getFecha().compareToIgnoreCase(fecha) == 0 || 
					precio.getFecha().compareToIgnoreCase(fecha) > 0) {
				return false;
			}
			
		}
		
		return true;
	}
	
	private double comparaFechaDos(String fecha){
		
		double aux = 0;
		if(misPrecios.isEmpty() == true) {
			System.out.println("No hay precios Cargados");
			return 0;
		}
		
		if (misPrecios.size() == 1) {
			return misPrecios.get(0).getValor();
		}
		
		for (Precio precio : misPrecios) {
			if (precio.getFecha().compareToIgnoreCase(fecha) == 0) {
				return precio.getValor();
			}
		}
		aux = misPrecios.get(0).getValor();
		for (int i = 1; i < misPrecios.size(); i++) {
			if (convertirAEntero(fecha) > convertirAEntero(misPrecios.get(i).getFecha())) {
				aux = misPrecios.get(i).getValor();
			}			
		}
		
		return aux;
	}
	
	private int convertirAEntero(String fecha) {
		String fechaN = "";
		for (int i = 0; i < fecha.length(); i++) {
			if(fecha.charAt(i) == '-') 
				fechaN+="";
			else			
				fechaN+=fecha.charAt(i);
		}
		
		
		return Integer.parseInt(fechaN);
	}
}




