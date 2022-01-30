class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        // if(root == null){
        //     return 0;
        // }
        // int leftDiameter = diameterOfBinaryTree(root.left);
        // int rightDiameter = diameterOfBinaryTree(root.right);
        // int f = height(root.left) + height(root.right) + 2;
        // return Math.max(f,Math.max(leftDiameter, rightDiameter));
        
        if(root == null){
            return 0;
        }
        
        DiaPair ans = diameter2(root);
        return ans.dia;
    }
    
    public int height(TreeNode node){
        if(node == null){
            return -1;
        }
        
        int lh = height(node.left);
        int rh = height(node.right);
        
        int mh = Math.max(lh, rh) + 1;
        return mh;
    }
    
    public class DiaPair{
        int ht;
        int dia;
    }
    
    public DiaPair diameter2(TreeNode node){
        if(node == null){
            DiaPair mp = new DiaPair();
            mp.ht = -1;
            mp.dia = 0;
            return mp;
        }
        DiaPair left = diameter2(node.left);
        DiaPair right = diameter2(node.right);
        
        DiaPair dp = new DiaPair();
        dp.ht = Math.max(left.ht, right.ht) + 1;
        
        int fes = left.ht + right.ht + 2;
        dp.dia = Math.max(fes, Math.max(left.dia, right.dia));
        return dp;
    }
}
