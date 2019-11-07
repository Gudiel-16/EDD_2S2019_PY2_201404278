
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
    String carpetaPadre;
    ArrayList carpetasHijos;
    Node raiz;
    String ruta;
    
    public nodoGrafo(String cp, String rut) 
    {
        this.carpetaPadre=cp;
        this.carpetasHijos=new ArrayList();
        this.raiz=null;
        this.ruta=rut;
    }
        
}
