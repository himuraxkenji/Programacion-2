package aerolinea;

public abstract class Persona {

	private String apellido;
	private String nombre;
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) throws PasajeroMalFormadoException {
		
		if (apellido == null)
			throw new PasajeroNombreoApellidoNulosException("\nCampo Nombre de Pasajero Vacio");
		if (ValidarNombre(apellido))
			throw new PasajeroNombreNoValido("\nNombre de Pasajero No valido");
		
		this.apellido = apellido;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre)throws PasajeroMalFormadoException {
		
		if (nombre == null)
			throw new PasajeroNombreoApellidoNulosException("\nCampo Apellido de Pasajero Vacio");
		if (ValidarNombre(nombre))
			throw new PasajeroNombreNoValido("\nApellido de Pasajero No valido");
		
		this.nombre = nombre;
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
