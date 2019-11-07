
package estructuras;

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
    
    public nodoUsuario(String n) 
    {
        this.siguiente=null;
        this.primeroG=null;
        this.ultimoG=null;
        this.nombre=n;        
    }
    
}
