/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package git_arboles;

import java.util.Stack;

/**
 *
 * @author Juana García
 */

public class ArbolBinario {

    /**
     * @param args the command line arguments
     */
    
    private Node root;
 
    public void setRoot(Node root) {
        this.root = root;
    }
 
    public Node getRoot(){
        return root;
    }
 
    // Crea un árbol binario
    //              5
    //           /     \
    //          3       7
    //        /   \   /   \
    //       2     4 6     8
 
 
    public Node initial(){
        Node D = new Node(2);
        Node E = new Node(4);
        Node F = new Node(6);
        Node G = new Node(8);
        Node B = new Node(3, D, E);
        Node C = new Node(7, F, G);
        Node A = new Node(5, B, C);
        return A; //root
    }
 
 
         // Realización recursiva [recorrido previo al pedido] "raíz izquierda y derecha"
    public void preOrder(Node node){
        if (node == null) {
            return;
        }
        System.out.print(node.getN() + " ");
        preOrder(node.getLeftChild());
        preOrder(node.getRightChild());
    }
 
         // Realización recursiva [transversal en orden] "raíz izquierda derecha"
    public void inOrder(Node node){
        if (node == null) {
            return;
        }
        inOrder(node.getLeftChild());
        System.out.print(node.getN() + " ");
        inOrder(node.getRightChild());
    }
 
         // Realización recursiva [recorrido posterior al pedido] "raíz izquierda y derecha"
    public void postOrder(Node node){
        if (node == null) {
            return;
        }
        postOrder(node.getLeftChild());
        postOrder(node.getRightChild());
        System.out.print(node.getN() + " ");
    }
 
 
         // Realización no recursiva [recorrido previo al pedido] "raíz izquierda y derecha"
    public void iterativePreOrder(Node node) {
        Stack<Node> stack = new Stack<>();
        while (node != null || stack.size() > 0) {
                         // Presione todos los nodos secundarios izquierdos, visítelo antes de presionar
            while (node != null){
                System.out.print(node.getN() + " ");
                stack.push(node);
                node = node.getLeftChild();
            }
            if (stack.size() > 0) {
                node = stack.pop();
                node = node.getRightChild();
            }
        }
    }
 
         // Realización no recursiva [transversal en orden] "raíz izquierda derecha"
    public void iterativeInOrder(Node node){
        Stack<Node> stack = new Stack<>();
        while (node != null || stack.size() > 0){
                         // Presione todos los nodos secundarios izquierdos, temporalmente no visite
            while (node != null) {
                stack.push(node);
                node = node.getLeftChild();
            }
            if (stack.size() > 0) {
                node = stack.pop();
                System.out.print(node.getN() + " ");
                node = node.getRightChild();
            }
        }
}
 
         // Método de doble pila de realización no recursiva [recorrido posterior al pedido] "raíz izquierda y derecha"
    public void iterativePostOrder(Node node){
        Stack<Node> stack = new Stack<>();
        Stack<Node> temp = new Stack<>();
        while (node != null || stack.size() > 0) {
         // Presione todos los nodos secundarios correctos, temporalmente no visite
            while (node != null) {
                temp.push(node);
                stack.push(node);
                node = node.getRightChild();
            }
            if (stack.size() > 0) {
                node = stack.pop();
                node = node.getLeftChild();
            }
        }
        while (temp.size() > 0) {
            node = temp.pop();
            System.out.print(node.getN() + " ");
        }
    }
 
    public int getTreeDepth(Node node){
        if (node == null) {
            return 0;
        }
        int left = getTreeDepth(node.getLeftChild());
        int right = getTreeDepth(node.getRightChild());
        return (left < right) ? (right + 1) : (left + 1);

}
    
    public static void main(String[] args) {
       ArbolBinario bt = new ArbolBinario();
        bt.setRoot(bt.initial());
 
        System.out.println("Recorrido en preOrden del arbol binario: ");
        bt.preOrder(bt.getRoot());
        System.out.println();
        bt.iterativePreOrder(bt.getRoot());
        System.out.println();
 
        System.out.println("Recorrido inOrder del arbol binario: ");
        bt.inOrder(bt.getRoot());
        System.out.println();
        bt.iterativeInOrder(bt.getRoot());
        System.out.println();
 
        System.out.println("Recorrido postOrden del arbol binario: ");
        bt.postOrder(bt.getRoot());
        System.out.println();
        bt.iterativePostOrder(bt.getRoot());
        System.out.println();
 
        System.out.print("Profundidad del arbol: ");
        System.out.println(bt.getTreeDepth(bt.getRoot()));
    }

    }
    

