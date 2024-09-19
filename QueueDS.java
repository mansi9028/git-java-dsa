import java.util.*;

public class QueueDS {

//   static class  Queue {
//     static int arr[];
//     static int size;
//     static int rear;
//     static int front;

//     Queue(int n) {
//       arr = new int[n];
//       size = n;
//       rear = -1;
//       front = -1;
//     }

//     public static boolean isEmpty() {
//       return rear == -1 && front == -1;
//     }

//     public static boolean isFull() { // circular queue
//       return (rear+1)%size == front;
//     }

//     //add
//     public static void add(int data) {
//       if(isFull()) {
//         System.out.println("Queue is full");
//         return;
//       }
//       if(front == -1) { // add 1st element
//         front = 0;
//       }
//       rear = (rear + 1)%size;
//       arr[rear] = data;
//     }

//     //remove 
//     public static int remove() {
//       if(isEmpty()) {
//         System.out.println("empty queue");
//         return -1;
//       }

//       int result = arr[front];
//       front = (front+1) % size;
//       // last element delete
//       if(rear == front) {
//         rear = front = -1;
//       } else {
//         front = (front+1)%size;
//       }
//       return result;
//     }

//     //peek
//     public static int peek() {
//       if(isEmpty()) {
//         System.out.println("empty queue");
//         return -1;
//       }
//       return arr[front];
//     }
//   }



// implementing queue using linkedlist
// static class Node {
//   int data;
//   Node next;

//   Node(int data) {
//     this.data = data;
//     this.next = null;
//   }
// }

// static class Queue {
//   static Node head = null;
//   static Node tail = null;

//   public static boolean isEmpty() {
//     return head == null && tail == null;
//   }

//   //add
//   public static void add(int data) {
//     Node newNode = new Node(data);
//     if(head == null) {
//       head = tail = newNode;
//       return;
//     } 
//     tail.next = newNode;
//     tail = newNode;
//   }

//   // remove
//   public static int remove() {
//     if(isEmpty()) {
//       System.out.println("empty queue");
//       return -1;
//     }

//     int front = head.data;
//     if(tail == head) { //single element
//       tail = head = null;
//     } else {
//       head = head.next;
//     }
//     return front;
//   }

//   // peek
//     public static int peek() {
//       if(isEmpty()) {
//         System.out.println("empty queue");
//         return -1;
//       }
//       return head.data;
//     }




// // queue using 2 stacks
// static class Queue {
//     static Stack<Integer> s1 = new Stack<>();
//     static Stack<Integer> s2 = new Stack<>();

//     public static boolean isEmpty() {
//       return s1.isEmpty();
//     }

//     //add
//     public static void add(int data) {
//       while(!s1.isEmpty()) {
//         s2.push(s1.pop());
//       }

//       s1.push(data);

//       while(!s2.empty()) {
//         s2.push(s1.pop());
//       }
//     }

//     // remove
//     public static int remove() {
//       if(isEmpty()) {
//         System.out.println("queue empty");
//         return -1;
//       }

//       return s1.pop();
//     }

//     //peek
//     public static int peek() {
//       if(isEmpty()) {
//         System.out.println("queue empty");
//         return -1;
//       }

//       return s1.peek();
//     }
//   }



  // static class Stack {
  //   static Queue<Integer> q1 = new LinkedList<>();
  //   static Queue<Integer> q2 = new LinkedList<>();

  //   public static boolean isEmpty() {
  //     return q1.isEmpty() && q2.isEmpty();
  //   }

  //   public static void push(int data) {
  //     if(!q1.isEmpty()) {
  //       q1.add(data);
  //     } else {
  //       q2.add(data);
  //     }
  //   }

  //   public static int pop() {
  //     if(isEmpty()) {
  //       System.out.println("Empty stack");
  //       return -1;
  //     }
  //     int top = -1;

  //     if(!q1.isEmpty()) { // case 1
  //       while(!q1.isEmpty()) {
  //         top = q1.remove();
  //         if(q1.isEmpty()) {
  //           break;
  //         }
  //         q2.add(top);
  //         } 
  //       } else { // case 2
  //       while(!q2.isEmpty()) {
  //           top = q2.remove();
  //           if(q2.isEmpty()) {
  //             break;
  //             }
  //           q1.add(top);
  //         }
  //       }
  //     return top;
  //   }

  //   public static int peek() {
  //     if(isEmpty()) {
  //       System.out.println("Empty stack");
  //       return -1;
  //     }
  //     int top = -1;

  //     if(!q1.isEmpty()) { // case 1
  //       while(!q1.isEmpty()) {
  //         top = q1.remove();
  //         q2.add(top);
  //       }
  //     } else { // case 2
  //       while(!q2.isEmpty()) {
  //           top = q2.remove();
  //           q1.add(top);
  //         }
  //       }
  //     return top;
  //   }
  // }




  // public static void printNonReapeating(String str) {
  //   int freq[] = new int[26];
  //   Queue<Character> q = new LinkedList<>();

