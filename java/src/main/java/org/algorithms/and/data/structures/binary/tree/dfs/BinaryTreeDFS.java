package org.algorithms.and.data.structures.binary.tree.dfs;

public class BinaryTreeDFS
{

    // Inorder Traversal
    public void inorderTraversal(TreeNode root)
    {
        if (root != null)
        {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    // Preorder Traversal
    public void preorderTraversal(TreeNode root)
    {
        if (root != null)
        {
            System.out.print(root.val + " ");

            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    // Postorder Traversal
    public void postorderTraversal(TreeNode root)
    {
        if (root != null)
        {
            postorderTraversal(root.left);
            postorderTraversal(root.right);

            System.out.print(root.val + " ");
        }
    }

    public static void main(String[] args)
    {
        BinaryTreeDFS tree = new BinaryTreeDFS();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.print("Inorder traversal: ");
        tree.inorderTraversal(root); // Output: 1 2 3 4 5
        System.out.println();

        System.out.print("Preorder traversal: ");
        tree.preorderTraversal(root); // Output: 4 2 1 3 5
        System.out.println();

        System.out.print("Postorder traversal: ");
        tree.postorderTraversal(root); // Output: 1 3 2 5 4
    }
}

