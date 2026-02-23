public class Smallest_Element_Array {
    
    public static void main(String[] args) {
        int arr[] = {5, 2, 9, 3, 5, 6};
        int smallest = arr[0]; // Assume the first element is the smallest

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i]; // Update smallest if a smaller element is found
            }
        }

        System.out.println("The smallest element in the array is: " + smallest);
    }
}
