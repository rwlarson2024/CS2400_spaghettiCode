public class Calculator 
{
    public static void main(String[] args)
    {
        LinkedStack<String> stackOne = new LinkedStack<>();
        String infix = "a*b/(c-a)+d*e";

        String postfix = stackOne.convertToPostfix(infix);
        System.out.println(postfix); // ab*ca-/de*+

        ResizableArrayStack<String> stackTwo = new ResizableArrayStack<>();

        int evaluation = stackTwo.evaluatePostfix(postfix);
        System.out.println(evaluation); // 33
    }
}
