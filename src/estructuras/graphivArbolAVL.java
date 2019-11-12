
package estructuras;

import estructuras.arbol_AVL.Node;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


/**
 *
 * @author GUDIEL
 */
public class graphivArbolAVL {
    
    private String grafo;
    private static int contadorArbol=0;
    public static ArrayList<String> listArbol=new ArrayList<String>();
    
    void reporteArbol(Node raiz)
    {
        if (raiz==null) 
        {
            return;
        }else
        {
            if (raiz.left!=null) 
            {
                int altura=obtenerAltura(raiz);
                int alturaHI=obtenerAltura(raiz.left);
                int facte=obteneFE(raiz);
                int facteHI=obteneFE(raiz.left);
                grafo += "\"Nombre: " + raiz.value + " \nContenido: " + raiz.contenido + " \nFE: " + facte + "\nAltura: " + altura + "\nTimestamp: " + raiz.fecha + "\nUsuario: " + raiz.usuario + "\" -> \"Nombre: " + raiz.left.value + " \nContenido: " + raiz.left.contenido + " \nFE: " + facteHI + "\nAltura: " + alturaHI + "\nTimestamp: " + raiz.left.fecha + "\nUsuario: " + raiz.left.usuario + "\"\n";
            }else
            {
                int altura=obtenerAltura(raiz);
                int facte=obteneFE(raiz);
                grafo += "\"Nombre: " + raiz.value + " \nContenido: " + raiz.contenido + " \nFE: " + facte + "\nAltura: " + altura + "\nTimestamp: " + raiz.fecha + "\nUsuario: " + raiz.usuario + "\" -> \"Nombre: " + raiz.value + " NULL IZQ \"\n";
            }
            if (raiz.right!=null) 
            {
                int altura=obtenerAltura(raiz);
                int alturaHD=obtenerAltura(raiz.right);
                int facte=obteneFE(raiz);
                int facteHD=obteneFE(raiz.right);
                grafo += "\"Nombre: " + raiz.value + " \nContenido: " + raiz.contenido + " \nFE: " + facte + "\nAltura: " + altura + "\nTimestamp: " + raiz.fecha + "\nUsuario: " + raiz.usuario + "\" -> \"Nombre: " + raiz.right.value + " \nContenido: " + raiz.right.contenido + " \nFE: " + facteHD + "\nAltura: " + alturaHD + "\nTimestamp: " + raiz.right.fecha + "\nUsuario: " + raiz.right.usuario + "\"\n";
            }else
            {
                int altura=obtenerAltura(raiz);
                int facte=obteneFE(raiz);
                grafo += "\"Nombre: " + raiz.value + " \nContenido: " + raiz.contenido + " \nFE: " + facte + "\nAltura: " + altura + "\nTimestamp: " + raiz.fecha + "\nUsuario: " + raiz.usuario + "\" -> \"Nombre: " + raiz.value + " NULL DER \"\n";
            }
        }
        
        reporteArbol(raiz.right);
        reporteArbol(raiz.left);        
    }
    
    public void generarGrafica(Node raiz)
    { 
        contadorArbol++;
        grafo="";
        
        String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";        
        String direccionSalida = PathActual()+"\\"+"AVL"+contadorArbol +".jpg";
        String direccionEntrada = PathActual()+"\\"+"AVL"+contadorArbol+".txt";
        
        listArbol.clear();
        listArbol.add(direccionSalida);
        
        reporteArbol(raiz);
        
        String cadena = "digraph G\n" +
                        "{\n" +
                        grafo+                
                        "}";
        
        try (  PrintWriter writer = new PrintWriter(direccionEntrada)) {
            writer.print(cadena);            
        } catch (Exception e) {
        }               
        
        String tParam = "-Tpng";
        String tOParam = "-o";
        

        String[] cmd = new String[5];
        cmd[0] = dotPath;
        cmd[1] = tParam;
        cmd[2] = direccionEntrada;
        cmd[3] = tOParam;
        cmd[4] = direccionSalida;

        Runtime rt = Runtime.getRuntime();
              
        try {
            rt.exec( cmd );
        } catch (Exception e) {
        }
              
    }
    
    public int obtenerAltura(Node raiz)
    {
        int mayor=0,temp;
        if (raiz==null) 
        {
            return 0;
        }
        else
        {
            temp=obtenerAltura(raiz.left);
            if (temp>mayor) 
            {
                mayor=temp;
            }
            temp=obtenerAltura(raiz.right);
            if (temp>mayor) 
            {
                mayor=temp;                
            }
            return mayor+1;
        }
    }
    
    public int obteneFE(Node raiz)
    {
        if (raiz.left==null && raiz.right==null) 
        {
            return 0;
        }else if(raiz.left==null && raiz.right!=null)
        {
            return 1;
        }else if(raiz.left!=null && raiz.right==null)
        {
            return -1;
        }else
        {
            int alti=obtenerAltura(raiz.left);
            int altd=obtenerAltura(raiz.right);
            int op=altd-alti;
            return op;
        }
    }
    
    public String PathActual(){
        String path="";
         File miDir = new File (".");
         try {
           //System.out.println (miDir.getCanonicalPath());
           path=miDir.getCanonicalPath();
         }
         catch(Exception e) {
           e.printStackTrace();
           }
         return path;
    }  
}
