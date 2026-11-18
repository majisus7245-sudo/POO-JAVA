package ManejoDeExcepciones.ejercicios;

public class Excepciones {

	public static void main(String[] args) {
		try {
			Met1();
//			Met2();
//			Met3();
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Todo bien !!!!!!!!");

	}
	public static void Met1() throws MiExcepcion {
		int a=10/10;
		Met2();
	}
	public static void Met2() throws MiExcepcion {
		int a=Integer.parseInt(" 12334 ".trim());
		Met3();
	}
	public static void Met3() throws MiExcepcion{
	    int edad=10;
	   if( edad<100)
		   throw new MiExcepcion("NOSOTROS PROVOCAMOS ESTE ERROR");
	}
}
