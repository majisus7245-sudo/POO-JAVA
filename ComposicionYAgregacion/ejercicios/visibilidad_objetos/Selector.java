package ComposicionYAgregacion.ejercicios.visibilidad_objetos;

public class Selector {
	private String msg;
	private Interruptor interruptor;
	private int temperatura; // o fria,1 baja, 2 media y 3 alta.
	public Selector() {
		interruptor=new Interruptor(); // true = apagado
		temperatura=0;
	}
	
	public boolean Encender() {
		if( !interruptor.Abrir() ) {
			msg=interruptor.getMsg();
			return false;
		}
		return ;
	}
	public boolean Apagar() {
		return interruptor.Cerrar();
	}
	public boolean SeleccionarTemperatura(int nivel) {
		if( interruptor.isEstado()) {
			msg="Plancha está apagada";
			return false;
		}
		temperatura=nivel;
		return true;
	}
	public boolean getEstado() {
		return interruptor.isEstado();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
