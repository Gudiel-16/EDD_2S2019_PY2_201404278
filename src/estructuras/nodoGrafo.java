
package estructuras;

import estructuras.arbol_AVL.Node;
import java.util.*;

/**
 *
 * @author GUDIEL
 */
public class nodoGrafo 
{
    nodoGrafo siguiente;    
    //HashMap<String, String> rutasCarpetasHijos;    
    Node arbolDeArchivos;
    String rutaDondeSeEncontraraCarpeta;
    
    public nodoGrafo(String rut) 
    {
        //this.rutasCarpetasHijos=new HashMap<>();
        this.arbolDeArchivos=null;
        this.rutaDondeSeEncontraraCarpeta=rut;
    }
        
}
