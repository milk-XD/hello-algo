package chapter_hashing.practice;

import utils.Pair;

import java.util.ArrayList;
import java.util.List;

class HashMapChaining {

    private List<List<Pair>> map;
    private int size;
    private int capacity;
    private static final int EXTEND_RATIO = 2;
    private static final double LOAD_THRES = 2.0 / 3.0;

    public HashMapChaining() {
        capacity = 5;
        map = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            map.add(new ArrayList<>());
        }
    }

    public int capacity() {
        return capacity;
    }

    public void put(int key, String val) {
        if (loadFactor() > LOAD_THRES) {
            extend();
        }

        Pair pair = new Pair(key, val);
        List<Pair> buckets = map.get(hash(key));
        for (int i = 0; i < buckets.size(); i++) {
            Pair bucket = buckets.get(i);
            if (bucket.key == key) {
                buckets.add(i, pair);
                return;
            }
        }
        buckets.add(pair);
        size++;
    }

    public String get(int key) {
        List<Pair> buckets = map.get(hash(key));
        for (Pair bucket : buckets) {
            if (bucket.key == key) {
                return bucket.value;
            }
        }
        return null;
    }

    public void remove(int key) {
        List<Pair> buckets = map.get(hash(key));
        for (Pair bucket : buckets) {
            if (bucket.key == key) {
                buckets.remove(bucket);
                size--;
                return;
            }
        }
    }

    public void extend() {
        List<List<Pair>> old = map;
        capacity *= EXTEND_RATIO;
        map = new ArrayList<>(capacity);

        for (int i = 0; i < capacity; i++) {
            map.add(new ArrayList<>());
        }

        for (List<Pair> buckets : old) {
            for (Pair bucket : buckets) {
                put(bucket.key, bucket.value);
            }
        }
    }

    public int hash(int key) {
        return key % capacity;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (List<Pair> buckets : map) {
            for (Pair bucket : buckets) {
                sb.append("{ ").append(bucket.key).append(" -> ").append(bucket.value).append(" }\n");
            }
        }
        return sb.toString();
    }

    private double loadFactor() {
        return (double) size / capacity;
    }

}

public class HashMapChainingTest {

    public static void main(String[] args) {
        HashMapChaining map = new HashMapChaining();
        map.put(1, "Apple");
        map.put(2, "Banana");
        System.out.println("Capacity: " + map.capacity());
        map.put(3, "Cat");
        map.put(4, "Dog");
        map.put(5, "Egg");
        System.out.println("Capacity: " + map.capacity());
        System.out.println("Map: " + map);
        System.out.println("Map 3: " + map.get(3));
        map.remove(4);
        System.out.println("Map: " + map);
    }

}
