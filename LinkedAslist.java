
class Node {
 int data;
 Node next;

 public  Node(int data){
    this.data=data;
    next=null;
 }
  
 }

  public class LinkedAslist {
      Node head;   // ✅ head belongs here
    public void insertAtBegin(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;               // assign head
        } else {
            newNode.next = head;          // link new node
            head = newNode;               // update head
        }
    }
    public void insertAtEnd(int data){
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

    public void insertAtPos(int data, int pos) {
    Node newNode = new Node(data);

    // Case 1: insert at beginning
    if (pos == 1) {
        newNode.next = head;
        head = newNode;
        return;
    }

    Node temp = head;
    int count = 1;

    // Move to (pos-1)th node
    while (temp != null && count < pos - 1) {
        temp = temp.next;
        count++;
    }


    if (temp == null) {
        System.out.println("Invalid position");
        return;
    }


    newNode.next = temp.next;
    temp.next = newNode;
}


    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

//reverse Travsal 
    public void reverseTravsal(Node node){
       if (node==null) {
         return;  
       }
    reverseTravsal(node.next);
            System.out.println(node.data);
    }

    //delete from begig
    public void deleteFromBegin(){
        if(head==null){
            System.out.println("list is empty");
            
        }
        else{
            int data = head.data;
            Node temp=head;
               head=head.next;
               temp.next=null;
               System.out.println("this data is delted:-"+ data);

        }
    }

    //delete from last or delete from end
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
    //delete from possition
    public int deleteFromPos(int pos){
        if(head==null){
            System.out.println("list is empty");
            return -1;
        }
        else{
            int count=0;
              Node tt=head;
            Node temp=head;
            while (temp.next!=null) {
                if (count==pos-1) {
                     break;
                }
                    tt=temp;
                     temp=temp.next;
                     count++;
               
            }
            //int data=temp.data; 
            tt.next=null;
            
            return tt.data;

           
        }
    }

    public Node  mergeTwoLisgt(Node head1,Node head2)
    {
        if(head1==null && head2==null){
            return null;
        }
        else if(head1==null){
            return head2;
        }
        else if(head2==null){
            return head1;
        }
        else
        {
         Node temp =head1;
         while (temp.next!=null) {
            temp=temp.next;
         }
         temp.next=head2;
         head2=null;
         return head1;
        }

    }

   

    public static void main(String args[]) {
       LinkedAslist list1  = new LinkedAslist();
        list1.insertAtBegin(10);
        list1.insertAtBegin(20);
        list1.insertAtBegin(30);

        list1.display();
        list1.insertAtEnd(25);
        list1.insertAtBegin(40);
        list1.display();
        list1.insertAtPos(80,2);
        list1.display();
        

        list1.deleteFromBegin();
        list1.display();

        list1.deleteFromPos(3);
        list1.display();

LinkedAslist list = new LinkedAslist();

    Node head1 = new Node(10);
    head1.next = new Node(20);

    Node head2 = new Node(30);
    head2.next = new Node(40);

    Node mergedHead = list.mergeTwoLisgt(head1, head2);

    Node temp = mergedHead;
    while (temp != null) {
        System.out.print(temp.data + " ");
        temp = temp.next;
    }

    }
}




