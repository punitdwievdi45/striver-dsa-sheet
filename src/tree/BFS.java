package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data=data;
    }
}

public class BFS {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(doBFS(root));

    }

    private static List<List<Integer>> doBFS(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        List<List<Integer>> wrappedList = new LinkedList<List<Integer>>();
        if (root == null){
            return wrappedList;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> subList = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++){
                if (queue.peek().left != null){
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }
                subList.add(queue.poll().data);
            }
            wrappedList.add(subList);
        }
        //System.out.println(wrappedList);
        return wrappedList;
    }
}
