<<<<<<< HEAD
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
        outputFile.println();
        outputFile.print("Number of swaps in the heap creation: ");
        outputFile.println();
        outputFile.print("Heap after 10 removals: ");

        outputFile.println("\n");
        
        outputFile.print("Heap built using optimal method: ");
        outputFile.println();
        outputFile.print("Number of swaps in the heap creation: ");
        outputFile.println();
        outputFile.print("Heap after 10 removals: ");

        inputFile.close();
        outputFile.close();
    }
=======
public class DriverMH
{
    public static void main(String[] args)
        {

        }
             /**File creator for the output from the methods */
        public class FileWriter()
        {
            try
            {
                File outWriteFile = new File("outWriteFile.txt");
                if(outWriteFile.createNewFile())
                {
                    System.out.println("File created: " + outWriteFile.getName());
                }
                else
                {
                    System.out.println("File already exists.");
                }
            
            }
            catch (IOException e)
            {
                System.out.println("An error has ocurred...");
                e.printStackTrace();
            } 
        }
        /** Method to write the output into a seperate file  */
        public class WriteToFile()
        {
            try
            {
                FileWriter writer = new FileWriter("outWriteFile.txt");
                writer.write();
                writer.close();
            }
            catch(IOException e)
            {
                System.out.println("An error has ocurred...");
                e.printStackTrace();
            }
        }
>>>>>>> 447cc7d94b614eece2b1bebd9da39b94588c2684
}