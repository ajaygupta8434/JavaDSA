class Node {
 int data;
 Node next;

 public  Node(int data){
    this.data=data;
    next=null;
 }
  
 }

public class StackAsList {
    Node head;
  public void insert_At_End(int data){
  Node newNode = new Node(data);
        Node temp=head;
        if(head==null){
            this.head=newNode;
        }
        else{
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }
 }
  
  public int deleteFromEnd(){
        if(head==null){
            System.out.println("list is empty");
            return -1;
            
        }
        else{
            Node tt=head;
            Node temp=head;
            while (temp.next!=null) {
               tt=temp;
               temp=temp.next;
            }
            int data=temp.data; 
            tt.next=null;
            return data;
        }
    }
 public int peep() {
    if (head == null) {
        System.out.println("Stack is Empty");
        return -1;
    }

    Node temp = head;
    while (temp.next != null) {
        temp = temp.next;
    }

      System.out.println(temp.data);
    return temp.data;
}


 public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }


 public static void main(String[] args) {
    StackAsList sl =new StackAsList();
    sl.insert_At_End(12);
    sl.insert_At_End(22);
    sl.insert_At_End(32);
    sl.display();
    sl.deleteFromEnd();
    sl.display();
   sl.peep(); 
}
}
