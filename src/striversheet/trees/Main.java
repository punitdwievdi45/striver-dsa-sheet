package striversheet.trees;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);
        CustomBinaryTree customBinaryTree = new CustomBinaryTree();
        customBinaryTree.inOrderTraversal(root);
        System.out.println("Printing preOrder traversal");
        customBinaryTree.iterativePreOrderTraversal(root);
        System.out.println("Printing Inorder Iterative traversal");
        customBinaryTree.iterativeInOrderTraversal(root);
        customBinaryTree.morrisInorderTraversal(root);
        customBinaryTree.morrisPreOrderTraversal(root);
        List<Integer> rightView = new ArrayList<>();
        customBinaryTree.rightView(root, rightView, 0);
        customBinaryTree.leftView(root, new ArrayList<>(), 0);
        customBinaryTree.levelOrderTraversal(root);
        System.out.println("Printing bottom view of binary tree");
        customBinaryTree.bottomView(root);
        customBinaryTree.topView(root);
        customBinaryTree.allTraversalInOneGo(root);
        customBinaryTree.rootToNthParticularNode(root, 8);
        int width = customBinaryTree.widthOfBinaryTree(root);
        System.out.println("Width of binary tree is " + width);
        int maxHeight = customBinaryTree.maxHeightOfBinaryTree(root);
        System.out.println("Max height of binary tree is " + maxHeight);
        int diameter = customBinaryTree.diameterOfBinaryTree(root);
        System.out.println("Diameter of binary tree is " + diameter);
        int balanced = customBinaryTree.isBalanced(root);
        if (balanced == -1) {
            System.out.println("Tree is not balanced");
        } else {
            System.out.println("Tree is balanced");
        }
    }
}
