package ComposicionYAgregacion.ejercicios.visibilidad_objetos;

public class Interruptor {
	private String msg;
	private boolean estado; //true=cerrado, false=abierto
	public Interruptor() {
		estado=true;
	}
	public boolean Abrir() {
		if( !estado ) {
			msg="El interruptor ya está abierto";
			return false;
		}
		estado=false;
		return true;
	}
	public boolean Cerrar() {
		if( estado ) {
			msg="El interruptor ya está cerrado";
			return false;
		}
		estado=true;
		return true;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
