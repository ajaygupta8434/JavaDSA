public class AddDataAtBegin{
    private int arr[];
    private int size;
    private int idx;

    public AddDataAtBegin(){
        this.size=5;
        this.idx=-1;
        this.arr=new int[this.size];
    }
    public AddDataAtBegin( int capacity){
        this.size=capacity;
        this.idx=-1;
        this.arr=new int[this.size];

    }
    public void addAtlast(int data){
        if(this.idx==this.size-1){
            System.out.println("Array is full");
            return;
        }
        else{
    this.idx++;
        this.arr[this.idx]=data;
        }
       
    }
    public void addAtpos(int data ,int poss){
        if(this.idx==this.size-1){
            System.out.println("Array is full");
            return;
        }
        else{
            idx++;
    for(int i=idx;i>=1;i--){
         arr[i]=arr[i-1];
         }
         arr[poss-1]=data;
}
     }
     public void addAtbegin(int data){
        if(this.idx==this.size-1){
            System.out.println("Array is full");
            return;
        }
        else{
            idx++;
    for(int i=idx;i>=1;i--){
         arr[i]=arr[i-1];
         }
         arr[0]=data;
}
     }

     public void deleteData(){
        if(idx==-1){
            System.err.println("Array is Empty");
            return;
        }
        else{
           int data=arr[idx];
            idx--;
            System.err.println(data);
            return ;
        }
     }

     public int deleteDataAtbegin(){
        if(idx==-1){
            System.err.println("Array is Empty");
            return 0;
        }
        else{
        int data=arr[0];
         for (int i = 0; i < idx; i++) {
            arr[i] = arr[i + 1];
        }

        idx--; 
            return data;
        }

     }

public void search(int s_data){
     for(int i=0;i<=idx;i++){
   if(arr[i]==s_data)
   {
   System.err.println("search element = " +s_data);
 return;   
}
 System.out.println("key is not found");

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
        AddDataAtBegin list=new AddDataAtBegin(4);
        list.addAtlast(10);
        list.addAtlast(20);
        list.addAtbegin(15);
        list.addAtpos(30, 2);
        list.display();
        list.deleteData();
        list.search(15);
        list.display();
        list.deleteDataAtbegin();
        list.display();
        
    }
}