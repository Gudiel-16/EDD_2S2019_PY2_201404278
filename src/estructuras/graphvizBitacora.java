
package estructuras;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author GUDIEL
 */
public class graphvizBitacora 
{
    private String grafo;
    private static int contadorBitacora=0;
    public static ArrayList<String> listBitacora=new ArrayList<String>();
    
    public void reporteTablaHash(String graph)
    {
        grafo+=graph;     
    }
    
    public void generarGrafica(String graph)
    { 
        contadorBitacora++;
        grafo="";
        
        String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";        
        String direccionSalida = PathActual()+"\\"+"BITACORA"+contadorBitacora +".jpg";
        String direccionEntrada = PathActual()+"\\"+"BITACORA"+contadorBitacora+".txt";
        
        listBitacora.clear();
        listBitacora.add(direccionSalida);
        
        reporteTablaHash(graph);
        
        String cadena = "digraph G\n" +
                        "{\n" +
                            "tbl [\n" +
                                "shape=plaintext\n"+
                                "label=<\n"+
                                    "<table color='orange' cellspacing='0'>\n"+
                                        "<tr><td>USUARIO</td><td>DESCRIPCION</td><td>TIMESTAMP</td></tr>\n"+
                                        grafo+
                                    "</table>\n"+
                            ">];\n"+
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
