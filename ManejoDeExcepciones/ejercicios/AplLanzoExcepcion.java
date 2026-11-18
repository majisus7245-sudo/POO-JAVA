package ManejoDeExcepciones.ejercicios;
import java.util.*;

import Unidad0_Diagnostico.ejercicios.Rutinas;
public class AplLanzoExcepcion {

	public static void main(String[] args) throws MiExcepcion{
//		System.out.print("Edad : ");
//		try {
//		int edad=new Scanner(System.in).nextInt();
//		if( edad<18 || edad>60)
//			throw new MiExcepcion("Edad fuera de rango");
//		edad=edad/(0);
//		} catch (MiExcepcion obj) {
//			System.out.println("ERROR POR : "+obj.getMessage());
//			return;
//		}
//		catch (Exception obj) {
//			System.out.println("ERROR POR : "+obj.getMessage());
//			return;
//		}
//		System.out.println("Edad capturada es válida");
//		

		int edad=Rutinas.LeerEntero("EDAD ", 18, 65);
		
		System.out.println("edad capturada "+edad);
		
	}

}
