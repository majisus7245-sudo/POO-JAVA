package FlujosYArchivos.ejercicios.archivos_secuenciales;
import java.io.*;

import Unidad0_Diagnostico.ejercicios.Rutinas;
/*registro lógico
Nombre  40 caracteres
Edad     3 caracteres (años)
estatura 3 caracteres (cm)
Estatus  1 caracter (A activo B borrado)
*/

public class ArchivoSecuencialCrearAmigos {

	public static void main(String[] args) {
		FileWriter fw;
		try {

			fw = new FileWriter("AMIGOS.TXT");
			String nombre;
			int edad, estatura, estatus;
			for(int i=0 ; i<1_000 ;i++) {
				nombre=Rutinas.nextNombre(2).trim();
				edad=Rutinas.nextInt(18, 65);
				estatura=Rutinas.nextInt(150, 187);
				estatus=Rutinas.nextInt(1, 2);
				String linea=String.format("%-40s%3d%3d%1s", nombre,edad,estatura,estatus==1?"A":"B");
				System.out.println(linea.length()+"  "+linea);
				fw.write(linea+"\n");
			}
			fw.close();
			
		} catch (Exception obj) {
			System.out.println("La conexión al archivo AMIGOS.TXT no se realizó");
			System.out.println(obj.getMessage());
			return;
		}
		System.out.println("el proceso termino exitosamente!!!!!!!");
		
	}

}
