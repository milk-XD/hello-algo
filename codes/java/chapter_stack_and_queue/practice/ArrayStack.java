package chapter_stack_and_queue.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayStack {

    private final List<Integer> stack;

    public ArrayStack() {
        stack = new ArrayList<>();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(int val) {
        stack.add(val);
    }

    public int pop() {
        return stack.remove(size() - 1);
    }

    public int peek() {
        if (size() == 0) {
            throw new IndexOutOfBoundsException();
        }

        return stack.get(size() - 1);
    }

    public Object[] toArray() {
        return stack.toArray();
    }

}

class ArrayStackTest {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
        System.out.println("Size: " + stack.size());
        System.out.println("Empty: " + stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(Arrays.toString(stack.toArray()));
        System.out.println("Peek: " + stack.peek());
        stack.pop();
        stack.pop();
        System.out.println(Arrays.toString(stack.toArray()));
    }

}