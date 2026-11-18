package HerenciaYPolimorfismo.ejercicios.calculadora;

import HerenciaYPolimorfismo.ejercicios.torniquete_especial.TorniqueteEspecial;

public class AplCalculadora {

	public static void main(String[] args) {
		CalculadoraIntermedia calc= new CalculadoraIntermedia();
		
		System.out.println("2 + 8 ="+calc.Sumar(2, 8));
		System.out.println("2 + 8 ="+calc.Sumar(2, 8.9));
		System.out.println("2 elevado 8 ="+calc.Elevar(2, 8));
		System.out.println("Raiz de 9 ="+calc.Raiz(9));

		TorniqueteEspecial t = new TorniqueteEspecial(20,"juan-2,Alicia-6");
	}

}
