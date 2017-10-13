package negocio;

public class Cliente {
	
	private String apellidoYNombre;
	
	public Cliente(String apellido, String nombre) throws ValidaNombreException {
		
		if (ValidarNombre(apellido)) 
			throw new ValidaNombreException("El Nombre no es valido");
		if (ValidarNombre(nombre)) 
			throw new ValidaNombreException("El Apellido no es valido");
		
		this.apellidoYNombre = apellido+" "+nombre;

	}
	
	public String getApellidoYNombre() {
		return apellidoYNombre;
	}

	@Override
	public String toString() {
		return "\nCliente\nApellido y Nombre = " + apellidoYNombre ;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (apellidoYNombre == null) {
			if (other.apellidoYNombre != null)
				return false;
		} else if (!apellidoYNombre.equals(other.apellidoYNombre))
			return false;
		return true;
	}
	
	// Metodos Privados
	
	private boolean ValidarNombre(String nombre) {
		
		for(int i = 0 ; i < nombre.length(); i++) {
			if ((nombre.charAt(i) < 65 || nombre.charAt(i) > 91) && (nombre.charAt(i) < 97 || nombre.charAt(i) > 122) ) {
				return true;
			}
		}
		
		return false;
	}
	
}
