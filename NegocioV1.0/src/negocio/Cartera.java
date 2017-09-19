package negocio;

public class Cartera extends Producto{
	
	private double volumen;
	
	public Cartera(double volumen, String codigo, String nombre) {
		this.volumen = volumen;
		this.setCodigo(codigo);
		this.setNombre(nombre);
	}
	
	public double getVolumen() {
		return volumen;
	}

	@Override
	public String toString() {
		return "\nCartera\nVolumen = " + volumen + super.toString();
	}

	public boolean equals(Object obj) {
		super.equals(obj);
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
	
	
	
	
}
