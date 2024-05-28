package linkedlist.ll_hard;

/*
 * Flattening a Linked List
 * 
 * Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.
Each of the sub-linked-list is in sorted order.
Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. 

Note: The flattened list will be printed using the bottom pointer instead of the next pointer.
For more clarity have a look at the printList() function in the driver code.

Input:
5 -> 10 -> 19 -> 28
|     |     |     | 
7     20    22   35
|           |     | 
8          50    40
|                 | 
30               45
Output:  5-> 7-> 8- > 10 -> 19-> 20->
22-> 28-> 30-> 35-> 40-> 45-> 50.
Explanation:
The resultant linked lists has every 
node in a single level.
(Note: | represents the bottom pointer.)



Input:
5 -> 10 -> 19 -> 28
|          |                
7          22   
|          |                 
8          50 
|                           
30              
Output: 5->7->8->10->19->22->28->30->50
Explanation:
The resultant linked lists has every
node in a single level.

(Note: | represents the bottom pointer.)



Your Task:
You do not need to read input or print anything. Complete the function flatten() that takes the head of the linked list as input parameter and returns the head of flattened link list.

Expected Time Complexity: O(N*N*M)
Expected Auxiliary Space: O(N)

Constraints:
0 <= N <= 50
1 <= Mi <= 20
1 <= Element of linked list <= 103
 */

public class FlatteningLinkedList {
    static class Node {
        public int key;
        public Node next;
        public Node bottom;

        public Node(int key) {
            this.key = key;
        }
    }

    public static Node merge(Node head1, Node head2) {
        Node head = null;
        Node curr = null;

        while (head1 != null && head2 != null) {
            Node n = null;
            if (head1.key < head2.key) {
                n = head1;
                head1 = head1.bottom;
            }else {
                n = head2;
                head2 = head2.bottom;
            }

            n.bottom = null;
            if (head == null) {
                head = n;
                curr = n;
            } else {
                curr.bottom = n;
                curr = n;
            }
        }

        while (head1 != null) {
            Node n = head1.bottom;
            head1.bottom = null;
            curr.bottom = head1;
            curr = head1;

            head1 = n;
        }

        while (head2 != null) {
            Node n = head2.bottom;
            head2.bottom = null;
            curr.bottom = head2;
            curr = head2;

            head2 = n;
        }

        return head;
    }

    public static Node mergeSortList(Node head) {
        Node start = head;
        Node next = head.next;

        while (next != null) {
            Node n = next.next;
            start = merge(start, next);
            next = n;
        }

        return start;
    }

    public static void flatten(int[][] arr) {
        Node head = null;
        Node curr = null;

        for (int i = 0; i < arr.length; i++) {
            Node chead = null;
            Node ctail = null;
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    break;
                }

                Node n = new Node(arr[i][j]);
                if (chead == null) {
                    chead = n;
                    ctail = n;
                } else {
                    ctail.bottom = n;
                    ctail = n;
                }
            }

            if (head == null) {
                head = chead;
                curr = chead;
            } else {
                curr.next = chead;
                curr = chead;
            }
        }

        Node temp =  mergeSortList(head);
        StringBuilder sb = new StringBuilder();
        while (temp != null)  {
            sb.append(temp.key);
            if(temp.bottom != null) {
                sb.append(" -> ");
            }

            temp = temp.bottom;
        }

        System.out.println(sb.toString());

    }
}
