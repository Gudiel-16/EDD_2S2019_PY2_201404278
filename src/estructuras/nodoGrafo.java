
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
    HashMap<String, String> nombreCarpetasHijos;
    HashMap<String, String> rutasCarpetasHijos;    
    Node arbolDeArchivos;
    String nomCarpetaPadre;
    String rutaDondeSeEncontraraCarpeta;
    String nombreCarpetaAIngresar;
    
    public nodoGrafo(String carppadre, String rut,String nomcarp) 
    {
        this.nomCarpetaPadre=carppadre;
        this.nombreCarpetasHijos=new HashMap<>();
        this.rutasCarpetasHijos=new HashMap<>();
        this.arbolDeArchivos=null;
        this.rutaDondeSeEncontraraCarpeta=rut;
        this.nombreCarpetaAIngresar=nomcarp;
    }
        
}
