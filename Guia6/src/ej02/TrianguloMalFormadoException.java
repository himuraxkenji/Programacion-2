package ej02;

public class TrianguloMalFormadoException extends Exception {
	public TrianguloMalFormadoException() {
		this("Triangulo mal formado");
	}
	
	public TrianguloMalFormadoException(String msg) {
		super(msg);
	}
}
