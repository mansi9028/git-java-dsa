// import java.util.LinkedList;

public class Linkedlist {

  // public static class Node {
  //   int data;
  //   Node next;

  //   public Node(int data) {
  //     this.data = data;
  //     this.next = null;
  //   }
  // }
  
  // public static Node head;
  // public static Node tail;
  // public static int size;

  // public void addFirst(int data) {
  //   // step1 - create new node
  //   Node newNode = new Node(data);
  //   size++;
  //   if(head == null) {
  //     head = tail = newNode;
  //     return;
  //   }

    
  //   // step2 - newNode next points towards head
  //   newNode.next = head; // linking

  //   // step3 - head = newNode
  //   head = newNode;
  // }

  // public void addLast(int data) {
  //   // step1 - create newNode
  //   Node newNode = new Node(data);
  //   size++;
  //   if(head == null) {
  //     head = tail = newNode;
  //     return;
  //   }

  //   // step2 
  //   tail.next = newNode;

  //   // step3
  //   tail = newNode;

  // }

  // public void print() {
  //   if(head == null) {
  //     System.out.println("linked list is empty");
  //     return;
  //   }
  //   Node temp = head;
  //   while(temp != null) {
  //     System.out.print(temp.data + "->");
  //     temp = temp.next;
  //   }
  //   System.out.println("null");
  // }

  // public void add(int idx, int data) {
  //   if(idx == 0) {
  //     addFirst(data);
  //     return;
  //   }
  //   Node newNode = new Node(data);
  //   size++;
  //   Node temp = head;
  //   int i = 0;

  //   while(i < idx-1) {
  //     temp = temp.next;
  //     i++;
  //   }

  //   // i = idx-1; temp -> prev
  //   newNode.next = temp.next;
  //   temp.next = newNode;

  // }

  // public int removeFirst() { 
  //   if(size == 0) {
  //     System.out.println("LL is empty");
  //     return Integer.MIN_VALUE;
  //   } else if(size == 1){
  //     int val = head.data;
  //     head = tail = null;
  //     size = 0;
  //     return val;
  //   }
  //   int val = head.data;
  //   head = head.next;
  //   size--;
  //   return val;
  // }

  // public int removeLast() {
  //   if(size == 0) {
  //     System.out.println("LL is empty. ");
  //     return Integer.MIN_VALUE;
  //   } else if(size == 1) {
  //     int val = head.data;
  //     head = tail = null;
  //     size = 0;
  //     return val;
  //   }
  //   // prev: i = size-2
  //   Node prev = head;
  //   for(int i=0; i<size-2; i++) {
  //     prev = prev.next;
  //   }

  //   int val = prev.next.data; // OR we can say tail.data
  //   prev.next = null;
  //   tail = prev;
  //   size--;
  //   return val;
  // }

  // public int iterativeSearch(int key) {
  //   Node temp = head;
  //   int i = 0;

  //   while(temp != null) {
  //     if(temp.data == key) { // key found
  //       return i;
  //     }
  //     temp = temp.next;
  //     i++;
  //   }
  //   // key not found
  //   return -1;
  // }
  // public int helper(Node head, int key) { // O(n)
  //   if(head == null) {
  //     return -1;
  //   }

  //   if(head.data == key) {
  //     return 0;
  //   }

  //   int idx = helper(head.next, key);
  //   if(idx == -1) {
  //     return -1;
  //   }
  //   return idx+1;
  // }
  // public int reccursiveSearch(int key) {
  //   return helper(head, key);
  // }

  // public void reverseLL() {
  //   Node prev = null;
  //   Node curr = tail = head;
  //   Node next;

  //   while(curr != null) {
  //     next = curr.next;
  //     curr.next = prev;
  //     prev = curr;
  //     curr = next;
  //   }
  //   head = prev;
  // }

  // public void deleteNthFromEnd(int n) {
  //   // claculate size
  //   int sz = 0; // sz is size
  //   Node temp = head;
  //   while(temp != null) {
  //     temp = temp.next;
  //     sz++;
  //   }

  //   if(n == sz) {
  //     head = head.next; // removeFirst
  //     return;
  //   }

  //   // sz-n
  //   int i=3;
  //   int iToFind = sz-n;
  //   Node prev = head;
  //   while(i < iToFind) {
  //     prev = prev.next;
  //     i++;
  //   }

  //   prev.next = prev.next.next;
  //   return;

  // }

  // // Slow-Fast Approach
  // public Node findMid(Node head) {
  //   Node slow = head;
  //   Node fast = head;

