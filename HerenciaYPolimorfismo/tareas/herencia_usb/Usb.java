/*Nombre: Manuel de Jesus Inzunza Lara 
No. Control: 23170195
Materia: Programacion orientada a objetos
Unidad: 3
Proyecto: USB corregida
Fecha: 10 de abril del 2024
Maestro Dr. Clemente Garcia Gerardo*/
package HerenciaYPolimorfismo.tareas.herencia_usb;

import java.text.SimpleDateFormat;
import java.util.Date;

import Unidad0_Diagnostico.tareas.metodos_de_cadena.Rutinas;

class Archivo{
	
	private String nomArchivo, extension, unMedida;
	private long tamaño;
	private String fecha;
	private Date date;
	
	public Archivo(String nomArchivo, String extension, long tamaño, String unMedida) {
		this.nomArchivo = nomArchivo;
		this.extension = extension;
		this.tamaño = tamaño;
		this.unMedida = unMedida;
		date = new Date();
		fecha = new SimpleDateFormat("dd-MM-yyyy").format(date);
	}
	public String toString() {
		String ext = Rutinas.Minusculas(extension);
		String nArc = Rutinas.Minusculas(nomArchivo);
		return Rutinas.PonBlancos(ext, 5)+Rutinas.PonBlancos(nArc, 100);
	}
	public String getNomArchivo() {
		return nomArchivo;
	}

	public void setNomArchivo(String nomArchivo) {
		this.nomArchivo = nomArchivo;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getUnMedida() {
		return unMedida;
	}

	public void setUnMedida(String unMedida) {
		this.unMedida = unMedida;
	}
	
	public long getTamaño() {
		return tamaño;
	}

	public void setTamaño(long tamaño) {
		this.tamaño = tamaño;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
public class Usb {

	private Archivo [] archivos;
	private int maxArchivos, numArchivos;
	long memoria, memUsada;
	private String tipoSistema, msg;
	
	public Usb(int memoria, String tipoSistema) {
		this.memoria = memoria * 1073741824L;
		this.tipoSistema = tipoSistema;
		memUsada = 0;
		numArchivos = 0;
		if(tipoSistema == "FAT32") {
			maxArchivos = Rutinas.nextInt(100, 200);
		}
		else if(tipoSistema == "NTFS") {
			maxArchivos = Rutinas.nextInt(50, 99);
		}
		else if(tipoSistema == "exFAT") {
			maxArchivos = Rutinas.nextInt(10, 20);
		}
		archivos = new Archivo[maxArchivos];		
	}
	
	public boolean Grabar(Archivo archivo) {
		if(numArchivos == maxArchivos) {
			msg = "El maximo de archivos ya alcanzo su limite";
			return false;
		}
		long tamTotal = calTamaño(archivo) + memUsada;
		if(tamTotal > memoria) {
			msg = "Este archivo es muy grande, no se ha guardado";
			return false;
		}
		for(int i = 0; i < numArchivos; i++) {
			if(archivos[i].getNomArchivo().equalsIgnoreCase(archivo.getNomArchivo()) && archivos[i].getExtension().equalsIgnoreCase(archivo.getExtension())) {
				msg = "Este archivo ya existe";
				return false;
			}
		}
		archivos[numArchivos] = new Archivo(archivo.getNomArchivo(), archivo.getExtension(), archivo.getTamaño(), archivo.getUnMedida());
		numArchivos ++;
		memUsada += calTamaño(archivo);
		msg = "El archivo se ha guardado correctamente";
		return true;
	}
	public long calTamaño(Archivo archivo) {
		long tamaño = 0;
		if(archivo.getUnMedida() == "Gb")
			tamaño = archivo.getTamaño() * 1073741824L;
		else if(archivo.getUnMedida() == "Mb")
			tamaño = archivo.getTamaño() * 1048576L;
		else if(archivo.getUnMedida() == "Kb")
			tamaño = archivo.getTamaño() * 1024L;
		else {
			tamaño = archivo.getTamaño();
		}
		return tamaño;
	}
	public boolean Borrar(Archivo archivo) {
		int pos = -1;
		for(int i = 0; i < numArchivos; i++) {
			if(archivo.getNomArchivo()==archivos[i].getNomArchivo() && archivo.getExtension()==archivos[i].getExtension()) {
				pos = i;
				break;
			}
		}
		if(pos == -1) {
			msg = "Este archivo no existe";
			return false;
		}
		archivos[pos] = null;
		numArchivos --;
		for(int i = pos; i < numArchivos - 1; i++) {
			archivos[i] = archivos[i+1];
			archivos[i+1] = null;
		}
		memUsada -= calTamaño(archivo);
		msg = "Se ha borrado correctamente el archivo";
		return true;
	}
	public String mosContenido() {
		String contenido = "";
		for(int i = 0; i < numArchivos+1; i++) {
			if(archivos[i] != null)
				contenido += String.format("%s\t%s\t%d\t%s\t%s\n", archivos[i].getNomArchivo(), archivos[i].getExtension(), archivos[i].getTamaño(), archivos[i].getUnMedida(), archivos[i].getFecha());
		}
		return contenido;
	}

	
	public Archivo[] getArchivos() {
		return archivos;
	}

	public void setArchivos(Archivo[] archivos) {
		this.archivos = archivos;
	}

	public int getMaxArchivos() {
		return maxArchivos;
	}

	public void setMaxArchivos(int maxArchivos) {
		this.maxArchivos = maxArchivos;
	}

	public long getMemUsada() {
		return memUsada;
	}

	public void setMemUsada(long memUsada) {
		this.memUsada = memUsada;
	}

	public int getNumArchivos() {
		return numArchivos;
	}

	public void setNumArchivos(int numArchivos) {
		this.numArchivos = numArchivos;
	}

	public long getMemoria() {
		return memoria;
	}

	public void setMemoria(long memoria) {
		this.memoria = memoria;
	}

	public String getTipoSistema() {
		return tipoSistema;
	}

	public void setTipoSistema(String tipoSistema) {
		this.tipoSistema = tipoSistema;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
