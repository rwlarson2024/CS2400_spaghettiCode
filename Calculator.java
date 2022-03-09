public class Calculator 
{
    public static void main(String[] args)
    {
        StackInterface<String> stack = new ResizableArrayStack<>();
        stack.push("a+b");
        System.out.print(stack.peek());
        stack.pop();
        System.out.print(stack.peek());
        stack.pop();
        System.out.print(stack.peek());
    }
}
