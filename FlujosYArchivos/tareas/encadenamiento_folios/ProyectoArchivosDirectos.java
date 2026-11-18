/*Nombre: Manuel de Jesus Inzunza Lara 
No. Control: 23170195
Materia: Programacion orientada a objetos
Unidad: 6
Proyecto: Proyecto Archivos Directos
Fecha: 26 de mayo del 2024
Maestro Dr. Clemente Garcia Gerardo*/
package FlujosYArchivos.tareas.encadenamiento_folios;

import java.io.*;

public class ProyectoArchivosDirectos {

	private static RandomAccessFile archF;//FolioPri.dat
	private static RandomAccessFile archD;//FolioDetallePri.dat
	
	public static void main(String[] args) {
		if(!Abrir()) {
			System.out.println("El archivo no se pudo abrir");
			return;
		}
		Procesar();
		if(!Cerrar()) {
			System.out.println("El archivo no se pudo cerrar");
			return;
		}
		System.out.println("FIN DEL PROCESO!!!!!!");
	}
	public static boolean Abrir() {
		try {
			archF = new RandomAccessFile ("FoliosPri.dat", "rw");
			archD = new RandomAccessFile ("FoliosPriDetalle.dat", "rw");
		}catch(Exception obj) {
			return false;
		}
		return true;
	}
	public static void Procesar() {
		try {
			int FolioF;
			while(true) {//Obtener folio de archivos folioPri
				FolioF = archF.readInt();
				archD.seek(0);//Cada vez que se busque un nuevo folio el apuntador debera estar en 0
				CompararFolios(FolioF);
			}
		}catch(Exception obj) {}
	}
	public static void CompararFolios(int FolioF) {
		try {
			int FolioD, mvto, pos;
			while(true) {//Comparar folio de FolioPri y folio de FolioDetallePri
				FolioD = archD.readInt();
				if(FolioD == FolioF) {
					mvto = (int)(((archD.getFilePointer()-4)/20)+1);
					archF.seek(archF.getFilePointer()+4);
					archF.writeInt(mvto);
					pos = (mvto-1)*20;//posicion en bytes
					ModificarDetalles(FolioD, pos);
				}
				else {
					archD.seek(archD.getFilePointer()+16);
				}
			}
		}catch(Exception obj) {
			return;
		}
	}
	public static void ModificarDetalles(int FolioD, int pos) {
		try {
			int FolioD1, mvtoD;
			archD.seek(archD.getFilePointer()+16);
			FolioD1 = archD.readInt();
			if(FolioD1==FolioD) {
				mvtoD = (int)(((archD.getFilePointer()-4)/20)+1);
				archD.seek(pos+16);
				archD.writeInt(mvtoD);
				pos = (mvtoD-1)*20;//posicion en bytes
				archD.seek(pos+4);
			}
			ModificarDetalles(FolioD, pos);
		}catch(Exception obj) {
			return;
		}
	}
	public static boolean Cerrar() {
		try {
			archF.close();
			archD.close();
		}catch(Exception obj) {
			return false;
		}
		return true;
	}
}
