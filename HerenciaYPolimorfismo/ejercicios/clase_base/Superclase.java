package HerenciaYPolimorfismo.ejercicios.clase_base;

public class Superclase {
	private int atr1,atr2;
	protected int atr3;
	
	public Superclase() {
		atr1=1;
		atr2=2;
		atr3=3;
	}
	public Superclase(int atr1,int atr2,int atr3) {
		this.atr1=atr1;
		this.atr2=atr2;
		this.atr3=atr3;
	}
	public int Sumar() {
		return atr1+atr2+atr3;
	}
	public String toString() {
		return "atr1= "+atr1+"\n"+"atr2= "+atr2+"\n"+"atr3= "+atr3+"\n";
	}
	public int getAtr1() {
		return atr1;
	}
	public void setAtr1(int atr1) {
		this.atr1 = atr1;
	}
	public int getAtr2() {
		return atr2;
	}
	public void setAtr2(int atr2) {
		this.atr2 = atr2;
	}
	public int getAtr3() {
		return atr3;
	}
	public void setAtr3(int atr3) {
		this.atr3 = atr3;
	}
	
}
