package HerenciaYPolimorfismo.ejercicios.clase_base;
public class Subclase extends Superclase{
	private int atr4;
	
	public Subclase() {
		atr4=4;
	}
	public Subclase(int atr1,int atr2, int atr3, int atr4) {
		super(atr1,atr2,atr3);
		this.atr4=atr4;
	}
	public String toString() {
		return super.toString()+" atr4 = "+atr4;
	}
	public int Sumar() {
		return atr4 + super.Sumar();
	}
	public int Sumar(int a, int b , int c) {
		return a;
	}
}
