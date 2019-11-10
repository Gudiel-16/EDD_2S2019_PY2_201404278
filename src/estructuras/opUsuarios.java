
package estructuras;

import com.sun.javafx.collections.MappingChange.Map;
import estructuras.arbol_AVL.Node;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import java.util.*;

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
    
    public ArrayList contenidoArbol=new ArrayList<String>();

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
    public void insertarCarpetaParaUsuario(String nomUs, String ruta)
    {
        nodoUsuario temp=this.primero;
        for (int i = 0; i < this.size; i++) 
        {
            if (temp.nombre.equals(nomUs)) //cuando encuentra nombre
            {
                nodoGrafo nuevo=new nodoGrafo(ruta);
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
    
    public void insertarCarpetaHijo(String nomUs, String carpetaPadre, carpeta carpetaInsertar)
    {
        nodoUsuario temp=this.primero;
        for (int i = 0; i < this.size; i++) 
        {
            if (temp.nombre.equals(nomUs)) //cuando encuentra nombre
            {
                if (temp.carpetas.containsKey(carpetaPadre)) 
                {
                    temp.carpetas.get(carpetaPadre).add(carpetaInsertar);
                    //System.out.println("Carpeta Padre: "  + carpetaPadre + " -> " + temp.carpetas.get(carpetaPadre));
                }else
                {
                    ArrayList<carpeta> nuevo= new ArrayList<carpeta>();
                    nuevo.add(carpetaInsertar);
                    temp.carpetas.put(carpetaPadre, nuevo);
                    //System.out.println("Carpeta Padre: " + carpetaPadre + " -> " + temp.carpetas.get(carpetaPadre));
                }
                
                break;
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
                            aux.arbolDeArchivos=miTree.insertar(aux.arbolDeArchivos, nombreArchivo, Contenido, fecha, usuario,"");
                            //graphviz.generarGrafica(aux.arbolDeArchivos);
                            break;
                        }
                        aux=aux.siguiente;
                    }
                }                
            }
            temp=temp.siguiente;
        }
    
    }
    
    //ingresa carpetas a la tabla para mostrar
    public void mostrarCarpetasYArchivos(javax.swing.JTable tabla, String usuario, String rutaCarpeta)
    {
        DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
        nodoUsuario temp=this.primero;
        for (int i = 0; i < this.size; i++) 
        {
            if (temp.nombre.equals(usuario)) //cuando encuentra nombre
            {
                //se agregan carpetas
                if (temp.carpetas.containsKey(rutaCarpeta)) 
                {
                    ArrayList<carpeta> aux=temp.carpetas.get(rutaCarpeta);
                    for (int j = 0; j < aux.size(); j++) 
                    {
                        carpeta resultado=(carpeta)aux.get(j);
                        Object [] fila=new Object[4]; 
                        fila[0]=resultado.nombreOriginalCarpeta; //nombre de carpeta  
                        fila[1]="";  //contenido
                        fila[2]=resultado.rutaCarpetaHijo; //ruta 
                        fila[3]="carpeta";//tipo
                        modelo.addRow(fila);
                    }                    
                } 
                //se agregan archivos
                nodoGrafo aux=temp.primeroG;
                if (aux!=null) 
                {
                    while (aux!=null) //recorre el grafo
                    {                        
                        if (aux.rutaDondeSeEncontraraCarpeta.equals(rutaCarpeta)) //cuando encuentre la ruta de carpeta
                        {                               
                            insertarArchivosDesdeArbol(modelo, aux.arbolDeArchivos);
                        }
                        aux=aux.siguiente;
                    }
                }               
            }
            temp=temp.siguiente;
        }        
    }
    
    //inrgesa archivos desde el arbol a la tabla para mostrar
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
    
    //modificar archivo
    public void modificarArchivo(String usuario, String rutaDondeEstaArchivo, String nomArchiElim, String nomArchiNuevo, String contenido, String fecha)
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
                        if (aux.rutaDondeSeEncontraraCarpeta.equals(rutaDondeEstaArchivo)) //cuando encuentre la ruta de carpeta
                        {                               
                            aux.arbolDeArchivos=miTree.deleteNode(aux.arbolDeArchivos, nomArchiElim);
                            aux.arbolDeArchivos=miTree.insertar(aux.arbolDeArchivos, nomArchiNuevo, contenido, fecha, usuario, "");
                            //graphviz.generarGrafica(aux.arbolDeArchivos);
                            break;
                        }
                        aux=aux.siguiente;
                    }
                }                
            }
            temp=temp.siguiente;
        }
    }
    
    //eliminar archivo
    public void eliminarArchivo(String usuario, String rutaDondeEstaArchivo, String nomArchiElim)
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
                        if (aux.rutaDondeSeEncontraraCarpeta.equals(rutaDondeEstaArchivo)) //cuando encuentre la ruta de carpeta
                        {                               
                            aux.arbolDeArchivos=miTree.deleteNode(aux.arbolDeArchivos, nomArchiElim);
                            break;
                        }
                        aux=aux.siguiente;
                    }
                }                
            }
            temp=temp.siguiente;
        }
    }
    
    //validar si existe carpeta
    public boolean existeCarpeta(String usuario, String rut)
    {
        boolean bande=false;
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
                        if (aux.rutaDondeSeEncontraraCarpeta.equals(rut)) //cuando encuentre la ruta de carpeta
                        {                               
                            bande=true;
                        }
                        aux=aux.siguiente;
                    }
                }                
            }
            temp=temp.siguiente;
        }
        
        return bande;
    }
    
    //validar si existe carpeta
    public boolean existeArchivo(String usuario, String rut, String nomArchi)
    {
        boolean bande=false;
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
                        if (aux.rutaDondeSeEncontraraCarpeta.equals(rut)) //cuando encuentre la ruta de carpeta
                        {       
                            contenidoArbol.clear();
                            existeNodoEnArbol(aux.arbolDeArchivos);
                            if (contenidoArbol.contains(nomArchi)){
                                return true;                                
                            }
                        }
                        aux=aux.siguiente;
                    }
                }                
            }
            temp=temp.siguiente;
        }
        
        return bande;
    }
    
    public void existeNodoEnArbol(Node root)
    {
        if (root!=null)         
        {
            existeNodoEnArbol(root.left);
            contenidoArbol.add(root.value);
            existeNodoEnArbol(root.right);
        }  
    }
    
    public void generarArbolDeCarpeta(String usuario, String ruta)
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
                        if (aux.rutaDondeSeEncontraraCarpeta.equals(ruta)) //cuando encuentre la ruta de carpeta
                        {                               
                            graphviz.generarGrafica(aux.arbolDeArchivos);
                        }
                        aux=aux.siguiente;
                    }
                }                
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
                                System.out.println(" Ruta: "+auxJ.rutaDondeSeEncontraraCarpeta);
                         auxJ=auxJ.siguiente;    
                        }
                    }
                    
             aux=aux.siguiente;   
            }
        }
    }
    
    
}
