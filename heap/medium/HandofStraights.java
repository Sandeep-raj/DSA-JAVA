package heap.medium;

import java.util.Hashtable;
import java.util.PriorityQueue;

/*
 * Hand of Straights
 * 
 * Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.

Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.


Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]

Input: hand = [1,2,3,4,5], groupSize = 4
Output: false
Explanation: Alice's hand can not be rearranged into groups of 4.

Constraints:

1 <= hand.length <= 104
0 <= hand[i] <= 109
1 <= groupSize <= hand.length
 */

public class HandofStraights {
    public static boolean hands(int[] cards, int groupSize) {
        // Array Implementation
        // if(cards.length%groupSize != 0) {
        //     return false;
        // }

        // Arrays.sort(cards);

        // int group = cards.length/groupSize;
        // int[] groupCard = new int[group];
        // int[] cardCount = new int[group];

        // for (int card : cards) {
        //     boolean entryFound = false;
        //     for(int i = 0; i < group; i++) {
        //         if(cardCount[i] == 0 || (groupCard[i] + 1 == card && cardCount[i] < groupSize)) {
        //             groupCard[i] = card;
        //             cardCount[i]++;
        //             entryFound = true;
        //             break;
        //         }
        //     }

        //     if (!entryFound) {
        //         return false;
        //     }
        // }

        // return true;




        // PriorityQueue Implementation
        if(cards.length%groupSize != 0) {
            return false;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (a - b));
        Hashtable<Integer,Integer> hash = new Hashtable<>();

        for(int i = 0; i < cards.length; i++) {
            if(hash.containsKey(cards[i])) {
                hash.put(cards[i], hash.get(cards[i]) + 1);
            }else {
                pq.add(cards[i]);
                hash.put(cards[i], 1);
            }
        }

        while (pq.size() > 0) {
            int minCard = pq.peek();
            int minCount = hash.get(minCard);

            if(minCount == 1) {
                hash.remove(minCard);
                pq.remove();
            }else {
                hash.put(minCard, minCount - 1);
            }

            for(int i = 1; i < groupSize; i++) {
                if(hash.containsKey(minCard + i)) {
                    int keyCount = hash.get(minCard + i);
                    if(keyCount > 1) {
                        hash.put(minCard + i, keyCount - 1);
                    }else {
                        int minKey = pq.remove();
                        if(minKey != minCard + i) {
                            return false;
                        }

                        hash.remove(minCard + i);
                    }
                }else {
                    return false;
                }
            }
        }

        return true;
    }
}
