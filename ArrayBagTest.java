// import java.util.Arrays;

public class ArrayBagTest
{
    public static void main(String[] args) 
    {
        ResizableArrayBag<String> bagOne = new ResizableArrayBag<>();
        String[] bagOneContents = {"a", "b", "c"};
        bagOne.add(bagOneContents);
        
        ResizableArrayBag<String> bagTwo = new ResizableArrayBag<>();
        String[] bagTwoContents = {"b", "b", "d", "e"};
        bagTwo.add(bagTwoContents);

        BagInterface<String> everything = bagOne.union(bagTwo);
        everything.displayBag();

        BagInterface<String> commonItems = bagTwo.intersection(bagOne);
        commonItems.displayBag();
        
        BagInterface<String> leftOver1 = bagOne.difference(bagTwo);
        leftOver1.displayBag();

        BagInterface<String> leftOver2 = bagTwo.difference(bagOne);
        leftOver2.displayBag();
    }
}