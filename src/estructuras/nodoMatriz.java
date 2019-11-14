
package estructuras;

/**
 *
 * @author GUDIEL
 */
public class nodoMatriz 
{
    nodoMatriz siguiente, anterior, arriba, abajo;
    String valor;
    String columna;
    String fila;
    int x,y;
    
    public nodoMatriz(String columna, String fila, String valor)
    {
        this.siguiente=null;
        this.anterior=null;
        this.arriba=null;
        this.abajo=null;
        this.valor=valor;
        this.columna=columna;
        this.fila=fila;
        this.x=0;
        this.y=0;
    }
}
