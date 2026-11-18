/*Nombre: Manuel de Jesus Inzunza Lara 
No. Control: 23170195
Materia: Programacion orientada a objetos
Unidad: 3 y 4
Proyecto: Examen Herencia Tienda Especial
Fecha: 19 de abril del 2024
Maestro Dr. Clemente Garcia Gerardo*/
package HerenciaYPolimorfismo.examen.segundo_parcial;

import Unidad0_Diagnostico.tareas.metodos_de_cadena.Rutinas;

class Paquete extends Tienda{ // ESTO NO ES UNA ESPECIALIZACIÓN ¿QUÉ CASO TIENE LA HERENCIA AQUI?
	
	private int id, numProductos;
	private Producto [] proPaquete;
	
	public Paquete(int id) {
		this.id = id;
		proPaquete = new Producto[maxProductos]; // MAXPRODUCTOS LO HEREDO
		for(int i = 0; i < canProductos; i++) {
			proPaquete[i] = new Producto(i+1);// NO SABE QUE PRODUCTOS LLEVA EL PAQUETE...
		}
		numProductos = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumProductos() {
		return numProductos;
	}

	public void setNumProductos(int numProductos) {
		this.numProductos = numProductos;
	}

	public Producto[] getProPaquete() {
		return proPaquete;
	}

	public void setProPaquete(Producto[] proPaquete) {
		this.proPaquete = proPaquete;
	}
	
	
}

public class TiendaEspecial extends Tienda{

	private int numPaquetes;
	private Paquete [] paquetes; // aqui en paquetes anda la tienda ya heredaste---------
	
	public TiendaEspecial() {
		numPaquetes = Rutinas.nextInt(10, 20);
		paquetes = new Paquete[numPaquetes];
		for(int i = 0; i < numPaquetes; i++) {
			paquetes[i] = new Paquete(i+1); // incorrecto a todos los paquetes le asigna los mismos productos..MAL
		}
	}
	
	public boolean Agregar(int id, int idProducto, int cantidad) {
PUEDE VALIDA QUE LOS ID ESTEN EN EL RANGFO
		int posPaquete = -1;
		for(int i = 0; i < numPaquetes; i++) {
			if(paquetes[i].getId() == id) {
				posPaquete = i;
				break;
			}
		}
		if(posPaquete == -1) {
			msg = "Este paquete no existe";
			return false;
		}
		int posProducto = -1;
		for(int i = 0; i < numPaquetes; i++) {
			if(productos[i].getId() == idProducto) {
				posProducto = i;
				break;
			}
		}
		if(posProducto == -1) {
			msg = "Este producto no existe";
			return false;
		}
EL PRODUCTO NO DEBE EXISTIR PARA AGRAGARLO Y UD DESDE QUE CREA EL PAQUETE LE METIO LOS MISMOS ID A TODOS LOS PAQUETES........
		if(paquetes[posPaquete].getNumProductos() == 10) {
			msg = "El maximo de productos en este paquete ha alcanzado su limite";
			return false;
		}
		if(productos[posProducto].getExistencia() == 0) {
			msg = "Ya no hay existencia de este producto"; 
			return false;
		}
		if(paquetes[posPaquete].getNumProductos() == 10) {
			msg = "Ya no se pueden agregar mas productos a este paquete";
			return false;
		}
		if(cantidad > productos[posProducto].getExistencia()) {
			cantidad = productos[posProducto].getExistencia();
		}
		
		paquetes[posPaquete].getProPaquete()[idProducto-1].setExistencia(cantidad);;
		
		productos[posProducto].setExistencia(productos[posProducto].getExistencia()-cantidad);
		paquetes[posPaquete].setNumProductos(paquetes[posPaquete].getNumProductos() + 1);
		msg = "Se ha agregado el producto correctamente";
		return true;
	}
	public boolean AgregarProducto() {
		if(canProductos == maxProductos) {
			msg = "Ya no se pueden registrar mas productos";
			return false;
		}
		productos[canProductos] = new Producto(canProductos + 1);
		canProductos ++;
		msg = "Se ha registrado con exito el nuevo producto";
		return true;
	}
	public boolean VenderPaquete(int id) {
		int posPaquete = -1;
		for(int i = 0; i < numPaquetes; i++) {
			if(paquetes[i].getId() == id) {
				posPaquete = i;
				break;
			}
		}
		if(posPaquete == -1) {
			msg = "Este paquete no existe";
			return false;
		}
		if(paquetes[posPaquete].getNumProductos() < 2) {
			msg = "Este paquete aun no esta disponible";
			return false;
		}
// NO AFECTA LA EXISWTENCIA
		msg = "Se vendio correctamente el paquete";
		return true;
	}
	
}
