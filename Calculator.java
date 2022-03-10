public class Calculator 
{
    public static void main(String[] args)
    {
        ResizableArrayStack<String> stack = new ResizableArrayStack<>();
        System.out.println(stack.convertToPostfix("a*b+c"));
        System.out.println(stack.convertToPostfix("a+b*c"));
        System.out.println(stack.convertToPostfix("a*(b+c)")); // Need debugging
    }
}
