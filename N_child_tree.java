import java.util.*;

class Node {
    int data;
    Vector<Node> children = new Vector<>();

    Node(int data) {
        this.data = data;
    }
}

public class N_child_tree {
     Node root;
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        for (int i = 0; i < root.children.size(); i++) {
            preOrder(root.children.get(i));
        }
    }
     public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < root.children.size(); i++) {
            preOrder(root.children.get(i));
        }
         System.out.print(root.data + " ");
    }
    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");
            for (int i = 0; i < current.children.size(); i++) {
                queue.add(current.children.get(i));
            }
        }
    }
public static Node insertNode(Node root, int data){
    if (root == null) {
        return new Node(data);
    }

    Queue<Node> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
        Node temp = q.poll();

        // agar 10 se kam children hai (ternary tree)
        if (temp.children.size() < 10) {
            temp.children.add(new Node(data));
            return root;
        }

        // warna next level me jao
        for (Node child : temp.children) {
            q.add(child);
        }
    }

    return root;
}


  public static void main(String[] args) {
    Node root = new Node(1);
    root.children.add(new Node(2));
    root.children.add(new Node(3));
    root.children.add(new Node(4));
    root.children.get(0).children.add(new Node(5));
    root.children.get(0).children.add(new Node(6));
    root.children.get(1).children.add(new Node(7));

    System.out.println("Pre-order Traversal:");
    preOrder(root); 
     System.out.println("\n post-order Traversal:");
    postOrder(root); 
   root = insertNode(root, 8);

System.out.println("\nLevel-order Traversal:");
levelOrder(root);
  }   
}
