package FlujosYArchivos.ejercicios.archivos_directos;
import java.io.*;

import Unidad0_Diagnostico.ejercicios.Rutinas;
// MARCAR LA VIGENCIA CON B DE TODOS LOS REGISTROS QUE CONTENGAN EN EL NOMBRE EL APELLIDO GARCIA
public class BaJaAmigosDat {
	static private RandomAccessFile arch;
	public static void main(String[] args) {
		if( !Abrir()) {
			System.out.println("El archivo AMIGOS.DAT no pudo abrirse");
			return;
		}
		if( !Borrar()) {
			System.out.println("Se presentó un error al crear el arcvivo");
			return;
		}
		if( !Imprimir()) {
			System.out.println("Se presentó error al imprimitr");
			return;
		}
		if(!Cerrar()) {
			System.out.println("No pudo cerrar el archivo");
			return;
		}
		System.out.println("Arcuvi amigo.dat se modificò corectamente !!!!");

	}
	static private boolean Abrir() {
		try {
			arch= new RandomAccessFile("AMIGOS.DAT","rw");
		} catch (Exception obj) {
			return false;
		}
		return true;
	}
	
	static private boolean Borrar() {
		String nombre,color;
		int edad,estatura;
		char vig='B';
		try {
			arch.seek(0);
			int noReg=(int) (arch.length()/69);
			for(int i=0 ; i<noReg ; i++) {
	/* VERSION 1			
				nombre=arch.readUTF(); // 40+2
				edad=arch.readInt();   // 4
				estatura=arch.readInt(); // 4
				color=arch.readUTF(); // 15+2
				vig=arch.readChar();   // 2
				
				if(nombre.indexOf("Garcia")>=0) {
					arch.seek(arch.getFilePointer()-2);
					arch.writeChar('B');
				}
	*/						
				nombre=arch.readUTF();
				if(nombre.indexOf("Garcia")>=0) {//Garcia
					System.out.println(nombre.length()+"  "+nombre.indexOf("Garcia"));

					arch.seek(arch.getFilePointer()+25);
					arch.writeChar(vig);
				} else {
					arch.seek(arch.getFilePointer()+27);
				}
			}
			
		} catch (Exception obj) {
			System.out.println(obj.getMessage());
			return false;
		}
		return true;
	}
	
	static private boolean Cerrar() {
		try {
			
			arch.close();
			//new File("AMIGOS.DAT").delete();
			
		} catch (Exception obj) {
			System.out.println("pppp "+obj.getMessage());
			return false;
		}
		return true;
	}
	static private boolean Imprimir() {
		String nombre,color;
		int edad,estatura;
		char vig='A';
		try {
			arch.seek(0);
			long noReg = arch.length() / 69;
			System.out.println("TOTAL DE REGISTROS = "+noReg);
			for(int i=0 ; i<noReg ; i++) {
				
				nombre=arch.readUTF(); // 40+2
				edad=arch.readInt();   // 4
				estatura=arch.readInt(); // 4
				color=arch.readUTF(); // 15+2
				vig=arch.readChar();   // 2
			//	arch.seek(arch.getFilePointer()+2);
				System.out.printf("%-40s  %5d  %5d  %-15s  %1s\n",nombre,edad,estatura,color,vig+"");
				
				
			}
			System.out.println("TOTAL DE REGISTROS = "+noReg);
		} catch (Exception obj) {
			return false;
		}
		return true;
	}
	
	

}
