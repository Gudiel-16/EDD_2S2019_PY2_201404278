
package estructuras;
import java.util.*;

/**
 *
 * @author GUDIEL
 */
public class nodoUsuario 
{
    HashMap<String, ArrayList<carpeta>> carpetas; //(carpetaPadre , lista de carpetas que contiene una carpeta especifica )
    nodoUsuario siguiente;
    nodoGrafo primeroG;
    nodoGrafo ultimoG;    
    String nombre;
    
    
    public nodoUsuario(String n) 
    {
        this.carpetas=new HashMap<>();
        this.siguiente=null;
        this.primeroG=null;
        this.ultimoG=null;
        this.nombre=n;        
    }
    
}
