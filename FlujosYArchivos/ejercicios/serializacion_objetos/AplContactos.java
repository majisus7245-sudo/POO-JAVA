package FlujosYArchivos.ejercicios.serializacion_objetos;

import Unidad0_Diagnostico.ejercicios.Rutinas;

public class AplContactos {

	public static void main(String[] args) {
		Contacto obj = new Contacto();
		obj.Abrir();
//		for(int i=0 ; i<100 ; i++)
//			obj.Grabar(new Amigo(Rutinas.nextNombre(1),"dedos","667700000"+(i+1)));
//		for(int i=0 ; i<6 ; i++)
//			obj.Borrar(i);
		Amigo ok=new Amigo("Raymundo","Dedos","667700000");
//		obj.Grabar(ok);
//		ok=new Amigo("Maria Perez Garcia","dedos","6677000001");
		int pos=obj.Buscar(ok);
		System.out.println("Posicion "+pos);
		System.out.println(obj.Borrar(ok));
		obj.Imprimir();
		obj.Cerrar();
		

	}

}
