
package estructuras;

/**
 *
 * @author GUDIEL
 */
public class bitacora 
{
    nodoBitacora primero;
    int size;
    
    public bitacora()
    {
        this.primero=null;
        this.size=0;
    }
    
    public boolean getIsVacio()
    {
        return this.primero==null;
    }
    
    public void insertar(String d, String t, String u)
    {
        nodoBitacora nuevo=new nodoBitacora(d, t, u);
        if (getIsVacio()) 
        {
            this.primero=nuevo;
        }
        else{
            nuevo.siguiente=nuevo;
            this.primero=nuevo;
        }
        this.size=this.size+1;        
    }
    
    public String reporte()
    {
        nodoBitacora temp=this.primero;
        String cadena="node0[label= \"{";
        String cadenaNodo="";
        for (int i = 0; i < this.size; i++) 
        {
            cadenaNodo="|"+temp.descripcion+"\n"+temp.timeStamp+"\n"+temp.usuario;
            cadena+=cadenaNodo;
            temp=temp.siguiente;
        }
        cadena+="}\"];";
        
        return cadena;        
    }
    
    
    
    
}
