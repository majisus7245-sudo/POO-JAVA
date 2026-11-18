package FlujosYArchivos.ejercicios.serializacion_objetos;
import java.io.*;
import java.util.ArrayList;

import Unidad0_Diagnostico.ejercicios.Rutinas;

class Empleado implements Serializable {
	private int id, edad;
	private String nombre;
	public Empleado(int id, String nombre, int edad) {
		
		this.id=id;
		this.nombre=nombre;
		this.edad=edad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
public class GrabarObjetos {

	public static void main(String[] args) {

	
		Empleado emp1 = new Empleado(1,"PEDRO INFANTE",110);
		Empleado emp2 = new Empleado(2,"ALICIA MACHADO",30);
		Empleado emp3 = new Empleado(3,"JUAN GARCIA",88);
		
		try {
			FileOutputStream f = new FileOutputStream("EMPLEADOS.OBJ");
			ObjectOutputStream salida = new ObjectOutputStream(f);
			
//			salida.writeObject(emp1);
//			salida.writeObject(emp2);
//			salida.writeObject(emp3);
			
			Empleado [] empleados = new Empleado[10];
			for(int i=0 ; i< empleados.length ; i++) {
				empleados[i]=new Empleado(i+4,Rutinas.nextNombre(1),Rutinas.nextInt(18,60));
			}
//			for(int i=0 ; i<empleados.length ; i++)
//				salida.writeObject(empleados[i]);
		
			salida.writeObject(empleados);
/*			
			
			ArrayList<Empleado> contenedor = new ArrayList<Empleado>();
			for(int i=0 ; i< 2147 ; i++) {
				contenedor.add(new Empleado(i+4,Rutinas.nextNombre(1),Rutinas.nextInt(18,60)));
			}
			
			salida.writeObject(contenedor);
*/			
			f.close();
			salida.close();

		} catch (IOException e) {
			System.out.println("Se presentó error al abro archivos");
			return;
		}

	}

}
