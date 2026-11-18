# 📊 Proyecto · Archivos de texto secuenciales CSV

> **Flujos y Archivos** — [Ver solución](../ArchivoSecuencialCVSProyecto.java)

## 📝 Enunciado

La dirección de informática acaba de recibir un archivo de texto (`ventas.cvs`) de organización secuencial con formato CSV. El registro lógico es el siguiente:

```
Folio, Precio, Unidades   (", Precio, Unidades" se puede repetir n veces)
```

Ejemplo del contenido:

```csv
1,$282,15,$303,14,$1508,4,$1900,13,$294,18,$1232,8
2,$834,9,$1232,1,$1456,20,$1600,16,$1916,1,$1580,4
3,$275,15,$387,12,$1095,12,$678,5
4,$620,19,$1621,8,$1112,12,$400,15
5,$1513,12,$1859,2
6,$787,11,$685,8,$1039,9,$1676,19,$984,2
7,$1766,13,$739,15,$374,19
8,$275,17,$1503,13,$1981,17,$1313,4,$1662,20,$698,19,$1485,14
9,$1176,17
10,$1819,12
```

Se desea que desarrolle las clases Java necesarias que permitan **agregar dos campos** a los registros del archivo `ventas.cvs`:

1. El **importe total** de esa venta.
2. El **porcentaje** que representa esa venta con respecto al total de las ventas.

---

## 📁 Archivo de datos

[`VENTAS.CVS`](VENTAS.CVS) es el archivo de entrada proporcionado. Cópialo como `ventas.cvs` al directorio desde donde se ejecuta el programa.
