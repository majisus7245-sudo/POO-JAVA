/*Nombre: Manuel de Jesus Inzunza Lara 
No. Control: 23170195
Materia: Programacion orientada a objetos
Unidad: 3
Proyecto: Usb Ordenada
Fecha: 10 de abril del 2024
Maestro Dr. Clemente Garcia Gerardo*/
package HerenciaYPolimorfismo.tareas.herencia_usb;

public class UsbOrdenada extends Usb{

	public UsbOrdenada(int memoria, String tipoSistema) {
		super(memoria, tipoSistema);
	}

	public String MostrarOrdenado() {
		String conOrdenado = "";
		Archivo pos;
		int x;
		for(int i = 0; i < getNumArchivos(); i ++) {
			for(int j = 0; j < getNumArchivos()-i-1; j++) {
				x = getArchivos()[j].toString().compareTo(getArchivos()[j+1].toString());
				if(x > 0) {
					pos = getArchivos()[j+1];
					getArchivos()[j+1] = getArchivos()[j];
					getArchivos()[j] = pos;
				}					
			}
		}
		for(int i = 0; i < getNumArchivos()+1; i++) {
			if(getArchivos()[i] != null)
				conOrdenado += String.format("%s\t%s\t%d\t%s\t%s\n", getArchivos()[i].getNomArchivo(), getArchivos()[i].getExtension(), getArchivos()[i].getTamaño(), getArchivos()[i].getUnMedida(), getArchivos()[i].getFecha());
		}
		return conOrdenado;
	}
	
}
