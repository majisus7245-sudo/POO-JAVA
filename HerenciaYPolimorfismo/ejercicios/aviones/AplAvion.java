/*Nombre: Manuel de Jesus Inzunza Lara 
No. Control: 23170195
Materia: Programacion orientada a objetos
Unidad: 3
Proyecto: Aplicacion de avion de Carga y Pasajero
Fecha: 14 de abril del 2024
Maestro Dr. Clemente Garcia Gerardo*/
package HerenciaYPolimorfismo.ejercicios.aviones;

public class AplAvion {

	public static void main(String[] args) {
		
		Avion_Carga avion1 = new Avion_Carga(10, 5);
		
		Caja caja1 = new Caja(600);
		Caja caja2 = new Caja(300);
		Caja caja3 = new Caja(200);
		Caja caja4 = new Caja(700);
		Caja caja5 = new Caja(800);
		Caja caja6 = new Caja(900);
		Caja caja7 = new Caja(100);
		Caja caja8 = new Caja(1000);
		Caja caja9 = new Caja(400);
		Caja caja10 = new Caja(500);
		
		avion1.Cargar(caja1);
		System.out.println(avion1.msg);
		avion1.Cargar(caja2);
		System.out.println(avion1.msg);
		avion1.Cargar(caja3);
		System.out.println(avion1.msg);
		avion1.Cargar(caja4);
		System.out.println(avion1.msg);
		avion1.Cargar(caja5);
		System.out.println(avion1.msg);
		avion1.Cargar(caja6);
		System.out.println(avion1.msg);
		avion1.Cargar(caja7);
		System.out.println(avion1.msg);
		avion1.Cargar(caja8);
		System.out.println(avion1.msg);
		avion1.Cargar(caja9);
		System.out.println(avion1.msg);
		avion1.Cargar(caja10);
		System.out.println(avion1.msg);
		System.out.println();
		if(avion1.Verificar()) {
			System.out.println("El avion puede despegar");
		}
		else {
			avion1.Ordenar();
			System.out.println("Ahora si puede despegar");
		}
		System.out.println();
		System.out.println(avion1.impInformacion());
		System.out.println("_____________________________________________________________________");
		Avion_Pasaje_Carga avion2 = new Avion_Pasaje_Carga(10, 10);
		avion2.Cargar(caja1);
		System.out.println(avion2.msg);
		avion2.Cargar(caja2);
		System.out.println(avion2.msg);
		avion2.Cargar(caja3);
		System.out.println(avion2.msg);
		avion2.Cargar(caja4);
		System.out.println(avion2.msg);
		avion2.Cargar(caja5);
		System.out.println(avion2.msg);
		avion2.Cargar(caja6);
		System.out.println(avion2.msg);
		avion2.Cargar(caja7);
		System.out.println(avion2.msg);
		avion2.Cargar(caja8);
		System.out.println(avion2.msg);
		avion2.Cargar(caja9);
		System.out.println(avion2.msg);
		avion2.Cargar(caja10);
		System.out.println(avion2.msg);
		System.out.println();
		if(avion2.Verificar()) {
			System.out.println("El avion puede despegar");
		}
		else {
			avion2.Ordenar();
			System.out.println("Ahora si puede despegar");
		}
		System.out.println();
		Pasajero pasajero1 = new Pasajero("Alfredo");
		Pasajero pasajero2 = new Pasajero("1",1);
		Pasajero pasajero3 = new Pasajero("2",2);
		Pasajero pasajero4 = new Pasajero("3",3);
		Pasajero pasajero5 = new Pasajero("4",4);
		Pasajero pasajero6 = new Pasajero("5",5);
		Pasajero pasajero7 = new Pasajero("6",6);
		
		avion2.Abordar(pasajero1);
		System.out.println(avion2.msg);
		avion2.Abordar(pasajero2);
		System.out.println(avion2.msg);
		avion2.Abordar(pasajero3);
		System.out.println(avion2.msg);
		avion2.Abordar(pasajero4);
		System.out.println(avion2.msg);
		avion2.Abordar(pasajero5);
		System.out.println(avion2.msg);
		avion2.Abordar(pasajero6);
		System.out.println(avion2.msg);
		avion2.Abordar(pasajero7);
		System.out.println(avion2.msg);
		
		System.out.println();
		System.out.println(avion2.impInformacion());
	}

}
