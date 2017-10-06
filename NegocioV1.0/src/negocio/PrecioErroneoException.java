package negocio;

public class PrecioErroneoException extends ExcepcionesNegocio{

	public PrecioErroneoException(String msg) {
		super("Error en el Precio: " + msg);
	}

}
