package FlujosYArchivos.ejercicios.archivos_directos;
import java.io.*;

import Unidad0_Diagnostico.ejercicios.Rutinas;
public class CrearArchivoDirecto {

	static private RandomAccessFile arch=null;
	
	public static void main(String[] args) {
		if( !Abrir()) {
			System.out.println("El archivo AMIGOS.DAT no pudo abrirse");
			return;
		}
		if( !Crear()) {
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
		System.out.println("Arcuvi amigo.dat creado corectamente !!!!");

	}
	static private boolean Abrir() {
		try {
			arch= new RandomAccessFile("AMIGOS.DAT","rw");
		} catch (Exception obj) {
			return false;
		}
		return true;
	}
	
	static private boolean Crear() {
		String nombre,color;
		int edad,estatura;
		char vig='A';
		try {
			arch.seek(arch.length());
			
			for(int i=0 ; i<10 ; i++) {
				nombre = Rutinas.nextNombre(1);
				nombre=nombre.length()>40?nombre.substring(0, 40):nombre;
				nombre=Rutinas.PonBlancos(nombre, 40);
				color = Rutinas.nextColor();
				color=color.length()>15?color.substring(0,15):color;
				color=Rutinas.PonBlancos(color, 15);
				edad=Rutinas.nextInt(18, 65);
				estatura=Rutinas.nextInt(170,199);
				
				arch.writeUTF(nombre);
				arch.writeInt(edad);
				arch.writeInt(estatura);
				arch.writeUTF(color);
				arch.writeChar(vig);
				
				
				
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
			//	vig=arch.readChar();   // 2
				arch.seek(arch.getFilePointer()+2);
				System.out.printf("%-40s  %5d  %5d  %-15s  %1s\n",nombre,edad,estatura,color,vig+"");
				
				
			}
			System.out.println("TOTAL DE REGISTROS = "+noReg);
		} catch (Exception obj) {
			return false;
		}
		return true;
	}

}
