package HerenciaYPolimorfismo.ejercicios.torniquete_especial;

public class TorniqueteEspecial extends Torniquete {
	private String msg;
	public TorniqueteEspecial(int noEmpleados, String jefes) {
		super(noEmpleados);
		String [] nombres=jefes.split(",");
		String nom;
		int id,pos;
		for(int i=0 ; i<nombres.length ; i++) {
			pos=nombres[i].indexOf("-");
			nom=nombres[i].substring(0,pos);
			id= Integer.parseInt(nombres[i].substring(pos+1));
//   version i, private getEmpleados()[id-1].setNombre(nom);
//	version 2, private		Empleado [] arreglo = getEmpleados();
//			arreglo[id-1].setNombre(nom);
			empleados[id-1].setNombre(nom);
			
		}
	}
	public boolean Entrar(String nom) {
		if ( nom.equals("")) {
			msg="Debe proporcionar nombre del jefe";
			return false;
		}
		int pos=-1;
		for(int i=0 ; i<empleados.length ; i++) {
			if(empleados[i].getNombre().equals(nom)) {
				pos=i;
				break;
			}
		}
		if(pos==-1) {
			msg="Nobre no registrado como jefe";
			return false;
		}
		if( empleados[pos].isAdentro()) {
			msg="Ya se encuentra adentro";
			return false;
		}
		empleados[pos].setAdentro(true);
		return true;
	}
	public boolean Salir(String nom) {
		if ( nom.equals("")) {
			msg="Debe proporcionar nombre del jefe";
			return false;
		}
		int pos=-1;
		for(int i=0 ; i<empleados.length ; i++) {
			if(empleados[i].getNombre().equals(nom)) {
				pos=i;
				break;
			}
		}
		if(pos==-1) {
			msg="Nobre no registrado como jefe";
			return false;
		}
		return Salir(pos+1);
	}
}
