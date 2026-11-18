package FlujosYArchivos.ejercicios.serializacion_objetos;

import java.io.*;
import java.util.*;
public class LeerObjetosPersistentes {
	public static void main(String [] a) {
		Empleado e1,e2,e3;
		Empleado [] empleados;
		try {
			
	
			
			FileInputStream f = new FileInputStream("EMPLEADOS.OBJ");
			ObjectInputStream salida = new ObjectInputStream(f);
	
//			e1=(Empleado)salida.readObject();
//			e1.setEdad(e1.getEdad()+100);
//			System.out.println(e1.getNombre()+"\t"+e1.getEdad()+"\t"+e1.getId());
//			e2=(Empleado)salida.readObject();
//			System.out.println(e2.getNombre()+"\t"+e2.getEdad()+"\t"+e2.getId());
//			e3=(Empleado)salida.readObject();
//			System.out.println(e3.getNombre()+"\t"+e3.getEdad()+"\t"+e3.getId());
//			
//			 empleados = new Empleado[10];
//			for(int i=0 ; i<10_000 ; i++) {
//			empleados[i]=(Empleado)salida.readObject();
//			System.out.println(empleados[i].getNombre());
//			}

			empleados=(Empleado [] )salida.readObject();
			System.out.println("Total de empleados recuperados "+empleados.length);
			for(int i=0 ; i<empleados.length;i++)
				System.out.println(empleados[i].getNombre());
		} catch (Exception e) {
			System.out.println("SE PRESENTÓ EROR");
			return;
		}

	}
}

