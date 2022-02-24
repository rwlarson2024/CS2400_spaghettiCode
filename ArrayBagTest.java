// import java.util.Arrays;

public class ArrayBagTest
{
    public static void main(String[] args) 
    {
        BagInterface<String> bagOne = new ResizableArrayBag<>(4);
        String[] bagOneContents = {"a", "b", "c"};
        bagOne.add(bagOneContents);
        System.out.println("Displaying bag");
        bagOne.displayBag();

        System.out.println("Testing the getCurrentSize Method");
        System.out.println(bagOne.getCurrentSize());
        System.out.println("Testing the isEmpty Method with the contents of the bag");
        System.out.println(bagOne.isEmpty());
        System.out.println("Testing the add Method, adding 'd'");
        bagOne.add("d");
        System.out.println("Displaying bag");
        bagOne.displayBag();
        System.out.println("Testing the isFull Method");
        System.out.println(((ResizableArrayBag<String>) bagOne).isFull());
    }
}