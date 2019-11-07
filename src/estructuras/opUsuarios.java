
package estructuras;

/**
 *
 * @author GUDIEL
 */
public class opUsuarios 
{
    nodoUsuario primero;
    nodoUsuario ultimo;
    
    int size;

    public opUsuarios() 
    {
        this.primero=null;
        this.ultimo=null;
        this.size=0;
    }
    
    public boolean estaVacia()
    {
        return this.primero==null;
    }
    
    public void insertar(String nomUs)
    {
        nodoUsuario nuevo=new nodoUsuario(nomUs);
        
        if (estaVacia()) 
        {
            this.primero=nuevo;
            this.ultimo=nuevo;
            this.size=this.size+1;
        }
        else
        {
           this.ultimo.siguiente=nuevo;
           this.ultimo=nuevo;
           this.size=this.size+1;
        }
    }
    
    public void insertarGrafoRaiz(String nomUs, String carPadre, String ruta)
    {
        nodoUsuario temp=this.primero;
        for (int i = 0; i < this.size; i++) 
        {
            if (temp.nombre.equals(nomUs)) //cuando encuentra nombre
            {
                nodoGrafo nuevo=new nodoGrafo(carPadre, ruta);
                if (temp.primeroG==null) 
                {
                    nuevo.siguiente=null;
                    temp.primeroG=nuevo;
                    temp.ultimoG=nuevo;
                }else
                {
                    nuevo.siguiente=null;
                    temp.ultimoG.siguiente=nuevo;
                    temp.ultimoG=nuevo;
                }
                break;
            }
            temp=temp.siguiente;
        }
    }
    
    public void imprimir()
    {
        nodoUsuario aux=this.primero;
        if(aux!=null){
            while(aux!=null){
                System.out.println("Usuario--> : "+aux.nombre);
                
                    nodoGrafo auxJ=aux.primeroG;
                    if(auxJ!=null){
                        while(auxJ!=null){
                                System.out.println("       CarpetaPadre: "+auxJ.carpetaPadre+" Ruta: "+auxJ.ruta);
                         auxJ=auxJ.siguiente;    
                        }
                    }
                    
             aux=aux.siguiente;   
            }
        }
    }
    
    
}
