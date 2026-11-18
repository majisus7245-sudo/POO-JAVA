/*Nombre: Manuel de Jesus Inzunza Lara 
No. Control: 23170195
Materia: Programacion orientada a objetos
Unidad: Segunda oportunidad sem112
Proyecto: CaballoFino
Fecha: 04 de junio del 2024
Maestro Dr. Clemente Garcia Gerardo*/
package Recuperaciones.segunda_oportunidad;

import Unidad0_Diagnostico.tareas.metodos_de_cadena.Rutinas;

public class CaballoFino extends Caballo{

	private final int maxCapsulas;
	private int conPaseos, conCapsulas, minRestantes, capsulas;
	private int [] minPaseo = new int [7]; // UN ARREGLO DE ESTE TIPO DEBE USAR PARA CONOCER EL MAXIMO NO DE CAPSULAS A TOMAR EN HORA
	private int [] capHora = new int[7]; // DEBE CREARLO EN EL CONSTRUCTOR Y
	private String men;

	public CaballoFino() {
		maxCapsulas = Rutinas.nextInt(100, 200);
		conPaseos = 0;
		conCapsulas = 0;
	}
	//Tomando en cuenta que se va a manda a la hora un numero mayor al anterior
	public boolean Pasear(int hora, int minDuracion) {
		if(hora < 8 || hora > 14) {
			msg = "El caballo no puede pasear a las "+ hora + " horas";
			return false;
		}
		if(minPaseo[hora-8] == 60) { // ok
			msg = "El caballo ya no puede pasear en esta hora";
			return false;
		}	
// MUY COMPLICADO ESA PARTE, UEDE MEJORARSE DE UNA MANERA MAS SENCILLA.
		if(minPaseo[hora-8] + minDuracion >= 60) {// es <=
			minRestantes = minPaseo[hora-8] + minDuracion - 60;
			minDuracion = 60 - minPaseo[hora-8];
			minPaseo[hora-8]+=minDuracion;
			minPaseo[hora+1-8]+=minRestantes;
			msg = "El caballo a paseado " + minDuracion + " minutos a las " + hora + " y " + minRestantes + " minutos a las " + (hora +1);
			while(minDuracion >= 5) {
				Vitaminas(minDuracion, hora);
			}
			
			while(minRestantes >= 5) {
				VitaminasR(minRestantes, hora+1);//Este metodo sera para los minutos que se acomodaron para la siguiente hora
			}
		}
		else {
			msg = "El caballo a paseado " + minDuracion + " minutos a las " + hora;
			capHora[hora-8] += minDuracion;
			while(minDuracion >= 5) {
				Vitaminas(minDuracion, hora);
			}
		}
		conPaseos ++;
		if(conPaseos == 3) {
			conPaseos -= 3;
			men = msg;
			Comer(Rutinas.nextInt(2, 3));
			msg += " - " +men;
		}
		return true;
	}
	private int Vitaminas(int minDuracion, int hora) {
		minDuracion -= 5;
		if(capHora[hora-8] == maxCapsulas) { // MAXCAPSULAS PUEDE SER DISTINTO PARA CADA HORA, DEBIO USAR  UN ARREGLO
			return minDuracion;
		}
		capsulas = Rutinas.nextInt(5, 10);
		if(capsulas + capHora[hora-8] > maxCapsulas) {
			capsulas = maxCapsulas - conCapsulas;
			capHora[hora-8]+= capsulas;
			Comer(capsulas);
		}
		else {
			capHora[hora-8]+= capsulas;
			Comer(capsulas);
		}
		
		return minDuracion;
	}
	private int VitaminasR(int minRestantes, int hora) {
		minRestantes -= 5;
		if(capHora[hora-8] == maxCapsulas) {
			return minRestantes;
		}
		capsulas = Rutinas.nextInt(5, 10);
		if(capsulas + capHora[hora-8] > maxCapsulas) {
			capsulas = maxCapsulas - conCapsulas;
			capHora[hora-8]+= capsulas;
			Comer(capsulas);
		}
		else {
			capHora[hora-8]+= capsulas;
			Comer(capsulas);
		}
		
		return minRestantes;
	}
}	
	
