package linkedlist.ll_hard;

import linkedlist.learn.LinkedList;
import linkedlist.learn.LinkedList.Node;

/*
 * Rotate List
 * 
 * Given the head of a linked list, rotate the list to the right by k places.
 * 
 * Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Input: head = [0,1,2], k = 4
Output: [2,0,1]

Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109
 */

public class RotateList {
    public static int getLen(Node head) {
        int len =0;
        while (head != null) {
            len++;
            head = head.next;
        }

        return len;
    }

    public static Node rotateList(Node head, int k) {
        int listLen = getLen(head);
        int wrap = listLen - (k%listLen);

        if(wrap == k) {
            return head;
        }

        Node sndhead = head;
        Node sndtail = head;
        Node fsthead = null;
        Node fsttail = null;

        while (wrap > 1) {
            sndtail = sndtail.next;
            wrap--;
        }

        fsthead = sndtail.next;
        Node curr = fsthead;
        while (curr.next != null) {
            curr = curr.next;
        }
        fsttail = curr;

        sndtail.next = null;
        fsttail.next = sndhead;

        return fsthead;
    }

    public static void rotate(int[] arr, int k) {
        LinkedList ll = new LinkedList();
        for(int i = 0; i < arr.length; i++) {
            ll.insert(arr[i]);
        }

        Node head = rotateList(ll.head, k);
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.Key);
            if(head.next != null) {
                sb.append(" -> ");
            }
            head = head.next;
        }

        System.out.println(sb.toString());
    }
}
