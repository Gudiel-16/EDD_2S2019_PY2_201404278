
package estructuras;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author GUDIEL
 */
public class graphvizMatriz 
{
    private String grafo;
    private static int contadorMatriz=0;
    public static ArrayList<String> listMatriz=new ArrayList<String>();
    
    public void reporteTablaHash(String graph)
    {
        grafo+=graph;     
    }
    
    public void generarGrafica(String graph)
    { 
        contadorMatriz++;
        grafo="";
        
        String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";        
        String direccionSalida = PathActual()+"\\"+"MATRIZ"+contadorMatriz +".jpg";
        String direccionEntrada = PathActual()+"\\"+"MATRIZ"+contadorMatriz+".txt";
        
        listMatriz.clear();
        listMatriz.add(direccionSalida);
        
        reporteTablaHash(graph);
        
        String cadena = "digraph G {\n" +
                        "node[shape=record];\n"+
                            grafo+
                        "}";
        
        try (  PrintWriter writer = new PrintWriter(direccionEntrada)) {
            writer.print(cadena);            
        } catch (Exception e) {
        }
        
        try {
            ProcessBuilder pbuilder;		    
            /*
             * Realiza la construccion del comando    
             * en la linea de comandos esto es: 
             * dot -Tpng -o archivo.png archivo.dot
             */
            pbuilder = new ProcessBuilder( "neato", "-Tpng", "-o", direccionSalida, direccionEntrada );
            pbuilder.redirectErrorStream( true );
            //Ejecuta el proceso
            pbuilder.start();
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
