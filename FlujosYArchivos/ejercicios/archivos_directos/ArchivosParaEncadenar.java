package FlujosYArchivos.ejercicios.archivos_directos;

import java.io.RandomAccessFile;

import Unidad0_Diagnostico.ejercicios.Rutinas;
/* Folios.dat
 * Nofolio    int   4 bytes
 * NoSucursal int   4 bytes 
 * priMovto   int   4 bytes
 * ultMovto   int   4 bytes
 * 
 * FoliosMovtos.dat
 * noFolio    int    4 bytes
 * idProducto int    4 bytes
 * noUnidades int    4 bytes
 * precio     float  4 bytes
 */
public class ArchivosParaEncadenar {

	public static void main(String[] args) {
		RandomAccessFile archFolios, archDetalle;
		
		try {
			archFolios=new RandomAccessFile("Folios.dat","rw");
			archDetalle=new RandomAccessFile("FiliosDetalle.dat","rw");
			int ap=0;
			for(int folio=1 ; folio<=20 ; folio++) {
				archFolios.writeInt(folio);
				archFolios.writeInt(Rutinas.nextInt(1, 10));
				archFolios.writeInt(ap);
				archFolios.writeInt(ap);
				int no=Rutinas.nextInt(1, 15);
				for(int j=0 ; j<no ; j++ ) {
					archDetalle.writeInt(folio);
					archDetalle.writeInt(Rutinas.nextInt(1, 50));
					archDetalle.writeInt(Rutinas.nextInt(1, 20));
					archDetalle.writeFloat(Rutinas.nextInt(50, 200));
				}
				
			}

			Mostrar(archFolios,archDetalle);
//			Mostrar1(archFolios,archDetalle);
			archFolios.close();
			archDetalle.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("proceso exitoso !!!!!!!!!");
	}
	static private void Mostrar(RandomAccessFile archF,RandomAccessFile archD) {
		try {
			archF.seek(0);
			int folio;
			while (true) {
				folio=archF.readInt();
				System.out.printf("Folio %4d  %4d  %4d  %4d\n",folio,archF.readInt(),archF.readInt(),archF.readInt());
				
				try {
					archD.seek(0);
					int folioD;
					while (true) {
						folioD=archD.readInt();
						if(folioD==folio) 
							System.out.printf("\tFolio:%4d  %4d  %4d  %8.2f\n ",folioD,archD.readInt(),archD.readInt(),archD.readFloat());
						else
							archD.seek(archD.getFilePointer()+12);
					}
				} catch (Exception e) {
					
				}
				
			}
		} catch (Exception e) {
			
		}
	}
//	static private void Mostrar1(RandomAccessFile archF,RandomAccessFile archD) {
//		try {
//			archD.seek(0);
//			int folio;
//			while (true) {
//				folio=archF.readInt();
//				System.out.printf("%4d  %4d  %4d  %4f\n",folio,archF.readInt(),archF.readInt(),archF.readFloat());
	
}
