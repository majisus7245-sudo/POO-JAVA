package ManejoDeExcepciones.ejercicios;

import java.io.File;
import java.util.*;

import Unidad0_Diagnostico.ejercicios.Rutinas;
public class AplErrores {

	public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num=0;
        int [] v;
       File borrarlo = new File("AMIGOS.CVS");
       borrarlo.delete();
//        System.out.println(Rutinas.Renombrar( "CONTROL.CVS","Torniquete.java"));
  System.out.println(new File("AMIGOS.TXT").renameTo(new File("AMIGOS.CVS")));      
        try {
        	 System.out.print("Proporcione Edad : ");
             num=in.nextInt();
            v=new int[num];
            v[10]=8;
            float d=num / (num-1) ;
        }		
        catch(ArithmeticException e) {
            System.out.println("divison entre cero");
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("subindice fuera de rango");
            return;
        }
        catch(NegativeArraySizeException e) {
            System.out.println("intentó crear un vector con valor negativo");
            System.exit(0);
        }
        finally {
             System.out.println("....instrucciones del ffinally..");
      
        } 
        System.out.print ("continua con las instrucciones");
   }
}
