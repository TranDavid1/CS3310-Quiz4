import java.util.Random;

public class PeaksAndValleys
{
    // Helper method to print out array.
    public void print(int arr[])
    {
        int rowCount = 0;   //Iterator to keep track of when to create new row
        int n = arr.length;
        for (int i=0; i<n; ++i)
        {
            // If the current element is a multiple of 10, create a new row
            if (rowCount >= 10)
            {
                System.out.println();
                rowCount = 0;   // Reset the rowCount iterator
            }
            System.out.printf("%3d" + " ", arr[i]);     // Print out element in the array with 3 digit wide format
            rowCount++;     // Iterate rowCount
        }
        System.out.println();      // Print out empty line
    } // end print

    // Helper method, swaps two elements in an array
    public void swap(int arr[], int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    } // end swap

    // Function to fill out an array with random values
    public static void fillArray(int[] arr)
    {
        // Create instance of Random class
        Random rand = new Random();
        int n = arr.length;
        for (int i = 0; i < n; i++)
            arr[i] = rand.nextInt(1000);    // Randomly generate int value between 0-999
    }   // end fillArray

    // Sort the given array into an alternating sequence of peaks and valleys.
    public void sort(int arr[], int n)
    {
        // Traverse all even elements in arrays
        for (int i = 0; i < n; i+=2)
        {
            // If current even element is smaller than the previous
            if (i > 0 && arr[i - 1] > arr[i])
                swap (arr, i - 1, i);
            // If current even element is smaller than the next
            if (i < n - 1 && arr[i] < arr[i + 1])
                swap(arr, i, i + 1);
        }
    } // end sort

    public static void main(String args[])
    {
        PeaksAndValleys ob = new PeaksAndValleys();

        // Sample run of example from the quiz prompt
        int[] arr = {5, 3, 1, 2, 3};
        System.out.println("Unsorted array from quiz prompt:");
        ob.print(arr);
        int arr_length = arr.length;
        ob.sort(arr, arr_length);
        System.out.println("Sorted array from quiz prompt:");
        ob.print(arr);

        // Test runs with random values
        int[] arr10 = new int[10];
        int[] arr50 = new int[50];
        int[] arr100 = new int[100];

        ob.fillArray(arr10);
        ob.fillArray(arr50);
        ob.fillArray(arr100);

        System.out.println("\nUnsorted array of 10 elements:");
        ob.print(arr10);
        int arr10_length = arr10.length;
        ob.sort(arr10, arr10_length);
        System.out.println("\nSorted array of 10 elements:");
        ob.print(arr10);

        System.out.println("\nUnsorted array of 50 elements:");
        ob.print(arr50);
        int arr50_length = arr50.length;
        ob.sort(arr50, arr50_length);
        System.out.println("\nSorted array of 50 elements:");
        ob.print(arr50);

        System.out.println("\nUnsorted array of 100 elements:");
        ob.print(arr100);
        int arr100_length = arr100.length;
        ob.sort(arr100, arr100_length);
        System.out.println("\nSorted array of 100 elements:");
        ob.print(arr100);
    } // end main
}