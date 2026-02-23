class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
        next=null;
    }
}
public class QueueAsList {
     Node head;
    int size;
    int[] queue;
    int fIdx;
    int rIdx;

    public QueueAsList() {
        this.size = 5;
        this.queue = new int[size];
        this.fIdx = -1;
        this.rIdx = -1;
    }

    
    public void enqueue(int data){
       
        Node newNode = new Node(data);
        if (this.head==null) {
             System.out.println("list is Empty");
        }
        else{
            Node temp=this.head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }
    }

   

    public static void main(String[] args) {
        queue q = new queue();
        System.out.println(q.getClass().getName());
      q.display();
    }
}