package ComposicionYAgregacion.ejercicios.visibilidad_objetos;

public class Contenedor {
	private int capacidad, nivel;
	private String msg;
	
	public Contenedor() {
		capacidad=500;
		nivel=0;
	}
	public Contenedor(int capacidad) {
		this.capacidad=capacidad;
	}
	
	public boolean Sacar(int cantidad) {
		if(nivel==0) {
			msg="No hay liquido en el contenedor";
			return false;
		}
		if( nivel< cantidad)
			cantidad=nivel;
		
		nivel-=cantidad;
		return true;
	}
	public boolean Poner(int cantidad) {
		if( nivel == capacidad ) {
			msg="Contenedor lleno";
			return false;
		}
		if( nivel+cantidad > capacidad) {
			cantidad=capacidad-nivel;
		}
		nivel+=cantidad;
		
		return true;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
