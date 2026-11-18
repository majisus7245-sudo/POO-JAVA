/*Nombre: Manuel de Jesus Inzunza Lara 
No. Control: 23170195
Materia: Programacion orientada a objetos
Unidad: 6
Proyecto: Interface Examen tercer parcial
Fecha: 31 de mayo del 2024
Maestro Dr. Clemente Garcia Gerardo*/
package FlujosYArchivos.examen.tercer_parcial;

public interface InterfaceClientes {

	boolean Autorizar(long telefono);
	boolean Bloquear(long telefono);
	boolean Desbloquear();
	
}
