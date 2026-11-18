package FlujosYArchivos.ejercicios.serializacion_objetos;
import java.io.*;
import java.util.*;
class Amigo implements Serializable{
	private String nombre,apodo,telefono;
	public Amigo(String nombre,String apodo,String telefono) {
		this.nombre=nombre;
		this.apodo=apodo;
		this.telefono=telefono;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApodo() {
		return apodo;
	}
	public void setApodo(String apodo) {
		this.apodo = apodo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String toString() {
		return nombre+apodo+telefono;
	}
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Amigo amigo = (Amigo) o;
	        return this.toString().equals( amigo.toString());
	    }

//	    @Override
//	    public int hashCode() {
//	        return Objects.hash(nombre,apodo,telefono);
//	    }	
}
public class Contacto {
	private ArrayList<Amigo> array;
	public Contacto() {
		
	}
	public boolean Abrir() {
		File file=new File("Contactos.obj");
		if(!file.exists()) {
		   array=new ArrayList<Amigo>();
		   System.out.println("Total de amigos "+array.size());
		}
		else {
			try {
			FileInputStream f = new FileInputStream("contactos.OBJ");
			ObjectInputStream salida = new ObjectInputStream(f);
			array=(ArrayList<Amigo>) salida.readObject();
			 System.out.println("===Total de amigos "+array.size());
			f.close();
			salida.close();
			} catch (Exception obj) {
				return false;
			}
		}
		return true;
	}
	
	public boolean Cerrar() {
		try {
		FileOutputStream f = new FileOutputStream("contactos.OBJ");
		ObjectOutputStream salida = new ObjectOutputStream(f);
		salida.writeObject(array);
		salida.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	public boolean Grabar(Amigo amigo) {
		array.add(amigo);
//		System.out.println("Total amigos registardos"+array.size());
		return true;
	}
	
	public void Imprimir() {
		System.out.println("ESTADO ACTUAL DEL ARRAY LIST");
//		for(Amigo amigo:array) {
//			System.out.println(amigo.getNombre()+"\t"+amigo.getApodo()+"\t"+amigo.getTelefono());
//		}
		Amigo amigo;
		for(int i=0 ; i<array.size(); i++) {
			amigo=array.get(i);
			System.out.println(amigo.getNombre()+"\t"+amigo.getApodo()+"\t"+amigo.getTelefono());

		}
	}
	
	public boolean Borrar(int posicion) {
		if(posicion<1 || posicion>array.size())
			return false;
		array.remove(posicion-1);
		
		return true;
	}
	public boolean Borrar(Amigo amigo) {
		if(amigo==null)
			return false;
		if(!array.contains(amigo))
			return false;
		array.remove(amigo);
		
		return true;
	}
	public int Buscar(Amigo amigo) {
//		System.out.println("ojo "+array.contains(amigo));
		return array.indexOf(amigo);
		
	}
}
