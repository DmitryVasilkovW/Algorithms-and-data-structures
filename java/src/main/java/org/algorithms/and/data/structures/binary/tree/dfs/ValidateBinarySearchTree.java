package org.algorithms.and.data.structures.binary.tree.dfs;
// https://leetcode.com/problems/validate-binary-search-tree/description/

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {

        List<Integer> inorder = inorder(root);

        for (int i = 1; i < inorder.size(); i++) {
            if (inorder.get(i) <= inorder.get(i - 1)) {
                return false;
            }
        }

        return true;
    }

    private List<Integer> inorder(TreeNode root) {
        return inorderRecursion(root, new ArrayList<>());
    }

    private List<Integer> inorderRecursion(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return list;

        inorderRecursion(root.left, list);
        list.add(root.val);
        inorderRecursion(root.right, list);

        return list;
    }

    public static void main(String[] args) {
        var root = new TreeNode(10);
        var ans = new ValidateBinarySearchTree();
        root.left = new TreeNode(9);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);

        System.out.println(ans.isValidBST(root));
    }
}
