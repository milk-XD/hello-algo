package chapter_stack_and_queue.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ArrayQueue {

    private final List<Integer> list;

    public ArrayQueue() {
        list = new ArrayList<>();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(int val) {
        list.add(val);
    }

    public int pop() {
        int val = peek();
        list.remove(0);
        return val;
    }

    public int peek() {
        if (size() == 0) {
            throw new IndexOutOfBoundsException();
        }

        return list.get(0);
    }

    public Object[] toArray() {
        return list.toArray();
    }

}

class ArrayQueueTest {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        System.out.println("Size: " + queue.size());
        System.out.println("Empty: " + queue.isEmpty());
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(Arrays.toString(queue.toArray()));
        System.out.println("Peek: " + queue.peek());
        queue.pop();
        queue.pop();
        System.out.println(Arrays.toString(queue.toArray()));
    }

}