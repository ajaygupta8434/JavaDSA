import java.util.*;
 class Node {
    int data;
    Node left;
    Node middle;
    Node  right;

    public Node(int item) {
        data = item;
        left = middle = right = null;
    }
}

public class Ternary_tree {
    public void pre_order(Node root) 
    {
    if(root== null){
        return ;
    }
    System.out.print(root.data+" ");
    pre_order(root.left);
    pre_order(root.middle);
    pre_order(root.right);
    }
    public void post_order(Node root) 
    {
    if(root== null){
        return ;
    }
    post_order(root.left);
    post_order(root.middle);    
    post_order(root.right);
    System.out.print(root.data+" ");
    }
    public void level_order(Node root) 
    {   
    if(root== null){
        return ;
    }
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while(!q.isEmpty()){
        Node curr = q.poll();
        System.out.print(curr.data+" ");
        if(curr.left!=null){
            q.add(curr.left);
        }
        if(curr.middle!=null){
            q.add(curr.middle);
        }
        if(curr.right!=null){
            q.add(curr.right);
        }
    }
    }
    public Node insertNode(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.left == null) {
                curr.left = new Node(data);
                return root;
            } else {
                q.add(curr.left);
            }
            if (curr.middle == null) {
                curr.middle = new Node(data);
                return root;
            } else {
                q.add(curr.middle);
            }
            if (curr.right == null) {
                curr.right = new Node(data);
                return root;
            } else {
                q.add(curr.right);
            }
        }
        return root;
    }

    public Node deleteLastNode(Node root) {
    if (root == null) {
        return null;
    }

    if (root.left == null && root.middle == null && root.right == null) {
        return null;
    }

    Queue<Node> q = new LinkedList<>();
    q.add(root);

    Node last = null;
    Node parent = null;

    while (!q.isEmpty()) {
        Node curr = q.poll();

        if (curr.left != null) {
            parent = curr;
            last = curr.left;
            q.add(curr.left);
        }

        if (curr.middle != null) {
            parent = curr;
            last = curr.middle;
            q.add(curr.middle);
        }

        if (curr.right != null) {
            parent = curr;
            last = curr.right;
            q.add(curr.right);
        }
    }

    if (parent.right == last) {
        parent.right = null;
    } else if (parent.middle == last) {
        parent.middle = null;
    } else if (parent.left == last) {
        parent.left = null;
    }

    return root;
}
 
public Node deleteByValue(Node root, int key) {
    if (root == null) {
        return null;
    }

    // single node case
    if (root.left == null && root.middle == null && root.right == null) {
        if (root.data == key) {
            return null;
        } else {
            return root;
        }
    }

    Queue<Node> q = new LinkedList<>();
    q.add(root);

    Node keyNode = null;
    Node last = null;
    Node parent = null;

    while (!q.isEmpty()) {
        Node curr = q.poll();

        // target node find
        if (curr.data == key) {
            keyNode = curr;
        }

        // left
        if (curr.left != null) {
            parent = curr;
            last = curr.left;
            q.add(curr.left);
        }

        // middle
        if (curr.middle != null) {
            parent = curr;
            last = curr.middle;
            q.add(curr.middle);
        }

        // right
        if (curr.right != null) {
            parent = curr;
            last = curr.right;
            q.add(curr.right);
        }
    }

    // agar key mila
    if (keyNode != null) {
        // replace
        keyNode.data = last.data;

        // delete last node
        if (parent.right == last) {
            parent.right = null;
        } else if (parent.middle == last) {
            parent.middle = null;
        } else if (parent.left == last) {
            parent.left = null;
        }
    }

    return root;
}
    public static void main(String[] args) {
        Node root = new Node(1);
        Ternary_tree tree = new Ternary_tree();
        tree.insertNode(root, 2);
        tree.insertNode(root, 3);
        tree.insertNode(root, 4);
        tree.insertNode(root, 5);
        tree.insertNode(root, 6);   
        System.out.println("Pre-order traversal of the ternary tree:");
        tree.pre_order(root);
        System.out.println("\nPost-order traversal of the ternary tree:");
        tree.post_order(root);
        System.out.println("\nLevel-order traversal of the ternary tree:");
        tree.level_order(root);
        
        tree.deleteLastNode(root);
        System.out.println("\nLevel-order traversal after deleting the last node:");
        tree.level_order(root);
        
  tree.deleteByValue(root, 3);
        System.out.println("\nLevel-order traversal after deleting node with value 3:");
        tree.level_order(root);
    }
}
