public class ArrayAsList{
    private int arr[];
    private int size;
    private int idx;

    public ArrayAsList(){
        this.size=5;
        this.idx=-1;
        this.arr=new int[this.size];
    }
    public ArrayAsList( int capacity){
        this.size=capacity;
        this.idx=-1;
        this.arr=new int[this.size];

    }
    public void add(int data){
        if(this.idx==this.size-1){
            System.out.println("Array is full");
            return;
        }
        else{
    this.idx++;
        this.arr[this.idx]=data;
        }
       
    }
    public void display(){
        if (this.idx==-1){
            System.out.println("Array is empty");
            return;
        }
       else{
        for(int i=0;i<=this.idx;i++){
            System.out.print(this.arr[i]+" ");
        }
        System.out.println();
       }
    }

    public static void main(String[] args) {
        ArrayAsList list=new ArrayAsList(4);
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.display();
    }
}