  //   for(int i=0; i<str.length(); i++) {
  //     char ch = str.charAt(i);
  //     q.add(ch);
  //     freq[ch - 'a']++;

  //     while(!q.isEmpty() && freq[q.peek()-'a'] > 1) {
  //       q.remove();
  //     } 

  //     if(q.isEmpty()) {
  //       System.out.print("-1" + " ");
  //     }
  //     else {
  //       System.out.print(q.peek() + " ");
  //     }
  //   }

  //   System.out.println();
  // }



  // public static void interleave(Queue<Integer> q) {
  //   Queue<Integer> firstHalf = new LinkedList<>();
  //   int size = q.size();

  //   for(int i=0; i<size/2; i++) {
  //     firstHalf.add(q.remove());
  //   }

  //   while(!firstHalf.isEmpty()) {
  //     q.add(firstHalf.remove());
  //     q.add(q.remove());
  //   }

  // }



  // public static void queueReversal(Queue<Integer> q) {
  //   Stack<Integer> s = new Stack<>();

  //   while(!q.isEmpty()) {
  //     s.push(q.remove());
  //   }

  //   while(!s.isEmpty()) {
  //     q.add(s.pop());
  //   }
  // }


  // }




  // static class Stack {
  //   Deque<Integer> deque = new LinkedList<>();

  //   public void push(int data) {
  //     deque.addLast(data);
  //   }

  //   public int pop(int data) {
  //     return deque.removeLast();
  //   }

  //   public int peek(int data) {
  //     return deque.getLast();
  //   }



    static class Queue {
      Deque<Integer> deque = new LinkedList<>();

      public void add(int data) {
        deque.addLast(data);
      }

      public int remove(int data) {
        return deque.removeFirst();
      }

      public int peek(int data) {
        return deque.getFirst();
      }
    }

  public static void main(String[] args) {
    // Queue q = new Queue(3);
    // q.add(1);
    // q.add(2);
    // q.add(3);

    // while(!q.isEmpty()) {
    //   System.out.println(q.peek());
    //   q.remove();
    // }
    


    // queue using linked list
    // Queue q = new Queue();
    // q.add(1);
    // q.add(2);
    // q.add(3);

    // while(!q.isEmpty()) {
    //   System.out.println(q.peek());
    //   q.remove();
    // }



    // queue using JCF
    // Queue<Integer> q = new LinkedList<>(); // LinkedList <=> ArrayDeque
    // q.add(1);
    // q.add(2);
    // q.add(3);

    // while(!q.isEmpty()) {
    //     System.out.println(q.peek());
    //     q.remove();
    //   }



    // queue using 2 stacks
    // Queue q = new Queue();
    // q.add(1);
    // q.add(2);
    // q.add(3);

    // while(!q.isEmpty()) {
    //   System.out.println(q.peek());
    //   q.remove();
    // }




    // stack using 2 queues
    // Stack s = new Stack();
    // s.push(1);
    // s.push(2);
    // s.push(3);

    // while(!s.isEmpty()) {
    //   System.out.println(s.peek());
    //   s.pop();
    // }




    //q4 - first non-repeating letter in a stream of characters
    // String str = "aabccxb";

    // printNonReapeating(str);



    //q5 - interleave 2 halves of a queue(even length)
    // Queue<Integer> q = new LinkedList<>();
    // q.add(1);
    // q.add(2);
    // q.add(3);
    // q.add(4);
    // q.add(5);
    // q.add(6);
    // q.add(7);
    // q.add(8);
    // q.add(9);
    // q.add(10);

    // interleave(q);
    // //print q
    // while(!q.isEmpty()) {
    //   System.out.print(q.remove() + " ");
    // }
    // System.out.println();





    
    
    //Q6 - QUEUE REVERSAL
    // Queue<Integer> q = new LinkedList<>();
    // q.add(1);
    // q.add(2);
    // q.add(3);
    // q.add(4);
    // q.add(5);

    // queueReversal(q);

    // while(!q.isEmpty()) {
    //   System.out.print(q.remove() + " ");
    // }
    // System.out.println();






    // DEQUE - double ended queue
    // Deque <Integer> deque = new LinkedList<>();
    // deque.addFirst(1);
    // deque.addFirst(2);
    // deque.addFirst(3);
    // System.out.println(deque);
    // deque.remove(3);
    // System.out.println(deque);




    // stack and queue using deque
    // Stack s = new Stack();
    // s.push(1);
    // s.push(2);
    // s.push(3);
    // System.out.println("peek is: " + s.peek());
    // System.out.println(s.pop());
    // System.out.println(s.pop());
    // System.out.println(s.pop());
  

    // Queue q = new Queue();
    // q.add(1);
    // q.add(2);
    // q.add(3);

    // System.out.println("peek = " + q.peek(3));
    // System.out.println(q.remove(1));
    // System.out.println(q.remove(2));
    // System.out.println(q.remove(3));












    //Assignment questions
    

  }
}

