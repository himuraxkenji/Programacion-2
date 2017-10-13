package aerolinea;

public class Ciudad {

	private String nombre;
	
	public Ciudad(String pNombre) throws PasajeroMalFormadoException  {
		
		if (pNombre == null) 
			throw new PasajeroNombreoApellidoNulosException("\nCampo de Ciudad Vacio");
		
		if (ValidarNombre(pNombre)) 
			throw new PasajeroNombreNoValido("\nCiudad no valida");

		this.nombre = pNombre;
	
	}
	
	public String getNombre() {
		return nombre;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ciudad other = (Ciudad) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
	
	@Override
	public String toString() {
		return "\nCiudad: " + nombre;
	}
	
	//Metodos Privados
	
	private boolean ValidarNombre(String nombre) {
		
		for(int i = 0 ; i < nombre.length(); i++) {
			if ((nombre.charAt(i) < 65 || nombre.charAt(i) > 91) && (nombre.charAt(i) < 97 || nombre.charAt(i) > 122) ) {
				return true;
			}
		}
		
		return false;
	}
	
}
