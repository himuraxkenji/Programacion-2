package ej01;

public class TestTrianguloMalFormado {

	public static void main(String[] args) {
		try {
			Triangulo p = new Triangulo(2, 3);
			System.out.println(p.getArea());
			
			/*p = new Triangulo(0, 5);
			System.out.println(p.getArea());*/
			
			int e = 23/0;
			
		}catch (TrianguloMalFormadoException ex) {
			System.err.println(ex.getMessage());
		}catch(Exception ex) {
			System.err.println(ex.getMessage());
		}finally {
			System.out.println("Yo corro siempre");
		}

	}

}
