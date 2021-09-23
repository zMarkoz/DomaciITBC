import java.util.Stack;

public class StringReverser {
    public String reverse(String input) {
        if (input==null)
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray())
            stack.push(ch);

        StringBuffer rvsd = new StringBuffer();
        while (!stack.empty())
            rvsd.append(stack.pop());
        return rvsd.toString();


    }
}
