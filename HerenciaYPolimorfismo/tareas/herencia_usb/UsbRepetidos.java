/*Nombre: Manuel de Jesus Inzunza Lara 
No. Control: 23170195
Materia: Programacion orientada a objetos
Unidad: 3
Proyecto: Usb Repetidos
Fecha: 10 de abril del 2024
Maestro Dr. Clemente Garcia Gerardo*/
package HerenciaYPolimorfismo.tareas.herencia_usb;

public class UsbRepetidos extends UsbOrdenada{
	
	public UsbRepetidos(int memoria, String tipoSistema) {
		super(memoria, tipoSistema);
	}

	public boolean GrabarArchivo(Archivo archivo) {
		int i = 0;
		while(!Grabar(archivo)) {
			if(getMsg()=="Este archivo ya existe") {
				i++;
				String [] nomArchivo = archivo.getNomArchivo().split("\\(");
				archivo.setNomArchivo(nomArchivo[0]+"("+String.format("%03d", i)+")");
			}
		}
		return true;
	}
//	public boolean Grabar(Archivo archivo) {
//		if(getNumArchivos() == getMaxArchivos()) {
//			setMsg("El maximo de archivos ya alcanzo su limite");
//			return false;
//		}
//		long tamTotal = calTamaño(archivo) + memUsada;
//		if(tamTotal > memoria) {
//			setMsg("Este archivo es muy grande, no se ha guardado");
//			return false;
//		}
//		for(int i = 0; i < getNumArchivos(); i++) {
//			if(getArchivos()[i].getNomArchivo().equalsIgnoreCase(archivo.getNomArchivo()) && getArchivos()[i].getExtension().equalsIgnoreCase(archivo.getExtension())) {
//				if(getArchivos()[i].getArcRepetido()==999) {
//					setMsg("Este nombre de archivo ya no se puede repetir");
//					return false;
//				}
//				getArchivos()[i].setArcRepetido(getArchivos()[i].getArcRepetido()+1);
//				archivo.setNomArchivo(archivo.getNomArchivo()+"("+String.format("%03d", getArchivos()[i].getArcRepetido())+")");
//			}
//		}
//		
//		getArchivos()[getNumArchivos()] = new Archivo(archivo.getNomArchivo(), archivo.getExtension(), archivo.getTamaño(), archivo.getUnMedida());
//		setNumArchivos(getNumArchivos()+1);
//		setMemUsada(getMemUsada() + calTamaño(archivo));
//		setMsg("El archivo se ha guardado correctamente");
//		return true;
//	}
	
}
