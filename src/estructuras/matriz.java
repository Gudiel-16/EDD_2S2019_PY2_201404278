
package estructuras;

/**
 *
 * @author GUDIEL
 */
public class matriz 
{
    nodoMatriz root;
    
    public matriz()
    {
        this.root=new nodoMatriz("-1", "-1", "-1");
    }
    
    public nodoMatriz getRoot()
    {
        return this.root;
    }
    
    public nodoMatriz buscar_fila(String fila)
    {
        nodoMatriz temp=this.root;
        while (temp!=null) 
        {            
            if (temp.fila.equals(fila)) 
            {
                return temp;
            }
            temp=temp.abajo;
        }     
        return null;
    }
    
    public nodoMatriz buscar_columna(String columna)
    {
        nodoMatriz temp=this.root;
        while (temp!=null) 
        {            
            if (temp.columna.equals(columna)) 
            {
                return temp;
            }
            temp=temp.siguiente;
        }     
        return null;
    }
    
    public nodoMatriz insertar_columna(nodoMatriz nuevo, nodoMatriz cabCol)
    {
        nodoMatriz temp=cabCol;
        boolean bandera=false;
        
        while (true) 
        {
            if (temp.columna.equals(nuevo.columna)) //si son iguales, se sobreescribe
            {
                temp.fila=nuevo.fila;
                temp.valor=nuevo.valor;
                return temp;                
            }
            else if(temp.columna.compareTo(nuevo.columna)>0)
            {
                bandera=true;
                break;
            }
            if (temp.siguiente!=null) 
            {
                temp=temp.siguiente;
            }
            else
            {
                break;
            }            
        }
        
        if (bandera==true) 
        {
            nuevo.siguiente=temp;
            temp.anterior.siguiente=nuevo;
            nuevo.anterior=temp.anterior;
            temp.anterior=nuevo;
        }
        else
        {
            //insertamos al final
            temp.siguiente=nuevo;
            nuevo.anterior=temp;
        }
//        //insertamos al final
//            temp.siguiente=nuevo;
//            nuevo.anterior=temp;
        
        return nuevo;        
    }
    
    public nodoMatriz insertar_fila(nodoMatriz nuevo, nodoMatriz cabFil)
    {
        nodoMatriz temp=cabFil;
        boolean bandera=false;
        
        while (true) 
        {
            if (temp.fila.equals(nuevo.fila)) //si son iguales, se sobreescribe
            {
                temp.columna=nuevo.columna;
                temp.valor=nuevo.valor;
                return temp;                
            }
            else if(temp.fila.compareTo(nuevo.fila)>0)
            {
                bandera=true;
                break;                        
            }
            if (temp.abajo!=null) 
            {
                temp=temp.abajo;
            }
            else
            {
                break;
            }            
        }
        
        if (bandera==true) 
        {
            nuevo.abajo=temp;
            temp.arriba.abajo=nuevo;
            nuevo.arriba=temp.arriba;
            temp.arriba=nuevo;
        }
        else
        {
            //insertamos al final
            temp.abajo=nuevo;
            nuevo.arriba=temp;
        }
//        //insertamos al final
//            temp.abajo=nuevo;
//            nuevo.arriba=temp;
            
        
        return nuevo;        
    }
    
    public nodoMatriz crear_columna(String colum)
    {
        nodoMatriz cabColum=this.root;
        nodoMatriz columna=insertar_columna(new nodoMatriz(colum, "-1", "COL"), cabColum);
        return columna;
    }
    
    public nodoMatriz crear_fila(String filaa)
    {
        nodoMatriz cabFila=this.root;
        nodoMatriz fila=insertar_fila(new nodoMatriz("-1", filaa, "FIL"), cabFila);
        return fila;
    }
    
    public void insertar(String columna, String fila, String valor)
    {
        nodoMatriz nuevo=new nodoMatriz(columna, fila, valor);
        nodoMatriz nodoColumna=buscar_columna(columna);
        nodoMatriz nodoFila=buscar_fila(fila);
        
        if (nodoColumna==null && nodoFila ==null) 
        {
            nodoColumna=crear_columna(columna);
            nodoFila=crear_fila(fila);
            nuevo=insertar_columna(nuevo, nodoFila);
            nuevo=insertar_fila(nuevo, nodoColumna);
        }
        else if(nodoColumna==null && nodoFila !=null)
        {
            nodoColumna=crear_columna(columna);
            nuevo=insertar_columna(nuevo, nodoFila);
            nuevo=insertar_fila(nuevo, nodoColumna);            
        }
        else if(nodoColumna!=null && nodoFila ==null)
        {
            nodoFila=crear_fila(fila);
            nuevo=insertar_columna(nuevo, nodoFila);
            nuevo = insertar_fila(nuevo, nodoColumna);
        }
        else if(nodoColumna!=null && nodoFila != null)
        {
            nuevo=insertar_columna(nuevo, nodoFila);
            nuevo=insertar_fila(nuevo, nodoColumna);
        }
    }
    
    public int obtenerIndiceMasGrande(nodoMatriz r)
    {
        int y=0;
        
        nodoMatriz aux=r;
        while (aux!=null) 
        {    
            y=aux.y;
            aux=aux.abajo;
        }
        
        return y;
    }
    
    
}
