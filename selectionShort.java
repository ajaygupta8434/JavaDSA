public class selectionShort {
    
    void load() {
        int arr[] = {14, 19, 4, 5};
        int temp;

        for (int i = 0; i < arr.length - 1; i++) {

            int min_idx = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            // swap
            temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        selectionShort a = new selectionShort();
        a.load();
    }
}
