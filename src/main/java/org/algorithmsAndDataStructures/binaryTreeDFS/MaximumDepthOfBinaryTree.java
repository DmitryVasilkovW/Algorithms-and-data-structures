package org.algorithmsAndDataStructures.binaryTreeDFS;
// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75

public class MaximumDepthOfBinaryTree
{
    public static int max(int depth, TreeNode root)
    {
        if (root == null) return depth;

        depth ++;
        return Math.max(max(depth, root.left), max(depth, root.right));
    }

    public static int maxDepth(TreeNode root)
    {
        return max(0, root);
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(maxDepth(root));
    }
}
