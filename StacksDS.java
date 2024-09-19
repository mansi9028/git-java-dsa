import java.util.*;

public class StacksDS {

//   static class Stack {  // IPLEMENTING STACKS USING ARRAYLIST
//     static ArrayList<Integer> list = new ArrayList<>();
//     public static boolean isEmpty() {
//       return list.size() == 0;
//     }

//     // push
//     public static void push(int data) {
//       list.add(data);
//     }

//     // pop
//     public static int pop() {
//       if(isEmpty()) {
//         return -1;
//       }
//       int top = list.get(list.size() - 1);
//       list.remove(list.size()-1);
//       return top;
//     }

//     // peek
//     public static int peek() {
//       if(isEmpty()) {
//         return -1;
//       }
//       return list.get(list.size() - 1);
//     }

//   }





// IMPLEMNETING STACKS USING LINKEDLIST
//   static class Node {
//     int data;
//     Node next;
//     Node(int data) {
//       this.data = data;
//       this.next = null;
//     }
//   }

//   static class Stack {  
//     static Node head = null;

//     public static boolean isEmpty() {
//       return head == null;
//     }

//     // push
//     public static void push(int data) {
//       Node newNode = new Node(data);
//       if(isEmpty()) {
//         head = newNode;
//         return;
//       }

//       newNode.next = head;
//       head = newNode;
//     }

//     // pop
//     public static int pop() {
//       if(isEmpty()) {
//         return -1;
//       }

//       int top = head.data;
//       head = head.next;
//       return top;
//     }

//     // peek
//     public static int peek() {
//       if(isEmpty()) {
//         return -1;
//       }
//       return head.data;
//     }
//   }


public static void pushAtBottom(Stack<Integer> s, int data) {
  if(s.empty()) {
    s.push(data);
    return;
  }
  int top = s.pop();
  pushAtBottom(s, data);
  s.push(top);
}

public static String reverseString(String str) {
  Stack<Character> s = new Stack<>();
  int idx =0;
  while(idx < str.length()) {
    s.push(str.charAt(idx));
    idx++;
  }

  StringBuilder result = new StringBuilder("");
  while(!s.empty()) {
    char curr = s.pop();
    result.append(curr);
  }

  return result.toString();
}

public static void reverseStack(Stack<Integer> s) {
  if(s.empty()) {
    return;
  }

  int top = s.pop();
  reverseStack(s);
  pushAtBottom(s, top);
}

public static void printStack(Stack<Integer> s) {
  while(!s.empty()) {
    System.out.println(s.pop());
  }
}

public static void stockSpan(int stocks[], int span[]) {
  Stack<Integer> s = new Stack<>();
  span[0] = 1;
  s.push(0);

  for(int i=1; i<stocks.length; i++) {
    int currPrice = stocks[i];
    while(!s.empty() && currPrice > stocks[s.peek()]) {
      s.pop();
    }
    
    if(s.empty()) {
      span[i] = i+1;
    } else {
      int prevHigh = s.peek();
      span[i] = i - prevHigh;
    }

    s.push(i);
  }
}

public static boolean isValid(String str) {
  Stack<Character> s = new Stack<>();

  for(int i=0; i<str.length(); i++) {
    char ch = str.charAt(i);

    if(ch == '(' || ch == '[' || ch == '{') { // opening parentheses
      s.push(ch);  
    } else { // closing parentheses
      if(s.empty()) {
        return false;
      }
      if( (s.peek() == '(' && ch == ')') || (s.peek() == '{' && ch == '}') || (s.peek() == '[' && ch == ']') ) {
        s.pop(); 
      } else {
        return false;
      }
    }
  }
  if(s.empty()) {
    return true;
  } else {
    return false;
  }
}

  public static boolean isDuplicate(String str) { // O(n)
    Stack<Character> s = new Stack<>();

    for(int i=0; i<str.length(); i++) {
      char ch = str.charAt(i);

      // closing
      if(ch == '}') {
        int count=0;
        while(s.pop() != '{') {
          count++;
        } 
        if(count < 1) {
          return true; // duplicate
        } 
      } else { //opening
        s.push(ch);
      }
    } 
    return false;
  }

