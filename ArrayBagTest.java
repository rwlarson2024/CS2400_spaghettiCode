// import java.util.Arrays;

public class ArrayBagTest
{
    public static void main(String[] args) 
    {
        BagInterface<String> bagOne = new ResizableArrayBag<>();
        String[] bagOneContents = {"a", "b", "c"};
        System.out.println("Testing the getBag Method");
        bagOne.getBag();
        System.out.println("Testing the getIntegrityOK Method");
        bagOne.getIntegrityOK();
        System.out.println("Testing the getCurrentSize Method");
        bagOne.getCurrentSize();
        System.out.println("Testing the isEmpty Method with the contents of the bag");
        bagOne.isEmpty();
        System.out.println("Testing the isFull Method");
        bagOne.isFull();
        System.out.println("Testing the add Method");
        bagOne.add("d");
        System.out.println();
        bagOne.getBag();
        System.out.println("Testing the doubleCapacity Method");
        bagOne.doubleCapacity();
        

        bagOne.add(bagOneContents);
        
    }
}