  //   while(fast != null && fast.next != null) {
  //     slow = slow.next;
  //     fast = fast.next.next;
  //   }
  //   return slow; // slow is my midNode
  // }

  // public boolean checkPalindrome() {
  //   if(head == null || head.next == null) {
  //     return true;
  //   }
  //   // step1 - find midNode
  //   Node midNode = findMid(head);

  //   // step2 - reverse IInd half
  //   Node prev = null;
  //   Node curr = midNode;
  //   Node next;
  //   while(curr != null) {
  //     next = curr.next;
  //     curr.next = prev;
  //     prev = curr;
  //     curr = next;
  //   }

  //   Node right = prev; //right half head
  //   Node left = head;

  //   // step3 - check left half nad right half
  //   while(right != null) {
  //     if(left.data != right.data) {
  //       return false;
  //     }
  //     left = left.next;
  //     right = right.next;
  //   }
  //   return true;
  // }

  // public static boolean isCycle() {
  //   Node slow = head;
  //   Node fast = head;

  //   while(fast != null && fast.next != null) {
  //     slow = slow.next; // +1
  //     fast = fast.next.next; // +2
  //     if(slow == fast) {
  //       return true; // cycle exists
  //     }
  //   }
  //   return false; // cycle doesn't exists
  // }

  // public static void removeCycle() {
  //   // detect cycle
  //   Node slow = head;
  //   Node fast = head;
  //   boolean exists = false;
  //   while(fast != null && fast.next != null) {
  //     slow = slow.next;
  //     fast = fast.next.next;
  //     if(slow == fast) {
  //       exists = true;
  //       break;
  //     }
  //   }
  //   if(exists == false) {
  //     return;
  //   }

  //   // find meeting point
  //   slow = head;
  //   Node prev = null; // last node
  //   while(slow != fast) {
  //     prev = fast;
  //     slow = slow.next;
  //     fast = fast.next;
  //   }
    
  //   // remove cycle -> last.next = null
  //   prev.next = null;
  // }

  // private Node merge(Node head1, Node head2) {
  //   Node mergedLL = new Node(-1);
  //   Node temp = mergedLL;

  //   while(head1 != null && head2 != null) {
  //     if(head1.data <= head2.data) {
  //       temp.next = head1;
  //       head1 = head1.next;
  //       temp = temp.next;
  //     } else {
  //       temp = head2.next;
  //       head2 = head2.next;
  //       temp = temp.next;
  //     }
  //   }

  //   while(head1 != null) {
  //     temp.next = head1;
  //     head1 = head1.next;
  //     temp = temp.next;
  //   }

  //   while(head2 != null) {
  //     temp.next = head2;
  //     head2 = head2.next;
  //     temp = temp.next;
  //   }

  //   return mergedLL.next;
  // }

  // private Node getMid(Node head) {
  //   Node slow = head;
  //   Node fast = head.next;

  //   while(fast != null && fast.next != null) {
  //     slow = slow.next;
  //     fast = fast.next.next;
  //   }
  //   return slow; // slow is mid node
  // }


  // public Node mergeSort(Node head) {
  //   if(head == null || head.next == null) {
  //     return head;
  //   }

  //   // find mid
  //   Node mid = getMid(head);

  //   // left and right call MS
  //   Node rightHead = mid.next;
  //   mid.next = null;
  //   Node newLeft = mergeSort(head);
  //   Node newRight = mergeSort(rightHead);

  //   // merge
  //   return merge(newLeft, newRight);
  // }

  // public void zigZag() {
  //   // find mid
  //   Node slow = head;
  //   Node fast = head.next;
  //   while(fast != null && fast.next != null) {
  //     slow = slow.next;
  //     fast = fast.next.next;
  //   }
  //   Node mid = slow;

  //   // reverse 2nd half
  //   Node curr = mid.next;
  //   mid.next = null;
  //   Node prev = null;
  //   Node next;

  //   while(curr != null) {
  //     next = curr.next;
  //     curr.next = prev;
  //     prev = curr;
  //     curr = next;
  //   }

  //   Node left = head;
  //   Node right = prev;
  //   Node nextL, nextR;

  //   // alternate merge - zig-zag merge
  //   while(left != null && right != null) {
  //     nextL = left.next;
  //     left.next = right;
  //     nextR = right.next;
  //     right.next = nextL;

  //     left = nextL;
  //     right = nextR;
  //   }
  // }

  public class Node{
    int data;
    Node next;
    Node prev;

    public Node(int data) {
      this.data = data;
      this.next = null;
      this.prev = null;
    }
  }

  public static Node head;
  public static Node tail;
  public static int size;
  
