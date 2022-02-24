public class bagDriver
{
    public static void main(String[] args) 
    {
        BagInterface<String> bagOne = new ResizableArrayBag<>();
        String[] bagOneContents = {"a", "b", "c"};
        bagOne.add(bagOneContents);
        
        BagInterface<String> bagTwo = new ResizableArrayBag<>();
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

        BagInterface<String> bagThree = new LinkedBag<>();
        String[] bagThreeContents = {"a", "b", "c"};
        bagOne.add(bagThreeContents);
            
        BagInterface<String> bagFour = new LinkedBag<>();
        String[] bagFourContents = {"b", "b", "d", "e"};
        bagTwo.add(bagFourContents);
    
        everything = bagThree.union(bagFour);
        everything.displayBag();
    
        commonItems = bagThree.intersection(bagFour);
        commonItems.displayBag();
            
        leftOver1 = bagThree.difference(bagFour);
        leftOver1.displayBag();
    
        leftOver2 = bagFour.difference(bagThree);
        leftOver2.displayBag();
    }
}
