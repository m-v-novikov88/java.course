package org.example;

import java.util.Objects;

public class OwnHashMap<K, V> {
    private final static int DEFAULT_CAPACITY = 16;

    static class OwnNode<K, V> {
        private final K key;
        private V value;

        OwnNode<K, V> next;

        public OwnNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        @Override
        public final boolean equals(Object o) {
            if (o == this)
                return true;

            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            OwnNode<?, ?> ownNode = (OwnNode<?, ?>) o;
            return Objects.equals(key, ownNode.key) && Objects.equals(value, ownNode.value);
        }

        @Override
        public final String toString() {
            return key + "=" + value;
        }
    }

    private final OwnNode<K, V>[] buckets;
    private int size = 0;

    public OwnHashMap() {
        this.buckets = new OwnNode[DEFAULT_CAPACITY];
    }

    private int getBucketIndex(K key) {
        if (key == null) return 0;
        return Math.abs(key.hashCode() % buckets.length);
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        OwnNode<K, V> head = buckets[index];

        while (head != null) {
            if (head.key != null && head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;
        OwnNode<K, V> newOwnNode = new OwnNode<>(key, value);
        newOwnNode.next = buckets[index];
        buckets[index] = newOwnNode;
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        OwnNode<K, V> head = buckets[index];

        while (head != null) {
            if (head.key != null && head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V remove(K key) {
        int index = getBucketIndex(key);
        OwnNode<K, V> head = buckets[index];
        OwnNode<K, V> prev = null;

        while (head != null) {
            if (head.key != null && head.key.equals(key)) {
                if (prev != null) {
                    prev.next = head.next;
                } else {
                    buckets[index] = head.next;
                }
                size--;
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }

    public int size() {
        return this.size;
    }

    @Override
    public final int hashCode() {
        int hashCode = 0;

        for (OwnNode<K, V> bucketCellHead : buckets) {
            OwnNode<K, V> currentHead = bucketCellHead;
            while (currentHead != null) {
                hashCode += currentHead.hashCode();
                currentHead = currentHead.next;
            }
        }

        return hashCode;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OwnHashMap ownHashMap = (OwnHashMap) o;
        if (this.size != ownHashMap.size) return false;

        for (OwnNode<K, V> bucketCellHead : buckets) {
            OwnNode<K, V> currentHead = bucketCellHead;
            while (currentHead != null) {
                Object value = ownHashMap.get(currentHead.key);
                if (value == null && currentHead.value != null) return false;
                if (!Objects.equals(currentHead.value, value)) return false;

                currentHead = currentHead.next;
            }
        }

        return true;
    }

    @Override
    public final String toString() {
        StringBuilder builder = new StringBuilder();

        for (OwnNode<K, V> bucketCellHead : buckets) {
            OwnNode<K, V> currentHead = bucketCellHead;
            while (currentHead != null) {
                builder.append(currentHead);
                currentHead = currentHead.next;
            }
        }
        return builder.toString();
    }
}
