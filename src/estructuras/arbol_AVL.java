
package estructuras;

/**
 *
 * @author GUDIEL
 */
public class arbol_AVL 
{
    public class Node 
    {
        public Node left, right, parent;
        public int height = 1;
        public String value;
        public String contenido;
        public String fecha;
        public String usuario;
        public String ruta;

        public Node (String val, String cont, String fech, String us, String ruta) 
        {
            this.value = val;
            this.contenido=cont;
            this.fecha=fech;
            this.usuario=us;
            this.ruta=ruta;
        }
    }
    
    private int height (Node N) 
    {
        if (N == null)
            return 0;
        return N.height;
    }
    
    public Node insertar(Node node, String value, String cont, String fech, String us, String ruta) {
        
        if (node == null) 
        {
            return(new Node(value,cont,fech,us,ruta));
        }

        if (value.compareTo(node.value) < 0)
        {
            node.left  = insertar(node.left, value,cont,fech,us,ruta);
        }
        else
        {
            node.right = insertar(node.right, value,cont,fech,us,ruta);
        }

        // Actualizar altura de este nodo 
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        //  obtener el factor de equilibrio de este nodo anterior para verificar si este nodo se desequilibró 
        int balance = getBalance(node);

        // Si este nodo se desequilibra, entonces hay 4 casos

        // Caso izquierdo izquierdo
        if (balance > 1 && value.compareTo(node.left.value) < 0)
            return rightRotate(node);

        // Caso derecho derecho
        if (balance < -1 && value.compareTo(node.right.value) > 0)
        {
            return leftRotate(node);
        }

        // Caso izquierdo derecho
        if (balance > 1 && value.compareTo(node.left.value) > 0)
        {
            node.left =  leftRotate(node.left);
            return rightRotate(node);
        }

        // Caso derecho izquierdo
        if (balance < -1 && value.compareTo(node.right.value) < 0)
        {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        /* devolver el puntero de nodo (sin cambios) */
        return node;
    }
    
    public Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // realizar rotacion
        x.right = y;
        y.left = T2;

        // acutaliar alturas
        y.height = Math.max(height(y.left), height(y.right))+1;
        x.height = Math.max(height(x.left), height(x.right))+1;

        // retornar nueva raiz
        return x;
    }

    public Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // realizar rotacion
        y.left = x;
        x.right = T2;

        //  actualiazar alturas
        x.height = Math.max(height(x.left), height(x.right))+1;
        y.height = Math.max(height(y.left), height(y.right))+1;

        // retornar nueva raiz
        return y;
    }

    // obtener el factor de equilibrio del nodo N
    public int getBalance(Node N) {
        if (N == null)
        {
            return 0;
        }
        return height(N.left) - height(N.right);
    }

    public void preOrder(Node root) {
        if (root != null) 
        {
            preOrder(root.left);
            System.out.printf("id "+ root.value);
            preOrder(root.right);
        }
    }

    public Node minValueNode(Node node) {
        Node current = node;
        // bucle hacia abajo para encontrar la hoja más a la izquierda
        while (current.left != null)
        {
            current = current.left;
        }
        return current;
    }

    public Node deleteNode(Node root, String value) {

        if (root == null)
            return root;

        // Si el valor a eliminar es menor que el valor de la raíz, luego se encuentra en el subárbol izquierdo/**/
        if ( value.compareTo(root.value) < 0 )
        {
            root.left = deleteNode(root.left, value);
        }
        // Si el valor a eliminar es mayor que el valor de la raíz, entonces se encuentra en el subárbol derecho
        else if( value.compareTo(root.value) > 0 )
        {
            root.right = deleteNode(root.right, value);
        }
        // si el valor es igual al valor de la raíz, entonces este es el nodo para ser eliminado
        else {
            // nodo con un solo hijo o sin hijo
            if( (root.left == null) || (root.right == null) ) 
            {

                Node temp;
                if (root.left != null)
                        temp = root.left;
                else
                    temp = root.right;

                // ningun caso
                if(temp == null) {
                    temp = root;
                    root = null;
                }
                else 
                    root = temp; // Copiar contenido

                temp = null;
            }
            else 
            {
                // nodo con dos hijos: Obtener el sucesor (el más pequeño en el subárbol derecho)
                Node temp = minValueNode(root.right);

                // Copiar valores
                root.value = temp.value;

                // eliminar sucesor
                root.right = deleteNode(root.right, temp.value);
            }
        }

        // Si el árbol tenía solo un nodo, entonces regresar
        if (root == null)
        {
            return root;
        }

        // ACTUALIZAR LA ALTURA DEL NODO ACTUAL
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        // OBTENGER EL FACTOR DE EQUILIBRIO DE ESTE NODO (para verificar si este nodo se desequilibró)
        int balance = getBalance(root);

        // SI SE DESEQUILIBRA ENONCES HAY CUATRO CASOS:

        // caso izquierda izquierda
        if (balance > 1 && getBalance(root.left) >= 0)
        {
            return rightRotate(root);
        }

        // caso iquierda derecha
        if (balance > 1 && getBalance(root.left) < 0) 
        {
            root.left =  leftRotate(root.left);
            return rightRotate(root);
        }

        // caso derecha derecha
        if (balance < -1 && getBalance(root.right) <= 0)
        {
            return leftRotate(root);
        }

        // caso derecha izquierda
        if (balance < -1 && getBalance(root.right) > 0) 
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }
   
}
