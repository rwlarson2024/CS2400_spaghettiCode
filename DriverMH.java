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

        File fileRand = new File("data_random.txt");
        inputFile = new Scanner(fileRand);



        MaxHeap<Integer> heapRand = new MaxHeap<>(100);
        while (inputFile.hasNext())
        {
            heapRand.add(inputFile.nextInt());
        }

        outputFile.print("Heap built using sequential insertions: ");
        Integer[] heapRandArray = heapRand.getArray();
        for (int i = 1; i <= 10; i++)
        {
            outputFile.print(heapRandArray[i] + " ");
        }
        outputFile.println();
        outputFile.print("Number of swaps in the heap creation: " + heapRand.getSwapCount());
        outputFile.println();
        outputFile.print("Heap after 10 removals: ");
        for (int i = 1; i <= 10; i++)
        {
            heapRand.removeMax();
        }
        heapRandArray = heapRand.getArray();
        for (int i = 1; i <= 10; i++)
        {
            outputFile.print(heapRandArray[i] + " ");
        }
    
        inputFile.close();
        outputFile.println("\n");
        inputFile = new Scanner(fileRand);

        Integer[] tempRandArray = new Integer[100];
        int k = 0;
        while (inputFile.hasNext())
        {
            tempRandArray[j] = inputFile.nextInt();
            k++;
        }
        MaxHeap<Integer> heapRandTwo = new MaxHeap<>(tempRandArray);  
        outputFile.print("Heap built using optimal method: ");
        Integer[] heapRandTwoArray = heapTwo.getArray();
        for (int i = 1; i <= 10; i++)
        {
            outputFile.print(heapRandTwoArray[i] + " ");
        }
        outputFile.println();
        outputFile.print("Number of swaps in the heap creation: " + heapRandTwo.getSwapCount());
        outputFile.println();
        outputFile.print("Heap after 10 removals: ");
        for (int i = 1; i <= 10; i++)
        {
            heapRandTwo.removeMax();
        }
        heapRandTwoArray = heapRandTwo.getArray();
        for (int i = 1; i <= 10; i++)
        {
            outputFile.print(heapTwoArray[i] + " ");
        }

        System.out.print("Output printed in output.txt");


        inputFile.close();
        outputFile.close();
    }
}