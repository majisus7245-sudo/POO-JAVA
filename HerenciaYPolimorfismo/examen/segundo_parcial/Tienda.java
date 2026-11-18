/*Nombre: Manuel de Jesus Inzunza Lara 
No. Control: 23170195
Materia: Programacion orientada a objetos
Unidad: 3 y 4
Proyecto: Examen Herencia Tienda
Fecha: 19 de abril del 2024
Maestro Dr. Clemente Garcia Gerardo*/
package HerenciaYPolimorfismo.examen.segundo_parcial;

import Unidad0_Diagnostico.tareas.metodos_de_cadena.Rutinas;
// NO RIENE SENTIDO EL USO DE LA CLASE PRODUCTO YA QUE SOLO NECESITA ALMACENAR LA EXISTENCIA
class Producto{
	
	private int id, existencia;
	public Producto(int id) {
		this.id = id;
		existencia = Rutinas.nextInt(10, 20);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getExistencia() {
		return existencia;
	}
	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}
}

public class Tienda {

	protected int canProductos, maxProductos;
// ESTE ARREGLO LO PUEDE DEFINIR DE TIPO PRIMITICO int
	protected Producto [] productos;
	protected String msg;
	
	public Tienda() {
		canProductos = Rutinas.nextInt(100, 200);
		maxProductos = 200;
		productos = new Producto[maxProductos];
		for(int i = 0; i < canProductos; i++) {
			productos[i] = new Producto(i+1);
		} // OK, usa solo los elementos que genero aleatorio
	}
	
	public boolean Surtir(int id, int cantidad) {
PUEDE CHECAR SI EL ID ES INCORRECTO...........
// EL CICLO QUE ESTA USANDO PARA BUSCAR LO PUED OMITIR Y USAR DIRECAMENTE EL ID-1 PARA ACCEDER EL ELEMENTO DONDE ESTA EL PRODUCTO
		int pos = -1;
		for(int i = 0; i < canProductos; i++) {
			if(productos[i].getId() == id) {
				pos = i;
				break;
			}
		}
		if(pos == -1) { 
			msg = "Este producto no existe";
			return false;
		}
		if(productos[pos].getExistencia() == 20) {
			msg = "La existencia de este producto ha alcanzado su limite";
			return false;
		}
		if(productos[pos].getExistencia() + cantidad >= 20) {
			msg = "Elija una cantidad menor para introducir";
			return false;
		}
		productos[pos].setExistencia(productos[pos].getExistencia() + cantidad);
		msg = "Se ha surtido correctamente el producto";
		canProductos ++;
		return true;
	}

	public boolean Vender(int id, int cantidad) {
PUEDE VALIDAR EL ID<1 || ID>LONGITUD DEL ARREGLO 
		int pos = -1; SI ASIGNA ID-1 PUEDE EVIRA EL CICLO Y LA PREGUNAT DESPUES DEL CICLO
		for(int i = 0; i < canProductos; i++) {
			if(productos[i].getId() == id) {
				pos = i;
				break;
			}
		}
		if(pos == -1) {
			msg = "Este producto no existe";
			return false;
		}
		if(productos[pos].getExistencia() == 0) {
			msg = "Ya no hay existencia de este producto"; 
			return false;
		}
		if(cantidad > productos[pos].getExistencia()) {
			cantidad = productos[pos].getExistencia();
		}
		productos[pos].setExistencia(productos[pos].getExistencia() - cantidad);
		msg = "Se ha vendido correctamente el producto";
		return true;
	}
	
	public int getCanProductos() {
		return canProductos;
	}

	public void setCanProductos(int canProductos) {
		this.canProductos = canProductos;
	}

	public int getMaxProductos() {
		return maxProductos;
	}

	public void setMaxProductos(int maxProductos) {
		this.maxProductos = maxProductos;
	}

	public Producto[] getProductos() {
		return productos;
	}

	public void setProductos(Producto[] productos) {
		this.productos = productos;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
