package negocio;

public class Precio {

	private double valor;
	private String fecha;
	
	public Precio(double valor, String fecha)throws ExcepcionesNegocio{
		
		this.valor = valor;
		
		if (Integer.parseInt(fecha.substring(0, 4)) == 0  ) 
			throw new ValidaFechaException("El dia no puede ser 0");
		}else{
			if (fecha.substring(3, 4) != 0) {
			
			}
		
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
	
	
}
