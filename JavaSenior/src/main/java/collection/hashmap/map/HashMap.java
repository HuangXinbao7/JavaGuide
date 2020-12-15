package org.example.collection.hashmap.map;

/**
 * HashMap的模拟实现
 * @author: Ming
 * Date: Created on 2020/9/24 1:38
 */
public class HashMap<K, V> implements Map<K, V> {
    Entry<K, V> table[] = null;
    int size = 0;

    public HashMap() {
        table = new Entry[16];
    }

    /**
     * 1、hash => hashCode => 取模
     * 2、拿到下标值，对应Entry数组去找当前下标值
     * 3、如果为空，直接存储 => 数组
     * 4、如果不为空，用链表
     * @param k
     * @param v
     */
    @Override
    public V put(K k, V v) {
        //
        int index = hash(k);
        Entry<K, V> kvEntry = table[index];

        if (null == kvEntry) {
            table[index] = new Entry<>(k, v, index, null);
            size++;
        } else {
            table[index] = new Entry<>(k, v, index, kvEntry);
        }
        return null;
    }


    /**
     * 获取 key 的hash值
     * @param k
     */
    private int hash(K k) {
        int i = k.hashCode() % 16;
        return Math.abs(i);
    }


    /**
     * 1、k 去 hash
     * 2、数组下标
     * 3、当前下标和查找的下标是否相等
     * 4、相等时，直接返回，说明查找到
     * 5、不相等时，判断当前next是否为空
     * 6、为空直接返回null，相等不为空，直接返回
     *
     * @param k
     */
    @Override
    public V get(K k) {
        int index = hash(k);
        Entry<K, V> kvEntry = table[index];

        if (null == kvEntry) {
            return null;
        }
        return findValue(k, kvEntry);
    }


    /**
     * 查找值的方法
     * @param k
     * @param entry
     */
    private V findValue(K k, Entry<K, V> entry) {
        if (k == entry.getKey() || k.equals(entry.getKey())) {
            return entry.getValue();
        } else {
            if (entry.next != null) {
                return findValue(k, entry.next);
            }
        }
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    /**
     * 静态内部类 Entry
     * @param <K>
     * @param <V>
     */
    static class Entry<K, V> implements Map.Entry<K, V> {
        K k;
        V v;
        int hash;
        Entry<K, V> next;

        public Entry(K k, V v, int hash, Entry<K, V> next) {
            this.k = k;
            this.v = v;
            this.hash = hash;
            this.next = next;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }
}
