package negocio;

public class Cliente {
	
	private String apellidoYNombre;
	
	public Cliente(String apellidoYNombre) {
		this.apellidoYNombre = apellidoYNombre;
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
	
	
}
