package ManejoDeExcepciones.ejercicios;

public class Sleep {

	public static void main(String[] args) {
		System.out.println("imprie lo importante, necesito una pausa para que lo lean");
		try {
			Thread.sleep(20_000);
		} catch (Exception obj) {}

		System.out.println("el resto del la informacin menos importante");
		

	}

}
