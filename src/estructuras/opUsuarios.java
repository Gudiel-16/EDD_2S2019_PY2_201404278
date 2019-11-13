
package estructuras;

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
    graphvizGrafo graphGrafo;
    
    public ArrayList contenidoArbol=new ArrayList<String>();
    
    public opUsuarios() 
    {
        this.primero=null;
        this.ultimo=null;
        this.size=0;
        miTree=new arbol_AVL();
        graphviz=new graphivArbolAVL();
        graphGrafo= new graphvizGrafo();
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
    
    //existe archivo en arbol
    public void existeNodoEnArbol(Node root)
    {
        if (root!=null)         
        {
            existeNodoEnArbol(root.left);
            contenidoArbol.add(root.value);
            existeNodoEnArbol(root.right);
        }  
    }
    
    //existe usuario
    public boolean existeUsuario(String us)
    {
        nodoUsuario temp=this.primero;
        for (int i = 0; i < this.size; i++) 
        {
            if (temp.nombre.equals(us)) //cuando encuentra nombre
            {
                return true;
            }
            temp=temp.siguiente;
        }        
        return false;
    }
    
    //genera el arbol en graphviz de carpeta especifica
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
    
    //generar cadena y graphviz de grafo
    public void generarGrafo(String usuario)
    {
        nodoUsuario temp=this.primero;
        String grafo="";
        
        for (int i = 0; i < this.size; i++) 
        {
            if (temp.nombre.equals(usuario)) //cuando encuentra nombre
            {
                Iterator it = temp.carpetas.keySet().iterator();
                while(it.hasNext()){
                    Object key = it.next();
                    //System.out.println("Clave: " + key + " -> Valor: " + temp.carpetas.get(key));
                    if (temp.carpetas.containsKey(key.toString())) 
                    {
                        ArrayList<carpeta> nue= temp.carpetas.get(key.toString());
                        for (int j = 0; j < nue.size(); j++) 
                        {
                            carpeta aja=nue.get(j);
                            grafo+="\""+key + "\"" + " -> " + "\""+ aja.rutaCarpetaHijo + "\"\n";
                        }
                    }                    
                }
                graphGrafo.generarGrafica(grafo);
            }
            temp=temp.siguiente;
        }        
    }
    
    //modificar carpeta
    public void modificarCarpeta(String usuario, String ruta, String nuevaRuta, String nombreNuevo)
    {
        HashMap<String, ArrayList<carpeta>> hmtemporal = new HashMap<>();
        ArrayList<String> listTemp=new ArrayList<>();
        nodoUsuario temp=this.primero;
        
        for (int i = 0; i < this.size; i++) 
        {
            if (temp.nombre.equals(usuario)) //cuando encuentra nombre
            {     
                //se modifica la ruta cuando esta como hijo
                Iterator it = temp.carpetas.keySet().iterator();
                while(it.hasNext()) //recorro el hash
                {                    
                    Object key = it.next(); //clave actual del hash
                    ArrayList<carpeta> nue= temp.carpetas.get(key);//lista de la clave actual
                    for (int j = 0; j < nue.size(); j++) //recorro lista de clave actual
                    {
                        carpeta aja=nue.get(j);//obtengo valor actual de la lista
                        if (aja.rutaCarpetaHijo.equals(ruta)) 
                        {
                            modificarCarpetaEnLista(usuario, ruta, nuevaRuta);
                            nue.set(j, new carpeta(nombreNuevo, nuevaRuta)); //modifico el nombre y ruta como hijo
                        }
                    }
                }
                                
                Iterator it3 = temp.carpetas.keySet().iterator();
                while(it3.hasNext()) //recorro el hash
                {                    
                    Object key = it3.next(); //clave actual del hash
                    
                    if (key.toString().length()>=ruta.length()) //para que no entre hasta que las rutas sean iguales o mayor
                    {
                        int a=key.toString().substring(0,ruta.length()).length();//obtengo el tamanio de lo que voy a modificar
                        String b=key.toString().substring(0,a);//obtengo la porcion te texto a modificar
                        
                        if (b.equals(ruta)) //si es la ruta que tengo que modificar
                        {
                            int aa=key.toString().substring(0,ruta.length()).length();//obtengo el tamanio de lo que voy a modificar
                            String bb=key.toString().substring(0,aa);//obtengo la porcion te texto a modificar
                            String nuevaKey=key.toString().replaceFirst(bb, nuevaRuta);//reemplazo la ruta vieja por la nueva
                            
                            ArrayList<carpeta> nue= temp.carpetas.get(key.toString());//obtengo la lista a modificar
                            ArrayList<carpeta> aux=new ArrayList<>();
                            
                            for (int j = 0; j < nue.size(); j++) //recorro lista de clave actual
                            {
                                carpeta aja=nue.get(j);//obtengo valor actual de la lista

                                int aaa=aja.rutaCarpetaHijo.substring(0,ruta.length()).length();//obtengo el tamanio de lo que voy a modificar
                                String bbb=aja.rutaCarpetaHijo.substring(0,aaa);//obtengo la porcion te texto a modificar
                                String ccc=aja.rutaCarpetaHijo.replaceFirst(bbb, nuevaRuta);//reemplazo la ruta vieja por la nueva
                                modificarCarpetaEnLista(usuario, aja.rutaCarpetaHijo, ccc); //modificamos en la lista grafo la ruta
                                listTemp.add(aja.rutaCarpetaHijo);//agregamos para saber que key hay que eliminar
                                nue.set(j, new carpeta(aja.nombreOriginalCarpeta,ccc)); //modificamos la ruta actual
                                aux.add(new carpeta(aja.nombreOriginalCarpeta,ccc)); //agregamos, para eliminar keys y luego agregar los nuevos
                                
                            }
                            hmtemporal.put(nuevaKey, aux);                            
                        }
                    }                    
                }  
                
                //recorremos list para eliminar keys
                for (int j = 0; j < listTemp.size(); j++) 
                {
                    String act=listTemp.get(j);
                    System.out.println(act);
                    if (temp.carpetas.containsKey(act)) 
                    {
                        temp.carpetas.remove(act);
                    }
                }
                
                //recorremos hash para agregar nuevas keys
                Iterator it2 = hmtemporal.keySet().iterator();
                while(it2.hasNext()) //recorro el hash
                {                    
                    Object key = it2.next(); //clave actual del hash
                    ArrayList<carpeta> nue= hmtemporal.get(key.toString());//lista de la clave actual
                    temp.carpetas.put(key.toString(), nue);
                }
                
                temp.carpetas.remove(ruta);
                
            }
            temp=temp.siguiente;
        } 
    }
    
    public void modificarCarpetaEnLista(String usuario, String rutaVieja, String rutaNueva)
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
                        if (aux.rutaDondeSeEncontraraCarpeta.equals(rutaVieja)) //cuando encuentre la ruta de carpeta
                        {                               
                            aux.rutaDondeSeEncontraraCarpeta=rutaNueva;//cambiamos ruta
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
