import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Dimension;

public class Main {
    public static void main(String[] args) {
        String[] choices = {
                " 1000.1",
                " 1000.2",
                " 1000.3",
                " 1000.4",
                " 10000.1",
                " 10000.2",
                " 10000.3",
                " 10000.4",
                " 100000.1",
                " 100000.2",
                " 100000.3",
                " 100000.4"
        };

        int choice = JOptionPane.showOptionDialog(null, "Choose the file to be sorted:", "File Selection",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, choices, choices[0]);

        String filePath = null;

        switch (choice) {
            case 0:
                filePath = "C:/Users/Laura/Documents/Java/Sorting/src/instances/num.1000.1.txt";
                break;
            case 1:
                filePath = "C:/Users/Laura/Documents/Java/Sorting/src/instances/num.1000.2.txt";
                break;
            case 2:
                filePath = "C:/Users/Laura/Documents/Java/Sorting/src/instances/num.1000.3.txt";
                break;
            case 3:
                filePath = "C:/Users/Laura/Documents/Java/Sorting/src/instances/num.1000.4.txt";
                break;
            case 4:
                filePath = "C:/Users/Laura/Documents/Java/Sorting/src/instances/num.10000.1.txt";
                break;
            case 5:
                filePath = "C:/Users/Laura/Documents/Java/Sorting/src/instances/num.10000.2.txt";
                break;
            case 6:
                filePath = "C:/Users/Laura/Documents/Java/Sorting/src/instances/num.10000.3.txt";
                break;
            case 7:
                filePath = "C:/Users/Laura/Documents/Java/Sorting/src/instances/num.10000.4.txt";
                break;
            case 8:
                filePath = "C:/Users/Laura/Documents/Java/Sorting/src/instances/num.100000.1.txt";
                break;
            case 9:
                filePath = "C:/Users/Laura/Documents/Java/Sorting/src/instances/num.100000.2.txt";
                break;
            case 10:
                filePath = "C:/Users/Laura/Documents/Java/Sorting/src/instances/num.100000.3.txt";
                break;
            case 11:
                filePath = "C:/Users/Laura/Documents/Java/Sorting/src/instances/num.100000.4.txt";
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

            List<String> results = new ArrayList<>();

            long startTime, endTime;
            double elapsedTime;

            // Selection Sort
            startTime = System.nanoTime();
            SelectionSort.selectionSort(arr);
            endTime = System.nanoTime();
            elapsedTime = (endTime - startTime) / 1_000_000.0; // Execution time in milliseconds
            results.add("Selection Sort:\n" + Arrays.toString(arr) + "\nTime: " + elapsedTime + " ms");

            // Bubble Sort
            startTime = System.nanoTime();
            BubbleSort.bubbleSort(arr);
            endTime = System.nanoTime();
            elapsedTime = (endTime - startTime) / 1_000_000.0; // Execution time in milliseconds
            results.add("Bubble Sort:\n" + Arrays.toString(arr) + "\nTime: " + elapsedTime + " ms");

            // Insertion Sort
            startTime = System.nanoTime();
            InsertionSort.insertionSort(arr);
            endTime = System.nanoTime();
            elapsedTime = (endTime - startTime) / 1_000_000.0; // Execution time in milliseconds
            results.add("Insertion Sort:\n" + Arrays.toString(arr) + "\nTime: " + elapsedTime + " ms");

            // Merge Sort
            startTime = System.nanoTime();
            MergeSort.mergeSort(arr, 0, arr.length - 1);
            endTime = System.nanoTime();
            elapsedTime = (endTime - startTime) / 1_000_000.0; // Execution time in milliseconds
            results.add("Merge Sort:\n" + Arrays.toString(arr) + "\nTime: " + elapsedTime + " ms");

            // Quick Sort
            startTime = System.nanoTime();
            QuickSort.quickSort(arr, 0, arr.length - 1);
            endTime = System.nanoTime();
            elapsedTime = (endTime - startTime) / 1_000_000.0; // Execution time in milliseconds
            results.add("Quick Sort:\n" + Arrays.toString(arr) + "\nTime: " + elapsedTime + " ms");

            int currentIndex = 0;
            int option;
            do {
                JTextArea textArea = new JTextArea(results.get(currentIndex));
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

                scrollPane.setPreferredSize(new Dimension(800, 400));

                option = JOptionPane.showOptionDialog(null, scrollPane, "Sorting Results",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                        new String[]{"Previous", "Next", "Close"}, "Next");

                if (option == 0 && currentIndex > 0) {
                    currentIndex--;
                } else if (option == 1 && currentIndex < results.size() - 1) {
                    currentIndex++;
                }
            } while (option == 0 || option == 1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
