import java.util.*;

public class Stack {

    private int[] ar;
    private int pos = -1;

    public Stack(int size) {
        ar = new int[size];
    }

    public void push(int item) {
        if (pos + 1 == ar.length) throw new StackOverflowError();
        ar[++pos] = item;
    }

    public int peek() {
        if (pos == -1) throw new EmptyStackException();
        return ar[pos];
    }

    public int pop() {
        if (pos == -1) throw new EmptyStackException();
        return ar[pos--];
    }

    public boolean isEmpty() {
        return pos  == -1;
    }

    public boolean isFull() {
        return pos + 1 == ar.length;
    }

    public static void main(String...args) {
        Stack stack = new Stack(5);
        stack.push(5);
        stack.push(3);
        System.out.println(stack.peek());
        stack.push(44);
        stack.push(144);
        stack.push(424);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }


}