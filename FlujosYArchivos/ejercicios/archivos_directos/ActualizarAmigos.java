package FlujosYArchivos.ejercicios.archivos_directos;

import java.io.RandomAccessFile;
import java.util.*;

import Unidad0_Diagnostico.ejercicios.Rutinas;

public class ActualizarAmigos {
	final static int longRegistro=69;
	static private RandomAccessFile arch;
	public static void main(String[] args) {
		if( !Abrir()) {
			System.out.println("El archivo AMIGOS.DAT no pudo abrirse");
			return;
		}
		if( !Actualizar()) {
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
	
	static private boolean Actualizar() {
		String nombre,color;
		int edad,estatura, id ;
		char vig;
		Scanner in = new Scanner(System.in);
		
		try {
			int totalRegistros=(int) (arch.length()/longRegistro);
			while (true) {
				System.out.print("id : ");
				id=in.nextInt();
				if( id == 0)
					break;
				if(id<1 || id>totalRegistros) {
					System.out.println("id no váligo");
					continue;
				}
				
				arch.seek( (id-1) * longRegistro);
				nombre=arch.readUTF(); // 40+2
				edad=arch.readInt();   // 4
				estatura=arch.readInt(); // 4
				color=arch.readUTF(); // 15+2
				vig=arch.readChar();   // 2
				while (true){
					System.out.println("1- nombre "+nombre);
					System.out.println("2- edad "+edad);
					System.out.println("3- estatura "+estatura);
					System.out.println("4- Color "+color);
					System.out.println("5- Vigencia "+vig);
					System.out.println("0- Salir ");
					System.out.print("opción : ");
					int op=in.nextInt();
					if(op<0 || op>5) {
						System.out.println("opción no válida");
						continue;
					}
					if(op ==0 ) {
						nombre=nombre.length()>40?nombre.substring(0, 40):nombre;
						nombre=Rutinas.PonBlancos(nombre, 40);
						color=color.length()>15?color.substring(0,15):color;
						color=Rutinas.PonBlancos(color, 15);
						arch.seek( (id-1) * longRegistro);
						arch.writeUTF(nombre);
						arch.writeInt(edad);
						arch.writeInt(estatura);
						arch.writeUTF(color);
						arch.writeChar(vig);
						break;
					}
					switch (op) {
					case 1:
						in.nextLine();
						System.out.print("Nuevo nombre --> ");
						nombre=in.nextLine();
//						arch.seek( (id-1) * longRegistro);
//						arch.writeUTF(nombre);
						break;
					case 2:
						System.out.print("Nueva edad -->");
						edad=in.nextInt();
//						arch.seek( (id-1) * longRegistro+42);
//						arch.writeInt(edad);
						break;
					case 3:
						System.out.print("Nueva estatura -->");
						estatura=in.nextInt();
						break;
					case 4:
						in.nextLine();
						System.out.print("Nuevo color --> ");
						color=in.nextLine();
						break;
					case 5:
						System.out.print("Nueco estatus ");
						vig = in.next().charAt(0);
						break;
					}
				}
			}
		
		} catch (Exception obj) {
			return false;
		}
		return true;
	}
	
	static private boolean Cerrar() {
		try {
			
			arch.close();
			//new File("AMIGOS.DAT").delete();
			
		} catch (Exception obj) {
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
