package negocio;

public class Zapato extends Producto{
	
	private Genero miGenero;
	private String talle;
	
	public Zapato(Genero miGenero, String talle, String codigo, String nombre){
		
		this.miGenero = miGenero;
		this.talle = talle;
		this.setCodigo(codigo);
		this.setNombre(nombre);
	}
	
	public Genero getMiGenero() {
		return miGenero;
	}
	
	public String getTalle() {
		return talle;
	}

	@Override
	public String toString() {
		return "Zapato\nGenero = " + miGenero + "\nTalle = " + talle + "\n" + super.toString() ;
	}

	@Override
	public boolean equals(Object obj) {
		super.equals(obj);
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zapato other = (Zapato) obj;
		if (miGenero != other.miGenero)
			return false;
		if (talle == null) {
			if (other.talle != null)
				return false;
		} else if (!talle.equals(other.talle))
			return false;
		return true;
	}
	
	
	
}
