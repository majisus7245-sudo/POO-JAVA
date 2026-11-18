/*Nombre: Manuel de Jesus Inzunza Lara 
No. Control: 23170195
Materia: Programacion orientada a objetos
Unidad: 3
Proyecto: Avion de Carga y Pasajero
Fecha: 14 de abril del 2024
Maestro Dr. Clemente Garcia Gerardo*/
package HerenciaYPolimorfismo.ejercicios.aviones;

import Unidad0_Diagnostico.tareas.metodos_de_cadena.Rutinas;

class Pasajero{
	
	private String nombre;
	private int asiento;
	
	public Pasajero(String nombre, int asiento) {
		this.nombre = nombre;
		this.asiento = asiento;
	}
	public Pasajero(String nombre) {
		this.nombre = nombre;
		asiento = 0; 
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAsiento() {
		return asiento;
	}

	public void setAsiento(int asiento) {
		this.asiento = asiento;
	}
	
}

public class Avion_Pasaje_Carga extends Avion_Carga{

	private boolean pos = true;
	private int numAsientos, posInicial, asiPar, con, asiOcupados, posFinal;
	private Pasajero [][] asiento;
	
	public Avion_Pasaje_Carga(int capMax, int numCajas) {
		super(capMax, numCajas);
		seccion = new Caja [numCajas/2][2];
		numAsientos = Rutinas.nextInt(50, 100);
		asiento = new Pasajero [1][numAsientos];
		asiPar = numAsientos;
		if(numAsientos%2!=0) {
			asiPar = numAsientos + 1;
		}
		posInicial = asiPar / 2;
		posFinal = 0;
		asiOcupados = 0;
	}

	public boolean Abordar(Pasajero pasajero) {
		if(pasajero.getAsiento() == 0) {
			msg = "Esta persona no cuenta con boleto de vuelo";
			return false;
		}
		if(asiOcupados == numAsientos) {
			msg = "Ya no hay asientos disponibles";
			return false;
		}
		if(asiento[0][posInicial-1] == null) {
			asiento[0][posInicial-1] = new Pasajero(pasajero.getNombre(), pasajero.getAsiento());
			msg = "El abordo tuvo exito";
			asiOcupados++;
			posFinal = posInicial-1;
			return true;
		}
		con++;
		if(pos) {
			if(numAsientos - asiOcupados == 1 && numAsientos%2==0) {
				asiento[0][posFinal+1] = new Pasajero(pasajero.getNombre(), pasajero.getAsiento());
				msg = "El abordo tuvo exito";
				asiOcupados++;
				return true;
			}
			asiento[0][posFinal-con] = new Pasajero(pasajero.getNombre(), pasajero.getAsiento());
			msg = "El abordo tuvo exito";
			asiOcupados++;
			pos = false;
			posFinal = posFinal-con;
			return true;
		}
		else if(!pos) {
			asiento[0][posFinal+con] = new Pasajero(pasajero.getNombre(), pasajero.getAsiento());
			msg = "El abordo tuvo exito";
			asiOcupados++;
			pos = true;
			posFinal = posFinal+con;
			return true;
		}
		return true;
	}
	public String impInformacion() {
		String contenido = "";
		contenido += "Total de cajas: " + contCajas + "\n";
		int estCarga = (contCapacidad * 100) / capMax;
		contenido += "Estado de la carga por: " + estCarga + "%\n";
		contenido += "Organización de las cajas(Izquierda-Derecha): \n";
		for(int i = 0; i < seccion.length; i++) {
			for(int j = 0; j < 2; j+=2) {
					contenido += String.format("\t%s\t%s\n", seccion[i][j].getPesoCaja(), seccion[i][j+1].getPesoCaja());
			}
		}
		contenido += "Listado de persona en orden de abordaje: \n";
		for(int i = 0; i < numAsientos; i++) {
			if(asiento[0][i] == null) {
				contenido += "vacío\n";
				continue;
			}
			contenido += asiento[0][i].getNombre() + "\n";
		}
		return contenido;
	}
	
}
