package ClasesYObjetos.ejercicios.torniquete;

import Unidad0_Diagnostico.ejercicios.Rutinas;

class Empleado{
	private int id;
	private String nombre;
	private boolean estaAdentro;
	private int maxAccesos, numeroAccesos;
	public Empleado(int id) {
		this.id=id;
		nombre="";
		maxAccesos=Rutinas.nextInt(1000, 1500);
		numeroAccesos=0; // representa los accesos que ha realizado
		estaAdentro=false;
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
	public boolean isEstaAdentro() {
		return estaAdentro;
	}
	public void setEstaAdentro(boolean estaAdentro) {
		this.estaAdentro = estaAdentro;
	}
	public int getMaxAccesos() {
		return maxAccesos;
	}
	public void setMaxAccesos(int maxAccesos) {
		this.maxAccesos = maxAccesos;
	}
	public int getNumeroAccesos() {
		return numeroAccesos;
	}
	public void setNumeroAccesos(int numeroAccesos) {
		this.numeroAccesos = numeroAccesos;
	}
	
}
public class Torniquete {
	private int maxEmpleados;
	private Empleado [] empleados;
	private String jefes, msg;
	public Torniquete(int maxEmpleados, String jefes) {
		this.maxEmpleados=maxEmpleados;
		this.jefes=jefes;
		empleados=new Empleado[maxEmpleados];
		for(int i=0 ; i<empleados.length ; i++)
			empleados[i]=new Empleado(i+1);
		String [] nomJefes=jefes.split(",");
		int pos;
		String nombre;
		for(int i=0 ; i<nomJefes.length ; i++) {
			pos=nomJefes[i].indexOf("-");
			nombre=nomJefes[i].substring(0, pos);
			int id= Integer.parseInt( nomJefes[i].substring(pos+1) );
			empleados[id-1].setNombre(nombre);
			
		}
	}
	public boolean Entrar(int id) {
		if(id<1 || id>empleados.length) {
			msg="el id es incorrecto, no existe";
			return false;
		}
		if( empleados[id-1].isEstaAdentro()) {
			msg="El empleado ya esta adentro";
			return false;
		}
		if( !empleados[id-1].getNombre().equals("")) {
			return true;
		}
		if( empleados[id-1].getMaxAccesos()==empleados[id-1].getNumeroAccesos()) {
			msg="Los acceso ya fueron agotados";
			return false;
		}
		empleados[id-1].setNumeroAccesos(empleados[id-1].getNumeroAccesos()+1);
		empleados[id-1].setEstaAdentro(true);
		return true;
	}
	public boolean Entrar(String nombre) {
		if( nombre.equals("")) {
			msg="Debe de proporcionar nombre";
			return false;
		}
		// busco en empleados donde se encuentra nombre
		int pos=-1;
		for(int i=0 ; i<empleados.length ; i++) {
			if( empleados[i].getNombre().equals(nombre)) {
				pos=i;
				break;
			}
		}
		if(pos==-1) {
			msg="El nombre proporcionado no está registrado como jefe";
			return false;
		}
		int id=empleados[pos].getId();
		
		if(id<1 || id>empleados.length) {
			msg="el id es incorrecto, no existe";
			return false;
		}
		if( empleados[id-1].isEstaAdentro()) {
			msg="El empleado ya esta adentro";
			return false;
		}	
		empleados[id-1].setEstaAdentro(true);
		return true;
	}
	public boolean Salir(int id) {
		if(id<1 || id>empleados.length) {
			msg="el id es incorrecto, no existe";
			return false;
		}
		if( !empleados[id-1].isEstaAdentro()) {
			msg="El empleado NO esta adentro";
			return false;
		}
		empleados[id-1].setEstaAdentro(false);
		return true;
	}
	public boolean Salir(String nombre) {
//busco en empleados donde se encuentra nombre
		int pos=-1;
		for(int i=0 ; i<empleados.length ; i++) {
			if( empleados[i].getNombre().equals(nombre)) {
				pos=i;
				break;
			}
		}
		if(pos==-1) {
			msg="El nombre proporcionado no está registrado como jefe";
			return false;
		}
		int id=empleados[pos].getId();	
		
		return Salir(id);
	}
		
}
