class Arraymerge {
    private int[] arr;
    private int size;
    private int idx;


    public Arraymerge() {
        this.size = 5;
        this.idx = -1;
        this.arr = new int[this.size];
    }

    // Parameterized constructor
    public Arraymerge(int capacity) {
        this.size = capacity;
        this.idx = -1;
        this.arr = new int[this.size];
    }

    // Add element at last
    public void addAtlast(int data) {
        if (this.idx == this.size - 1) {
            System.out.println("Array is full");
            return;
        }
        this.idx++;
        this.arr[this.idx] = data;
    }

    // Getter to access element
    public int get(int index) {
        return this.arr[index];
    }

    // Returns current length
    public int length() {
        return this.idx + 1;
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
}


 class MergeArray {
   public int[] mergeArray(Arraymerge a1, Arraymerge a2) {

    int size = a1.length() + a2.length();
    int[] merged = new int[size];

    int k = 0;

    for (int i = 0; i < a1.length(); i++)
       {
         merged[k] = a1.get(i);
        k++;
       }
    for (int j = 0; j < a2.length(); j++)
        {
            merged[k] = a2.get(j);
        k++; 
        }   
    return merged;
}

    public void display(int[] merged){
        for(int i=0;i<merged.length;i++){
            System.out.print(merged[i]+" ");
        }
        System.out.println();
}


    public static void main(String[] args) {
        Arraymerge array1 = new Arraymerge(3);
        array1.addAtlast(1);
        array1.addAtlast(3);
        array1.addAtlast(5);
        array1.display();

        Arraymerge array2 = new Arraymerge(2);
        array2.addAtlast(2);
        array2.addAtlast(4);
        array2.display();

     

         MergeArray merger = new MergeArray();
            int[] mergedArray = merger.mergeArray(array1, array2);
            merger.display(mergedArray);
            
    }
}