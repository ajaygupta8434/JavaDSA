 class Node {
    int data;
    Node previous;
    Node next;
      

    Node(int data){
        this.data=data;
        this.previous=null;
        this.next=null;
    }

    
}

 class InnerDoubly_linked_list {
   Node head;
  //Insert operation 
     public void  insert_at_begin(int data){
        Node nnNode=new Node(data);
        if(this.head==null){
     this.head=nnNode;
        }
        else{
        
              nnNode.next = head;
            head.previous = nnNode;
            head = nnNode;
            
        }
     }
     
     //display list
     public void dispaly(){
        Node temp=this.head;
        if(temp==null){
            System.out.println("List is Empty");
        }

        else{
            while (temp.next!= null) {
                   System.out.println(temp.data);
            }
        }
     }
}
public class Doubly_linked_list {
    public static void main(String args[]){
        InnerDoubly_linked_list ddl=new InnerDoubly_linked_list();
        ddl.insert_at_begin(12);
          ddl.dispaly();
    }
     
}
