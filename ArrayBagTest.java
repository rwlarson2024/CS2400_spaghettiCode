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
        Object[] temp = everything.toArray();
        for (int index = 0; index < temp.length; index++)
        {
            System.out.print(temp[index] + " ");
        }

        System.out.println();

        BagInterface<String> commonItems = bagTwo.intersection(bagOne);
        Object[] temp2 = commonItems.toArray();
        for (int index = 0; index < temp2.length; index++)
        {
            System.out.print(temp2[index] + " ");
        }

        System.out.println();
        
        
        BagInterface<String> leftOver1 = bagOne.difference(bagTwo);
        Object[] temp3 = leftOver1.toArray();
        for (int index = 0; index < temp3.length; index++)
        {
            System.out.print(temp3[index] + " ");
        }
        
        System.out.println();
        
        BagInterface<String> leftOver2 = bagTwo.difference(bagOne);
        Object[] temp4 = leftOver2.toArray();
        for (int index = 0; index < temp4.length; index++)
        {
            System.out.print(temp4[index] + " ");
        }
             
    }
}