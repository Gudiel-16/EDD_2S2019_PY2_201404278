
package estructuras;

/**
 *
 * @author GUDIEL
 */
public class nodoBitacora 
{
    nodoBitacora siguiente;
    String descripcion;
    String timeStamp;
    String usuario;
    
    public nodoBitacora(String d, String t, String u)
    {
        this.descripcion=d;
        this.timeStamp=t;
        this.usuario=u;
        this.siguiente=null;
    }
    
}
