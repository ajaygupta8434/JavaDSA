 class Array {

    private int[] arr;
    private int size;   
    private int idx;
    public Array() {
        this.size = 5;
        this.idx = -1;
        this.arr = new int[this.size];
    }
    // Parameterized constructor
    public Array(int capacity) {
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


    //display method
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

class AddingArrays {

    public int[] mergeArray(Array a1, Array a2) {

        int size = a1.length() + a2.length();
        int[] a = new int[size];

        int i = 0, j = 0, k = 0;

        while (i < a1.length() && j < a2.length()) {
            if (a1.get(i) < a2.get(j)) {
                a[k++] = a1.get(i++);
            } else {
                a[k++] = a2.get(j++);
            }
        }

        while (i < a1.length()) {
            a[k++] = a1.get(i++);
        }

        while (j < a2.length()) {
            a[k++] = a2.get(j++);
        }

        return a;
    }

    public void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
 

 public class MergeAccending {
    public static void main(String[] args) {
        Array a1 = new Array();
        a1.addAtlast(1);
        a1.addAtlast(3);
        a1.addAtlast(5);
        System.out.print("First Array: ");
        a1.display();

        Array a2 = new Array();
        a2.addAtlast(2);
        a2.addAtlast(4);
        a2.addAtlast(6);
        System.out.print("Second Array: ");
        a2.display();

     AddingArrays ma = new AddingArrays();
        int[] mergedArray = ma.mergeArray(a1, a2);
        System.out.print("Merged Array in Ascending Order: ");
        ma.show(mergedArray);
      
    }
}
