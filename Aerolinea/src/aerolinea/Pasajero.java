package aerolinea;

public class Pasajero extends Persona{
	
	private int asiento;
	private String fila;
	
	public Pasajero(String pNombre, String pApellido) throws PasajeroMalFormadoException {
		this.setNombre(pNombre);
		this.setApellido(pApellido);
	}
	
	public Pasajero(String pNombre, String pApellido, int pAsiento, int pFilas)throws PasajeroMalFormadoException {
		
		this.setApellido(pApellido);
		this.setNombre(pNombre);
		
		
		
	}
	
	// Metodos Privados
	

}
