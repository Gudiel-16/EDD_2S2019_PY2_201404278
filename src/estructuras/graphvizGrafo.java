
package estructuras;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author GUDIEL
 */
public class graphvizGrafo 
{
    private String grafo;
    private static int contadorGrafo=0;
    public static ArrayList<String> listGrafo=new ArrayList<String>();
    
    public void reporteTablaHash(String graph)
    {
        grafo+=graph;     
    }
    
    public void generarGrafica(String graph)
    { 
        contadorGrafo++;
        grafo="";
        
        String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";        
        String direccionSalida = PathActual()+"\\"+"GRAFO"+contadorGrafo +".jpg";
        String direccionEntrada = PathActual()+"\\"+"GRAFO"+contadorGrafo+".txt";
        
        listGrafo.clear();
        listGrafo.add(direccionSalida);
        
        reporteTablaHash(graph);
        
        String cadena = "digraph G {\n" +
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
