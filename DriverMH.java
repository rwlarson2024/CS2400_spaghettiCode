import java.io.PrintWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DriverMH
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("data_sorted.txt");
        Scanner inputFile = new Scanner(file);

        FileWriter fwriter = new FileWriter("output.txt");
        PrintWriter outputFile = new PrintWriter(fwriter);

        MaxHeap<Integer> heapOne = new MaxHeap<>(100);
        while (inputFile.hasNext())
        {
            heapOne.add(inputFile.nextInt());
        }

        outputFile.print("Heap built using sequential insertions: ");
        Integer[] heapOneArray = heapOne.getArray();
        for (int i = 1; i <= 10; i++)
        {
            outputFile.print(heapOneArray[i] + " ");
        }
        outputFile.println();
        outputFile.print("Number of swaps in the heap creation: " + heapOne.getSwapCount());
        outputFile.println();
        outputFile.print("Heap after 10 removals: ");
        for (int i = 1; i <= 10; i++)
        {
            heapOne.removeMax();
        }
        heapOneArray = heapOne.getArray();
        for (int i = 1; i <= 10; i++)
        {
            outputFile.print(heapOneArray[i] + " ");
        }
    
        inputFile.close();
        outputFile.println("\n");
        inputFile = new Scanner(file);

        Integer[] tempArray = new Integer[100];
        int j = 0;
        while (inputFile.hasNext())
        {
            tempArray[j] = inputFile.nextInt();
            j++;
        }
        MaxHeap<Integer> heapTwo = new MaxHeap<>(tempArray);  
        outputFile.print("Heap built using optimal method: ");
        Integer[] heapTwoArray = heapTwo.getArray();
        for (int i = 1; i <= 10; i++)
        {
            outputFile.print(heapTwoArray[i] + " ");
        }
        outputFile.println();
        outputFile.print("Number of swaps in the heap creation: " + heapTwo.getSwapCount());
        outputFile.println();
        outputFile.print("Heap after 10 removals: ");
        for (int i = 1; i <= 10; i++)
        {
            heapTwo.removeMax();
        }
        heapTwoArray = heapTwo.getArray();
        for (int i = 1; i <= 10; i++)
        {
            outputFile.print(heapTwoArray[i] + " ");
        }

        System.out.print("Output printed in output.txt");

        inputFile.close();
        outputFile.close();
    }
}