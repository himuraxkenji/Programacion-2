package tests;

public class fecha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fecha = "yyyy-mm-dd";
		
		System.out.println(fecha.substring(0, 4));// YYYY
		System.out.println(fecha.substring(4, 5));// -
		System.out.println(fecha.substring(5, 7));// MM
		System.out.println(fecha.substring(7, 8));// -
		System.out.println(fecha.substring(8, 10));// DD
		
		
		
	}

}
