package negocio;

import java.util.*;

public abstract class Producto {

	private String codigo;
	private String nombre; 
	private List<Precio> misPrecios = new ArrayList<Precio>();
	
	public void setCodigo(String codigo) throws ExcepcionesNegocio{
		if (ValidarCodigo(codigo)) 
			throw new ValidaCodigoException("Codigo no valido");
		
		this.codigo = codigo;
	}
	
	public void setNombre(String nombre) throws ExcepcionesNegocio{
		if (ValidarNombre(nombre)) 
			throw new ValidaNombreException("Nombre no valido");
		
		this.nombre = nombre;
		
	}
	
	public boolean addPrecio(double valor, String fecha) throws ExcepcionesNegocio {
		
		if(valor <= 0 )
			throw new ValidaPrecioException("Precio No Valido");
		
		ValidarFecha(fecha);
		
		if (misPrecios.isEmpty()){
			misPrecios.add(new Precio(valor, fecha));
			return true;
		}
		
		if (comparaFecha(fecha)){
			misPrecios.add(new Precio(valor,fecha));
			
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
	
	public double getPrecio(String fecha) throws ExcepcionesNegocio {
		ValidarFecha(fecha);
		return comparaFechaDos(fecha);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Producto other = (Producto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Producto \nCodigo = " + codigo + "\nNombre = " + nombre + "\nMis Precios = " + misPrecios;
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
	
	private boolean ValidarNombre(String nombre) {
		
		for(int i = 0 ; i < nombre.length(); i++) {
			if ((nombre.charAt(i) < 65 || nombre.charAt(i) > 91) && (nombre.charAt(i) < 97 || nombre.charAt(i) > 122) ) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean ValidarCodigo(String codigo) {
		
		for(int i = 0 ; i < codigo.length(); i++) {
			if (codigo.charAt(i) < 48 || codigo.charAt(i) > 57 ) {
				return true;
			}
		}
		
		return false;
	}
	
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




