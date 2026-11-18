package FlujosYArchivos.ejercicios.archivos_directos;
import java.io.*;
class Bomba{
	private String usuario, password;
	public Bomba(String usuario, String password) {
		this.usuario=usuario;
		this.password=password;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
public class EstacionGasolina {
	private Bomba [] passwordBombas;
	private String msg;
	
	public EstacionGasolina() {
		try {
			RandomAccessFile arch=new RandomAccessFile("BOMBAS.DAT","r");
			int noBombas=(int) (arch.length()/20);
			passwordBombas=new Bomba[noBombas];
			String usuario,password;
			for(int i=0 ; i<noBombas;i++) {
				usuario=arch.readUTF();
				password=arch.readUTF();
				passwordBombas[i]=new Bomba(usuario,password);
			}
			arch.close();
			for(int i=0 ; i<passwordBombas.length;i++)
				System.out.println(passwordBombas[i].getUsuario()+" "+passwordBombas[i].getPassword());
			
		} catch (Exception e) {
			msg="estacion no creada";
			return;
		}
		msg="estacion bien creada";
	}
	
	public boolean Vender(int noBomba, int listros, String usuario, String password) {
		Bomba [] b=passwordBombas;
		if( !b[noBomba-1].getUsuario().equals(usuario) ||
				!b[noBomba-1].getPassword().equals(password) )
			return false;
		
		return true;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	

}
