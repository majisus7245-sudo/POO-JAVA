package FlujosYArchivos.ejercicios.archivos_secuenciales;

import java.io.*;
//FALTA INFORMACIÓN DE IDENTIFICACIÓN DE LA CLASE
public class ArchivoSecuencialContarAmigos
{
 public static void main(String[] args)
 {
     FileReader fr=null;
     BufferedReader bf=null;
     String linea,nombre,nombre1,nombre2;
     String []nombresGuardados = new String[10];
     int nombrePos=0;

     try
     {
         fr = new FileReader("amigos.TXT");
         bf = new BufferedReader(fr);
         while ( ( linea=bf.readLine())!=null )
         {
             boolean encontrado1 = false;
             boolean encontrado2 = false;
//IMAGINA QUE LUEGO SE LE PONGAN MAS NOMBRES......
             nombre = linea.substring(0,39); // NOMBRE Y APELLIDOS
             nombre1 = nombre.substring(0,nombre.indexOf(" ")); // PRIMER NOMBRE
             nombre = nombre.substring(nombre.indexOf(" ")+1,39);
             nombre2 = nombre.substring(0,nombre.indexOf(" "));// YA NO TIENE BLANCOS
             
             for (int i = 0; i < nombresGuardados.length; i++)// DEBE LLEVAR UN APUNTADOR PARA SABER HASTA DONDE VA LLENO EL ARREGLO.
             {
                 if (nombresGuardados[i] != null) // PUEDE EVITAR ESTO
                 {
                     int contador=0,pos=0;
                     pos=nombresGuardados[i].indexOf("-");
                     contador = Integer.parseInt(nombresGuardados[i].substring(pos+1));
                     nombre = nombresGuardados[i].substring(0,pos);
// si se llama juan juan cómo cuenta????
                    if ((nombre.equals(nombre1)))
                    {

                        nombresGuardados[i] = nombre+"-"+(contador+1);
                        encontrado1 = true;

                    } // aunque no este checando el seguindo nombre
                    if (nombre.equals(nombre2))
                    {
                         nombresGuardados[i] = nombre+"-"+(contador+1);
                         encontrado2 = true;
                    }
                    if (encontrado1 && encontrado2)
                    {
                        break;
                    }

                 }
             }
             if (encontrado1 && encontrado2)
             {
                 continue;
             }

             if (nombrePos >= nombresGuardados.length)
             {
                 String []nombresGuardadosAux;
                 nombresGuardadosAux = new String[nombresGuardados.length+1];
                 for (int i = 0; i < nombresGuardados.length; i++)
                 {
                     nombresGuardadosAux[i] = nombresGuardados[i];
                 }
                 nombresGuardados = nombresGuardadosAux;
             }



             if (!encontrado1)
             {
                 nombresGuardados[nombrePos] = nombre1 + "-" + 1;
                 nombrePos++;
             }
             if (!encontrado2)
             {
                 nombresGuardados[nombrePos] = nombre2 + "-" + 1;
                 nombrePos++;
             }
         }

         fr.close();
         bf.close();

         FileWriter fw;
         fw = new FileWriter("ContarAmigos.TXT");

         for (int i = 0; i < nombresGuardados.length; i++)
         {
             fw.write(nombresGuardados[i] + "\n");
         }
         fw.close();
     }

     catch (Exception obj)
     {
         System.out.println(obj.getMessage());
         return;
     }

     finally
     {
         try
         {
             fr.close();
             bf.close();
         }
         catch(Exception obj)
         {
             System.out.println("No se pudo cerrar los archivos");
             return;
         }

     }


 }
}

