
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
                grafo += "\"" + raiz.value + " FE:" + raiz.contenido + "\" -> \"" + raiz.left.value + " FE:" + raiz.left.contenido + "\"\n";
            }else
            {
                grafo += "\"" + raiz.value + " FE:" + raiz.contenido + "\" -> \"" + raiz.value + " FE:" + raiz.contenido + " NULL IZQ \"\n";
            }
            if (raiz.right!=null) 
            {
                grafo += "\"" + raiz.value + " FE:" + raiz.contenido + "\" -> \"" + raiz.right.value + " FE:" + raiz.right.contenido + "\"\n";
            }else
            {
                grafo += "\"" + raiz.value + " FE:" + raiz.contenido + "\" -> \"" + raiz.value + " FE:" + raiz.contenido + " NULL DER \"\n";
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
                        //"rankdir=LR;"+
                        grafo+                
                        "}";
        //cadena = cadena.replace("\"\"","\"");
        //cadena = cadena.replace("\\","\\\\");
        
        /*---------------------------------------------------------------------------------*/
        try (  PrintWriter writer = new PrintWriter(direccionEntrada)) {
            writer.print(cadena);            
        } catch (Exception e) {
        }
        /*---------------------------------------------------------------------------------*/
        
        
        
        String tParam = "-Tpng";
        String tOParam = "-o";
        
        //dot -Tpng ast.txt -o ast.jpg

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
