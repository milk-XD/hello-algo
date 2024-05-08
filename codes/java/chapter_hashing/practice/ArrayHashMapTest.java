package chapter_hashing.practice;

import java.util.ArrayList;
import java.util.List;

class Pair {
    int key;
    String value;

    public Pair(int key, String value) {
        this.key = key;
        this.value = value;
    }
}

class ArrayHashMap {
    private final List<Pair> map;
    private static final int CAPACITY = 100;

    public ArrayHashMap() {
        map = new ArrayList<>(CAPACITY);
        for (int i = 0; i < CAPACITY; i++) {
            map.add(null);
        }
    }

    public void add(int key, String value) {
        Pair pair = new Pair(key, value);
        map.add(hash(key), pair);
    }

    public String get(int key) {
        Pair pair = map.get(hash(key));
        return pair == null ? null : pair.value;
    }

    public int hash(int key) {
        return key % CAPACITY;
    }

}

public class ArrayHashMapTest {

    public static void main(String[] args) {
        ArrayHashMap map = new ArrayHashMap();
        map.add(1, "Apple");
        map.add(2, "Banana");
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));
        System.out.println(map.hash(150));
    }

}
