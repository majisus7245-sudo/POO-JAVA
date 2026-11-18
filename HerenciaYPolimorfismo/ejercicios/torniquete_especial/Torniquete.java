package HerenciaYPolimorfismo.ejercicios.torniquete_especial;

import Unidad0_Diagnostico.ejercicios.Rutinas;

public class Torniquete {
	protected Empleado [] empleados;
	private int noEmpleados;
	private String msg;
	
	public Torniquete(int noEmpleados) {
		this.noEmpleados=noEmpleados;
		empleados=new Empleado[noEmpleados];
		for(int i=0 ; i<empleados.length ; i++) {
			empleados[i]=new Empleado(i+1);
		}
	}
	public boolean Entrar(int id) {
		if( id<1 || id>noEmpleados) {
			msg="El id no es de un emleado";
			return false;
		}
		if( empleados[id-1].isAdentro()) {
			msg="El empleado se encuentra dentro";
			return false;
		}
		if( empleados[id-1].getNoAccesos()<=0) {
			msg="El empleado no tiene accesos disponibles";
			return false;
		}
		if( empleados[id-1].getNombre().equals(""))
			empleados[id-1].setNoAccesos(empleados[id-1].getNoAccesos()-1);
		empleados[id-1].setAdentro(true);
		return true;
	}
	public boolean Salir(int id) {
		if( id<1 || id>empleados.length) {
			msg="El id es incorrecto";
			return false;
		}
		if( !empleados[id-1].isAdentro()) {
			msg="el empleado ya esta afuera";
			return false;
		}
		empleados[id-1].setAdentro(false);
		
		return true;
	}
	public Empleado[] getEmpleados() {
		return empleados;
	}
	public void setEmpleados(Empleado[] empleados) {
		this.empleados = empleados;
	}
	
}
