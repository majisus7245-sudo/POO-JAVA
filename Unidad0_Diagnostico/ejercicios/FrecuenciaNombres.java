package Unidad0_Diagnostico.ejercicios;


public class FrecuenciaNombres {
    public static void main(String[] args) {
        System.out.println("*************Hola Mundo*****************");
        String [] freNom =new String[100];
         int [] freVeces=Frecuencia("Sabado domingo lunes Sabado domingo", freNom);
         Imprimir(freNom,freVeces);
         System.out.println(Rutinas.nextNombre(1));
         System.out.println("ojojojojo");
    }
    public static void Imprimir(String [] freNom,int [] freVeces){
        System.out.println(" ***** Frecuencia de nombres ***********");
        for( int i=0 ; i<freNom.length ; i++){
            if(freNom[i]==null)
            break;
          //  System.out.println(freNom[i]+"\t"+freVeces[i]);
            System.out.printf("%-20s  %4d\n",freNom[i],freVeces[i]);
            
        }
    }
    public static int[] Frecuencia(String a, String [] freNom){


        String [] palabras=a.split(" ");
        int [] freVeces= new int[palabras.length];
   //     String []freNom = new String[palabras.length];
        int posicion,contador=0;
        String palabra;
        for(int i=0 ; i<palabras.length ; i++){
            palabra=palabras[i];
            posicion=-1;
            for(int j=0 ; j<contador ; j++){
                if( palabra.equals(freNom[j])){
                    posicion=j;
                    break;
                }
            }
            if(posicion==-1){
                freNom[contador]=palabra;
                freVeces[contador]=1;
                contador++;
            } 
            else{
                freVeces[posicion]++;
            }
        }

        return freVeces;
    }
}