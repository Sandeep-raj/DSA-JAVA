package stack_queues.implementation;

import java.util.Hashtable;

import stack_queues.learning.DoublyLinkedlist;
import stack_queues.learning.DoublyLinkedlist.Node;

/*
 * Implement LRU Cache
 * 
 * “Design a data structure that follows the constraints of Least Recently Used (LRU) cache”.
 * 
 * Implement the LRUCache class:

LRUCache(int capacity) we need to initialize the LRU cache with positive size capacity.
int get(int key) returns the value of the key if the key exists, otherwise return -1.
Void put(int key,int value), Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache.if the number of keys exceeds the capacity from this operation, evict the least recently used key.


Example:

Input:
 ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
       [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]

Output:
 [null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation:

LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
 */

public class LRUCache {
    /**
     * LRU
     */
    static class LRU {
        private int size;
        private DoublyLinkedlist.DLL dll;
        private Hashtable<Integer, DoublyLinkedlist.Node> hashmap;

        public LRU(int size) {
            this.dll = new DoublyLinkedlist.DLL(size);
            this.hashmap = new Hashtable<Integer, DoublyLinkedlist.Node>();
            this.size = size;
        }

        public int Get(int key) {
            if (this.hashmap.containsKey(key)) {
                DoublyLinkedlist.Node node = this.hashmap.get(key);
                this.dll.Remove(node);

                this.dll.InsertNode(node);

                return node.GetValue();
            } else {
                return -1;
            }
        }

        public void Put(int key, int value) {
            if (this.hashmap.containsKey(key)) {
                DoublyLinkedlist.Node node = this.hashmap.get(key);
                this.dll.Remove(node);

                this.dll.InsertNode(node);
            } else {
                DoublyLinkedlist.Node node = new Node(key, value);
                if (this.dll.Size() == this.size) {
                    Node lastnode = this.dll.peekLast();
                    if (lastnode != null) {
                        this.dll.Remove(lastnode);
                        this.hashmap.remove(lastnode.GetKey());
                    }
                }

                this.dll.InsertNode(node);
                this.hashmap.put(key, node);
            }
        }
    }

    public static void test() {
        LRU lrucache = new LRU(2);
        lrucache.Put(1, 1);
        lrucache.Put(2, 2);
        System.out.println(lrucache.Get(1));
        lrucache.Put(3, 3);
        System.out.println(lrucache.Get(2)); // returns -1 (not found)
        lrucache.Put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lrucache.Get(1)); // return -1 (not found)
        System.out.println(lrucache.Get(3)); // return 3
        System.out.println(lrucache.Get(4)); // return 4
    }
}
