
package estructuras;

import java.util.ArrayList;
import java.util.List;

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
        /* 1.  Realizar la rotación normal */
        if (node == null) {
            return(new Node(value,cont,fech,us,ruta));
        }

        if (value.compareTo(node.value) < 0)
            node.left  = insertar(node.left, value,cont,fech,us,ruta);
        else
            node.right = insertar(node.right, value,cont,fech,us,ruta);

        /* 2. Actualizar altura de este nodo */
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        /* 3. obtener el factor de equilibrio de este nodo anterior para verificar si
            este nodo se desequilibró */
        int balance = getBalance(node);

        // Si este nodo se desequilibra, entonces hay 4 casos

        // Caso izquierdo izquierdo
        if (balance > 1 && value.compareTo(node.left.value) < 0)
            return rightRotate(node);

        // Caso derecho derecho
        if (balance < -1 && value.compareTo(node.right.value) > 0)
            return leftRotate(node);

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
            return 0;
        return height(N.left) - height(N.right);
    }

    public void preOrder(Node root) {
        if (root != null) {
            preOrder(root.left);
            System.out.printf("id "+ root.value);
            preOrder(root.right);
        }
    }

    public Node minValueNode(Node node) {
        Node current = node;
        /* bucle hacia abajo para encontrar la hoja más a la izquierda */
        while (current.left != null)
            current = current.left;
        return current;
    }

    public Node deleteNode(Node root, String value) {
        // STEP 1: PERFORM STANDARD BST DELETE

        if (root == null)
            return root;

        // If the value to be deleted is smaller than the root's value,
        // then it lies in left subtree
        if ( value.compareTo(root.value) < 0 )
            root.left = deleteNode(root.left, value);

        // If the value to be deleted is greater than the root's value,
        // then it lies in right subtree
        else if( value.compareTo(root.value) > 0 )
            root.right = deleteNode(root.right, value);

        // if value is same as root's value, then This is the node
        // to be deleted
        else {
            // node with only one child or no child
            if( (root.left == null) || (root.right == null) ) {

                Node temp;
                if (root.left != null)
                        temp = root.left;
                else
                    temp = root.right;

                // No child case
                if(temp == null) {
                    temp = root;
                    root = null;
                }
                else // One child case
                    root = temp; // Copy the contents of the non-empty child

                temp = null;
            }
            else {
                // node with two children: Get the inorder successor (smallest
                // in the right subtree)
                Node temp = minValueNode(root.right);

                // Copy the inorder successor's data to this node
                root.value = temp.value;

                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.value);
            }
        }

        // If the tree had only one node then return
        if (root == null)
            return root;

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        //  this node became unbalanced)
        int balance = getBalance(root);

        // If this node becomes unbalanced, then there are 4 cases

        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left =  leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    public void print(Node root) {

        if(root == null) {
            System.out.println("(XXXXXX)");
            return;
        }

        int height = root.height,
            width = (int)Math.pow(2, height-1);

        // Preparing variables for loop.
        List<Node> current = new ArrayList<Node>(1),
            next = new ArrayList<Node>(2);
        current.add(root);

        final int maxHalfLength = 4;
        int elements = 1;

        StringBuilder sb = new StringBuilder(maxHalfLength*width);
        for(int i = 0; i < maxHalfLength*width; i++)
            sb.append(' ');
        String textBuffer;

        // Iterating through height levels.
        for(int i = 0; i < height; i++) {

            sb.setLength(maxHalfLength * ((int)Math.pow(2, height-1-i) - 1));

            // Creating spacer space indicator.
            textBuffer = sb.toString();

            // Print tree node elements
            for(Node n : current) {

                System.out.print(textBuffer);

                if(n == null) {

                    System.out.print("        ");
                    next.add(null);
                    next.add(null);

                } else {

                    System.out.printf("(%6d)", n.value);
                    next.add(n.left);
                    next.add(n.right);

                }

                System.out.print(textBuffer);

            }

            System.out.println();
            // Print tree node extensions for next level.
            if(i < height - 1) {

                for(Node n : current) {

                    System.out.print(textBuffer);

                    if(n == null)
                        System.out.print("        ");
                    else
                        System.out.printf("%s      %s",
                                n.left == null ? " " : "/", n.right == null ? " " : "\\");

                    System.out.print(textBuffer);

                }

                System.out.println();

            }

            // Renewing indicators for next run.
            elements *= 2;
            current = next;
            next = new ArrayList<Node>(elements);

        }

    }
}
