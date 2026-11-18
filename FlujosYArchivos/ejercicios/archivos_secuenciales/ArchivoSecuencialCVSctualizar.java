package FlujosYArchivos.ejercicios.archivos_secuenciales;

import java.io.*;

import Unidad0_Diagnostico.ejercicios.Rutinas;

public class ArchivoSecuencialCVSctualizar {
	static private FileReader fr=null;
	static private BufferedReader bf=null;
	static private FileWriter fw=null;

	public static void main(String[] args) {
		if(!Abrir()) {
			System.out.println("No pudo abrir el archivo");
			return;
		}
		if( !Actualizar()) {
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
			fw=new FileWriter("TRABAJO.CVS");
			
		} catch (Exception obj) {
			return false;
		}
		return true;
	}
	public static boolean Actualizar() {
		// nombre, edad, estatura, color.
		try {
			String linea=bf.readLine();
			String [] campos;
			int estatura,cont=0;
			while ( ( linea=bf.readLine())!=null ) {
				campos=linea.split(",");
				estatura=Integer.parseInt(campos[2]);
				if(estatura<180) {
					estatura=Rutinas.nextInt(180, 199);
					cont++;
				}

				fw.write(campos[0]+","+campos[1]+","+estatura+","+campos[3]+"\n");
	
				}
			System.out.println("estaturas corregidas "+cont);
			
			
		} catch (Exception e) {
			return false;
		}

		return true;
	}
	public static boolean Cerrar() {
		try {
			fr.close();
			bf.close();
			fw.close();
			new File("AMIGOS.CVS").delete();
			Rutinas.Renombrar("trabajo.cvs", "AMIGOS.CVS");
		} catch (Exception obj) {
			return false;
		}
		return true;
	}

}
