package linkedlist.ll_medium;

import linkedlist.learn.LinkedList;
import linkedlist.learn.LinkedList.Node;

/*
 * Intersection of Two Linked Lists
 * 
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
 * 
Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Intersected at '8'
Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
- Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A and 3rd node in B) are different node references. In other words, they point to two different locations in memory, while the nodes with value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory.


Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Intersected at '2'
Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.


Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: No intersection
Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.


Constraints:

The number of nodes of listA is in the m.
The number of nodes of listB is in the n.
1 <= m, n <= 3 * 104
1 <= Node.val <= 105
0 <= skipA < m
0 <= skipB < n
intersectVal is 0 if listA and listB do not intersect.
intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.

Follow up: Could you write a solution that runs in O(m + n) time and use only O(1) memory?
 */

public class Intersection2LinkedLists {
    public static Node getIntersect(Node head1, Node head2) {
        int len1 = 0, len2 = 0;
        Node curr = head1;
        while (curr != null) {
            len1++;
            curr = curr.next;
        }

        curr = head2;
        while (curr != null) {
            len2++;
            curr = curr.next;
        }

        int skip = len1 - len2;
        Node curr1 = head1;
        Node curr2 = head2;
        if(skip < 0) {
            for(int i = 0; i < -1 * skip; i++) {
                curr2 = curr2.next;
            }
        }else if (skip > 0) {
            for(int i = 0; i < skip; i++) {
                curr1 = curr1.next;
            }
        }

        while (curr1 != curr2) {
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return curr1;
    }

    public static void intersection(int[] arr1, int[] arr2, int[] commonArr) {
        LinkedList ll1 = new LinkedList();
        LinkedList ll2 = new LinkedList();
        LinkedList commonll = new LinkedList();

        for(int i = 0; i < arr1.length; i++) {
            ll1.insert(arr1[i]);
        }
        for(int i = 0; i < arr2.length; i++) {
            ll2.insert(arr2[i]);
        }
        for(int i = 0; i < commonArr.length; i++) {
            commonll.insert(commonArr[i]);
        }


        if(ll1.head == null) {
            ll1.head = commonll.head;
            ll1.tail = ll1.head;
        }else {
            ll1.tail.next = commonll.head;
        }

        if(ll2.head == null) {
            ll2.head = commonll.head;
            ll2.tail = ll2.head;
        }else {
            ll2.tail.next = commonll.head;
        }

        Node intersect = getIntersect(ll1.head, ll2.head);
        System.out.println(intersect.Key);
    }
}
