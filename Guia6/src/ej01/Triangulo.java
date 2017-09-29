package ej01;

public class Triangulo  {
	
	private float base;
	private float altura;
	
	public Triangulo(float pBase, float pAltura) throws TrianguloMalFormadoException{
		
		if (pBase == 0 || pAltura == 0) {
			throw new TrianguloMalFormadoException();
		}else {
			this.base = pBase;
			this.altura = pAltura;
		}
	}
	
	public float getArea() {
		return base*altura/2;
	}
	
}
