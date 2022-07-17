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
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode rSub = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode cur = root.right;
            while (cur.right != null) {
                cur = cur.right;
            }
            cur.right = rSub;
            root = root.right;
            }
        }
    }
}
// tc: O(n)
//sc: O(1)