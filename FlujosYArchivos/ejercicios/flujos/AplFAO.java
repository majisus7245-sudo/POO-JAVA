package FlujosYArchivos.ejercicios.flujos;
import java.io.*;
class AplFAO {
    public static void main(String [] a){
       int c;
       try {
	FileInputStream F=new FileInputStream("C:\\ClasesTec\\POO\\SEM112\\SEM112\\src\\UNIDAD5Y6\\SLEEP.java");
	
               while ( ( c= F.read() ) != -1){
 	   System.out.print((char)c);
	}
       }
       catch (Exception e){
	System.out.println("El flujo no se estableció, verifique si el archivo existe");
       }
    }
}

