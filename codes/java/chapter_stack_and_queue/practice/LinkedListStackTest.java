package chapter_stack_and_queue.practice;

import utils.ListNode;

import java.util.Arrays;

class LinkedListStack {

    private ListNode head;
    private int size;

    public LinkedListStack() {
        head = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public int pop() {
        int val = peek();
        head = head.next;
        size--;
        return val;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return head.val;
    }

    public int[] toArray() {
        ListNode cur = head;
        int[] res = new int[size()];
        for (int i = size() - 1; i >= 0; i--) {
            res[i] = cur.val;
            cur = cur.next;
        }
        return res;
    }

}

class LinkedListStackTest {

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
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