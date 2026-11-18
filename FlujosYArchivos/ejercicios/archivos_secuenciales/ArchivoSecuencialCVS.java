package FlujosYArchivos.ejercicios.archivos_secuenciales;

import java.io.FileWriter;

import Unidad0_Diagnostico.ejercicios.Rutinas;

public class ArchivoSecuencialCVS {
	static private FileWriter fw;

	public static void main(String[] args) {
		if(!Abrir()) {
			System.out.println("No pudo abrir el archivo");
			return;
		}
		if( !Crear()) {
			System.out.println("no pudo crear ell archivo CVS");
			return;
		}
		if(!Cerrar()) {
			System.out.println("No pudo cerrar el archivo");
			return;
		}

	}
	public static boolean Abrir() {
		try {
			fw=new FileWriter("AMIGOS.CVS");
			
			
		} catch (Exception obj) {
			return false;
		}
		return true;
	}
	public static boolean Crear() {
		// nombre, edad, estatura, color.
		
		try {
			String nom,color;
			int edad, estatura;
			fw.write("Nombre,edad,estatura,color\n");
			for(int i= 0 ; i<10_000 ; i++) {
				nom=Rutinas.nextNombre(2);
				color=Rutinas.nextColor();
				edad=Rutinas.nextInt(18, 65);
				estatura=Rutinas.nextInt(170, 199);
				
				fw.write(nom+","+edad+","+estatura+","+color+"\n");
				
				
			}
			
		} catch (Exception e) {
			return false;
		}

		return true;
	}
	public static boolean Cerrar() {
		try {
			fw.close();
		} catch (Exception obj) {
			return false;
		}
		return true;
	}
}
