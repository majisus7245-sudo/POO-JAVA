/*Nombre: Manuel de Jesus Inzunza Lara 
No. Control: 23170195
Materia: Programacion orientada a objetos
Unidad: 6
Proyecto: Examen tercer parcial
Fecha: 31 de mayo del 2024
Maestro Dr. Clemente Garcia Gerardo*/
package FlujosYArchivos.examen.tercer_parcial;

import java.io.RandomAccessFile;

public class Cliente implements InterfaceClientes{
// EL MÉTODO PUBLIC CERRAR ES INCORRECTO YA QUE SOLO SE REQUIERE DE 3 MMETODOS PUBLICOS....
	private RandomAccessFile archB, archE;
	private int canB;
	
	public Cliente() {
		try { PAAR EL PROBLEMA PLANTEADO NO ES LO MAS ADECUADO ABRIR AQUI LOS ARCHIVOS
			archB = new RandomAccessFile("Boletinados.dat","rw");
			canB  = (int)(archB.length()/2);
			archE = new RandomAccessFile("Estadisticas.dat","rw");
		}catch(Exception obj) {
			System.out.println("Hubo un error al abrir el archivo"); // DE NADA SIRVE ESTA IMPRESIÓN
		}
		
	}
	
	public boolean Autorizar(long telefono) {
		int veces, autorizada, rechazada;
		String tel = Long.toString(telefono);
		if(tel.length() > 10 || tel.length() < 10) { // NO SERIA MEJOR tel.length() != 10
			System.out.println("Inserte un numero adecuado"); // LAS IMPRESIONES NO SE USAN AQUI, ES EN LA APLICACIÓN
			return false;
		}
		int num = Integer.parseInt(tel.substring(4,10)); // SE QUEDA CON EL NUMERO CONSECUTIVO
		try {
			archB.seek((num-1)*2);
			char estatus = archB.readChar();
			if(estatus == 'S') {
				archE.seek((num-1)*12);
				veces = archE.readInt();
				archE.seek(archE.getFilePointer()-4);
				archE.writeInt(veces+1);
				archE.seek(((num-1)*12)+8);
				rechazada = archE.readInt();
				archE.seek(archE.getFilePointer()-4);
				archE.writeInt(rechazada+1); // BIEN ACTUALIZÓ VECES Y RECHAZADAS
				System.out.println("Este numero de telefono se encuentra bloqueado");// DE NADA SIRVE
				return true;
			}
			else if(estatus == 'N'){
				archE.seek((num-1)*12);
				veces = archE.readInt();
				archE.seek(archE.getFilePointer()-4);
				archE.writeInt(veces+1);
				archE.seek(((num-1)*12)+4);
				autorizada = archE.readInt();
				archE.seek(archE.getFilePointer()-4);
				archE.writeInt(autorizada+1);
				System.out.println("Este numero de telefono se encuentra autorizado");// DE NADA SIRVE
				return true;
			}
		}catch(Exception obj) {
			return false;
		}
		return true;
	}
	public boolean Bloquear(long telefono) {
		String tel = Long.toString(telefono);
		if(tel.length() > 10 || tel.length() < 10) {
			System.out.println("Inserte un numero adecuado");
			return false;
		}
		int num = Integer.parseInt(tel.substring(4,10));
		try {
			archB.seek((num-1)*2);
			char estatus = archB.readChar();
			if(estatus == 'S') {
				System.out.println("Este numero de telefono ya se encuentra bloqueado");// DE NADA SIRVE
				return true;
			}
			else if(estatus == 'N'){ // FALTA VALIDAR QUE HAYA HECHO ALGUNO PEDIDOS
				archB.seek((num-1)*2);
				archB.writeChar('S');
				System.out.println("Este numero de telefono ya esta bloqueado");// DE NADA SIRVE
				return true;
			}
		}catch(Exception obj) {
			System.out.println("Error al bloquear");
			return false;
		}
		return true;
	}
	public boolean Desbloquear() {
		try {
			int veces, autoriazada;
			float porcentaje;
			char estatus;
			archB.seek(0);
			for(int i = 0; i < canB; i++) {
				archB.seek(i*2);
				estatus = archB.readChar();
				if(estatus == 'N') {
					continue;
				}
				archE.seek(i*12);
				veces = archE.readInt();
				autoriazada = archE.readInt();
				porcentaje = ((float)autoriazada/(float)veces)*100;
				if(porcentaje >= 50) {
					archB.seek(i*2);
					archB.writeChar('N');// OK
				}
			}
			System.out.println("Desbloqueados exitosamente");// DE NADA SIRVE
		}catch(Exception obj) {
			System.out.println("Error al desbloaquear");// DE NADA SIRVE
			return false;
		}
		return true;
	}
	public boolean Cerrar() {
		try {
			archB.close();
			archE.close();
		}catch(Exception obj) {
			return false;
		}
		return true;
	}
}
