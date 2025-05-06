package org.algorithms.and.data.structures.binary.tree.dfs;
// https://leetcode.com/problems/leaf-similar-trees/?envType=study-plan-v2&envId=leetcode-75

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees
{
    public static void leafs(List<Integer> leafs, TreeNode root)
    {
        if (root == null) return;

        if (root.left == null && root.right == null) leafs.add(root.val);
        leafs(leafs, root.left);
        leafs(leafs, root.right);
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2)
    {
        var leafs1 = new ArrayList<Integer>();
        var leafs2 = new ArrayList<Integer>();

        leafs(leafs1, root1);
        leafs(leafs2, root2);

        return leafs1.equals(leafs2);
    }

    public static void main(String[] args)
    {
        TreeNode root1 = new TreeNode(4);

        root1.left = new TreeNode(2);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(4);

        root2.left = new TreeNode(2);
        root2.right = new TreeNode(5);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(3);

        System.out.println(leafSimilar(root1, root2));
    }
}
