package ComposicionYAgregacion.tareas.rocola_caja;

public class Caja {
	class Denominacion{
		private int denominacion, cantidad;

		public Denominacion(int denominacion, int cantidad) {
			this.denominacion=denominacion;
			this.cantidad=cantidad;
		}
		public int getDenominacion() {
			return denominacion;
		}
		public void setDenominacion(int denominacion) {
			this.denominacion = denominacion;
		}
		public int getCantidad() {
			return cantidad;
		}
		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}
		
	}
	private String msg;
	private Denominacion [] deno;
	private int [] den= {200,100,50,20,10,5,2,1};
	
	public Caja() {
		deno=new Denominacion[den.length];
		for(int i=0 ; i<den.length ; i++)
			deno[i]=new Denominacion(den[i],0);
	}
	public Caja(String dinero) {
		String [] din=(dinero.split(","));
		int dine, cant;
		deno=new Denominacion[den.length];
		for(int i=0 ; i<den.length ; i++)
			deno[i]=new Denominacion(den[i],0);
		
		for(int i=0 ; i<din.length ; i+=2) {
			dine=Integer.parseInt(din[i]);
			cant=Integer.parseInt(din[i+1]);
			for(int j = 0; j<den.length;j++) {
				if(dine==den[j]) {
					deno[j].setCantidad(cant);
				}
			}
		}		
	}
	public boolean Pagar(String pago, int [] cambio, int costo) {
		String [] BilleteCantidad = pago.split(",");
		int denom, cant, total = 0;
		for(int i = 0; i < BilleteCantidad.length; i+=2) {
			denom=Integer.parseInt(BilleteCantidad[i]);
			cant=Integer.parseInt(BilleteCantidad[i+1]);
			total += denom*cant;
		}
		if(total < costo) {
			msg = "El importe dado no es suficiente";
			return false;
		}
		int importe = total - costo;
		int aux=importe,nb,den,billetes;
		for(int i= 0 ; i<deno.length ; i++) {
			if(deno[i].getCantidad()==0)
				continue;
			nb=deno[i].getCantidad();
			den=deno[i].getDenominacion();
			billetes = aux / den ;
			if( billetes==0)
				continue;
			if( billetes>nb)
				billetes=nb;
			aux -= billetes * den ;
		}
		if( aux !=0) {
			msg="No es posible darle feria";
			cambio = new int[BilleteCantidad.length-1];
			for(int i = 0; i < BilleteCantidad.length-1; i++) {
				cambio[i] = Integer.parseInt(BilleteCantidad[i]); 
			}
			return false;
		}
		aux=importe;
		String Regresar = "";
		for(int i= 0 ; i<deno.length ; i++) {
			if(deno[i].getCantidad()==0)
				continue;
			nb=deno[i].getCantidad();
			den=deno[i].getDenominacion();
			billetes = aux / den ;
			if( billetes==0)
				continue;
			if( billetes>nb)
				billetes=nb;
			aux -= billetes * den ;
			Regresar += (den + "," + billetes+ ",");
			deno[i].setCantidad(deno[i].getCantidad()-billetes);
		}
		String [] regresar = Regresar.split(",");
		//Mi variable de cambio solo pasa los datos al declarar el tamaño del arreglo desde el main
		//No jala desde adentro de la caja -->cambio = new int[deno.length*2];
		//Desde el main declare -> int [] cambio = new int [12];
		for(int i = 0; i < regresar.length; i++) {
			cambio[i] = Integer.parseInt(regresar[i]); 
		}
		for(int i = 0; i < BilleteCantidad.length; i+=2) {
			denom=Integer.parseInt(BilleteCantidad[i]);
			cant=Integer.parseInt(BilleteCantidad[i+1]);
			for(int j = 0; j < deno.length; j++) {
				if(denom == deno[j].getDenominacion()) {
					deno[j].setCantidad(deno[j].getCantidad()+cant);
				}
			}
		}
		return true;
	}

	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}	
		
}
