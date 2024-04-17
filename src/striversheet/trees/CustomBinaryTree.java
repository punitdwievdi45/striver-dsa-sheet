package striversheet.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class CustomBinaryTree {

    public void inOrderTraversal(Node root) {

        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);

    }

    public void iterativePreOrderTraversal(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> preOrder = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            preOrder.add(root.data);

            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        System.out.println("PreOrder Traversal is : " + preOrder);
    }


    public void iterativeInOrderTraversal(Node root) {
        List<Integer> inOrder = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                root = stack.peek();
                inOrder.add(root.data);
                stack.pop();
                root = root.right;
            }
        }
        System.out.println("InOrder Traversal is : " + inOrder);
    }


    /*Case 1: When the current node has no left subtree. In this scenario, there is nothing to be
    traversed on the left side, so we simply print the value of the current node and move to the right of the current node.
    Case 2: When there is a left subtree and the right-most child of this left subtree is pointing to null.
    In this case we need to set the right-most child to point to the current node, instead of NULL and move to the left of the current node.
    Case 3: When there is a left subtree and the right-most child of this left-subtree is already pointing to the current node.
          In this case we know that the left subtree is already visited so we need to print the value of the current node and move to the right of the current node.
            Note: Case 3 is very important as we need to remove the new links added to restore the original tree.

    To summarize, at a node whether we have to move left or right is determined whether the node has a left subtree.
     If it doesn’t we move to the right. If there is a left subtree then we see its rightmost child.
     If the rightmost child is pointing to NULL, we move the current node to its left.
     If the rightmost child is already pointing towards the current node,
      we remove that link and move to the right of the current node.
      We will stop the execution when the current points to null and we have traversed the whole tree.*/
    public void morrisInorderTraversal(Node root) {
        List<Integer> inorder = new ArrayList<Integer>();

        Node cur = root;
        while (cur != null) {
            if (cur.left == null) {
                inorder.add(cur.data);
                cur = cur.right;
            } else {
                Node prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    inorder.add(cur.data);
                    cur = cur.right;
                }
            }
        }
        System.out.println("Morris In Order Traversal is : " + inorder);
    }


    public void morrisPreOrderTraversal(Node root) {
        List<Integer> inorder = new ArrayList<Integer>();

        Node cur = root;
        while (cur != null) {
            if (cur.left == null) {
                inorder.add(cur.data);
                cur = cur.right;
            } else {
                Node prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = cur;
                    inorder.add(cur.data);
                    cur = cur.left;
                } else {
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        System.out.println("Morris PreOrder Traversal is : " + inorder);
    }


    public void rightView(Node root, List<Integer> rightView, int level) {
        rightViewOfTree(root, rightView, level);
        System.out.println("Right View of Tree is : " + rightView);
    }

    public void rightViewOfTree(Node root, List<Integer> rightView, int level) {

        if (root == null) {
            return;
        }

        if (rightView.size() == level) {
            rightView.add(root.data);
        }
        rightViewOfTree(root.right, rightView, level + 1);
        rightViewOfTree(root.left, rightView, level + 1);
    }


    public void leftView(Node root, List<Integer> leftView, int level) {
        leftViewOfTree(root, leftView, level);
        System.out.println("Left View of Tree is : " + leftView);
    }

    public void leftViewOfTree(Node root, List<Integer> leftView, int level) {

        if (root == null) {
            return;
        }

        if (leftView.size() == level) {
            leftView.add(root.data);
        }
        leftViewOfTree(root.left, leftView, level + 1);
        leftViewOfTree(root.right, leftView, level + 1);
    }


    public void levelOrderTraversal(Node root) {
        List<List<Integer>> wrapperList = new ArrayList<>();
        Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {

                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                levelList.add(queue.poll().data);

            }
            wrapperList.add(levelList);
        }
        System.out.println("Level Order Traversal is : " + wrapperList);
    }

    public void bottomView(Node root) {
        if (root == null) {
            return;
        }
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        root.hd = 0;
        q.add(root);
        while(!q.isEmpty()){
            Node temp = q.remove();
            int hd = temp.hd;
            map.put(hd,temp.data);
            if(temp.left != null){
                temp.left.hd = hd -1;
                q.add(temp.left);
            }
            if(temp.right != null){
                temp.right.hd = hd+1;
                q.add(temp.right);
            }
        }
        System.out.println("Bottom View of Tree is : " + map.values());
    }

    public void topView(Node root) {
       if(root == null) {
           return;
       }
       Queue<Node> queue = new LinkedList<>();
         Map<Integer, Integer> map = new TreeMap<>();
         root.hd = 0;
         queue.add(root);
         while(!queue.isEmpty()){
             Node temp = queue.remove();
             int hd = temp.hd;
             if (map.get(hd) == null){
                 map.put(hd, temp.data);
             }
             if(temp.left != null){
                 temp.left.hd = temp.hd -1;
                 queue.add(temp.left);
             }
             if (temp.right != null){
                 temp.right.hd =temp.hd +1;
                 queue.add(temp.right);
             }
         }
        System.out.println("Top View of Tree is : " + map.values());
    }

    public void allTraversalInOneGo(Node root){
        Stack<Pair> stack = new Stack<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        stack.push(new Pair(root, 1));
        while (!stack.isEmpty()){
            Pair top = stack.pop();
            if (top.num == 1){
                pre.add(top.node.data);
                top.num++;
                stack.push(top);
                if (top.node.left != null){
                    stack.push(new Pair(top.node.left, 1));
                }
            }
            else if (top.num == 2){
                in.add(top.node.data);
                top.num++;
                stack.push(top);
                if (top.node.right != null){
                    stack.push(new Pair(top.node.right, 1));
                }
            }
            else {
                post.add(top.node.data);
            }
        }
        System.out.println("PreOrder Traversal is : " + pre);
        System.out.println("InOrder Traversal is : " + in);
        System.out.println("PostOrder Traversal is : " + post);
    }

    public void rootToNthParticularNode(Node root,int val){
        List<Integer> list = new ArrayList<>();
        getPath(root, val, list);
        System.out.println("Root to Nth Part is : " + list);
    }

    private boolean getPath(Node root, int val, List<Integer> list) {
        if (root == null){
            return false;
        }
        list.add(root.data);
        if (root.data == val){
            return true;
        }
        if (getPath(root.left, val, list) || getPath(root.right, val, list)){
            return true;
        }
        list.remove(list.size() - 1);
        return false;
    }



   /* The algorithm approach can be stated as:

    We take a queue and push the root node along with index 0.
    We traverse the tree using a level order traversal.
    In the level order traversal we set another loop to run for the size of the queue, so that we visit the same level nodes inside it.
    Before a level starts, we use a variable(say curMin) to store the index of the first node.
    We assign an index to every node, and to its children as described above.
    When the inner loop is at the first node of a level, we store its index in another variable(sayleftMost)
    When the inner loop is at the last node of a level, we store its index in another variable(say rightMost)
    After a level  in the outer loop, we calculate the width of the level as (rightMost – leftMost +1).
    We return the maximum width as the answer.*/

    public int widthOfBinaryTree(Node root) {
        if(root == null) return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            int mmin = q.peek().num;    //to make the id starting from zero
            int first = 0,last = 0;
            for(int i=0; i<size; i++){
                int cur_id = q.peek().num-mmin;
                Node node = q.peek().node;
                q.poll();
                if(i==0) first = cur_id;
                if(i==size-1) last = cur_id;
                if(node.left != null)
                    q.offer(new Pair(node.left, cur_id*2+1));
                if(node.right != null)
                    q.offer(new Pair(node.right, cur_id*2+2));
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }

    public int maxHeightOfBinaryTree(Node root) {
        if (root ==null){
            return 0;
        }
        int leftHeight = maxHeightOfBinaryTree(root.left);
        int rightHeight = maxHeightOfBinaryTree(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /*public void verticalTraversal(Node root){
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0 ,0));
        while (!queue.isEmpty()){
            Tuple tuple = queue.poll();
            Node node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            if (!map.containsKey(x)){
                map.put(x, new TreeMap<>());
            }
            if (map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<>());
        }
            map.g
    }*/



    public int diameterOfBinaryTree(Node root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];
    }

    private int height(Node node, int[] diameter) {
        if (node == null){
            return 0;
        }
        int leftHeight = height(node.left, diameter);
        int rightHeight = height(node.right, diameter);
        diameter[0] = Math.max(diameter[0], leftHeight+rightHeight);
        return 1 + Math.max(leftHeight,rightHeight);
    }

    public void level(Node root){
        List<List<Node>> wrapList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Node> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size;i++){
                if(queue.peek().left !=null) queue.offer(queue.peek().left);
                if(queue.peek().right !=null)  queue.offer(queue.peek().right);
                list.add(queue.poll());
            }
            wrapList.add(list);
        }
    }

    public int isBalanced(Node root) {
        if(root == null){
            return 0;
        }
        int leftHeight =isBalanced(root.left);
        if (leftHeight == -1){
            return -1;
        }
        int rightHeight =isBalanced(root.right);

        if (rightHeight == -1){
            return -1;
        }
        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }
        return Math.max(leftHeight,rightHeight)+1;
    }
}
