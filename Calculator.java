public class Calculator 
{
    public static void main(String[] args)
    {
        LinkedStack<String> stackOne = new LinkedStack<>();

        String infix = "a*b/(c-a)+d*e"; // Changeable
        System.out.println("Infix: " + infix);

        String postfix = stackOne.convertToPostfix(infix);
        System.out.println("Postfix: " + postfix); // ab*ca-/de*+

        ResizableArrayStack<String> stackTwo = new ResizableArrayStack<>();

        // a=2 b=3 c=4 d=5 e=6
        int evaluation = stackTwo.evaluatePostfix(postfix);
        System.out.println("Evaluation of postfix: " + evaluation); // 33
    }
}
