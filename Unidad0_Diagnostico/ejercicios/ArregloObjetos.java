package Unidad0_Diagnostico.ejercicios;


class Dato{
	private String nombre;
	private int veces;
	public Dato() {
		nombre="*****";
		veces=0;
	}
	public Dato(String nombre, int veces) {
		this.nombre=nombre;
		this.veces=veces;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getVeces() {
		return veces;
	}
	public void setVeces(int veces) {
		this.veces = veces;
	}

	public String toString() {
		return nombre+"\t"+veces;
	}
}



public class ArregloObjetos {
	
	
	
	public static void main(String [] a) {
		
		Dato [] arreglo = new Dato[10];
		
		System.out.println("Direccion al elemento 0 ===>>>>"+arreglo);
		
		Crear(arreglo);
		
		arreglo[9].setNombre("Pedro infante");
		arreglo[9].setVeces(100);
		
		Imprimir(arreglo);
	}
	public static void Crear(Dato [] vector) {
		for(int i=0 ; i<vector.length; i++) {
			vector[i]=new Dato();
		}
		
	}
	public static void Imprimir(Dato [] a) {
		
		for(int i=0 ; i<a.length ; i++){
			//System.out.println(a[i].getNombre()+"\t"+a[i].getVeces()   );
			System.out.println(a[i].toString());
		}

	}
}
