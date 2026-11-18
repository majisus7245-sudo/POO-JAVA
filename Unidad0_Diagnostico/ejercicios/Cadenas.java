package Unidad0_Diagnostico.ejercicios;
import java.util.Arrays;

public class Cadenas {

	public static void main(String[] a) {
		if( a.length == 0) {
			System.out.println("No ha especificado parámetros");
			return;
		}
		boolean band = true;
		int cont=0;
		for( int i=0 ; i<a.length  ; i++) {  
			System.out.println(a[i]);
		}
		
		System.out.println("El arreglo a esta en la direccion "+a);
		System.out.println(Arrays.toString(a));
		
		
		String nom1="EsPERANZo";
		String nom2=new String("ESPERANZO");
		
		
		if( nom1 == nom2)
			System.out.println("Si son iguales");
		else 
			System.out.println("NO SON IGUALES");
		
		int resultado= nom1.compareTo(nom2);
		if( resultado==0)
			System.out.println(nom1+" es igual a "+nom2);
		if( resultado>0)
			System.out.println(nom1+" es mayor que "+nom2+" resultado "+resultado);
		if( resultado<0)
			System.out.println(nom1+" es menor que "+nom2+" resultado "+resultado);
		
		Remplaza();
		
		//int [] fre = Frecuencia("ES UN EJEMPLO DE textoyzñ");
		int [] fre=new int[27];
		Frecuencia("ES UN EJEMPLO DE textoyzñ",fre);
		Imprime(fre);
	}
	public static void Imprime(int [] arreglo) {
		System.out.println("**** FRECUENCIA DE LETRAS ****");
		char car;
		for(int i=0 ; i < arreglo.length ; i++) {
			if(arreglo[i]==0)
				continue;
			if ( i == arreglo.length-1 ) 
				car='Ñ';
			else 
				car= (char)(i+65);
			System.out.println(car+"\t"+arreglo[i]);
		}
	}
//	public static void Frecuencia(String cadena) {
//		int [] f = new int[27];
	public static void Frecuencia(String cadena, int [] f) {
		char car;
		for(int i=0 ; i<cadena.length() ; i++) {
			car = cadena.charAt(i);
			if( car>='a' && car<='z')
				car=(char)(car-32);
			if( car>='A' && car<='Z' || "Ññ".indexOf(car) >=0 ) {
				if("Ññ".indexOf(car) >=0 ) {
					f[ f.length-1]++;
				}
				else 
				   f [ car - 65 ] ++;
			}
		}
		
	}
	public static void Remplaza() {
		String texto="a.b.c.d.e..";
		
	       String nvoTexto=texto.replace('.','*');
	       System.out.println("Texto original "+texto);
	       System.out.println("Texto original "+nvoTexto);
	       
	       
	       if ( texto.startsWith("a.b")) {
	    	   System.out.println("el texto si incia con a.b");
	       }

	}

}
