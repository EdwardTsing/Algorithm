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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        LinkedList<String> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        dfs1(root, q);
        int size = q.size();
        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                sb.append(q.get(i) + ",");
            } else {
                sb.append(q.get(i));
            }
        }
        return sb.toString();
    }
    
    private void dfs1(TreeNode root, Deque<String> q) {
        if (root == null) return;
        q.offer(String.valueOf(root.val));
        dfs1(root.left, q);
        dfs1(root.right, q);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String s) {
        if (s == "") return null;
        String[] ss = s.split(",");
        int len = ss.length;
        TreeNode root = dfs2(ss, 0, len - 1);
        return root;
    }
    
    private TreeNode dfs2(String[] ss, int start, int end) {
        if (start > end) return null;
        TreeNode cur = new TreeNode(Integer.valueOf(ss[start]));
        if (start == end) {
            return cur;
        }
        int left = start;
        int right = end;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (Integer.valueOf(ss[mid]) > Integer.valueOf(ss[start])) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (Integer.valueOf(ss[left]) <= Integer.valueOf(ss[start])) left++;
        cur.left = dfs2(ss, start + 1, left - 1);
        cur.right = dfs2(ss, left, end);
        return cur;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;

//tc: O(n * logn)
//sc: O(n)