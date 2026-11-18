package HerenciaYPolimorfismo.ejercicios.clase_base;

public class AplClasebase {

	public static void main(String[] args) {
		Subclase obj = new Subclase(10,20,30,40);
		System.out.println(obj.toString());
		System.out.println("Suma de los atributos = "+obj.Sumar());
	}
}
