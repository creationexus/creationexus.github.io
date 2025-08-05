package challenges.trees.level_order_traversal;

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Tree {

    /*
     * 
     * class Node
     * int data;
     * Node left;
     * Node right;
     */

    public static int height(Node root) {
        if (root == null)
            return -1;
        else
            return 1 + Math.max(height(root.left), height(root.right));
    }

    private static void levelOrderIn(Node root, List<Node> l) {
        // Se asegura que el nodo recibido no sea null
        if (root != null) {
            // Se iteran todos los nodos cargados
            for (; l.size() > 0;) {
                // Se obtiene el nodo de la primera posicion en cada iteracion
                Node t = l.get(0);
                // Se muestra el valor del nodo de la primera posicion
                System.out.print(t.data + " ");
                // Se quita el nodo
                l.remove(0);
                // Si tiene referencia hacia nodo izquierdo, se carga a la lista
                // NOTA: Es importante que las n referencias sean cargadas en el mismo ciclo
                if (t.left != null) {
                    l.add(t.left);
                }
                // Si tiene referencia hacia nodo derecho, se carga a la lista
                // NOTA: Es importante que las n referencias sean cargadas en el mismo ciclo
                if (t.right != null) {
                    l.add(t.right);
                }
            }
        }
    }

    public static void levelOrder(Node root) {
        List<Node> l = new ArrayList<Node>();
        l.add(root);
        Tree.levelOrderIn(root, l);
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // int t = scan.nextInt();
        int t = -1;
        Node root = null;
        Integer[] n = new Integer[] { 8, 5, 2, 10, 1, 3, 9, 19, 18, 20, 21 };
        while (t++ < n.length - 1) {
            // int data = scan.nextInt();
            // System.out.println(">>"+t);
            int data = n[t];
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }
}