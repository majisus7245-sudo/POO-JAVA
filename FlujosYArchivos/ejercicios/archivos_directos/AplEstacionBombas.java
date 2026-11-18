package FlujosYArchivos.ejercicios.archivos_directos;

public class AplEstacionBombas {

	public static void main(String[] args) {
		EstacionGasolina obj=new EstacionGasolina();
		if(obj.getMsg().equals("estacion no creada")) {
			System.out.println("La aplicación, no puede ejecutarse, se presentó error al crear las bombas");
			return;
		}
		System.out.println("Toodo listo para vender");
		
		//obj.Vender(1,100,"usuariox","pasword1");

	}

}
