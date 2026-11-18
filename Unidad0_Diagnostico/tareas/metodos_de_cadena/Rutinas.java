//Nombre: Manuel de Jesus Inzunza Lara
//No. Control: 23170195
//Materia: Programacion orientada a objetos
//Unidad: 0
//Proyecto: Metodos de cadenas
//Fecha: 19 de febrero del 2024
//Maestro Dr. Clemente Garcia Gerardo

package Unidad0_Diagnostico.tareas.metodos_de_cadena;

import java.util.*;

public class Rutinas {
	
	static Random r=new Random();
	static String []VN ={"Diego","Daniel","Yessenia","Luis","Anastacia","Plutarco","Alicia","Maria","Sofia","Antonio","Nereida","Carolina",
			"Rebeca","Javier","Luis"};
	static String [] VA={"Garcia","Lopez","Perez","Urias","Mendoza","Coppel","Diaz"};
	static boolean [] Sexo={true,true,false,true,false,true,false,false,false,true,false,false,
			false,true,true};	

	public static String nextNombre(int Numero){
		String Nom="",NomTra="";
		int Pos;
		boolean Genero=true;

		for(int i=0;i<Numero;i++){
			Pos=r.nextInt(VN.length);

			NomTra=VN[Pos]+" ";

			if (i==0){
				Genero=Sexo[Pos];
			}

			if( Genero != Sexo[Pos]  || i>0 && Nom.indexOf(NomTra)>-1    ){
				i--;
				continue;
			}	

			Nom+=NomTra;

		}
		NomTra="";
		for(byte i=0;i<2;i++){
			NomTra+=VA[r.nextInt(VA.length)]+" ";
		}
		Nom=Nom+NomTra;
		return Nom.trim();
	} 	
	public static int nextInt(int li, int ls) {
		return r.nextInt(ls-li+1)+li;
	}
	public static String PonCeros(long numero, int tamaño) {
		String texto=numero+"";
		while (texto.length()<tamaño)
			texto="0"+texto;
		return texto;
	}
	public static String PonBlancos(String texto, int tamaño) {
		while (texto.length()<tamaño)
			texto=texto+" ";
		return texto;
	}

	public static String nextColor() {
		String [] colores= {"rojo","rosa","violeta","negro","amarillo","blanco","gris","azul","verde","cafe","naranja","lila"};
		return colores[ Rutinas.nextInt(0,colores.length-1)   ];
	}
	public static String Mayusculas(String texto) {
	    String textoFinal = "";
	    for (int i = 0; i < texto.length(); i++) {
	        char car = texto.charAt(i);
	        if (car >= 'a' && car <= 'z') {
	            car = (char) (car - 'a' + 'A');
	        } else if (car == 'ñ') {
	            car = 'Ñ';
	        }
	        textoFinal += car;
	    }
	    return textoFinal;
	}
    public static String Minusculas(String texto) {
        String textoFinal = "";
        for (int i = 0; i < texto.length(); i++) {
            char car = texto.charAt(i);
            if (car >= 'A' && car <= 'Z') {
                car = (char) (car - 'A' + 'a');
            }
            else if (car == 'Ñ') {
	            car = 'ñ';
	        }
            textoFinal += car;
        }
        return textoFinal;
    }
    public static String SinBlancos(String texto) {
        String[] palabras = texto.split("\\s+");
        String textoFinal = "";
        for (int i = 0; i < palabras.length; i++) {
        	textoFinal += palabras[i] + " ";
        }
        return textoFinal;
    }
    public static int Comparar(String texto1, String texto2) {
    	int num=0;
    	System.out.println(texto1+"\t"+texto2);
    	 for (int i = 0; i < texto1.length(); i++) {
             char caracter = texto1.charAt(i);
             int codCar=(int)caracter;
             char caracter2 = texto2.charAt(i);
             int codCar2=(int)caracter2;
             if (codCar == codCar2) {	 
                 num=0;
              }
             if(codCar > codCar2) {
            	 num=1;
            	 System.out.println(texto1+" es mayor que "+texto2);
            	 break;
             }
             else if(codCar < codCar2){
            	 num=-1;
            	 System.out.println(texto1+" es menor que "+texto2);
            	 break;
             }
         }
    	 if (num == 0) {
    		 System.out.println(texto1+" es igual que "+texto2);
    	 }
		return num;
    }

}

