package chapter_stack_and_queue.practice;

import utils.ListNode;

import java.util.Arrays;

class LinkedListQueue {

    private ListNode head;
    private ListNode tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(int val) {
        ListNode cur = new ListNode(val);
        if (head == null) {
            head = cur;
        } else {
            tail.next = cur;
        }
        tail = cur;
        size++;
    }

    public int pop() {
        int val = peek();
        head = head.next;
        size--;
        return val;
    }

    public int peek() {
        if (size() == 0) {
            throw new IndexOutOfBoundsException();
        }

        return head.val;
    }

    public int[] toArray() {
        ListNode cur = head;
        int[] res = new int[size()];

        for (int i = 0; i < size(); i++) {
            res[i] = cur.val;
            cur = cur.next;
        }

        return res;
    }

}

class LinkedListQueueTest {

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
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