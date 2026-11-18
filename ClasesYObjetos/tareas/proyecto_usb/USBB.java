//Nombre: Manuel de Jesus Inzunza Lara
//No. Control: 23170195
//Materia: Programacion orientada a objetos
//Unidad: 1
//Proyecto: USB
//Fecha: 03 de marzo del 2024
//Maestro Dr. Clemente Garcia Gerardo
package ClasesYObjetos.tareas.proyecto_usb;

import Unidad0_Diagnostico.tareas.metodos_de_cadena.Rutinas;

class Archivo {
    private String nomArchivo, extension, unMedida, fecha;
    private long tamaño;

    public Archivo(String nomArchivo, String extension, int tamaño, String unMedida, String fecha) {
        this.nomArchivo = nomArchivo;
        this.extension = extension;
        this.tamaño = tamaño;
        this.unMedida = unMedida;
        this.fecha = fecha;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public long getTamaño() {
        return tamaño;
    }

    public void setTamaño(long tamaño) {
        this.tamaño = tamaño;
    }
}

public class USBB {
    
    private String tipoSistema, msg;
    private int maxArchivos, numArchivos, arcDisponibles;
    private int capMemoria;
    private long memBytes, memUsada, memDisponible;
    private Archivo[] archivo;

    public USBB() {
        this(20, "NTFS");
    }

    public USBB(int capMemoria, String tipoSistema) {
        this.capMemoria = capMemoria;
        this.tipoSistema = tipoSistema;
        memUsada = 0;
        numArchivos = 0;
        memBytes = capMemoria * 1073741824L;
        memDisponible = memBytes;
        if (tipoSistema.equalsIgnoreCase("FAT32"))
            maxArchivos = Rutinas.nextInt(100, 200);
        if (tipoSistema.equalsIgnoreCase("NTFS"))
            maxArchivos = Rutinas.nextInt(50, 99);
        if (tipoSistema.equalsIgnoreCase("exFat"))
            maxArchivos = Rutinas.nextInt(10, 20);
        arcDisponibles = maxArchivos;
        archivo = new Archivo[maxArchivos];
        for (int i = 0; i < archivo.length; i++)
            archivo[i] = new Archivo("", "", 0, "", "");
    }

    public boolean Grabar(Archivo archivo) {
        if (numArchivos >= maxArchivos) {
            msg = "Ya se alcanzó el límite de número de archivos";
            return false;
        }
        long tamañoBytes = CalcularBytes(archivo.getTamaño(), archivo.getUnMedida());

        if (this.memUsada + tamañoBytes > memBytes) {
            msg = "La memoria está llena";
            return false;
        }
        for (int i = 0; i < this.archivo.length; i++) {
            if (this.archivo[i].getNomArchivo().equalsIgnoreCase(archivo.getNomArchivo()) && this.archivo[i].getExtension().equalsIgnoreCase(archivo.getExtension())) {
                msg="No se permite repetir el nombre de los archivos";
            	return false;
            }
        }
        int pos = -1;
        for (int i = 0; i < this.archivo.length; i++) {
            if (this.archivo[i].getNomArchivo().equalsIgnoreCase("") && this.archivo[i].getExtension().equalsIgnoreCase("")) {
                pos = i;
                break;
            }
        }
        if (pos == -1) {
            msg = "La USB está a su máxima capacidad";
            return false;
        }
        this.archivo[pos].setNomArchivo(archivo.getNomArchivo());
        this.archivo[pos].setExtension(archivo.getExtension());
        this.archivo[pos].setTamaño(tamañoBytes);
        this.archivo[pos].setUnMedida("bytes");
        this.archivo[pos].setFecha(archivo.getFecha());
        numArchivos++;
        arcDisponibles--;
        memUsada += tamañoBytes;
        memDisponible -= tamañoBytes;
        msg = "El archivo se guardó correctamente";
        return true;
    }

    private long CalcularBytes(long tamaño, String unMedida) {
        long tamañoBytes = 0;
        if (unMedida.equalsIgnoreCase("b"))
            tamañoBytes = tamaño;
        if (unMedida.equalsIgnoreCase("Kb"))
            tamañoBytes = tamaño * 1024L;
        if (unMedida.equalsIgnoreCase("Mb"))
            tamañoBytes = tamaño * 1048576L;
        if (unMedida.equalsIgnoreCase("Gb"))
            tamañoBytes = tamaño * 1073741824L;
        return tamañoBytes;
    }

    public String MostrarContenido() {
        String contenido = "";
        for (int i = 0; i < archivo.length; i++) {
        	if (archivo[i].getTamaño() != 0)
        		contenido += String.format("%s\t%s\t%d\t%s\t%s\n", archivo[i].getNomArchivo(), archivo[i].getExtension(), archivo[i].getTamaño(), archivo[i].getUnMedida(), archivo[i].getFecha());
        }
        return contenido;
    }

    public boolean Borrar(Archivo archivo) {
		int pos = -1;
	    for(int i = 0; i < this.archivo.length; i ++) {
	    	if(this.archivo[i].getNomArchivo()==archivo.getNomArchivo()&&this.archivo[i].getExtension()==archivo.getExtension()) {
	    		this.archivo[i]=new Archivo("", "", 0, "", "");
	    		pos = i;
	    	}
	    }
	    if( pos == -1) {
	    	msg="Este archivo no se encontro";
	    	return false;
	    }
	    for(int i = pos; i < this.archivo.length - 1; i++) {
	    	this.archivo[i] = this.archivo[i+1];
	    }
	    msg="Se borro correctamente el archivo";
	    numArchivos --;
	    arcDisponibles ++;
	    memUsada -= CalcularBytes(archivo.getTamaño(), archivo.getUnMedida());
	    memDisponible += CalcularBytes(archivo.getTamaño(), archivo.getUnMedida());
	    return true;
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

    public int getMaxArchivos() {
        return maxArchivos;
    }

    public void setMaxArchivos(int maxArchivos) {
        this.maxArchivos = maxArchivos;
    }

    public int getNumArchivos() {
        return numArchivos;
    }

    public void setNumArchivos(int numArchivos) {
        this.numArchivos = numArchivos;
    }

    public long getCapMemoria() {
        return capMemoria;
    }

    public void setCapMemoria(int capMemoria) {
        this.capMemoria = capMemoria;
    }

    public long getMemUsada() {
        return memUsada;
    }

    public long getMemBytes() {
        return memBytes;
    }

    public void setMemBytes(long memBytes) {
        this.memBytes = memBytes;
    }

    public void setMemUsada(long memUsada) {
        this.memUsada = memUsada;
    }

    public Archivo[] getArchivo() {
        return archivo;
    }

    public void setArchivo(Archivo[] archivo) {
        this.archivo = archivo;
    }

	public long getMemDisponible() {
		return memDisponible;
	}

	public void setMemDisponible(long memDisponible) {
		this.memDisponible = memDisponible;
	}

	public int getArcDisponibles() {
		return arcDisponibles;
	}

	public void setArcDisponibles(int arcDisponibles) {
		this.arcDisponibles = arcDisponibles;
	}
	
}
