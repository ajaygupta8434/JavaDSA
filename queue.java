class Innerqueue {
int size;
int fidx;
int ridx;
int queue[];
Innerqueue(int size){
    this.size=size;
    this.fidx=-1;
   this.ridx=-1;
    this.queue=new int[size];
    
}
//enqueue data into queue
public void enqueue(int val){
//check full case
if(ridx==size-1){
    System.out.println("Queue Overflow");
    return;
}
else if (ridx==-1) {
    ridx=0;
    fidx=0;
    queue[ridx]=val;    
    
}
else{
    ridx++;
    queue[ridx]=val;
}
}
//dequeue data from queue
public void dequeue()
{
    //check empty case

    if(fidx==-1 && ridx==-1){
        System.out.println("Queue Underflow");
        return;
    }
    else if(fidx==ridx){
        System.out.println(queue[fidx]);
        fidx=-1;
        ridx=-1;
    }
    else{
        System.out.println(queue[fidx]);
        fidx++;
    }
}}
public class queue {
    public static void main(String[] args) {
        Innerqueue q=new Innerqueue(5);
        q.enqueue(10);
        q.enqueue(15);
        q.enqueue(30);
        System.err.println("Queue elements are:\n");
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
    }
    
}
