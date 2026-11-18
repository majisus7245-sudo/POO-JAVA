package ComposicionYAgregacion.tareas.rocola_caja;

class Disco{
	private String cancionA, cancionB, artista;
	public Disco(String cancionA, String cancionB, String artista) {
		this.cancionA = cancionA;
		this.cancionB = cancionB;
		this.artista = artista;
	}
	public String getCancionA() {
		return cancionA;
	}
	public void setCancionA(String cancionA) {
		this.cancionA = cancionA;
	}
	public String getCancionB() {
		return cancionB;
	}
	public void setCancionB(String cancionB) {
		this.cancionB = cancionB;
	}
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
	
	
}

public class Rocola {

	private Caja caja;
	private String msg, cambio;
	private boolean pagado;
	private Disco [][] discos;
	private int costo, numDiscos;
	
	public Rocola() {
		this(10);
	}
	public Rocola(int costo) {
		discos = new Disco[20][10];
		this.costo = costo;
		pagado = false;
		caja=new Caja();
	}
	
	public Rocola(int costo, String dineroCaja) {
		discos = new Disco[20][10];
		this.costo = costo;
		pagado = false;
		caja=new Caja(dineroCaja);
	}
	public boolean Pagar(String pago, int [] cambio) {
		if(!caja.Pagar(pago, cambio, costo)) {
			msg = caja.getMsg();
			return false;
		}
		
		return true;
	}
	public boolean Introducir(int fila, String columna, Disco disco) {
		int col = columna.charAt(0) - 'A';
		if((fila < 1 && fila > 20)||(col < 0 && col > 9)) {
			msg="Esta posicion no existe";
			return false;
		}
		for(int i = 0; i < discos.length; i++) {
			for(int j = 0; j < discos[i].length; j++) {
				if(this.discos[fila - 1][col] != null) {
					msg="Ya hay un disco en esta posicion";
					return false;
				}
			}
		}
		if(numDiscos==200) {
			msg="Ya no hay espacios para mas discos";
			return false;
		}
		numDiscos++;
		this.discos[fila - 1][col] = disco;
		msg="El disco se introdujo correctamente";
		return true;
	}
	public boolean Reproducir(int fila, String columna, String lado) {
		if(!pagado) {
			msg="No a pagado";
			return false;
		}
		int col = columna.charAt(0) - 'A';
		if(discos[fila-1][col]== null) {
			msg="No hay disco en esa posicion";
			return false;
		}
		int lado1 = lado.charAt(0)+65;
		if(lado1 < 65 && lado1 > 66) {
			msg="Introduza el lado correcto";
			return false;
		}
		msg="La canción se ha reproducido exitosamente";
		pagado=false;
		return true;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Disco[][] getDiscos() {
		return discos;
	}
	public void setDiscos(Disco[][] discos) {
		this.discos = discos;
	}
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}
	
	
}
