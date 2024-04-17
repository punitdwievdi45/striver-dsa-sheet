package striversheet.linkedlist;

public class Main {

    public static void main(String[] args) {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.insert(10);
        customLinkedList.insert(20);
        customLinkedList.insert(30);
        customLinkedList.inserAtStart(5);
        //customLinkedList.insertAtLast(40);
        customLinkedList.insertAtIndex(2, 15);
        // customLinkedList.deleteAt(2);
        customLinkedList.show();
        customLinkedList.findMiddleElement(customLinkedList);
        customLinkedList.reverseUsingStack();
        customLinkedList.show();
        System.out.println("After iterative reverse");
        customLinkedList.iterativeReverse();
        //customLinkedList.show();

        Node head1 = new Node(5);
        head1.next = new Node(10);
        head1.next.next = new Node(15);
        head1.next.next.next = new Node(40);
        System.out.println("Printing head1");
        customLinkedList.show(head1);
        Node head2 = new Node(2);
        head2.next = new Node(3);
        head2.next.next = new Node(20);
        System.out.println("Printing head2");
        customLinkedList.show(head2);
        System.out.println("Printing merged list");
        customLinkedList.mergeTwoSortedLinkedList(head1, head2);
        System.out.println("Iterative merge with O(1) complexity");
        customLinkedList.mergeTwoLinkedListWithO1Complexity(head1, head2);
        System.out.println("Printing head1");
        customLinkedList.show(head1);
        System.out.println("Printing head1 after removing nth node from end");
        customLinkedList.removeNthFromEnd(head1, 4);
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);
        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);
        System.out.println("Linked afer adding two numbers");
        customLinkedList.addTwoNumbersAsLinkedList(l1, l2);
        System.out.println("Intersection of two linked list");
        l2.next.next.next = l1.next.next;
        Node node = customLinkedList.findIntersectionWithExtraSpace(l1, l2);
        if (node == null) {
            System.out.println("No intersection");
        } else {
            System.out.println("Intersection point is " + node.data);
        }
        Node intersectionPoint = customLinkedList.findIntersectionWithO1SpaceComplexity(l1, l2);
        if (intersectionPoint == null) {
            System.out.println("No intersection");
        } else {
            System.out.println("Intersection point using 01 space complexity is " + intersectionPoint.data);
        }
        Node cycleHead = new Node(3);
        cycleHead.next = new Node(2);
        cycleHead.next.next = new Node(0);
        cycleHead.next.next.next = new Node(-4);
        cycleHead.next.next.next.next = cycleHead.next;
        boolean isCycle = customLinkedList.detectCycle(cycleHead);
        if (isCycle) {
            System.out.println("Cycle is present");
        } else {
            System.out.println("Cycle is not present");
        }
        Node reverse = new Node(1);
        reverse.next = new Node(2);
        reverse.next.next = new Node(3);
        reverse.next.next.next = new Node(4);
        reverse.next.next.next.next = new Node(5);
        System.out.println("Reversing linked list in groups");
        customLinkedList.reverseLinkedListInGroups(reverse,2);
        Node isPalindrome = new Node(1);
        isPalindrome.next = new Node(2);
        isPalindrome.next.next = new Node(2);
        isPalindrome.next.next.next = new Node(1);
        boolean isPalindromePresent = customLinkedList.checkIfListIsPalindrome(isPalindrome);
        if (isPalindromePresent) {
            System.out.println("List is palindrome");
        } else {
            System.out.println("List is not palindrome");
        }

        Node findStartOfLoop = new Node(3);
        findStartOfLoop.next = new Node(2);
        findStartOfLoop.next.next = new Node(0);
        findStartOfLoop.next.next.next = new Node(-4);
        findStartOfLoop.next.next.next.next = findStartOfLoop.next.next;
        System.out.println("Finding start of loop");
        Node startOfLoop = customLinkedList.detectCycleAndReturnStartOfLoop(findStartOfLoop);
        if (startOfLoop == null) {
            System.out.println("No loop");
        } else {
            System.out.println("Start of loop is " + startOfLoop.data);
        }
        Node rotate = new Node(1);
        rotate.next = new Node(2);
        rotate.next.next = new Node(3);
        rotate.next.next.next = new Node(4);
        rotate.next.next.next.next = new Node(5);
        System.out.println("Rotating linked list by k nodes");
        customLinkedList.rotateLinkedListByKNodes(rotate, 2);
    }

}
