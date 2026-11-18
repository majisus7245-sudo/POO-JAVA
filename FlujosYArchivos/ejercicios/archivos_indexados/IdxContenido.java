package FlujosYArchivos.ejercicios.archivos_indexados;

import java.io.RandomAccessFile;

public class IdxContenido {

	public static void main(String[] args) {
		RandomAccessFile arch, archIdx;
		try {
			arch=new RandomAccessFile("AUTOS.DAT","rw");
			archIdx=new RandomAccessFile("AUTOSidx.DAT","rw");
			System.out.println("PLACAS DE AUTOS DESCENDENTE");
			int registros=(int) (archIdx.length()/16)-1;
			int pos,año;
			String placa,marca,modelo;
			char vig;
			for(int i=registros ; i>=0 ; i--) {
				archIdx.seek(i*16);
				placa=archIdx.readUTF();
				pos=archIdx.readInt();
				arch.seek((pos-1)*50);
				System.out.print(placa+"\t");
				System.out.print(arch.readUTF()+"\t"+arch.readUTF());
				System.out.println(arch.readInt()+"\t"+arch.readChar());
			}
			
			
/*			
			System.out.println("contenido del indice");
			
			int reg=(int)(archIdx.length()/16);
			for(int i=0 ; i<reg ; i++) {
				System.out.println(archIdx.readUTF()+"\t"+archIdx.readInt());
			}
			System.out.println("contenido del AUTOS");

			for(int i=0 ; i<reg ; i++) {
				System.out.println(arch.readUTF()+"\t"+arch.readUTF()+"\t"+arch.readInt()+"\t"+arch.readChar());
			}
			arch.close();
			archIdx.close();
*/
		} catch (Exception obj) {
			System.out.println(obj.getMessage());
			return;
		}
	}

}
