/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    class Pair {
        TreeNode node;
        long index;

        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        int maxWidth = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            long first = 0;
            long last = 0;

            for (int i = 0; i < size; i++) {

                Pair curr = q.poll();

                TreeNode node = curr.node;
                long index = curr.index;

                // First node of this level
                if (i == 0) {
                    first = index;
                }

                // Last node of this level
                if (i == size - 1) {
                    last = index;
                }

                if (node.left != null) {
                    q.offer(new Pair(node.left, 2 * index + 1));
                }

                if (node.right != null) {
                    q.offer(new Pair(node.right, 2 * index + 2));
                }
            }

            int width = (int)(last - first + 1);

            maxWidth = Math.max(maxWidth, width);
        }

        return maxWidth;
    }
}