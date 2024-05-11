package stack_queues.implementation;

import java.util.Hashtable;

/*
 * LFU Cache
 * Design and implement a data structure for a Least Frequently Used (LFU) cache.

Implement the LFUCache class:

LFUCache(int capacity) Initializes the object with the capacity of the data structure.
int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.

When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.

The functions get and put must each run in O(1) average time complexity.

Example 1:

Input
["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, 3, null, -1, 3, 4]

Explanation
// cnt(x) = the use counter for key x
// cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
LFUCache lfu = new LFUCache(2);
lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
lfu.get(1);      // return 1
                 // cache=[1,2], cnt(2)=1, cnt(1)=2
lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
                 // cache=[3,1], cnt(3)=1, cnt(1)=2
lfu.get(2);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,1], cnt(3)=2, cnt(1)=2
lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
                 // cache=[4,3], cnt(4)=1, cnt(3)=2
lfu.get(1);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,4], cnt(4)=1, cnt(3)=3
lfu.get(4);      // return 4
                 // cache=[4,3], cnt(4)=2, cnt(3)=3




Constraints:

1 <= capacity <= 104
0 <= key <= 105
0 <= value <= 109
At most 2 * 105 calls will be made to get and put.
 */

public class LFUCache {
    static class Node {
        public int key;
        public int value;
        public int count;
        public Node Next;
        public Node Last;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.count = 1;
        }
    }

    static class DLL {
        public Node firsNode;
        public Node lasNode;
        private int count;

        public DLL() {
            firsNode = new Node(0, 0);
            lasNode = new Node(0, 0);
            firsNode.Next = lasNode;
            lasNode.Last = firsNode;
        }

        public int Insert(Node node) {
            Node nxtNode = this.firsNode.Next;
            this.firsNode.Next = node;
            node.Last = this.firsNode;
            node.Next = nxtNode;
            nxtNode.Last = node;

            this.count++;

            return node.key;
        }

        public int Remove(Node node) {
            Node lastNode = node.Last;
            Node nextNode = node.Next;

            lastNode.Next = nextNode;
            nextNode.Last = lastNode;
            this.count--;

            return node.key;
        }

        public Node RemoveLast() {
            Node node = this.lasNode.Last;
            Node LastNode = node.Last;

            LastNode.Next = this.lasNode;
            this.lasNode.Last = LastNode;
            this.count--;

            return node;
        }

        public int Size() {
            return this.count;
        }
    }

    static class LFU {
        private int size;
        private int count;
        private Hashtable<Integer, Node> nodeMap;
        private Hashtable<Integer, DLL> countMap;

        public LFU(int size) {
            this.size = size;

            nodeMap = new Hashtable<>();
            countMap = new Hashtable<>();
        }

        public int Get(int key) {
            if (nodeMap.containsKey(key)) {
                Node node = nodeMap.get(key);

                DLL dll = countMap.get(node.count);
                dll.Remove(node);
                if(dll.Size() == 0) {
                    countMap.remove(node.count);
                }

                node.count++;

                if (countMap.containsKey(node.count)) {
                    dll = countMap.get(node.count);
                    dll.Insert(node);
                } else {
                    dll = new DLL();
                    dll.Insert(node);

                    countMap.put(node.count, dll);
                }

                return node.value;
            } else {
                return -1;
            }
        }

        public void Put(int key, int value) {
            if (this.count < this.size) {
                if (nodeMap.containsKey(key)) {
                    Node node = nodeMap.get(key);
                    node.value = value;

                    DLL dll = countMap.get(node.count);
                    dll.Remove(node);
                    if (dll.Size() == 0) {
                        countMap.remove(node.count);
                    }
                    nodeMap.remove(node.key);

                    node.count++;
                    if (countMap.containsKey(node.count)) {
                        dll = countMap.get(node.count);
                        dll.Insert(node);
                        nodeMap.put(node.key, node);
                    } else {
                        dll = new DLL();
                        dll.Insert(node);

                        countMap.put(node.count, dll);
                        nodeMap.put(node.key, node);
                    }
                } else {
                    Node node = new Node(key, value);
                    if (countMap.containsKey(node.count)) {
                        DLL dll = countMap.get(node.count);
                        dll.Insert(node);
                        nodeMap.put(node.key, node);
                    } else {
                        DLL dll = new DLL();
                        dll.Insert(node);

                        countMap.put(node.count, dll);
                        nodeMap.put(node.key, node);
                    }
                }
                this.count++;
            } else {
                int cnt = 1;
                while (!countMap.containsKey(cnt)) {
                    cnt++;
                }

                DLL dll = countMap.get(cnt);
                Node leastFreqNode = dll.RemoveLast();
                nodeMap.remove(leastFreqNode.key);
                if (dll.Size() == 0) {
                    countMap.remove(leastFreqNode.count);
                }
                this.count--;
                Put(key, value);
            }
        }
    }

    public static void test() {
        LFU lfu = new LFU(2);
        lfu.Put(1, 1); // cache=[1,_], cnt(1)=1
        lfu.Put(2, 2); // cache=[2,1], cnt(2)=1, cnt(1)=1
        System.out.println(lfu.Get(1)); // return 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.Put(3, 3); // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        System.out.println(lfu.Get(2)); // return -1 (not found)
        System.out.println(lfu.Get(3)); // return 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.Put(4, 4); // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        System.out.println(lfu.Get(1)); // return -1 (not found)
        System.out.println(lfu.Get(3)); // return 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        System.out.println(lfu.Get(4)); // return 4
        // cache=[4,3], cnt(4)=2, cnt(3)=3
    }
}
