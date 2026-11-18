# 🔗 Proyecto · Archivos directos (encadenamiento de folios)

> **Flujos y Archivos** — [Ver solución](../ProyectoArchivosDirectos.java)

## 📝 Enunciado

Ejecute el programa `ArchivosParaEncadenarPri.java` (incluido abajo), el cual creará dos archivos binarios de organización directa con el siguiente registro lógico:

<table>
<tr><th>FoliosPri.dat</th><th>FoliosPriMovtos.dat</th></tr>
<tr><td>

| Campo | Tipo | Tamaño |
|---|---|---|
| `noFolio` | `int` | 4 bytes |
| `noSucursal` | `int` | 4 bytes |
| `priMovto` | `int` | 4 bytes |

</td><td>

| Campo | Tipo | Tamaño |
|---|---|---|
| `noFolio` | `int` | 4 bytes |
| `idProducto` | `int` | 4 bytes |
| `noUnidades` | `int` | 4 bytes |
| `precio` | `float` | 4 bytes |
| `siguiente` | `int` | 4 bytes |

</td></tr>
</table>

Se desea que desarrolle las clases Java necesarias que permitan actualizar los campos:

- **`priMovto`** → el número de registro donde se encuentra el **primer movimiento** de ese folio.
- **`siguiente`** → el número de registro donde se encuentra el **siguiente movimiento** del mismo folio.

```mermaid
flowchart LR
    F["Folio N<br/>priMovto"] --> M1["Movto 1<br/>siguiente"] --> M2["Movto 2<br/>siguiente"] --> M3["Último movto<br/>del folio"]
```

---

## 📄 Código base proporcionado — `ArchivosParaEncadenarPri.java`

> El programa genera los archivos `FoliosPri.dat` y `FiliosPriDetalle.dat`. También está disponible como ejercicio de clase en [`archivos_directos`](../../../ejercicios/archivos_directos/ArchivosParaEncadenarPri.java).

```java
import java.io.RandomAccessFile;

/* FoliosPri.dat
 * Nofolio    int   4 bytes
 * NoSucursal int   4 bytes
 * priMovto   int   4 bytes
 *
 * FoliosPriMovtos.dat
 * noFolio    int    4 bytes
 * idProducto int    4 bytes
 * noUnidades int    4 bytes
 * precio     float  4 bytes
 * siguiente   int    4 bytes
 */
public class ArchivosParaEncadenarPri {

	public static void main(String[] args) {
		RandomAccessFile archFolios, archDetalle;

		try {
			archFolios=new RandomAccessFile("FoliosPri.dat","rw");
			archDetalle=new RandomAccessFile("FiliosPriDetalle.dat","rw");
			int ap=0;
			for(int folio=1 ; folio<=20 ; folio++) {
				archFolios.writeInt(folio);
				archFolios.writeInt(Rutinas.nextInt(1, 10));
				archFolios.writeInt(ap);
				int no=Rutinas.nextInt(1, 15);
				for(int j=0 ; j<no ; j++ ) {
					archDetalle.writeInt(Rutinas.nextInt(1, 20));
					archDetalle.writeInt(Rutinas.nextInt(1, 50));
					archDetalle.writeInt(Rutinas.nextInt(1, 20));
					archDetalle.writeFloat(Rutinas.nextInt(50, 200));
					archDetalle.writeInt(Rutinas.nextInt(0, 0));
				}

			}

			Mostrar(archFolios,archDetalle);
			archFolios.close();
			archDetalle.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("proceso exitoso !!!!!!!!!");
	}
	static private void Mostrar(RandomAccessFile archF,RandomAccessFile archD) {
		try {
			archF.seek(0);
			int folio;
			while (true) {
				folio=archF.readInt();
				System.out.printf("Folio %4d  %4d  %4d \n",folio,archF.readInt(),archF.readInt());

				try {
					archD.seek(0);
					int folioD;
					while (true) {
						folioD=archD.readInt();
						if(folioD==folio)
							System.out.printf("\tFolio:%4d  %4d  %4d  %8.2f %4d \n ",folioD,archD.readInt(),archD.readInt(),archD.readFloat(),archD.readInt());
						else
							archD.seek(archD.getFilePointer()+16);
					}
				} catch (Exception e) {

				}

			}
		} catch (Exception e) {

		}
	}

}
```
