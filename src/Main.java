import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose the file to be sorted(1 to 12):");
        int choice;
        choice = sc.nextInt();
        sc.close();

        String filePath = null;

        switch (choice){

            case 1: filePath = "C:/Users/Laura/Documents/Java/Sorting/src/instances/num.1000.1.txt";
                break;

            case 2: filePath = "C:/Users/Laura/Documents/Java/Sorting/src/instances/num.1000.2.txt";
                break;

            case 3: filePath = "C:/Users/Laura/Documents/Java/Sorting/src/instances/num.1000.3.txt";
                break;

            case 4: filePath = "C:/Users/Laura/Documents/Java/Sorting/src/instances/num.1000.4.txt";
                break;

            case 5: filePath = "C:/Users/Laura/Documents/Java/Sorting/src/instances/num.10000.1.txt";
                break;

            case 6: filePath = "C:/Users/Laura/Documents/Java/Sorting/src/instances/num.10000.2.txt";
                break;

            case 7: filePath = "C:/Users/Laura/Documents/Java/Sorting/src/instances/num.10000.3.txt";
                break;

            case 8: filePath = "C:/Users/Laura/Documents/Java/Sorting/src/instances/num.10000.4.txt";
                break;

            case 9: filePath = "C:/Users/Laura/Documents/Java/Sorting/src/instances/num.100000.1.txt";
                break;

            case 10: filePath = "C:/Users/Laura/Documents/Java/Sorting/src/instances/num.100000.2.txt";
                break;

            case 11: filePath = "C:/Users/Laura/Documents/Java/Sorting/src/instances/num.100000.3.txt";
                break;

            case 12: filePath = "C:/Users/Laura/Documents/Java/Sorting/src/instances/num.100000.4.txt";
                break;
        }

        try {

            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            scanner.close();

            long startTime, endTime;
            double elapsedTime;

            // Selection Sort
            startTime = System.nanoTime();
            SelectionSort.selectionSort(arr);
            endTime = System.nanoTime();
            elapsedTime = (endTime - startTime) / 1_000_000.0; // Execution time in milliseconds
            System.out.println("Selection Sort:");
            System.out.println(Arrays.toString(arr));
            System.out.println("Time: " + elapsedTime + " ms");

            // Bubble Sort
            startTime = System.nanoTime();
            BubbleSort.bubbleSort(arr);
            endTime = System.nanoTime();
            elapsedTime = (endTime - startTime) / 1_000_000.0; // Execution time in milliseconds
            System.out.println("Bubble Sort:");
            System.out.println(Arrays.toString(arr));
            System.out.println("Time: " + elapsedTime + " ms");

            // Insertion Sort
            startTime = System.nanoTime();
            InsertionSort.insertionSort(arr);
            endTime = System.nanoTime();
            elapsedTime = (endTime - startTime) / 1_000_000.0; // Execution time in milliseconds
            System.out.println("Insertion Sort:");
            System.out.println(Arrays.toString(arr));
            System.out.println("Time: " + elapsedTime + " ms");

            // Merge Sort
            startTime = System.nanoTime();
            MergeSort.mergeSort(arr, 0, arr.length - 1);
            endTime = System.nanoTime();
            elapsedTime = (endTime - startTime) / 1_000_000.0; // Execution time in milliseconds
            System.out.println("Merge Sort:");
            System.out.println(Arrays.toString(arr));
            System.out.println("Time: " + elapsedTime + " ms");

            // Quick Sort
            startTime = System.nanoTime();
            QuickSort.quickSort(arr, 0, arr.length - 1);
            endTime = System.nanoTime();
            elapsedTime = (endTime - startTime) / 1_000_000.0; // Execution time in milliseconds
            System.out.println("Quick Sort:");
            System.out.println(Arrays.toString(arr));
            System.out.println("Time: " + elapsedTime + " ms");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}