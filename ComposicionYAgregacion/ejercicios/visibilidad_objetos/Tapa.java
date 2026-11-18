package ComposicionYAgregacion.ejercicios.visibilidad_objetos;

public class Tapa {
	private String msg;
	private boolean estado; // true=puesta, false=no puesta
	public Tapa() {
		estado=true;
	}
	public boolean Poner() {
		if( estado) {
			msg="La tapa ya está puesta";
			return false;
		}
		estado=true;
		return true;
	}
	public boolean Quitar() {
		if( !estado) {
			msg="La tapa no se encuentra sobre el contenedor";
			return false;
		}
		estado=false;
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
