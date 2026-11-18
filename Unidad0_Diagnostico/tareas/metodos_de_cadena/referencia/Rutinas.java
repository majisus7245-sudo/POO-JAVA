package Unidad0_Diagnostico.tareas.metodos_de_cadena.referencia;

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
		boolean Genero=true;;

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
}
