# 🔤 Proyecto 1 · Métodos de Cadena

> **Unidad 0 · Diagnóstico y Fundamentos** — [Ver solución](../Rutinas.java)

## 📝 Enunciado

En la clase `Rutinas.java` se desea que implemente los siguientes métodos:

| Método | Descripción |
|---|---|
| `public static String SinBlancos(String texto)` | Debe eliminar todo carácter blanco que no sea necesario en el texto. |
| `public static String Mayusculas(String texto)` | Debe regresar el texto con caracteres en mayúscula. |
| `public static String Minusculas(String texto)` | Debe regresar el texto con los caracteres en minúscula. |
| `public static int Comparar(String unTexto, String otroTexto)` | Debe comparar el contenido de `unTexto` con respecto a `otroTexto`. |

Valores de retorno de `Comparar`:

| Valor | Significado |
|:---:|---|
| `0` | Ambos valores son iguales (tienen el mismo contenido). |
| `1` | El contenido de `unTexto` es **mayor** que el de `otroTexto`. |
| `-1` | El contenido de `unTexto` es **menor** que el de `otroTexto`. |

> [!IMPORTANT]
> **No** se pueden utilizar los métodos `compareTo`, `trim` ni `toUpperCase`.

---

## 📄 Código base proporcionado — `Rutinas.java`

Clase de utilerías sobre la que se agregan los métodos solicitados.

```java
import java.util.*;

public class Rutinas {

	static Random r=new Random();
	static String []VN ={"Diego","Daniel","Yessenia","Luis","Anastacia","Plutarco","Alicia","Maria","Sofia","Antonio","Nereida","Carolina",
			"Rebeca","Javier","Luis"};
	static String [] VA={"Garcia","Lopez","Perez","Urias","Mendoza","Coppel","Diaz"};
	static boolean [] Sexo={true,true,false,true,false,true,false,false,false,true,false,false,
			false,true,true};

	public static String nextNombre(int Numero){
		String Nom="",NomTra="";
		int Pos;
		boolean Genero=true;;

		for(int i=0;i<Numero;i++){
			Pos=r.nextInt(VN.length);

			NomTra=VN[Pos]+" ";

			if (i==0){
				Genero=Sexo[Pos];
			}

			if( Genero != Sexo[Pos]  || i>0 && Nom.indexOf(NomTra)>-1    ){
				i--;
				continue;
			}

			Nom+=NomTra;

		}
		NomTra="";
		for(byte i=0;i<2;i++){
			NomTra+=VA[r.nextInt(VA.length)]+" ";
		}
		Nom=Nom+NomTra;
		return Nom.trim();
	}
	public static int nextInt(int li, int ls) {
		return r.nextInt(ls-li+1)+li;
	}
	public static String PonCeros(long numero, int tamaño) {
		String texto=numero+"";
		while (texto.length()<tamaño)
			texto="0"+texto;
		return texto;
	}
	public static String PonBlancos(String texto, int tamaño) {
		while (texto.length()<tamaño)
			texto=texto+" ";
		return texto;
	}

	public static String nextColor() {
		String [] colores= {"rojo","rosa","violeta","negro","amarillo","blanco","gris","azul","verde","cafe","naranja","lila"};
		return colores[ Rutinas.nextInt(0,colores.length-1)   ];
	}
}
```
