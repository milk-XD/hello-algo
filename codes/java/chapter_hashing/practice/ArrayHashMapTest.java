package chapter_hashing.practice;

import utils.Pair;

import java.util.ArrayList;
import java.util.List;

class ArrayHashMap {
    private final List<Pair> map;
    private static final int CAPACITY = 100;

    public ArrayHashMap() {
        map = new ArrayList<>(CAPACITY);
        for (int i = 0; i < CAPACITY; i++) {
            map.add(null);
        }
    }

    public void put(int key, String value) {
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
        map.put(1, "Apple");
        map.put(2, "Banana");
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));
        System.out.println(map.hash(150));
    }

}
