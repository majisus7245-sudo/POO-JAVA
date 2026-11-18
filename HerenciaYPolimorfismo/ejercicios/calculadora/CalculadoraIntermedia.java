package HerenciaYPolimorfismo.ejercicios.calculadora;

public class CalculadoraIntermedia extends CalculadoraBasica{

	public double Sumar(int x, double y) {
		return x+y;
	}
	public double Sumar(double x, double y) {
		return x+y;
	}
	public double Sumar(double x, int y) {
		return x+y;
	}
	public double Elevar(double x, double y) {
		return Math.pow(x, y);
	}
	public double Raiz(double x) {
		return Math.sqrt(x);
	}
}
