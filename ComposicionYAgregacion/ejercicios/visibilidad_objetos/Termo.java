package ComposicionYAgregacion.ejercicios.visibilidad_objetos;

import Unidad0_Diagnostico.ejercicios.Rutinas;

public class Termo {
	private String msg;
	private Contenedor contenedor;
	private Tapa		tapa;
	private Interruptor interruptor;
	
	public Termo() {
		this(500);
	}
	public Termo(int capacidad) {
		contenedor=new Contenedor(capacidad);
		tapa=new Tapa();
		interruptor=new Interruptor();
	}
	
	public boolean Beber(int trago) {
		if( !tapa.isEstado()) {
			return false;
		}
		if( interruptor.isEstado()) {
			return false;
		}
		int ml=0;
		switch (trago) {
		case 1: ml=Rutinas.nextInt(1, 3);break;
		case 2: ml=Rutinas.nextInt(4, 5);break;
		case 3: ml=Rutinas.nextInt(6, 8);break;
		}
		if( !contenedor.Sacar(ml)) {
			msg=contenedor.getMsg();
			return false;
		}
		return true;
		
	}
	public boolean Poner( int ml) {
		if( tapa.isEstado()) {
			msg="La tapa esta puesta";
			return false;
		}
		if( !contenedor.Poner(ml)) {
			msg=contenedor.getMsg();
			return false;
		}
		
		return true;
	}
	public boolean Vaciar() {
		tapa.Quitar();
		//contenedor.setNivel(0);
		
		//while(contenedor.Sacar(1));
		
		contenedor.Sacar( contenedor.getNivel());
		
		return true;
	}
	public boolean QuitarTapa() {
		if(! tapa.Quitar()) {
			msg=tapa.getMsg();
			return false;
		}
		return true;
	}
	public boolean PonerTapa() {
		if( !tapa.Poner()) {
			msg=tapa.getMsg();
			return false;
		}
		return true;
	}
	
}
