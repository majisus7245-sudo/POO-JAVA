//Nombre: Manuel de Jesus Inzunza Lara
//No. Control: 23170195
//Materia: Programacion orientada a objetos
//Unidad: 1
//Proyecto: USB
//Fecha: 03 de marzo del 2024
//Maestro Dr. Clemente Garcia Gerardo
package ClasesYObjetos.tareas.proyecto_usb;

public class AplUBSB {

	public static void main(String[] args) {
		
		USBB usb = new USBB(10, "exFAT");
		
		Archivo archivo1 = new Archivo("Archivo 1", "pdf", 2, "Gb","02-03-24");
		usb.Grabar(archivo1);
		System.out.println(usb.getMsg());
		System.out.println(usb.MostrarContenido());
		
		Archivo archivo2 = new Archivo("Archivo 2", "pdf", 5, "Gb","02-03-24");
		usb.Grabar(archivo2);
		System.out.println(usb.getMsg());
		System.out.println(usb.MostrarContenido());
		
		Archivo archivo3 = new Archivo("Archivo 3", "pdf", 1, "Gb","02-03-24");
		usb.Grabar(archivo3);
		System.out.println(usb.getMsg());
		System.out.println(usb.MostrarContenido());
		
		Archivo archivo4 = new Archivo("Archivo 4", "pdf", 1, "Gb","02-03-24");
		usb.Grabar(archivo4);
		System.out.println(usb.getMsg());
		System.out.println(usb.MostrarContenido());
		
		Archivo archivo5 = new Archivo("Archivo 5", "pdf", 1, "Gb","02-03-24");
		usb.Grabar(archivo5);
		System.out.println(usb.getMsg());
		System.out.println(usb.MostrarContenido());
		

		usb.Borrar(archivo1);
		System.out.println(usb.getMsg());
		System.out.println(usb.MostrarContenido());
		
		System.out.println("Memoria usada: "+usb.getMemUsada()+" bytes");
		System.out.println("Numero de archivos: "+usb.getNumArchivos());
		System.out.println();
		System.out.println("Memoria disponible: "+usb.getMemDisponible()+" bytes");
		System.out.println("Archivos disponibles: "+usb.getArcDisponibles());
		
	}

}
