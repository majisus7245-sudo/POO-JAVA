package ComposicionYAgregacion.tareas.rocola_caja;

public class AplRocola {
    public static void main(String[] args) {
    	Rocola rocola = new Rocola(50,"200,3,100,4,50,9,10,4,5,9,1,100");
    	Rocola rocola1 = new Rocola(50);
        
    	int [] cambio = new int [12];
        rocola.Pagar("100,4", cambio);
        for(int i = 0; i < cambio.length-1; i+=2) {
        	if(cambio[i] != 0) {
    		System.out.println(cambio[i] + "\t"+ cambio[i+1]);
        	}
    	}
        System.out.println();
  
        /*
        Disco disco1 = new Disco("La incondicional","Hasta que me olvides","Luis Miguel");
        Disco disco2 = new Disco("La incondicional","Hasta que me olvides","Luis Miguel");
        Disco disco3 = new Disco("La incondicional","Hasta que me olvides","Luis Miguel");
        
        rocola.Introducir(2, "A", disco3);
        System.out.println(rocola.getMsg());
        rocola.Introducir(3, "A", disco3);
        System.out.println(rocola.getMsg());
        rocola.Introducir(4, "A", disco3);
        System.out.println(rocola.getMsg());
        
        //int [] dineroCaja= {200,3,100,4,50,9,10,4,5,9,1,100};
        
        //rocola.Pagar(5);
        System.out.println(rocola.getMsg());
        
        rocola.Reproducir(3, "A", "C");
        System.out.println(rocola.getMsg());
        
        rocola.Reproducir(3, "A", "A");
        System.out.println(rocola.getMsg());*/
    }
}

