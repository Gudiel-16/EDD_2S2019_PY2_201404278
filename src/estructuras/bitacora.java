
package estructuras;

/**
 *
 * @author GUDIEL
 */
public class bitacora 
{
    nodoBitacora primero;
    graphvizBitacora graphB;
    
    int size;
    
    public bitacora()
    {
        graphB=new graphvizBitacora();
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
            nuevo.siguiente=this.primero;
            this.primero=nuevo;
        }
        this.size=this.size+1;        
    }
    
    public void generarBitacora()
    {
        String grafo="";
        
        nodoBitacora temp=this.primero;
        for (int i = 0; i < this.size; i++) 
        {
            grafo+="<tr><td>"+temp.usuario+"</td><td>"+temp.descripcion+"</td><td>"+temp.timeStamp+"</td></tr>\n";
            temp=temp.siguiente;
        }
        
        graphB.generarGrafica(grafo);        
    }
       
    
    
    
}
