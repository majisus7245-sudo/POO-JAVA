/*Nombre: Manuel de Jesus Inzunza Lara 
No. Control: 23170195
Materia: Programacion orientada a objetos
Unidad: 6
Proyecto: Proyecto Archivos Binarios
Fecha: 29 de mayo del 2024
Maestro Dr. Clemente Garcia Gerardo*/
package FlujosYArchivos.tareas.ventas_2023;

import java.io.*;

public class Ventas implements VentasInterface{

	private RandomAccessFile arch;
	private String msg;
	private int [] dias = {31,28,31,30,31,30,31,31,30,31,30,31};
	private String [] datos;
	private int totaldias;
	
	public Ventas() {
		try {
			arch = new RandomAccessFile("Ventas2023.dat","rw");
		}catch(Exception obj) {
			msg = "Hubo un error al abrir el archivo";
		}
	}
	private int CalcularDias(int dia, int mes) {
		int total = 0;
		for(int i = 0; i < mes-1; i++) {
			total += dias[i];
		}
		total+=dia;
		return total;
	}
	public int TotalUnidades(String fecha) {
		int unidades = 0;
		datos = fecha.split("-");
		totaldias = CalcularDias(Integer.parseInt(datos[0]),Integer.parseInt(datos[1]));
		try {
			arch.seek(0);
			for(int i = 0; i < totaldias; i++) {
				for(int j = 0; j < 100; j++) {
					unidades += arch.readInt();
				}
			}
		}catch(Exception obj) {
			msg = "Error al calcular las unidades a la fecha: "+fecha;
			return 0;
		}
		return unidades;
	}
	public int TotalUnidades(String fecha, int producto) {
		int unidades = 0;
		datos = fecha.split("-");
		totaldias = CalcularDias(Integer.parseInt(datos[0]),Integer.parseInt(datos[1]));
		try {
			arch.seek(0);
			for(int i = 0; i < totaldias; i++) {
				arch.seek(i*400);
				for(int j = 0; j < producto; j++) {
					unidades += arch.readInt();
				}
			}
		}catch(Exception obj) {
			msg = "Error al calcular las unidades a la fecha: "+fecha+", con referencia del producto: "+producto;
			return 0;
		}
		return unidades;
	}
	public int TotalUnidades(String fecha, int prodIni, int prodFin) {
		int unidades = 0;
		datos = fecha.split("-");
		totaldias = CalcularDias(Integer.parseInt(datos[0]),Integer.parseInt(datos[1]));
		try {
			for(int i = 0; i < totaldias; i++) {
				for(int j = prodIni-1; j <= prodFin-1; j++) {
					arch.seek((i*400)+(j*4));
					unidades += arch.readInt();
				}
			}
		}catch(Exception obj) {
			msg = "Error al calcular las unidades a la fecha: "+fecha+", con referencia de los productos: "+prodIni+"-"+prodFin;
			return 0;
		}
		return unidades;
	}
	public int TotalUnidades(String fechaIni, String fechaFin, int prodIni, int prodFin) {
		int unidades = 0;
		datos = fechaIni.split("-");
		int dia1 = CalcularDias(Integer.parseInt(datos[0]),Integer.parseInt(datos[1]));
		datos = fechaFin.split("-");
		int dia2 = CalcularDias(Integer.parseInt(datos[0]),Integer.parseInt(datos[1]));
		try {
			arch.seek(0);
			for(int i = dia1 - 1; i < dia2; i++) {
				for(int j = prodIni-1; j <= prodFin-1; j++) {
					arch.seek((i*400)+(j*4));
					unidades += arch.readInt();
				}
			}
		}catch(Exception obj) {
			msg = "Error al calcular las unidades de las fechas: "+fechaIni+"-"+fechaFin+", con referencia de los productos: "+prodIni+"-"+prodFin;
			return 0;
		}
		return unidades;
	}
	public boolean Abrir() {
		try {
			arch = new RandomAccessFile("Ventas2023.dat","rw");
		}catch(Exception obj) {
			msg = "Hubo un error al abrir el archivo";
			return false;
		}
		return true;
	}
	public boolean Cerrar() {
		try {
			arch.close();
		}catch(Exception obj) {
			msg = "Hubo un error al cerrar el archivo";
			return false;
		}
		return true;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
