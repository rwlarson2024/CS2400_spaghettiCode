public class Calculator 
{
    public static void main(String[] args)
    {
        ResizableArrayStack<String> stack = new ResizableArrayStack<>();

        System.out.println(stack.convertToPostfix("a*b+c")); // ab*c+
        System.out.println(stack.convertToPostfix("a+b*c")); // abc*+
        System.out.println(stack.convertToPostfix("a*(b+c)")); // abc+*
        
        System.out.println(stack.convertToPostfix("a*b/(c-a)+d*e")); // ab*ca-/de*+
    }
}
