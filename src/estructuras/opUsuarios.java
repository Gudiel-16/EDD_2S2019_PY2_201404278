
package estructuras;

import com.sun.javafx.collections.MappingChange.Map;
import estructuras.arbol_AVL.Node;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GUDIEL
 */

public class opUsuarios 
{
    nodoUsuario primero;
    nodoUsuario ultimo;    
    int size;
    
    arbol_AVL miTree;
    graphivArbolAVL graphviz;

    public opUsuarios() 
    {
        this.primero=null;
        this.ultimo=null;
        this.size=0;
        miTree=new arbol_AVL();
        graphviz=new graphivArbolAVL();
    }
    
    public boolean estaVacia()
    {
        return this.primero==null;
    }
    
    //inserta el usuario
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
    
    //ingresa carpetas a usuario especifico
    public void insertarCarpetaParaUsuario(String nomUs, String carPadre, String ruta, String nomCarp)
    {
        nodoUsuario temp=this.primero;
        for (int i = 0; i < this.size; i++) 
        {
            if (temp.nombre.equals(nomUs)) //cuando encuentra nombre
            {
                nodoGrafo nuevo=new nodoGrafo(carPadre, ruta, nomCarp);
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
    
    //inserta carpeta como hijo
    public void insertarCarpetaComoHijo(String nomUs, String CarPadre, String rutaCarpetaACrear, String nombreCarpeta)
    {
        nodoUsuario temp=this.primero;
        for (int i = 0; i < this.size; i++) 
        {
            if (temp.nombre.equals(nomUs)) //cuando encuentra nombre
            {
                nodoGrafo aux=temp.primeroG;
                if (aux!=null) 
                {
                    while (aux!=null) //recorre el grafo
                    {                        
                        if (aux.nomCarpetaPadre.equals(CarPadre)) //cuando encuentre carpeta padre, agrega como hijo
                        {
                            aux.rutasCarpetasHijos.put(nombreCarpeta, rutaCarpetaACrear);
                        }
                        aux=aux.siguiente;
                    }
                }                
            }
            temp=temp.siguiente;
        }
    }
    
    //ingresara archivo al AVL
    public void insertarArchivoACarpeta(String rutaCarpetaAInsertar, String nombreArchivo, String Contenido, String fecha, String usuario)
    {
        nodoUsuario temp=this.primero;
        for (int i = 0; i < this.size; i++) 
        {
            if (temp.nombre.equals(usuario)) //cuando encuentra nombre
            {
                nodoGrafo aux=temp.primeroG;
                if (aux!=null) 
                {
                    while (aux!=null) //recorre el grafo
                    {                        
                        if (aux.rutaDondeSeEncontraraCarpeta.equals(rutaCarpetaAInsertar)) //cuando encuentre la ruta de carpeta
                        {                               
                            Node root=aux.arbolDeArchivos;
                            root=miTree.insertar(root, nombreArchivo, Contenido, fecha, usuario,aux.nomCarpetaPadre);
                            aux.arbolDeArchivos=root;
                            //graphviz.generarGrafica(aux.arbolDeArchivos);
                        }
                        aux=aux.siguiente;
                    }
                }                
            }
            temp=temp.siguiente;
        }
    
    }
    
    public void mostrarCarpetasYArchivos(javax.swing.JTable tabla, String usuario, String rutaCarpeta)
    {
        DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
        nodoUsuario temp=this.primero;
        for (int i = 0; i < this.size; i++) 
        {
            if (temp.nombre.equals(usuario)) //cuando encuentra nombre
            {
                nodoGrafo aux=temp.primeroG;
                if (aux!=null) 
                {
                    while (aux!=null) //recorre el grafo
                    {                        
                        if (aux.rutaDondeSeEncontraraCarpeta.equals(rutaCarpeta)) //cuando encuentre la ruta de carpeta
                        {                               
                            Iterator<String> productos = aux.rutasCarpetasHijos.keySet().iterator();
                            while(productos.hasNext())
                            {
                                String clave = productos.next();
                                String valor=aux.rutasCarpetasHijos.get(clave);
                                Object [] fila=new Object[4]; 
                                fila[0]=clave; //nombre de carpeta  
                                fila[1]="";  //contenido
                                fila[2]=valor; //ruta 
                                fila[3]="carpeta";//tipo
                                modelo.addRow(fila);
                            }  
                            insertarArchivosDesdeArbol(modelo,aux.arbolDeArchivos);
                        }
                        aux=aux.siguiente;
                    }
                }                
            }
            temp=temp.siguiente;
        }
        tabla.setModel(modelo);
    }
    
    public void insertarArchivosDesdeArbol(DefaultTableModel modelo, Node root)
    {
        if (root!=null)         
        {
            insertarArchivosDesdeArbol(modelo, root.left);
            Object [] fila=new Object[4]; 
            fila[0]=root.value; //nombre de carpeta  
            fila[1]=root.contenido;  //contenido
            fila[2]=root.ruta; //ruta 
            fila[3]="archivo";//tipo
            modelo.addRow(fila);
            insertarArchivosDesdeArbol(modelo,root.right);
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
                                System.out.println("       CarpetaPadre: "+auxJ.nomCarpetaPadre+ " Hijos: " + auxJ.rutasCarpetasHijos.size() +" Ruta: "+auxJ.rutaDondeSeEncontraraCarpeta + " nombreCarpeta:" + auxJ.nombreCarpetaAIngresar);
                         auxJ=auxJ.siguiente;    
                        }
                    }
                    
             aux=aux.siguiente;   
            }
        }
    }
    
    
}
