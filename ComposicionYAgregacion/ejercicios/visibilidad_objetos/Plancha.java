package ComposicionYAgregacion.ejercicios.visibilidad_objetos;

public class Plancha {
	private Placa placa;
	private Contenedor contenedor;
	private Selector selector;
	private String msg;
	
	public Plancha() {
		this(40,5);
	}
	public Plancha(int capacidadContenedor, int grosorPlaca) {
		contenedor=new Contenedor(capacidadContenedor);
		placa =  new Placa(grosorPlaca*10);
		selector = new Selector();
	}
	public boolean Encender() {
		
		if(! selector.Encender()) {
			msg="La plancha ya está encendida";
			return false;
		}
		if( contenedor.getNivel()<20 ) {
			
			return false;
		}
		if( placa.getNivelGrosor()<1) {
			
			return false;
		}		
		return true;
		
	}
	
	public boolean Planchar() {
		if ( selector.getEstado()   ) {
			msg="La plancha está apagada";
			return false;
		}
		// afectar la plancha
		
		// validas si debe apagarse
		
		return true;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
