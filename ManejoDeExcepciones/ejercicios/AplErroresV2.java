package ManejoDeExcepciones.ejercicios;

public class AplErroresV2 {

	public static void main(String[] args) {
		try {
			Met1();
//			Met2();
//			Met3(1);
		}
		catch (Exception obj) {
			System.out.println(obj.getMessage());
			return;
		}
		catch (Error obj) {
			System.out.println("ERROR :");
			System.out.println(obj.getMessage());
			
			return;
		}
	}
	
	public static void Met1() {
		try {
			int n=10/1;
		} catch (Exception objeto) {
			System.out.println("Se preentó  un error en el método 1");
			return;
	
		}
		Met2();
	}
	public static void Met2() {
	
		System.out.println("cuerpo del método 2");
		int n=10/1;
			Met3(1);
	}
	public static void Met3(long cont) {
//		if(cont == 100)
//			return;
		long a,b,c,d;
		a=b=c=d=100;
		System.out.println(cont+"cuerpo del método 3");
		Met3(cont+1);
	}
}
