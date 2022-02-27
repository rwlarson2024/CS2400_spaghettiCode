/** Driver code for implementing the union, intersection, and difference methods. */
public class bagDriver
{
    public static void main(String[] args) 
    {
        /** Creates a resizable array bag, adds contents, and displays it. */
        BagInterface<String> bagOne = new ResizableArrayBag<>();
        String[] bagOneContents = {"a", "b", "c"};
        bagOne.add(bagOneContents);
        System.out.print("Array Bag One: ");
        bagOne.displayBag();
        
        /** Creates a second resizable array bag, adds contents, and displays it. */
        BagInterface<String> bagTwo = new ResizableArrayBag<>();
        String[] bagTwoContents = {"b", "b", "d", "e"};
        bagTwo.add(bagTwoContents);
        System.out.print("Array Bag Two: ");
        bagTwo.displayBag();

        /** Creates a union bag of bagOne and bagTwo and displays it. */
        BagInterface<String> everything = bagOne.union(bagTwo);
        System.out.print("Union of Bags One and Two: ");
        everything.displayBag();

        /** Creates an intersection bag of bagOne and bagTwo and displays it. */
        BagInterface<String> commonItems = bagOne.intersection(bagTwo);
        System.out.print("Intersection of Bags One and Two: ");
        commonItems.displayBag();
        
        /** Creates a difference bag of bagOne and bagTwo and displays it. */
        BagInterface<String> leftOver1 = bagOne.difference(bagTwo);
        System.out.print("Difference of Bags One and Two: ");
        leftOver1.displayBag();

        /** Creates a difference bag of bagTwo and bagOne and displays it. */
        BagInterface<String> leftOver2 = bagTwo.difference(bagOne);
        System.out.print("Difference of Bags Two and One: ");
        leftOver2.displayBag();

        System.out.println();

        /** Creates a linked bag, adds contents, and displays it. */
        BagInterface<String> bagThree = new LinkedBag<>();
        String[] bagThreeContents = {"h", "e", "l", "l", "o"};
        bagThree.add(bagThreeContents);
        System.out.print("Linked Bag Three: ");
        bagThree.displayBag();
        
        /** Creates a second linked bag, adds contents, and displays it. */
        BagInterface<String> bagFour = new LinkedBag<>();
        String[] bagFourContents = {"w", "o", "r", "l", "d"};
        bagFour.add(bagFourContents);
        System.out.print("Linked Bag Four: ");
        bagFour.displayBag();
    
        /** Creates a union bag of bagThree and bagFour and displays it. */
        everything = bagThree.union(bagFour);
        System.out.print("Union of Bags Three and Four: ");
        everything.displayBag();
    
        /** Creates an intersection bag of bagThree and bagFour and displays it. */
        commonItems = bagThree.intersection(bagFour);
        System.out.print("Intersection of Bags Three and Four: ");
        commonItems.displayBag();
            
        /** Creates a difference bag of bagThree and bagFour and displays it. */
        leftOver1 = bagThree.difference(bagFour);
        System.out.print("Difference of Bags Three and Four: ");
        leftOver1.displayBag();
    
        /** Creates a difference bag of bagFour and bagThree and displays it. */
        leftOver2 = bagFour.difference(bagThree);
        System.out.print("Difference of Bags Four and Three: ");
        leftOver2.displayBag();
    }
}
