package FlujosYArchivos.ejercicios.archivos_secuenciales;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import Unidad0_Diagnostico.ejercicios.Rutinas;

public class ArchivoSecuencialLerrCVS {
	static private FileReader fr=null;
	static private BufferedReader bf=null;

	public static void main(String[] args) {
		if(!Abrir()) {
			System.out.println("No pudo abrir el archivo");
			return;
		}
		if( !Imprimir()) {
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
			fr = new FileReader("amigos.cvs");
			bf = new BufferedReader(fr);
			
		} catch (Exception obj) {
			return false;
		}
		return true;
	}
	public static boolean Imprimir() {
		// nombre, edad, estatura, color.
		
		try {
			String linea=bf.readLine();
			String [] campos;
			int estatura,cont=0;
			while ( ( linea=bf.readLine())!=null ) {
				campos=linea.split(",");
				estatura=Integer.parseInt(campos[2]);
				if(estatura<180)
					continue;
				System.out.printf("%-50s%5s%5s%-10s\n",campos[0],campos[1],campos[2],campos[3]);	
					cont++;
				}
			System.out.println("Personas con estatura >= 180 "+cont);
			
			
		} catch (Exception e) {
			return false;
		}

		return true;
	}
	public static boolean Cerrar() {
		try {
			fr.close();
			bf.close();
		} catch (Exception obj) {
			return false;
		}
		return true;
	}

}