  public static void maxAreaInHistogram(int arr[]) { //  O(n) - OPTIMISED
    int maxArea = 0;
    int nsr[] = new int[arr.length]; // next smaller right
    int nsl[] = new int[arr.length]; // next smaller left

    // next smaller right - O(n)
    Stack<Integer> s = new Stack<>();

    for(int i=arr.length-1; i>=0; i--) {
      while(!s.empty() && arr[s.peek()] >= arr[i]) {
        s.pop();
      }  
      if(s.empty()) {
        nsr[i] = arr.length;
      } else {
        nsr[i] = s.peek();
      }
      s.push(i);
    }

    // next smaller left -  O(n)
    s = new Stack<>();

    for(int i=0; i<=arr.length-1; i++) {
      while(!s.empty() && arr[s.peek()] >= arr[i]) {
        s.pop();
      }  
      if(s.empty()) {
        nsl[i] = -1;
      } else {
        nsl[i] = s.peek();
      }
      s.push(i);
    }

    // current area : Width = j-i-1 = nsr[i]-nsr[i]-1 -  O(n)
    for(int i=0; i<arr.length; i++) {
      int height = arr[i];
      int width = nsr[i] - nsl[i] -1;
      int currArea = height * width;
      maxArea = Math.max(maxArea, currArea);
    }
    System.out.println("Maximum area in histogram = " + maxArea);
  }
  public static void main(String args[]) {
    // Stack s = new Stack();
    // s.push(1);
    // s.push(2);
    // s.push(3);
  
    // while(!s.isEmpty()) {
    //   System.out.println(s.peek());
    //   s.pop();
    // }




    // IMPLEMENTING STACKS USING JAVA COLLECTION FRAMEWORKS
    // Stack<Integer> s = new Stack<>();
    // s.push(1);
    // s.push(2);
    // s.push(3);

    // while(!s.isEmpty()) {
    //   System.out.println(s.peek());
    //   s.pop();
    // }





    //  QUES- push at the bottom of the stack
    // we'll solve this using RECURSION having O(n) - linear time complexity
    // Stack<Integer> s = new Stack<>();
    // s.push(1);
    // s.push(2);
    // s.push(3);

    // pushAtBottom(s, 4);
    // while(!s.empty()) {
    //   System.out.println(s.pop());
    // }



    // QUES- reverse a string using a stack
    // String str = "HelloWorld";
    // System.out.println(reverseString(str));




    // Ques- reverse a stack
    // Stack<Integer> s = new Stack<>();
    // s.push(1);
    // s.push(2);
    // s.push(3);

    // reverseStack(s);
    // printStack(s);





    // QUES- stock span problem
    // int stocks[] = {100, 80, 60, 70, 60, 85, 100};
    // int span[] = new int[stocks.length];
    // stockSpan(stocks, span);

    // for(int i = 0; i<span.length; i++) {
    //   System.out.println(span[i] + " ");
    // }





//     // QUES- ******next greater element***** 
//     // O(n)
//     // different forms of this ques - next greater right, next greater  left, next smaller right, next smaller left
//     int arr[] = {6, 8, 0, 1, 3};
//     Stack<Integer> s = new Stack<>();
//     int nextGreater[] = new int[arr.length];

//     for(int i = arr.length-1; i>=0; i-- ) {
//       // while loop
//       while(!s.empty() && arr[s.peek()] <= arr[i]) {
//         s.pop();
//       }

//       // if-else
//       if(s.empty()) {
//         nextGreater[i] = -1;
//       } else {
//         nextGreater[i] = arr[s.peek()];
//       }

//       // push in s
//       s.push(i);
//     }

//     for(int i=0; i<nextGreater.length; i++) {
//       System.out.print(nextGreater[i] + " ");
//     }
//     System.out.println();







    // valid parentheses - O(n)
    // String str = "({})[]";
    // System.out.println(isValid(str));



    // duplicate parentheses
    // String str = "{{a+b}}"; // true
    // String str2 = "{a-b}";
    // System.out.println(isDuplicate(str));




    // max rectangular area in histogram
    // int arr[] = {2, 1, 5, 6, 2, 3}; // heights in histogram. ans - 10 
    // maxAreaInHistogram(arr);






    // Assignment
    

  }
}
