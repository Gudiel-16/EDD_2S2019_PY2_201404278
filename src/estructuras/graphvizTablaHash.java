
package estructuras;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author GUDIEL
 */
public class graphvizTablaHash 
{
    private String grafo;
    private static int contadorHash=0;
    public static ArrayList<String> listTablaHash=new ArrayList<String>();
    
    public void reporteTablaHash(javax.swing.JTable tabla)
    {
        for (int i = 0; i < tabla.getRowCount(); i++) 
        {
            grafo+="<tr><td>"+tabla.getValueAt(i, 0)+"</td><td>"+tabla.getValueAt(i, 1)+"</td><td>"+tabla.getValueAt(i, 2)+"</td><td>"+tabla.getValueAt(i, 3)+"</td></tr>\n";
        }       
    }
    
    public void generarGrafica(javax.swing.JTable tabla)
    { 
        contadorHash++;
        grafo="";
        
        String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";        
        String direccionSalida = PathActual()+"\\"+"TABLAHASH"+contadorHash +".jpg";
        String direccionEntrada = PathActual()+"\\"+"TABLAHASH"+contadorHash+".txt";
        
        listTablaHash.clear();
        listTablaHash.add(direccionSalida);
        
        reporteTablaHash(tabla);
        
        String cadena = "digraph G\n" +
                        "{\n" +
                            "tbl [\n" +
                                "shape=plaintext\n"+
                                "label=<\n"+
                                    "<table color='orange' cellspacing='0'>\n"+
                                        "<tr><td>INDICE</td><td>NOMBRE</td><td>PASSWORD</td><td>TIMESTAMP</td></tr>\n"+
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
