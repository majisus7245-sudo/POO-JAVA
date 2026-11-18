/*Nombre: Manuel de Jesus Inzunza Lara 
No. Control: 23170195
Materia: Programacion orientada a objetos
Unidad: 3
Proyecto: Avion de Carga
Fecha: 14 de abril del 2024
Maestro Dr. Clemente Garcia Gerardo*/
package HerenciaYPolimorfismo.ejercicios.aviones;

class Caja{
	
	private int pesoCaja;
	
	public Caja(int pesoCaja) {
		this.pesoCaja = pesoCaja;
	}

	public int getPesoCaja() {
		return pesoCaja;
	}

	public void setPesoCaja(int pesoCaja) {
		this.pesoCaja = pesoCaja;
	}
	
}

public class Avion_Carga {

	protected int capMax, contCapacidad, numCajas, maxCajas, contCajas;
	protected double maxPeso;
	protected Caja [][] seccion;
	protected String msg;
	
	public Avion_Carga(int capMax, int numCajas) {
		this.capMax = capMax * 1000;
		this.numCajas = numCajas;
		seccion = new Caja [numCajas][2];
		maxCajas = numCajas * 2;
		contCapacidad = 0;
		contCajas = 0;
		maxPeso = capMax * 1000 * 0.1;

	}
	public boolean Cargar(Caja caja) {
		if(contCajas == maxCajas) {
			msg = "El limite de cajas se ha alcanzado";
			return false;
		}
		if(caja.getPesoCaja() + contCapacidad > capMax) {
			msg = "El limite de peso se ha alcanzado";
			return false;
		}
		if(caja.getPesoCaja() > maxPeso) {
			msg = "El peso de esta caja es muy grande";
			return false;
		}
		int col = -1;
		int fila = -1;
		for(int i = seccion.length-1; i >= 0; i--) {
			for(int j = 0; j < seccion[i].length; j++) {
				if(seccion[i][j] == null) {
					fila = i;
					col = j;
					break;
				}
			}
			if(col != -1 && fila != -1) {
				break;
			}
		}
		if(col == -1 && fila == -1) {
			msg = "Ya no hay secciones disponibles";
			return false;
		}
		seccion[fila][col] = new Caja(caja.getPesoCaja());
		msg = "Caja guardada exitosamente";
		contCajas ++;
		contCapacidad += caja.getPesoCaja();
		return true;
	}
	
	public boolean Verificar() {
		int pesIzquierdo = 0;
		int pesDerecho = 0;
		for(int i = 0; i < seccion.length; i++) {
			for(int j = 0; j < 2; j+=2) {
				pesIzquierdo += seccion[i][j].getPesoCaja();
				pesDerecho += seccion[i][j+1].getPesoCaja();
			}
		}
		
		int diferencia = pesIzquierdo - pesDerecho;
		double maxDiferencia = capMax * 0.1;
		if(Math.abs(diferencia) > maxDiferencia) {
			msg = "El peso esta desbalanceado";
			return false;
		}
		msg = "El peso esta balanceado";
		return true;
	}
	
	public boolean Ordenar() {
		Caja [] cajas = new Caja[maxCajas];
		int pos = 0;
		for(int i = seccion.length-1; i >= 0; i--) {
			for(int j = 0; j < seccion[i].length; j++) {
				cajas[pos] = seccion[i][j];
				pos++;
			}
		}
		Caja peso;
		for(int i = 0; i < pos; i++) {
			for(int j = 0; j < pos-i-1; j++) {
				if(cajas[j].getPesoCaja() < cajas[j+1].getPesoCaja()) {
					peso = cajas[j+1];
					cajas[j+1] = cajas[j];
					cajas[j] = peso;
				}
			}
		}
		int posi = 0;
		for(int i = seccion.length-1; i > -1; i--) {
			for(int j = 0; j < 2; j++) {
				seccion[i][j] = cajas[posi];
				posi++;
			}
		}
		return true;
	}
	public String impOrden() {
		String contenido = "";
		for(int i = 0; i < seccion.length; i++) {
			for(int j = 0; j < 2; j+=2) {
					contenido += String.format("%s\t%s\n", seccion[i][j].getPesoCaja(), seccion[i][j+1].getPesoCaja());
			}
		}
		return contenido;
	}
	public String impInformacion() {
		String contenido = "";
		contenido += "Total de cajas: " + contCajas + "\n";
		int estCarga = (contCapacidad * 100) / capMax;
		contenido += "Estado de la carga por: " + estCarga + "%\n";
		contenido += "Organización de las cajas(Izquierda-Derecha): \n";
		for(int i = 0; i < seccion.length; i++) {
			for(int j = 0; j < 2; j+=2) {
					contenido += String.format("\t%s\t%s\n", seccion[i][j].getPesoCaja(), seccion[i][j+1].getPesoCaja());
			}
		}
		return contenido;
	}
	
	public int getCapMax() {
		return capMax;
	}
	public void setCapMax(int capMax) {
		this.capMax = capMax;
	}
	public int getContCapacidad() {
		return contCapacidad;
	}
	public void setContCapacidad(int contCapacidad) {
		this.contCapacidad = contCapacidad;
	}
	public int getNumCajas() {
		return numCajas;
	}
	public void setNumCajas(int numCajas) {
		this.numCajas = numCajas;
	}
	public int getMaxCajas() {
		return maxCajas;
	}
	public void setMaxCajas(int maxCajas) {
		this.maxCajas = maxCajas;
	}
	public double getMaxPeso() {
		return maxPeso;
	}
	public void setMaxPeso(double maxPeso) {
		this.maxPeso = maxPeso;
	}
	public Caja[][] getSeccion() {
		return seccion;
	}
	public void setSeccion(Caja[][] seccion) {
		this.seccion = seccion;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