  // add first in dll
  public void addFirst(int data) {
    Node newNode = new Node(data);
    size++;
    if(head == null) {
      head = tail = newNode;
      return;
    }

    newNode.next = head;
    head.prev = newNode;
    head = newNode;
  }


  // print dll
  public void print() {
    Node temp = head; 
    while(temp != null) {
      System.out.print(temp.data + "<->");
      temp = temp.next;
    }
    System.out.println("null");

  }
  

  // remove first in dll
  public int removeFirst() {
    if(head == null) {
      System.out.println("DLL is empty");
      return Integer.MIN_VALUE;
    }

    if(size == 1) {
      int val = head.data;
      head = tail = null;
      size--;
      return val;
    }
    int val = head.data;
    head = head.next;
    head.prev = null;
    size--;
    return val;
  }


  public void reverse() {
    Node curr = head;
    Node prev = null;
    Node next;

    while(curr != null) {
      next = curr.next;
      curr.next = prev;
      curr.prev = next;

      prev = curr;
      curr = next;
    }
    head = prev;
  }
  public static void main(String[] args) {

//     // LinkedList ll = new LinkedList();
//     // ll.print();
//     // ll.addFirst(3);
//     // // ll.print();
    // ll.addFirst(1);
    // // ll.print();
    // ll.add(1, 2);
    // ll.addLast(4);
    // // ll.print();
    // ll.addLast(5);
    // ll.print();

    // display size of LL
    // System.out.println(ll.size);
    // ll.removeFirst();
    // ll.print();

    // ll.removeLast();
    // ll.print();
    // System.out.println(ll.size);


    // Iterative Search 
    // search for a key in a LL. Return the position where it si found. if not found, return -1.
    // System.out.println(ll.iterativeSearch(9));
    // System.out.println(ll.iterativeSearch(99));



    // Recursive search
    // search for a key in a LL. Return the position where it is found. if not found, return -1. use recursion
    // System.out.println(ll.reccursiveSearch(9));
    // System.out.println(ll.reccursiveSearch(99));



    // ***** Reverse a LL (Iterative approach) *****  - O(n)
    // ll.reverseLL();
    // ll.print();



    // Find and remove Nth node from end
    // ll.deleteNthFromEnd(3);
    // ll.print();



    // check if a LL is Palindrome 
    // ll.addLast(1);
    // ll.addLast(2);
    // ll.addLast(2);
    // ll.addLast(1);

    // ll.print();
    // System.out.println(ll.checkPalindrome());


    // detect a loop/cycle in a LL
    // Flody's cycle finding algorithm(CFA) - slow and fast
    // head = new Node(1);
    // head.next = new Node(2);
    // head.next.next = new Node(3);
    // head.next.next.next = head;

    // System.out.println(isCycle());




    // remove a loop/cycle in a LL
    // head = new Node(1);
    // Node temp = new Node(2);
    // head.next = temp;
    // head.next.next = new Node(3);
    // head.next.next.next = temp;

    // System.out.println(isCycle());
    // removeCycle();
    // System.out.println(isCycle());




    

    // // LL in Java Collections Framework
    // // create
    // LinkedList<Integer> ll = new LinkedList<>();


    // // add
    // ll.addFirst(2);
    // ll.addFirst(1);
    // ll.addLast(3);

    // System.out.println(ll);



    // // remove 
    // ll.removeLast();
    // ll.removeFirst();

    // System.out.println(ll);



    // Merge sort in a LL
    // LinkedList ll = new LinkedList();

    // ll.addFirst(1);
    // ll.addFirst(2);
    // ll.addFirst(3);
    // ll.addFirst(4);
    // ll.addFirst(5);
    // ll.addFirst(6);

    // ll.print();
    // ll.mergeSort(head);
    // ll.print();



    // Zig-Zag LL
    // LinkedList zz = new LinkedList();

    // zz.addLast(1);
    // zz.addLast(2);
    // zz.addLast(3);
    // zz.addLast(4);
    // zz.addLast(5);

    // zz.print();

    // zz.zigZag();
    // zz.print();






































    // Doubly Linked list
    // DoubleLL dll = new DoubleLL();
    // dll.addFirst(3);
    // dll.addFirst(2);
    // dll.addFirst(1);

    // dll.print();
    // System.out.println(dll.size);



    // dll.removeFirst();
    // dll.print();
    // System.out.println(dll.size);



    // reverse a doubly linked list
    // DoubleLL dll = new DoubleLL();
    // dll.addFirst(3);
    // dll.addFirst(2);
    // dll.addFirst(1);

    // dll.print();
    // dll.reverse();
    // dll.print();



    // circular LL
    

    

    



  }
}
