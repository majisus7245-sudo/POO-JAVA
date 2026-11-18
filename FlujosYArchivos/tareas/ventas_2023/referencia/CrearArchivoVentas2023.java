package FlujosYArchivos.tareas.ventas_2023.referencia;
/*Ventas2023.dat
 * unidade2P1 int 4 bytes
 * unidadesP2 int 4
 * 
 * 
 * unidadesP3 int 4 bytes
 * Longitud del registro 400 bytes.
 * El archivo contiene 365 registros que representan 
 * las ventas del 01/01/2023 al 31/12/2023
 */
import java.io.*;
import Unidad0_Diagnostico.ejercicios.Rutinas;

public class CrearArchivoVentas2023 {

	public static void main(String[] args) {
		try {
			RandomAccessFile arch = new RandomAccessFile("Ventas2023.dat","rw");
			
			for(int i=0;i<365 ; i++) {
				for(int j=0; j<100;j++) {
					arch.writeInt((int)Rutinas.nextInt(10, 50));
				}
			}
			arch.seek(0);
			int unidades;
			for(int i=0;i<365 ; i++) {
				System.out.println("Dia # "+(i+1));
				for(int j=0; j<100;j++) {
					System.out.printf("%4d",arch.readInt());
					if((j+1)%20==0)
						System.out.println();
				}
				System.out.println();
			}
			arch.close();
		} catch (Exception e) {
			System.out.println("Algo salió mal");
			return;
		}
		System.out.println("Archivo creado exitosamente");

	}

}
