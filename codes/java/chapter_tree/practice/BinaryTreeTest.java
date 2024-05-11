package chapter_tree.practice;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTree {

    public static List<Integer> bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return res;
    }

    public static void dfsPreOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        dfsPreOrder(root.left, res);
        dfsPreOrder(root.right, res);
    }

    public static void dfsInOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        dfsInOrder(root.left, res);
        res.add(root.val);
        dfsInOrder(root.right, res);
    }

    public static void dfsPostOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        dfsPostOrder(root.left, res);
        dfsPostOrder(root.right, res);
        res.add(root.val);
    }

}

public class BinaryTreeTest {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        System.out.println(BinaryTree.bfs(node1));

        List<Integer> preOrder = new ArrayList<>();
        BinaryTree.dfsPreOrder(node1, preOrder);
        System.out.println(preOrder);

        List<Integer> inOrder = new ArrayList<>();
        BinaryTree.dfsInOrder(node1, inOrder);
        System.out.println(inOrder);

        List<Integer> postOrder = new ArrayList<>();
        BinaryTree.dfsPostOrder(node1, postOrder);
        System.out.println(postOrder);
    }

}
