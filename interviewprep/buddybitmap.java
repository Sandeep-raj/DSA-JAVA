import java.util.Arrays;

/*
Given a complete binary tree with nodes of values of either 1 or 0, the following rules always hold:
(1) a node's value is 1 if and only if all its subtree nodes' values are 1
(2) a leaf node can have value either 1 or 0
Implement the following 2 APIs:
set_bit(offset, length), set the bits at range from offset to offset+length-1
clear_bit(offset, length), clear the bits at range from offset to offset+length-1

i.e. The tree is like:
             0
          /     \
         0        1
       /  \      /  \
      1    0    1    1
     /\   / \   / 
    1  1 1   0 1
    Since it's complete binary tree, the nodes can be stored in an array:
    [0,0,1,1,0,1,1,1,1,1,0,1]
*/

public class BuddyBitmap {

    private int[] tree;
    private int n;
    private int leafStart;
    private int[] leftBound;
    private int[] rightBound;
    private int[] lazy;
    private int bitPos;

    public BuddyBitmap(int[] leaves) {
        int numBits = leaves.length;
        int size = 1;
        while (size < numBits) size <<= 1;
        n = 2 * size - 1;
        leafStart = n / 2;

        tree = new int[n];
        leftBound = new int[n];
        rightBound = new int[n];
        lazy = new int[n];
        Arrays.fill(lazy, -1);
        Arrays.fill(tree, 1);

        for (int i = 0; i < numBits; i++) {
            tree[leafStart + i] = leaves[i];
        }

        for (int i = leafStart - 1; i >= 0; i--) {
            tree[i] = tree[2 * i + 1] & tree[2 * i + 2];
        }

        bitPos = 0;
        computeBounds(0);
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println(Arrays.toString(leftBound));
        System.out.println(Arrays.toString(rightBound));
    }

    private void computeBounds(int node) {
        if (node >= leafStart) {
            leftBound[node] = rightBound[node] = bitPos++;
            return;
        }
        int left = 2 * node + 1;
        int right = 2 * node + 2;
        computeBounds(left);
        if (right < n) computeBounds(right);
        leftBound[node] = leftBound[left];
        rightBound[node] = (right < n) ? rightBound[right] : rightBound[left];
    }

    private void pushDown(int node) {
        if (lazy[node] != -1) {
            int val = lazy[node];
            int left = 2 * node + 1;
            int right = 2 * node + 2;
            if (left < n) {
                tree[left] = val;
                lazy[left] = val;
            }
            if (right < n) {
                tree[right] = val;
                lazy[right] = val;
            }
            lazy[node] = -1;
        }
    }

    private void update(int node, int qL, int qR, int val) {
        if (qL <= leftBound[node] && rightBound[node] <= qR) {
            tree[node] = val;
            lazy[node] = val;
            return;
        }
        if (qR < leftBound[node] || rightBound[node] < qL) {
            return;
        }
        pushDown(node);
        int left = 2 * node + 1;
        int right = 2 * node + 2;
        if (left < n) update(left, qL, qR, val);
        if (right < n) update(right, qL, qR, val);
        int leftVal = (left < n) ? tree[left] : 1;
        int rightVal = (right < n) ? tree[right] : 1;
        tree[node] = leftVal & rightVal;
        lazy[node] = -1;
    }

    public void set_bit(int offset, int length) {
        if (length <= 0) return;
        update(0, offset, offset + length - 1, 1);
    }

    public void clear_bit(int offset, int length) {
        if (length <= 0) return;
        update(0, offset, offset + length - 1, 0);
    }

    public void printTree() {
        System.out.println("Tree (level-order): " + Arrays.toString(tree));
    }

    public void printBitmap() {
        System.out.print("Bitmap: ");
        printBitmapInOrder(0);
        System.out.println();
    }

    // ========== FIXED print method with lazy propagation ==========
    private void printBitmapInOrder(int node) {
        // Push any pending lazy down before traversing
        if (lazy[node] != -1) {
            pushDown(node);
        }
        if (node >= leafStart) {
            System.out.print(tree[node]);
            return;
        }
        int left = 2 * node + 1;
        int right = 2 * node + 2;
        if (left < n) printBitmapInOrder(left);
        if (right < n) printBitmapInOrder(right);
    }

    // ==================== MAIN ====================
    public static void main(String[] args) {
        // The example from the problem: leaves in bitmap order
        int[] leaves = {1, 1, 1, 0, 1, 1}; // 6 bits, padded to 8 with 1s
        BuddyBitmap bm = new BuddyBitmap(leaves);

        System.out.println("===== INITIAL STATE =====");
        bm.printTree();
        bm.printBitmap(); // Expected: 11101111

        System.out.println("\n----- clear_bit(2, 1) -----");
        bm.clear_bit(2, 1);
        bm.printTree();
        bm.printBitmap(); // Expected: 11001111

        System.out.println("\n----- set_bit(3, 1) -----");
        bm.set_bit(3, 1);
        bm.printTree();
        bm.printBitmap(); // Expected: 11011111

        System.out.println("\n----- clear_bit(0, 3) -----");
        bm.clear_bit(0, 3);
        bm.printTree();
        bm.printBitmap(); // Expected: 00011111  (now correct)

        System.out.println("\n----- set_bit(0, 6) -----");
        bm.set_bit(0, 6);
        bm.printTree();
        bm.printBitmap(); // Expected: 11111111
    }
}
