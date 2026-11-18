/*Nombre: Manuel de Jesus Inzunza Lara 
No. Control: 23170195
Materia: Programacion orientada a objetos
Unidad: 5 y 6
Proyecto: Archivos secuenciales
Fecha: 05 de mayo del 2024
Maestro Dr. Clemente Garcia Gerardo*/

package FlujosYArchivos.tareas.frecuencia_nombres;
import java.io.*;

class Nombre{
	
	private String nombre;
	private int frecuencia;
	
	public Nombre(String nombre) {
		this.nombre = nombre;
		frecuencia = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}
	
}

public class ArchivoSecuencialFrecuenciaNombres {

	public static void main(String[] args) {
		FileReader fr=null;
		BufferedReader bf=null;
		FileWriter fw = null;
		String linea;
		String [] nombre;
		Nombre [] nombres = new Nombre[100];
		Nombre [] clonNombres;
		int conNombres = 0;
		try {
			fr = new FileReader("amigos.TXT");
			bf = new BufferedReader(fr);
			fw = new FileWriter("FrecuenciaAmigos.txt");
			while ( ( linea=bf.readLine())!=null ) {
				int pos1 = -1;
				int pos2 = -1;
				nombre = linea.substring(0,39).split(" ");
				for(int i = 0; i < nombres.length; i++) {
					if(nombres[i].getNombre().equals(nombre[0])) {
						nombres[i].setFrecuencia(nombres[i].getFrecuencia() + 1);
						pos1 = i;
						break;
					}
				}
				if(pos1 == -1) {
					if(conNombres == nombres.length - 1) {
						clonNombres = nombres;
						nombres = new Nombre[nombres.length + 1];
						for(int i = 0; i < clonNombres.length; i++) {
							nombres[i] = clonNombres[i];
						}
					}
					nombres[conNombres] = new Nombre(nombre[0]);
					nombres[conNombres].setFrecuencia(nombres[conNombres].getFrecuencia() + 1);
					conNombres ++;
				}
				for(int i = 0; i < nombres.length; i++) {
					if(nombres[i].getNombre().equals(nombre[1])) {
						nombres[i].setFrecuencia(nombres[i].getFrecuencia() + 1);
						pos2 = i;
						break;
					}
				}
				if(pos2 == -1) {
					if(conNombres == nombres.length - 1) {
						clonNombres = nombres;
						nombres = new Nombre[nombres.length + 1];
						for(int i = 0; i < clonNombres.length; i++) {
							nombres[i] = clonNombres[i];
						}
					}
					nombres[conNombres]= new Nombre(nombre[1]);
					nombres[conNombres].setFrecuencia(nombres[conNombres].getFrecuencia() + 1);
					conNombres ++;
				}
			}
			for(int i = 0; i < nombres.length; i++) {
				String nomFrecuencia = String.format("%-15s%3d", nombres[i].getNombre(),nombres[i].getFrecuencia());
				System.out.println(nomFrecuencia);
				fw.write(nomFrecuencia+"\n");
			}
		} catch (Exception obj) {
			System.out.println(obj.getMessage());
			System.out.println("El archivo no existe !!!!");
			return;
		}
		finally {
			try {
			fr.close();
			bf.close();
			fw.close();
			}
			catch(Exception obj) {
				System.out.println("No se pudo cerrar los archivos");
				return;
			}
		}

	}

}
