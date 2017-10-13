package negocio;

public class Precio {

	private double valor;
	private String fecha;
	
	public Precio(double valor, String fecha)throws ExcepcionesNegocio{
		
		// Comprobar Precio 
		if ( valor <= 0 ) 
			throw new ValidaPrecioException("Precio no valido");

		// Comprobar Fecha
		ValidarFecha(fecha);
		this.valor = valor;
		this.fecha = fecha;
			
	}
	
	public double getValor() {
		return valor;
	}
	
	public String getFecha() {
		return fecha;
	}

	@Override
	public String toString() {
		return "\nPrecio\n\tValor = " + valor + "\n\tFecha = " + fecha;
	}
	
	private boolean bisiesto(int year) {
	    return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
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
}
