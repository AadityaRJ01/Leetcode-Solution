/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {

        if(root == null){
            sb.append("N,");
            return;
        }

        sb.append(root.val).append(",");

        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    public TreeNode deserialize(String data) {

        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));

        return build(q);
    }

    private TreeNode build(Queue<String> q){

        String curr = q.poll();

        if(curr.equals("N"))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(curr));

        root.left = build(q);
        root.right = build(q);

        return root;
    }
}
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));