package FlujosYArchivos.ejercicios.archivos_indexados;
/*Simular el funcinamiento de archivos indexados
 * utilizando archivos directo.
 * AUTOS.DAT
 * MARCA   STRING 20+2
 * MODELO  STRING 20+2
 * AÑO     INT       4
 * ESTATUS CHAR      2
 *    LONG REGISTRO 50 BYTES
 *    IDXAUTOS,DAT
 *  PLACA   STRING 10+2
 *  NOREGISTRO INT    4
 *  LOG REGISTRO    16 BYTES
 * 
 * 
 * 
 */
import java.io.*;
import java.util.*;

import Unidad0_Diagnostico.ejercicios.Rutinas;
public class AutosPlaca {
	static RandomAccessFile arch, archIdx;
	public static void main(String[] args) {
		if(!Abrir()) {
			System.out.println("No pudo abrir los archivos");
			return;
		}
		if(!Capturar()) {
			System.out.println("se presentó error al capturar");
			return;
		}
		if(!Cerrar()) {
			System.out.println("error al cerrar los archivos");
			return;
		}

	}
	public static boolean Abrir() {
		try {
			arch=new RandomAccessFile("AUTOS.DAT","rw");
			archIdx=new RandomAccessFile("AUTOSidx.DAT","rw");
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	public static boolean Capturar() {
		String placa, marca,modelo;
		int año;
		char vig='A';
		Scanner in = new Scanner(System.in);
		try {
			arch.seek(arch.length());
			archIdx.seek(archIdx.length());
			int registro=(int) (arch.length()/50);
			while(true) {
				System.out.print("Placa * fin captura ");
				placa=in.nextLine();
				if(placa.equals("*"))
					break;
				int posicion=Busqueda(placa,archIdx);
				System.out.println("Posicion "+posicion);
				if(  posicion>0 ) {
					System.out.println("La placa proporcionada ya existe");
					continue;
				}
				System.out.print("Marca ");
				marca=in.nextLine();
				System.out.print("Modelo ");
				modelo=in.nextLine();
				System.out.print("Año");
				año=in.nextInt();
				in.nextLine();
				// Grabar el autos.dat
				placa=Rutinas.PonBlancos(placa, 10);
				marca=Rutinas.PonBlancos(marca, 20);
				modelo=Rutinas.PonBlancos(modelo, 20);
				arch.writeUTF(marca);
				arch.writeUTF(modelo);
				arch.writeInt(año);
				arch.writeChar(vig);
				
				// grabar IDXAUTO.DAT
				archIdx.seek(archIdx.length());
				archIdx.writeUTF(placa);
				archIdx.writeInt(++registro);
				
				Ordenar(archIdx);

			}
			/* registro lógico 
			   Usuario  String 8+2
			   Password String 8+2
			   Longitud registro 20 bytes.
			*/
			RandomAccessFile archBombas=new RandomAccessFile("BOMBAS.DAT","rw");
			for(int i=1 ; i<10; i++) {
				archBombas.writeUTF("Usuario"+(i));
				archBombas.writeUTF("Pasword"+(i));
			}
			archBombas.seek(0);
			System.out.println("Total de bombas : "+(archBombas.length()/20));
			for(int i=1 ; i<10 ; i++) {
				System.out.println(archBombas.readUTF()+"\t"+archBombas.readUTF());
			}
			archBombas.seek(80);
			System.out.println("QUINTA BOBA\n"+archBombas.readUTF()+"\t"+archBombas.readUTF());
			archBombas.close();
		} catch (Exception e) {
			return false;
		}

		return true;
	}
	
	public static boolean Cerrar() {
		try {
			arch.close();
			archIdx.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	private static int Busqueda(String placa, RandomAccessFile idx) {
	
			int inferior=0,mitad;
			String placaidx;
			int registro;
			try {
				int superior=(int )(idx.length()/16)-1;
				while (inferior <= superior){
					mitad=(inferior+superior)/2;
					System.out.println("Posicion entró "+mitad);
					idx.seek(mitad*16);
					placaidx=idx.readUTF().trim();
					registro=idx.readInt();
					int resultado=placa.compareTo(placaidx);
					if (resultado==0)  
						return registro;
					else
						if (resultado > 0)
							inferior=mitad+1;
						else
							superior=mitad-1; 
				}
				

			} catch (Exception e ) {
				return -1;
			}
			return 0;
/*		try {
			idx.seek(0);
			int registros=(int) (idx.length()/16);
			String placaIdx;
			int registroIdx;
			System.out.println("Total de registros "+registros);
			for(int i=0 ; i<registros; i++) {
				placaIdx=idx.readUTF();
				registroIdx=idx.readInt();
				System.out.println(placaIdx+"\t"+registroIdx);
				if( placa.equals(placaIdx.trim())) {
					return registroIdx;
				}
			}
			
		} catch (Exception obj) {
			System.out.println(obj.getMessage());
			return -1;
		}
		return 0;
*/		
	}
	private static void Ordenar(RandomAccessFile idx) {
		try {
			String placai,placaj;
			int regi,regj;
			int registro=(int) (idx.length()/16);
			for(int i=0 ; i<registro-1 ; i++) {
				
				for(int j=i+1 ; j<registro ; j++) {
					idx.seek(i*16);
					placai=idx.readUTF();
					regi=idx.readInt();
					idx.seek(j*16);
					placaj=idx.readUTF();
					regj=idx.readInt();
					if( placai.compareTo(placaj)>0) {
						idx.seek(i*16);
						idx.writeUTF(placaj);
						idx.writeInt(regj);
						idx.seek(j*16);
						idx.writeUTF(placai);
						idx.writeInt(regi);
					}
					
				}
			}
			
			
		} catch (Exception obj) {
		System.out.println(obj.getMessage());
		}
	}
	

}
