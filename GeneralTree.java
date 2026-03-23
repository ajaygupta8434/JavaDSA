import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node leftChild, rightChild; // must match your code

    Node(int data) {
        this.data = data;
        leftChild = rightChild = null;
    }
}

// General Binary Tree class
class GeneralTree {

    Node root;

    GeneralTree() {
        root = null;
    }

    // 1. Insert a node in level-order
    void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr.leftChild != null)
                q.add(curr.leftChild       );
            else {
                curr.leftChild = newNode;
                return;
            }

            if (curr.rightChild != null)
                q.add(curr.rightChild   );
            else {
                curr.rightChild  = newNode;
                return;
            }
        }
    }

    // Delete the deepest node
    void deleteDeepest(Node dNode) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr == dNode) {
                curr = null;
                return;
            }

            if (curr.leftChild != null) {
                if (curr.leftChild == dNode) {
                    curr.leftChild = null;
                    return;
                } else
                    q.add(curr.leftChild);
            }

            if (curr.rightChild != null) {
                if (curr.rightChild == dNode) {
                    curr.rightChild = null;
                    return;
                } else
                    q.add(curr.rightChild);
            }
        }
    }

    // 2. Delete a node with a given key
    void delete(int key) {
        if (root == null)
            return;

        if (root.leftChild == null && root.rightChild == null) {
            if (root.data == key)
                root = null;
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node curr = null;
        Node keyNode = null;

        while (!q.isEmpty()) {
            curr = q.poll();

            if (curr.data == key)
                keyNode = curr;

            if (curr.leftChild != null)
                q.add(curr.leftChild);
            if (curr.rightChild != null)
                q.add(curr.rightChild);
        }

        if (keyNode != null) {
            int x = curr.data;          // deepest node's data
            keyNode.data = x;            // replace key node
            deleteDeepest(curr);         // delete deepest node
        }
    }

    // 3. Search for an element
    boolean search(int key) {
        if (root == null) return false;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.data == key) return true;

            if (curr.leftChild != null) q.add(curr.leftChild);
            if (curr.rightChild != null) q.add(curr.rightChild  );
        }

        return false;
    }

    // 4. Find maximum value in the tree
    int findMax() {
        if (root == null) return Integer.MIN_VALUE;

        int max = Integer.MIN_VALUE;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.data > max) max = curr.data;

            if (curr.leftChild != null) q.add(curr.leftChild    );
            if (curr.rightChild != null) q.add(curr.rightChild);
        }
        return max;
    }

    // 5. Find minimum value in the tree
    int findMin() {
        if (root == null) return Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.data < min) min = curr.data;

            if (curr.leftChild != null) q.add(curr.leftChild    );
            if (curr.rightChild != null) q.add(curr.rightChild  );
        }
        return min;
    }

    // Optional: Level-order traversal to print the tree
    void levelOrder() {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.data + " ");

            if (curr.leftChild != null) q.add(curr.leftChild);
            if (curr.rightChild != null) q.add(curr.rightChild  );
        }
        System.out.println();
    }

    // Driver method
    public static void main(String[] args) {
        GeneralTree tree = new GeneralTree();

        // Insert nodes
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);

        System.out.print("Tree (level-order): ");
        tree.levelOrder(); // 10 20 30 40 50

        // Search
        System.out.println("Search 30: " + tree.search(30)); // true
        System.out.println("Search 60: " + tree.search(60)); // false

        // Find Max & Min
        System.out.println("Maximum value: " + tree.findMax()); // 50
        System.out.println("Minimum value: " + tree.findMin()); // 10

        // Delete node
        tree.delete(20);
        System.out.print("Tree after deleting 20: ");
        tree.levelOrder(); // 10 50 30 40
    }
}