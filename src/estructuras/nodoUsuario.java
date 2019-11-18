
package estructuras;
import java.util.*;

/**
 *
 * @author GUDIEL
 */
public class nodoUsuario 
{    
    nodoUsuario siguiente;
    nodoGrafo primeroG;
    nodoGrafo ultimoG;    
    String nombre;
    String password;
    String hash;
    HashMap<String, ArrayList<carpeta>> carpetas; //(carpetaPadre , lista de carpetas que contiene una carpeta especifica )
    
    public nodoUsuario(String n, String p, String h) 
    {
        this.carpetas=new HashMap<>();
        this.siguiente=null;
        this.primeroG=null;
        this.ultimoG=null;
        this.nombre=n;  
        this.password=p;
        this.hash=h;
    }    
}
