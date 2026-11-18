<div align="center">

# ☕ Programación Orientada a Objetos

**Ejercicios de clase, tareas, exámenes y recuperaciones de la materia de POO en Java**

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Eclipse](https://img.shields.io/badge/Eclipse-2C2255?style=for-the-badge&logo=eclipseide&logoColor=white)
![Semestre](https://img.shields.io/badge/Semestre-Enero--Junio%202024-blue?style=for-the-badge)

</div>

---

## 📋 Tabla de contenido

- [Acerca del repositorio](#-acerca-del-repositorio)
- [Estructura](#-estructura)
- [Unidad 0 · Diagnóstico y Fundamentos](#-unidad-0--diagnóstico-y-fundamentos)
- [Clases y Objetos](#-clases-y-objetos)
- [Composición y Agregación](#-composición-y-agregación)
- [Herencia y Polimorfismo](#-herencia-y-polimorfismo)
- [Manejo de Excepciones](#-manejo-de-excepciones)
- [Flujos y Archivos](#-flujos-y-archivos)
- [Recuperaciones](#-recuperaciones)
- [Cómo compilar y ejecutar](#️-cómo-compilar-y-ejecutar)
- [Bibliografía](#-bibliografía)
- [Autor](#-autor)

---

## 📖 Acerca del repositorio

Este repositorio reúne todo el trabajo realizado durante el curso de **Programación Orientada a Objetos**, organizado por tema. Cada unidad contiene:

| Carpeta | Contenido |
|---|---|
| `ejercicios/` | Programas desarrollados en clase |
| `tareas/` | Proyectos entregados; cada uno incluye una carpeta `referencia/` con un `README.md` que contiene el enunciado y el código base proporcionado por el maestro |
| `examen/` | Examen parcial de la unidad (incluye las anotaciones de revisión del maestro) |

---

## 🗂 Estructura

```
📦 POO
├── 📁 Unidad0_Diagnostico        → Repaso de Java: cadenas, arreglos y rutinas de apoyo
├── 📁 ClasesYObjetos             → Modelado de objetos reales con clases
├── 📁 ComposicionYAgregacion     → Objetos formados por otros objetos
├── 📁 HerenciaYPolimorfismo      → Jerarquías de clases y especialización
├── 📁 ManejoDeExcepciones        → try / catch / throw y excepciones propias
├── 📁 FlujosYArchivos            → Archivos de texto, binarios, directos, indexados y serialización
├── 📁 Recuperaciones             → Examen de segunda oportunidad
└── 📄 README.md
```

> Los nombres de los paquetes Java coinciden con la ruta de carpetas (por ejemplo `ClasesYObjetos.ejercicios.billetera`).

---

## 🧭 Unidad 0 · Diagnóstico y Fundamentos

Repaso de la sintaxis de Java y creación de la clase utilitaria **`Rutinas`**, usada en el resto del curso para generar datos aleatorios y dar formato a texto.

### Ejercicios de clase
| Archivo | Descripción |
|---|---|
| [`Rutinas.java`](Unidad0_Diagnostico/ejercicios/Rutinas.java) | Utilerías: números/nombres/colores aleatorios, relleno con ceros y blancos, lectura validada de enteros, renombrado de archivos |
| [`Cadenas.java`](Unidad0_Diagnostico/ejercicios/Cadenas.java) | Manipulación de cadenas y frecuencia de caracteres |
| [`FrecuenciaNombres.java`](Unidad0_Diagnostico/ejercicios/FrecuenciaNombres.java) | Conteo de la frecuencia de nombres en un texto |
| [`ArregloObjetos.java`](Unidad0_Diagnostico/ejercicios/ArregloObjetos.java) | Primer uso de arreglos de objetos |

### Tareas
| Proyecto | Descripción |
|---|---|
| [Métodos de cadena](Unidad0_Diagnostico/tareas/metodos_de_cadena) | Implementar `SinBlancos`, `Mayusculas`, `Minusculas` y `Comparar` **sin** usar `trim`, `toUpperCase` ni `compareTo`. [📄 Enunciado](Unidad0_Diagnostico/tareas/metodos_de_cadena/referencia/README.md) |

---

## 🧱 Clases y Objetos

Abstracción de objetos del mundo real: atributos, constructores, encapsulamiento, getters/setters y estado del objeto.

### Ejercicios de clase
| Ejercicio | Descripción |
|---|---|
| [Billetera](ClasesYObjetos/ejercicios/billetera) | Billetera de piel o sintética con capacidad limitada de billetes y tarjetas; `BilleteraV2` agrega manejo por denominación y estado de cuenta. En `version_anterior/` está la primera versión |
| [Jaba](ClasesYObjetos/ejercicios/jaba) | Jaba de refrescos (matriz de espacios) con llenado secuencial y aleatorio y reportes |
| [Lápiz y Sacapuntas](ClasesYObjetos/ejercicios/lapiz) | Lápiz que se desgasta al escribir/borrar y sacapuntas que interactúa con él |
| [Torniquete](ClasesYObjetos/ejercicios/torniquete) | Control de entradas/salidas de empleados con límite de accesos |

### Tareas
| Proyecto | Descripción |
|---|---|
| [Proyecto USB](ClasesYObjetos/tareas/proyecto_usb) | Memoria USB con capacidad en GB y sistema de archivos (FAT32, NTFS, exFAT): grabar, borrar y mostrar archivos |

### Examen
| Examen | Descripción |
|---|---|
| [Primer parcial](ClasesYObjetos/examen/primer_parcial) | Torniquete de acceso para empleados |

---

## 🧩 Composición y Agregación

Clases que se construyen a partir de otras clases y visibilidad entre objetos.

### Ejercicios de clase
| Ejercicio | Descripción |
|---|---|
| [Visibilidad de objetos](ComposicionYAgregacion/ejercicios/visibilidad_objetos) | `Plancha` (placa, contenedor, selector) y `Termo` (contenedor, tapa, interruptor) compuestos por objetos más simples |

### Tareas
| Proyecto | Descripción |
|---|---|
| [Rocola con Caja](ComposicionYAgregacion/tareas/rocola_caja) | Rocola de 200 discos (20 filas × columnas A‑J) que delega el cobro y el cambio a un objeto `Caja` con denominaciones de 200 a 1 peso. [📄 Enunciado](ComposicionYAgregacion/tareas/rocola_caja/referencia/README.md) |

---

## 🧬 Herencia y Polimorfismo

Superclases, subclases, `protected`, sobrescritura de métodos, `super` e interfaces.

### Ejercicios de clase
| Ejercicio | Descripción |
|---|---|
| [Clase base](HerenciaYPolimorfismo/ejercicios/clase_base) | Ejemplo introductorio `Superclase` → `Subclase` |
| [Calculadora](HerenciaYPolimorfismo/ejercicios/calculadora) | `CalculadoraBasica` → `CalculadoraIntermedia` (sobrecarga y nuevas operaciones) |
| [Torniquete especial](HerenciaYPolimorfismo/ejercicios/torniquete_especial) | `Torniquete` → `TorniqueteEspecial`, que permite el acceso por nombre |
| [Aviones](HerenciaYPolimorfismo/ejercicios/aviones) | `Avion_Carga` → `Avion_Pasaje_Carga`: carga de cajas alternando lados con balanceo de peso, y abordaje de pasajeros desde el asiento central. [📄 Enunciado](HerenciaYPolimorfismo/ejercicios/aviones/referencia/README.md) |

### Tareas
| Proyecto | Descripción |
|---|---|
| [Herencia en USB](HerenciaYPolimorfismo/tareas/herencia_usb) | `Usb` → `UsbOrdenada` (ordena por extensión y nombre) → `UsbRepetidos` (permite duplicados como `archivo(001).java`). [📄 Enunciado](HerenciaYPolimorfismo/tareas/herencia_usb/referencia/README.md) |

### Examen
| Examen | Descripción |
|---|---|
| [Segundo parcial](HerenciaYPolimorfismo/examen/segundo_parcial) | `Tienda` → `TiendaEspecial` con venta de paquetes de productos |

---

## ⚠️ Manejo de Excepciones

| Archivo | Descripción |
|---|---|
| [`AplErrores.java`](ManejoDeExcepciones/ejercicios/AplErrores.java) / [`AplErroresV2.java`](ManejoDeExcepciones/ejercicios/AplErroresV2.java) | Captura de errores comunes con `try`/`catch` |
| [`MiExcepcion.java`](ManejoDeExcepciones/ejercicios/MiExcepcion.java) | Excepción personalizada (`extends Exception`) |
| [`Excepciones.java`](ManejoDeExcepciones/ejercicios/Excepciones.java) | Propagación de excepciones entre métodos con `throws` |
| [`AplLanzoExcepcion.java`](ManejoDeExcepciones/ejercicios/AplLanzoExcepcion.java) | Lanzar excepciones propias y validar entradas con `Rutinas.LeerEntero` |
| [`Sleep.java`](ManejoDeExcepciones/ejercicios/Sleep.java) | `Thread.sleep` y `InterruptedException` |

---

## 💾 Flujos y Archivos

Persistencia de datos con distintas organizaciones de archivo.

### Ejercicios de clase
| Tema | Archivos |
|---|---|
| [Flujos de bytes](FlujosYArchivos/ejercicios/flujos) | `AplFAO` — lectura de un archivo carácter por carácter con `FileInputStream` |
| [Archivos secuenciales (texto y CSV)](FlujosYArchivos/ejercicios/archivos_secuenciales) | Crear, leer, contar, calcular frecuencias y actualizar archivos `AMIGOS.TXT` / `AMIGOS.CVS` y `VENTAS.CVS` con `FileWriter` y `BufferedReader` |
| [Archivos directos](FlujosYArchivos/ejercicios/archivos_directos) | `RandomAccessFile`: altas, bajas y cambios de registros, encadenamiento de folios, estación de gasolina y generación de `Ventas2023.dat` |
| [Archivos indexados](FlujosYArchivos/ejercicios/archivos_indexados) | `AutosPlaca` simula un archivo indexado por placa usando dos archivos directos |
| [Serialización de objetos](FlujosYArchivos/ejercicios/serializacion_objetos) | Guardar y recuperar objetos con `ObjectOutputStream` / `ObjectInputStream` (empleados y agenda de contactos) |

### Tareas
| Proyecto | Descripción |
|---|---|
| [Frecuencia de nombres](FlujosYArchivos/tareas/frecuencia_nombres) | Leer un archivo secuencial y generar otro con la frecuencia de cada nombre |
| [Ventas CSV](FlujosYArchivos/tareas/ventas_csv) | Agregar a `ventas.cvs` el importe de cada venta y el porcentaje que representa del total. [📄 Enunciado](FlujosYArchivos/tareas/ventas_csv/referencia/README.md) |
| [Encadenamiento de folios](FlujosYArchivos/tareas/encadenamiento_folios) | Actualizar los campos `priMovto` y `siguiente` para encadenar los movimientos de cada folio en archivos directos. [📄 Enunciado](FlujosYArchivos/tareas/encadenamiento_folios/referencia/README.md) |
| [Ventas 2023](FlujosYArchivos/tareas/ventas_2023) | Implementar `VentasInterface` para consultar unidades vendidas por rango de fechas y productos en `Ventas2023.dat`. [📄 Enunciado](FlujosYArchivos/tareas/ventas_2023/referencia/README.md) |

### Examen
| Examen | Descripción |
|---|---|
| [Tercer parcial](FlujosYArchivos/examen/tercer_parcial) | `Cliente` implementa `InterfaceClientes`: autorizar, bloquear y desbloquear teléfonos usando archivos directos |

---

## 🔁 Recuperaciones

| Examen | Descripción |
|---|---|
| [Segunda oportunidad](Recuperaciones/segunda_oportunidad) | `Caballo` implementa `InterfaceCaballo` (comer, trabajar, pasear) y `CaballoFino` lo especializa con control de paseos y cápsulas |

---

## ▶️ Cómo compilar y ejecutar

Requisitos: **JDK 8 o superior**.

Desde la raíz del repositorio:

```bash
# Compilar un ejercicio (ejemplo: Billetera)
javac -encoding UTF-8 -d out ClasesYObjetos/ejercicios/billetera/*.java

# Ejecutarlo usando el nombre completo del paquete
java -cp out ClasesYObjetos.ejercicios.billetera.AplBilletera
```

Varios programas usan la clase `Rutinas`, así que conviene compilarla junto con ellos:

```bash
javac -encoding UTF-8 -d out Unidad0_Diagnostico/ejercicios/Rutinas.java ManejoDeExcepciones/ejercicios/MiExcepcion.java FlujosYArchivos/ejercicios/archivos_directos/*.java
java -cp out FlujosYArchivos.ejercicios.archivos_directos.CrearArchivoDirecto
```

También se puede abrir la carpeta raíz como proyecto en **Eclipse**, **IntelliJ IDEA** o **VS Code**, marcándola como carpeta de código fuente.

> **Notas**
> - Los programas de archivos crean y leen sus archivos (`.DAT`, `.TXT`, `.CVS`) en el directorio desde donde se ejecutan.
> - Los exámenes conservan las observaciones que el maestro escribió dentro del código al revisarlos, por lo que algunos no compilan tal cual.
> - El ejercicio de la `Plancha` quedó incompleto en clase.

---

## 📚 Bibliografía

- Joyanes Aguilar, L. y Zahonero Martínez, I. *Programación en Java 6: Algoritmos, programación orientada a objetos e interfaz gráfica de usuarios*. McGraw‑Hill.
- Martin, R. C. *Código limpio: Manual de estilo para el desarrollo ágil de software*. Anaya Multimedia.

---

## 👤 Autor

<table>
  <tr>
    <td><b>Alumno</b></td>
    <td>Manuel de Jesús Inzunza Lara</td>
  </tr>
  <tr>
    <td><b>Materia</b></td>
    <td>Programación Orientada a Objetos</td>
  </tr>
  <tr>
    <td><b>Maestro</b></td>
    <td>Dr. Clemente García Gerardo</td>
  </tr>
  <tr>
    <td><b>Semestre</b></td>
    <td>Enero – Junio 2024</td>
  </tr>
</table>
