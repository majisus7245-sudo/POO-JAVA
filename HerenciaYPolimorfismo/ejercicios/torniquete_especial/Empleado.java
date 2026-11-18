package HerenciaYPolimorfismo.ejercicios.torniquete_especial;

import Unidad0_Diagnostico.ejercicios.Rutinas;

class Empleado {
	private int id;
	private String nombre;
	private int noAccesos;
	private boolean adentro;
	public Empleado(int id) {
		this.id=id;
		nombre="";
		noAccesos=Rutinas.nextInt(1000, 1500);
		adentro=false;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNoAccesos() {
		return noAccesos;
	}
	public void setNoAccesos(int noAccesos) {
		this.noAccesos = noAccesos;
	}
	public boolean isAdentro() {
		return adentro;
	}
	public void setAdentro(boolean adentro) {
		this.adentro = adentro;
	}
	
}

