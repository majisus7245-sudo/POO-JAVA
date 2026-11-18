package FlujosYArchivos.ejercicios.archivos_secuenciales;
import java.io.*;
public class ArchivoSecuencialLeerAmigos {
	
	public static void main(String [] args) {
		FileReader fr=null;
		BufferedReader bf=null;
		String linea, nombre;
		int edad;
		try {
			fr = new FileReader("amigos.TXT");
			bf = new BufferedReader(fr);
			while ( ( linea=bf.readLine())!=null ) {
				nombre= linea.substring(0,39);
				edad = Integer.parseInt(linea.substring(40,42).trim() );
				System.out.println(linea);
			}

		} catch (Exception obj) {
			
			System.out.println("El archivo no existe !!!!");
			return;
		}
		finally {
			try {
			fr.close();
			bf.close();
			}
			catch(Exception obj) {
				System.out.println("No se pudo cerrar los archivos");
				return;
			}
			
		}
		
		
	}	

}
