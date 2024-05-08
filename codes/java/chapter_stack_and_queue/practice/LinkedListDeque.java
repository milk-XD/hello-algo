package chapter_stack_and_queue.practice;

import utils.DeListNode;

import java.util.Arrays;

public class LinkedListDeque {

    private DeListNode head;
    private DeListNode tail;
    private int size;

    public LinkedListDeque() {
        head = null;
        tail = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void pushFirst(int val) {
        DeListNode node = new DeListNode(val);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
        size++;
    }

    public void pushLast(int val) {
        DeListNode node = new DeListNode(val);
        if (isEmpty()) {
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
        size++;
    }

    public int popFirst() {
        int val = peekFirst();
        DeListNode node = head.next;
        if (node != null) {
            node.prev = null;
        }
        head = node;
        size--;
        return val;
    }

    public int popLast() {
        int val = peekLast();
        DeListNode node = tail.prev;
        if (node != null) {
            node.next = null;
        }
        tail = node;
        size--;
        return val;
    }

    public int peekFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return head.val;
    }

    public int peekLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return tail.val;
    }

    public int[] toArray() {
        DeListNode cur = head;
        int[] res = new int[size()];
        for (int i = 0; i < size(); i++) {
            res[i] = cur.val;
            cur = cur.next;
        }
        return res;
    }

}

class LinkedListDequeTest {

    public static void main(String[] args) {
        LinkedListDeque deque = new LinkedListDeque();
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