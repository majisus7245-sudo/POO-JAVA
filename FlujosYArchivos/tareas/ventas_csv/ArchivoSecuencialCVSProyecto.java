/*Nombre: Manuel de Jesus Inzunza Lara 
No. Control: 23170195
Materia: Programacion orientada a objetos
Unidad: 5 y 6
Proyecto: Proyecto Archivo Secuencial
Fecha: 10 de mayo del 2024
Maestro Dr. Clemente Garcia Gerardo*/
package FlujosYArchivos.tareas.ventas_csv;

import java.io.*;

import Unidad0_Diagnostico.ejercicios.Rutinas;

public class ArchivoSecuencialCVSProyecto {

	static private FileReader fr = null;
	static private BufferedReader br = null;
	static private FileWriter fw = null; 
	
	public static void main(String [] args) {
		if(!Abrir()) {
			System.out.println("El archivo no se pudo abrir");
			return;
		}
		if(!Procesar()) {
			System.out.println("Ocurrio un error en el proceso");
			return;
		}
		if(!Cerrar()) {
			System.out.println("El archivo no se pudo cerrar");
			return;
		}
	}
	public static boolean Abrir() {
		try {
			fr = new FileReader("ventas.cvs");
			br = new BufferedReader(fr);
			fw = new FileWriter("VentasModificado.cvs");
		}catch(Exception obj) {
			return false;
		}		
		return true;
	}
	public static boolean Procesar() {
			try {
				String linea;
				String [] datos;
				String [] num;
				int precio, unidad, suma, total = 0, importe;
				float porcentaje;
				while((linea=br.readLine())!=null) {
					suma = 0;
					datos = linea.split("\\$");
					for(int i = 1; i < datos.length; i++) {
						num = datos[i].split(",");
						precio = Integer.parseInt(num[0]);
						unidad = Integer.parseInt(num[1]);
						suma +=precio * unidad;
					}
					total += suma;
					fw.write(linea + ","+suma+"\n");
				}
				Cerrar();
				Abrir();
				System.out.println(total);
				while((linea=br.readLine())!=null) {
					datos = linea.split(",");
					importe = Integer.parseInt(datos[datos.length-1]);
					porcentaje = (float)(importe * 100)/total;
					fw.write(linea + ","+porcentaje+"%\n");
				}
			}catch(Exception obj) {

				return false;
			}
		return true;
	}
	public static boolean Cerrar() {
		try {
			fr.close();
			br.close();
			fw.close();
			new File("ventas.cvs").delete();
			Rutinas.Renombrar("VentasModificado.cvs", "ventas.cvs");
		}catch(Exception obj) {
			return false;
		}		
		return true;
	}
}
