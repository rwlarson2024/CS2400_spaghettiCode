//Commiting on 2/22/2022
public class LinkedBagTest 
{
    public static void main(String[] args) 
    {
        LinkedBag<String> bagOne = new LinkedBag<>();
        String[] bagOneContents = {"a", "b", "c"};
        bagOne.add(bagOneContents);
            
        LinkedBag<String> bagTwo = new LinkedBag<>();
        String[] bagTwoContents = {"b", "b", "d", "e"};
        bagTwo.add(bagTwoContents);
    
        BagInterface<String> everything = bagOne.union(bagTwo);
        everything.displayBag();
    
        BagInterface<String> commonItems = bagOne.intersection(bagTwo);
        commonItems.displayBag();
            
        BagInterface<String> leftOver1 = bagOne.difference(bagTwo);
        leftOver1.displayBag();
    
        BagInterface<String> leftOver2 = bagTwo.difference(bagOne);
        leftOver2.displayBag();
    }    
}