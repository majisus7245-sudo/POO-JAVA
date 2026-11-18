package FlujosYArchivos.ejercicios.archivos_secuenciales;

import java.io.FileWriter;

import Unidad0_Diagnostico.ejercicios.Rutinas;

public class ArchivoSecuencialVentas {
	static private FileWriter fw;

	public static void main(String[] args) {
		if(!Abrir()) {
			System.out.println("No pudo abrir el archivo");
			return;
		}
		if( !Crear()) {
			System.out.println("no pudo crear ell archivo CVS");
			return;
		}
		if(!Cerrar()) {
			System.out.println("No pudo cerrar el archivo");
			return;
		}

	}
	public static boolean Abrir() {
		try {
			fw=new FileWriter("VENTAS.CVS");
			
			
		} catch (Exception obj) {
			return false;
		}
		return true;
	}
	public static boolean Crear() {
		
		
		try {
			String linea;
			int folio,unidades,precio;
			// folio,precio unidad, unidades, (se puee repetir n veces)
			
			for(int i= 0 ; i<1000 ; i++) {
				folio=i+1;
				linea=folio+",";
				int veces=Rutinas.nextInt(1, 7);
				for(int j=0 ; j<veces ; j++) {
					precio=Rutinas.nextInt(100, 2000);
					unidades =Rutinas.nextInt(1, 20);
					linea=linea+"$"+precio+","+unidades+((j==veces-1)?"":",");
				}
				fw.write(linea+"\n");
				
				
			}
			
		} catch (Exception e) {
			return false;
		}

		return true;
	}
	public static boolean Cerrar() {
		try {
			fw.close();
		} catch (Exception obj) {
			return false;
		}
		return true;
	}
}
