/*Nombre: Manuel de Jesus Inzunza Lara 
No. Control: 23170195
Materia: Programacion orientada a objetos
Unidad: Segunda oportunidad sem112
Proyecto: Caballo
Fecha: 04 de junio del 2024
Maestro Dr. Clemente Garcia Gerardo*/
package Recuperaciones.segunda_oportunidad;

import Unidad0_Diagnostico.tareas.metodos_de_cadena.Rutinas;

public class Caballo implements InterfaceCaballo{

	protected String msg;
	private int maxLiquidos, mlSuero;
	private final int maxPastura;
	private int conPastura, conSuero, conHoras;
	private boolean duplicar = true;
	
	public Caballo() {
		maxLiquidos = Rutinas.nextInt(5,10);
		maxPastura = Rutinas.nextInt(10,20);
		conPastura = 0;
		conSuero = 0;
		conHoras = 0;
	}
	
	public boolean Comer(int kg) {// BIEN
		if(conPastura == maxPastura) {
			msg = "Tu caballo ya no puede ingerir mas pastura";
			return false;
		}
		if(conPastura + kg > maxPastura) {
			kg = maxPastura - conPastura;
			conPastura += kg;
			msg = "Tu caballo a comido " + kg + " kg de pastura";
			return true;
		}
		conPastura += kg;
		msg = "Tu caballo a comido " + kg + " kg de pastura";		return true; // AQUI LE FALTÓ CONTROLAR LO DE LA BEBIDA, POSIBLEMENTE CON UN MÉTODO PRIVADO...
	}
	public boolean Trabajar(int noHoras) { // PUEDE VALIDAR QUE noHoras no se negativa o exceda el máximo que puede trabaja(si se conoce)
		conHoras += noHoras;
		msg = "Horas trabajadas correctamente";
		while(conHoras >= 5) { // esto se puede eliminar con una operación aritmética......
			conHoras -= 5;
			mlSuero = Rutinas.nextInt(100, 300);
			conSuero += mlSuero;
			msg += ", ingirio " + mlSuero + " ml de suero";
		}
		if(conSuero >= 500 && duplicar) {  // correcto el duplicar
			maxLiquidos += maxLiquidos *2;
			duplicar = false;
		}
		return true;
	}
	public boolean Pasear(int hora, int minDuracion) { // con esto quita el método abstracto
		msg = "Este caballo no se le es posible pasear";
		return false;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
