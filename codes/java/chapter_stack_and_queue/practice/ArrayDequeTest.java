package chapter_stack_and_queue.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ArrayDeque {

    private List<Integer> list;

    public ArrayDeque() {
        list = new ArrayList<>();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void pushFirst(int val) {
        list.add(0, val);
    }

    public void pushLast(int val) {
        list.add(val);
    }

    public int popFirst() {
        int val = peekFirst();
        list.remove(0);
        return val;
    }

    public int popLast() {
        int val = peekLast();
        list.remove(size() - 1);
        return val;
    }

    public int peekFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return list.get(0);
    }

    public int peekLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return list.get(size() - 1);
    }

    public Object[] toArray() {
        return list.toArray();
    }

}

class ArrayDequeTest {

    public static void main(String[] args) {
        ArrayDeque deque = new ArrayDeque();
        System.out.println("Size: " + deque.size());
        System.out.println("Empty: " + deque.isEmpty());
        deque.pushFirst(2);
        deque.pushFirst(1);
        deque.pushLast(3);
        deque.pushLast(4);
        System.out.println(Arrays.toString(deque.toArray()));
        deque.popFirst();
        System.out.println(Arrays.toString(deque.toArray()));
        deque.popLast();
        System.out.println(Arrays.toString(deque.toArray()));
        System.out.println("Size: " + deque.size());
        System.out.println("Empty: " + deque.isEmpty());
    }

}