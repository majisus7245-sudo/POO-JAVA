package FlujosYArchivos.ejercicios.archivos_secuenciales;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
class Frecuencia {
	private String nombre;
	private int frecuencia;
	public Frecuencia(String nombre) {
		this.nombre=nombre;
		frecuencia=1;
	}
	public int getFrecuencia() {
		return frecuencia;
	}
	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
public class ArchivoSecuencialFrecuenciaAmigos {
	static FileWriter fw;
	static FileReader fr=null;
	static BufferedReader bf=null;
	
	public static void main(String[] args) {
		if( !Abrir()) {
			System.out.println("El archivo no se abrió");
			return;
		}
		if( !Procesar()) {
			System.out.println("Se presnt+o algún error al procesar el archivo");
			return;
		}
		if( !Cerrar()) {
			System.out.println("Problemas al cerrar los archivos");
			return;
		}

	}
	public static boolean Abrir() {
		try {
			fr = new FileReader("amigos.TXT");
			bf = new BufferedReader(fr);
			fw = new FileWriter("frecuenciaNombresAMIGOS.TXT");
		} catch (Exception obj) {
			return false;
		}
		return true;
	}
	public static boolean Procesar() {

		String linea, nombre;
		String [] arreglo;
		Frecuencia [] aux, frecuencia = new Frecuencia[3];
		int pos=0, sub ; 
		try {
			while (( linea=bf.readLine()) != null    ) {
				nombre=linea.substring(0,40).trim();
				arreglo=nombre.split(" ");
				
				for(int i=0 ; i< arreglo.length-2 ; i++) {
					nombre=arreglo[i];
					sub=-1;
					for(int j=0 ; j<pos ; j++) {
						if(nombre.equals(frecuencia[j].getNombre())){
							sub=j;
							break;
						}
						
					}
					if( sub==-1) {
						if( pos==frecuencia.length) {
							// el arreglo está lleno, darle mas elementos;
							aux=frecuencia;
							frecuencia=new Frecuencia[aux.length+10];
							for(int k=0 ; k<aux.length ; k++)
								frecuencia[k]=aux[k];
						}
						
						frecuencia[pos]=new Frecuencia(nombre);
						pos++;
					} else {
						frecuencia[sub].setFrecuencia(frecuencia[sub].getFrecuencia()+1);
					}
					
				}
			}
			System.out.println("resultados");
			String cadena;
			for(int i=0 ; i< pos ; i++) {
				cadena=String.format("%-15s%4d",frecuencia[i].getNombre(),frecuencia[i].getFrecuencia() );
				fw.write(cadena+"\n");
			}
				
			
		} catch (Exception obj) {
			return false;
		}
		return true;
	}
	public static boolean Cerrar() {
		try {
			fr.close();
			bf.close();
			fw.close();
		} catch (Exception obj) {
			return false;
		}
		return true;
	}
}
