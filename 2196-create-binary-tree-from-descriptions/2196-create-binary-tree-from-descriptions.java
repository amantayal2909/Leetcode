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
    public TreeNode createBinaryTree(int[][] des) {
        HashMap<Integer, TreeNode> node = new HashMap<>();
        HashSet<Integer> count = new HashSet<>();

        for(int i=0; i<des.length; i++){
            int father = des[i][0];
            int child = des[i][1];
            int isleft = des[i][2];

            if(!node.containsKey(father))
                node.put(father, new TreeNode(father));

            if(!node.containsKey(child))
                node.put(child, new TreeNode(child));

            if(isleft == 1){
                node.get(father).left = node.get(child);
            }
            else{
                node.get(father).right = node.get(child);
            }

            count.add(child);
            
        }

        for(int i=0; i<des.length; i++){
            int father = des[i][0];
            if(!count.contains(father)){
                return node.get(father);
            }
        }

        return null;
    }
}