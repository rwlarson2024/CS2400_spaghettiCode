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
}