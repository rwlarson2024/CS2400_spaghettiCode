public class bagDriver
{
    public static void main(String[] args) 
    {
        BagInterface<String> bagOne = new ResizableArrayBag<>();
        String[] bagOneContents = {"a", "b", "c"};
        bagOne.add(bagOneContents);
        System.out.print("Array Bag One: ");
        bagOne.displayBag();
        
        BagInterface<String> bagTwo = new ResizableArrayBag<>();
        String[] bagTwoContents = {"b", "b", "d", "e"};
        bagTwo.add(bagTwoContents);
        System.out.print("Array Bag Two: ");
        bagTwo.displayBag();

        BagInterface<String> everything = bagOne.union(bagTwo);
        System.out.print("Union of Bags One and Two: ");
        everything.displayBag();

        BagInterface<String> commonItems = bagOne.intersection(bagTwo);
        System.out.print("Intersection of Bags One and Two: ");
        commonItems.displayBag();
        
        BagInterface<String> leftOver1 = bagOne.difference(bagTwo);
        System.out.print("Difference of Bags One and Two: ");
        leftOver1.displayBag();

        BagInterface<String> leftOver2 = bagTwo.difference(bagOne);
        System.out.print("Difference of Bags Two and One: ");
        leftOver2.displayBag();

        System.out.println();

        BagInterface<String> bagThree = new LinkedBag<>();
        String[] bagThreeContents = {"a", "b", "c"};
        bagThree.add(bagThreeContents);
        System.out.print("Linked Bag Three: ");
        bagThree.displayBag();
            
        BagInterface<String> bagFour = new LinkedBag<>();
        String[] bagFourContents = {"b", "b", "d", "e"};
        bagFour.add(bagFourContents);
        System.out.print("Linked Bag Four: ");
        bagFour.displayBag();
    
        everything = bagThree.union(bagFour);
        System.out.print("Union of Bags Three and Four: ");
        everything.displayBag();
    
        commonItems = bagThree.intersection(bagFour);
        System.out.print("Intersection of Bags Three and Four: ");
        commonItems.displayBag();
            
        leftOver1 = bagThree.difference(bagFour);
        System.out.print("Difference of Bags Three and Four: ");
        leftOver1.displayBag();
    
        leftOver2 = bagFour.difference(bagThree);
        System.out.print("Difference of Bags Four and Three: ");
        leftOver2.displayBag();
    }
}
