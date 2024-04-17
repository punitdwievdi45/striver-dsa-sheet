package striversheet.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class CustomLinkedList {

    Node head;

    public void insert(int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;

        }
    }

    public void show() {
        Node n = head;
        while (n.next != null) {
            System.out.println(n.data);
            n = n.next;
        }
        System.out.println(n.data);
    }

    public void show(Node head1) {
        Node n = head1;
        while (n.next != null) {
            System.out.println(n.data);
            n = n.next;
        }
        System.out.println(n.data);
    }


    public void inserAtStart(int i) {
        Node n = head;
        Node node = new Node();
        node.data = i;
        head = node;
        head.next = n;
    }

    public void insertAtLast(int i) {
        insert(i);
    }

    public void insertAtIndex(int i, int data) {
        Node node = new Node();
        node.data = data;
        Node n = head;
        for (int j = 0; j < i - 1; j++) {
            n = n.next;
        }
        node.next = n.next;
        n.next = node;
    }

    public void deleteAt(int i) {
        if (i == 0) {
            head = head.next;
            return;
        }
        Node n = head;
        Node temp = null;
        for (int j = 0; j < i - 1; j++) {
            n = n.next;
        }
        temp = n.next;
        n.next = temp.next;
    }


    /*
    *Follow the steps below to solve the problem:
Store the nodes(values and address) in the stack until all the values are entered.
Once all entries are done, Update the Head pointer to the last location(i.e the last value).
Start popping the nodes(value and address) and store them in the same order until the stack is empty.
Update the next pointer of last Node in the stack by NULL.
    * */
    public void reverseUsingStack() {
        Stack<Node> stack = new Stack<>();
        Node temp = head;
        while (temp.next != null) {
            stack.push(temp);
            temp = temp.next;
        }
        head = temp;
        while (!stack.isEmpty()) {
            temp.next = stack.peek();
            stack.pop();
            temp = temp.next;
        }
        temp.next = null;
    }

    public void findMiddleElement(CustomLinkedList customLinkedList) {
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        System.out.println("Middle element is " + slow.data);
    }

    public void iterativeReverse() {
        Node temp = head;
        Node prev = null;
        while(temp != null){
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        show(prev);
    }




    public Node iterativeReverse(Node ptr) {
        Node pre = null;
        Node nex = null;
        while (ptr != null) {
            nex = ptr.next;
            ptr.next = pre;
            pre = ptr;
            ptr = nex;
        }
        return pre;
    }

    public void mergeTwoSortedLinkedList(Node head1, Node head2) {
        List<Integer> vector = new ArrayList<>();
        while (head1 != null) {
            vector.add(head1.data);
            head1 = head1.next;
        }

        while (head2 != null) {
            vector.add(head2.data);
            head2 = head2.next;
        }

        Collections.sort(vector);
        Node result = new Node();
        Node temp = result;
        for (int i = 0; i < vector.size(); i++) {
            result.next = new Node(vector.get(i));
            result = result.next;
        }
        temp = temp.next;
        show(temp);
    }


    /*Step 1: Create two pointers, say l1 and l2. Compare the first node
     of both lists and find the small among the two. Assign pointer l1 to the smaller value node.

Step 2: Create a pointer, say result, to l1. An iteration is basically
iterating through both lists till the value pointed by l1 is less than or equal to the value pointed by l2.

Step 3: Start iteration. Create a variable, say, temp. It will
 keep track of the last node sorted list in an iteration.

Step 4: Once an iteration is complete, link node pointed by temp to node pointed by l2. Swap l1 and l2.

Step 5: If any one of the pointers among l1 and l2 is NULL,
 then move the node pointed by temp to the next higher value node*/
    public void mergeTwoLinkedListWithO1Complexity(Node l1, Node l2) {

        if (l1 == null) {
            show(l2);
            return;
        }
        if (l2 == null) {
            show(l1);
            return;
        }

        if (l1.data > l2.data) {
            Node temp = l1;
            l1 = l2;
            l2 = temp;
        }

        Node result = l1;
        while (l1 != null && l2 != null) {
            Node temp = null;
            while (l1 != null && l1.data <= l2.data) {
                temp = l1;
                l1 = l1.next;
            }
            temp.next = l2; // breaking the link and aasigning the next to smaller value
            // swap
            Node temp1 = l1;
            l1 = l2;
            l2 = temp1;

        }

        show(result);
    }


    /*1.Take two dummy nodes, who’s next will be pointing to the head.
    2.Take another node to store the head, initially,s a dummy node(start),
    and the next node will be pointing to the head.
    The reason why we are using this extra dummy node is that there is an edge case.
    If the node is equal to the length of the LinkedList, then this slow will point to slow’s next→ next. And we can say our dummy start node will be broken and will be connected to the slow next→ next.

    3.Start traversing until the fast pointer reaches the nth node.

   4. Now start traversing by one step both of the pointers until the fast pointers reach the end.

    5.When the traversal is done, just do the deleting part. Make slow pointers next to the next of the slow pointer to ignore/disconnect the given node.

   6. Last, return to the next start.*/
    public void removeNthFromEnd(Node head1, int i) {
        Node start = new Node();
        start.next = head1;
        Node slow = start;
        Node fast = start;

        for (int j = 0; j <= i; j++) {
            fast = fast.next;
        }

        while (fast != null) {

            slow = slow.next;
            fast = fast.next;

        }
        slow.next = slow.next.next;
        show(start.next);
    }


//    Create a dummy node which is the head of new linked list.
//    Create a node temp, initialise it with dummy.
//    Initialize carry to 0.
//    Loop through lists l1 and l2 until you reach both ends, and until carry is present.
//            Set sum=l1.val+ l2.val + carry.
//            Update carry=sum/10.
//    Create a new node with the digit value of (sum%10) and set it to temp node’s next, then advance temp node to next.
//    Advance both l1 and l2.
//    Return dummy’s next node.

    /**
     * Adds two numbers represented by linked lists. The input linked lists represent
     * the digits of two numbers in reverse order, and the method returns a new linked
     * list representing the sum of the two numbers.
     *
     * @param l1 The head of the first linked list representing the first number.
     * @param l2 The head of the second linked list representing the second number.
     */
    public void addTwoNumbersAsLinkedList(Node l1, Node l2) {

        // Create a dummy node to simplify handling the result list
        Node dummy = new Node();

        // Use a temporary pointer to traverse and build the result list
        Node temp = dummy;

        // Initialize carry to 0
        int carry = 0;

        // Continue the loop until both input lists are processed and no carry is left
        while (l1 != null || l2 != null || carry == 1) {

            // Initialize sum to 0
            int sum = 0;

            // Add the value of the current node in the first list, if available
            if (l1 != null) {
                sum = sum + l1.data;
                l1 = l1.next;
            }

            // Add the value of the current node in the second list, if available
            if (l2 != null) {
                sum = sum + l2.data;
                l2 = l2.next;
            }

            // Add the carry from the previous iteration
            sum = sum + carry;

            // Calculate the new carry for the next iteration
            carry = sum / 10;

            // Create a new node with the digit at the current position in the result
            Node node = new Node(sum % 10);

            // Connect the new node to the result list
            temp.next = node;

            // Move the temporary pointer to the newly added node
            temp = temp.next;
        }

        // Display the result list (excluding the dummy node)
        show(dummy.next);
    }


    //    Iterate through list 1 and hash its node address. Why? (Hint: depends on the common attribute we are searching)
//    Iterate through list 2 and search the hashed value in the hash table. If found, return node.
    public Node findIntersectionWithExtraSpace(Node l1, Node l2) {
        HashSet<Node> hashSet = new HashSet<>();
        while (l1 != null) {
            hashSet.add(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            if (hashSet.contains(l2)) {
                return l2;
            }
            l2 = l2.next;
        }
        return null;
    }

//    Take two dummy nodes for each list. Point each to the head of the lists.
//    Iterate over them. If anyone becomes null, point them to the head of the opposite lists and continue iterating until they collide.

    public Node findIntersectionWithO1SpaceComplexity(Node l1, Node l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        Node a = l1;
        Node b = l2;
        //if a & b have different len, then we will stop the loop after second iteration
        while (a != b) {
            // for the end of the first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null ? l2 : a.next;
            b = b == null ? l1 : b.next;
        }
        return a;
    }

    /**
     * Detects a cycle in a linked list using the Floyd's Cycle Detection Algorithm.
     * <p>
     * We will take two pointers, namely fast and slow. The fast pointer takes 2 steps ahead,
     * and the slow pointer takes 1 step ahead. Iterate through the list until the fast
     * pointer is equal to NULL. This is because NULL indicates that there is no cycle present
     * in the given list. A cycle can be detected when the fast and slow pointers collide.
     *
     * @param cycleHead The head of the linked list to check for the presence of a cycle.
     * @return True if a cycle is detected, false otherwise.
     */
    public boolean detectCycle(Node cycleHead) {
        // Initialize slow and fast pointers to the head of the list
        Node slow = cycleHead;
        Node fast = cycleHead;

        // Iterate through the list until the fast pointer is equal to NULL
        while (slow.next != null && fast.next.next != null) {
            // Move the slow pointer one step ahead
            slow = slow.next;
            // Move the fast pointer two steps ahead
            fast = fast.next.next;

            // Check for collision between the slow and fast pointers
            if (slow == fast) {
                // A cycle is detected
                return true;
            }
        }

        // No cycle is detected
        return false;
    }

    public void reverseLinkedListInGroups(Node head1, int k) {

        if (head1 == null || k == 1) {
            show(head1);
            return;
        }
        Node dummy = new Node();
        dummy.next = head1;
        Node curr = dummy, prev = dummy, nex = dummy;
        int count = 0;
        while (curr.next != null) {
            curr = curr.next;
            count++;
        }
        while (count >= k) {
            curr = prev.next;
            nex = curr.next;
            for (int i = 1; i < k; i++) {
                curr.next = nex.next;
                nex.next = prev.next;
                prev.next = nex;
                nex = curr.next;
            }
            prev = curr;
            count = count - k;
        }
        show(dummy.next);
    }

    public boolean checkIfListIsPalindrome(Node head1) {

        Node slow = head1;
        Node fast = head1;
        while (fast != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = iterativeReverse(slow.next);
        slow = slow.next;
        Node dummy = head1;
        while (slow != null) {

            if (dummy.data != slow.data) {
                return false;
            }
            dummy = dummy.next;
            slow = slow.next;
        }
        return true;
    }

    public Node detectCycleAndReturnStartOfLoop(Node head1) {
        Node entry = head1;
        Node slow = head1;
        Node fast = head1;

        while (slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return slow;
            }

        }
        return null;
    }

    Node mergeTwoLists(Node a, Node b) {

        Node temp = new Node(0);
        Node res = temp;

        while (a != null && b != null) {
            if (a.data < b.data) {
                temp.bottom = a;
                temp = temp.bottom;
                a = a.bottom;
            } else {
                temp.bottom = b;
                temp = temp.bottom;
                b = b.bottom;
            }
        }

        if (a != null) temp.bottom = a;
        else temp.bottom = b;
        return res.bottom;

    }

    Node flatten(Node root) {

        if (root == null || root.next == null)
            return root;

        // recur for list on right
        root.next = flatten(root.next);

        // now merge
        root = mergeTwoLists(root, root.next);

        // return the root
        // it will be in turn merged with its left
        return root;
    }

    public void rotateLinkedListByKNodes(Node head1, int k) {
        if(head1 == null||head1.next == null||k == 0) show(head1);
        //calculating length
        Node temp = head1;
        int length = 1;
        while(temp.next != null) {
            ++length;
            temp = temp.next;
        }
        //link last node to first node
        temp.next = head1;
        k = k%length; //when k is more than length of list
        int end = length-k; //to get end of the list
        while(end--!=0) temp = temp.next;
        //breaking last node link and pointing to NULL
        head1 = temp.next;
        temp.next = null;
        show(head1);
    }

    static Node copyRandomList(Node head) {
        HashMap<Node,Node> hashMap=new HashMap<>();
        Node temp = head;
//first iteration for inserting deep nodes of every node in the hashmap.
        while(temp != null) {
            Node newNode = new Node(temp.data);
            hashMap.put(temp,newNode);
            temp = temp.next;
        }
        Node t = head;
//second iteration for linking next and random pointer as given question.
        while(t != null) {
            Node node = hashMap.get(t);
            node.next = (t.next != null) ? hashMap.get(t.next):null;
            node.random = (t.random != null) ? hashMap.get(t.random):null;
            t = t.next;
        }
        return hashMap.get(head);
    }
}
