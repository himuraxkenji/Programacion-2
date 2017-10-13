package negocio;

public class Cartera extends Producto{
	
	private double volumen;
	
	public Cartera(double volumen, String codigo, String nombre) throws ExcepcionesNegocio{
		
		if (volumen <= 0) 
			throw new ValidaVolumenException("Volumen no valido");
		
		this.setCodigo(codigo);
		this.setNombre(nombre);
		this.volumen = volumen;
		
	}
	
	public double getVolumen() {
		return volumen;
	}

	@Override
	public String toString() {
		return "\nCartera\nVolumen = " + volumen + super.toString();
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cartera other = (Cartera) obj;
		if (Double.doubleToLongBits(volumen) != Double.doubleToLongBits(other.volumen))
			return false;
		return true;
	}
	
	// Metodos Privados
	
	
	
}
