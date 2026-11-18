/*Nombre: Manuel de Jesus Inzunza Lara 
No. Control: 23170195
Materia: Programacion orientada a objetos
Unidad: 6
Proyecto: Interface Proyecto Archivos Binarios
Fecha: 29 de mayo del 2024
Maestro Dr. Clemente Garcia Gerardo*/

package FlujosYArchivos.tareas.ventas_2023;

public interface VentasInterface {

	public int TotalUnidades(String fecha);
	public int TotalUnidades(String fecha, int producto);
	public int TotalUnidades(String fecha, int prodIni, int prodFin);
	public int TotalUnidades(String fechaIni, String fechaFin, int prodIni, int prodFin);
	
}
