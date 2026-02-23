class Node {
    int data;
    Node previous;
    Node next;

    Node(int data) {
        this.data = data;
        this.previous = null;
        this.next = null;
    }
}

class InnerDoubly_linked_list {
    Node head;

    // Insert at beginning
    public void insert_at_begin(int data) {
        Node nnNode = new Node(data);

        if (head == null) {
            head = nnNode;
        } else {
            nnNode.next = head;
            head.previous = nnNode;
            head = nnNode;
        }
    }

    // Insert at ending
    public void insert_at_end(int data) {
        Node nnNode = new Node(data);
          
        if (head == null) {
            head = nnNode;
        } else {
          Node temp=head;
            while (temp.next!= null) {
                temp=temp.next;
            }
                temp.next=nnNode;
                nnNode.previous=temp;
                nnNode.next=null;
           
        }
    }
// Insert at position 
public void insert_at_poss(int data, int pos) {
    Node nnNode = new Node(data);

    // empty list
    if (head == null) {
        head = nnNode;
        
    }

    Node temp = head;
    int count = 1;

    while (temp.next != null) {
        if (count == pos - 1) {

            nnNode.next = temp.next;
            nnNode.previous = temp;
            temp.next.previous = nnNode;
            temp.next = nnNode;

        
        }
        temp = temp.next;
        count++;
    }

    
}


    // Display list or travers
    public void display() {
        Node temp = head;

        if (temp == null) {
            System.out.println("List is Empty");
        } else {
            while (temp != null) {
                System.out.print(temp.data + " <-> ");
                temp = temp.next;
            }
        
        }
    }

    
    // Display list or travers
    public void revers_display() {
        Node temp = head;

        if (temp == null) {
            System.out.println("List is Empty");
        } else {
            while (temp.next!= null) {
                temp = temp.next;
            }
             while (temp != null) {
                System.out.print(temp.data + " <-> ");
                temp = temp.previous;
            }
        
        }
    }
    //delete element form begin
    public int delete_from_begin(){
         if (this.head== null) {
            return -1;
        }
        else{
             Node temp = this.head;
             temp.next.previous=null;
             head=temp.next;
              return temp.data;
        }
    }
//delete element form end
    public int delete_from_end(){
         if (this.head== null) {
            return -1;
        }
        else{
            Node temp= this.head;
            while (temp.next!=null) {
                 temp=temp.next;
            }
            
            temp.previous.next=null;
            temp.previous=null;
            return temp.data;
        }
    }

//delete element form end
    public int delete_from_poss( int pos){
         if (this.head== null) {
            return -1;
        }
        else{
            Node temp= this.head;
            int count =0;
            while (temp.next!=null) {
                count++;
                if(count==pos-1){
                    break;
                }
                 temp=temp.next;
            }
            temp.previous.next=temp.next;
            temp.next.previous=temp.previous;
            temp.next=null;
            temp.previous=null;
            return temp.data;
        }
    }
}

public class Doubly_linked_list {
    public static void main(String args[]) {
        InnerDoubly_linked_list ddl = new InnerDoubly_linked_list();
        ddl.insert_at_begin(12);
        ddl.insert_at_begin(25);
        ddl.display();
        System.out.println("\n");
        ddl.insert_at_end(30);
        ddl.display();

         System.out.println("\n");
         ddl.insert_at_poss(20,2);
         ddl.display();
                System.out.print(" \n ");
         
         ddl.revers_display();
         System.out.print(" \n ");
         ddl.delete_from_begin();
            ddl.delete_from_end();
            ddl.delete_from_poss(2);
         ddl.display();
    }
}
