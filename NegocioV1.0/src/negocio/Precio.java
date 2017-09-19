package negocio;

public class Precio {

	private double valor;
	private String fecha;
	
	public Precio(double valor, String fecha){
		
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
	
	
}
