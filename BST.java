// import java.util.*;


public class BST {
  // static class Node {
  //   int data;
  //   Node left;
  //   Node right;

  //   Node(int data) {
  //     this.data = data;
  //   }
  // }

  // return null;
  //   }
    
    // int mid = (start+end)/2;
    // Node root = new Node(arr[mid]);
    
    // root.left = sortedArrayToBST(arr, start, mid-1);
    // root.right = sortedArrayToBST(arr, mid+1, end);
    // return root;
  // //mirror a BST ki class
  // static class Node {
  //   int data;
  //   Node left;
  //   Node right;

  //   public Node(int data) {
  //     this.data = data;
  //     this.left = this.right = null;
  //   }
  // }

  // //builds a BST
  // public static Node insert(Node root, int val) {
  //   if(root == null) {
  //     root = new Node(val);
  //     return root;
  //   }

  //   if(root.data > val) {
  //     // left subtree
  //     root.left = insert(root.left, val);
  //   } else {
  //     // right subtree
  //     root.right = insert(root.right, val);
  //   }
  //   return root;
  // }

  // public static void inorder(Node root) {
  //   if(root == null) {
  //     return;
  //   }
  //   inorder(root.left);
  //   System.out.print(root.data + " ");
  //   inorder(root.right);
  // }

  // //search a BST - O(H) {H is the heif=ght of the tree}
  // public static boolean search(Node root, int key) {
  //   if(root == null) {
  //     return false;
  //   }

  //   if(root.data == key) {
  //     return true;
  //   }

  //   if(root.data > key) {
  //     return search(root.left, key);
  //   }

  //   else {
  //     return search(root.right, key);
  //   }
  // }


  // // delete a node
  // public static Node delete(Node root, int val) {
  //   if(root.data < val) {
  //     root.right = delete(root.right, val);
  //   }

  //   else if(root.data > val) {
  //     root.left = delete(root.left, val);
  //   }

  //   else {
  //     // case 1 - leaf node
  //     if(root.left == null && root.right == null) {
  //       return null;
  //     }

  //     // case 2 - single child
  //     if(root.left == null) {
  //       return root.right;
  //       } else if (root.right == null) {
  //       return root.left;
  //       }

  //       // case 3 - two children
  //       Node IS = findInorderSuccessor(root.right);
  //       root.data = IS.data;
  //       root.right = delete(root.right, IS.data);
  //     }
  //     return root;
  // }

  // public static Node findInorderSuccessor(Node root) {
  //   while(root.left != null) {
  //     root = root.left;
  //   }
  //   return root;
  // }


  // // print in range
  // public static void printInRange(Node root, int k1, int k2) {
  //   if(root == null) {
  //     return;
  //   }
  //   if(root.data >= k1 && root.data <= k2) {
  //     printInRange(root.left, k1, k2);
  //     System.out.print(root.data + " ");
  //     printInRange(root.right, k1, k2);
  //   } else if(root.data < k1) {
  //     printInRange(root.left, k1, k2);
  //   } else {
  //     printInRange(root.right, k1, k2);
  //   }
  // }



  // // root to leaf paths
  // public static void printPath(ArrayList<Integer> path) {
  //   for(int i=0; i<path.size(); i++) {
  //     System.out.print(path.get(i) + "->");
  //   }
  //   System.out.println("Null");
  // }

  // public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
  //   if(root == null) {
  //     return;
  //   }
  //   path.add(root.data);
  //   if(root.left == null && root.right == null) {
  //     printPath(path);
  //   }
  //   printRoot2Leaf(root.left, path);
  //   printRoot2Leaf(root.right, path);

  //   path.remove(path.size()-1);
  // }



  // // validate a BST
  // public static boolean isValidBST(Node root, Node min, Node max) {
  //   if(root == null) {
  //     return true;
  //   }

  //   if(min != null && root.data <= min.data) {
  //     return false;
  //   }

  //   else if(max != null && root.data >= max.data) {
  //     return false;
  //   }

  // return isValidBST(root.left, min, root) 
  //         && isValidBST(root.right, root, max);

  // }



  // // mirror a BST - O(n)
  // public static  Node createMirror(Node root) {
  //   if(root == null) {
  //     return null;
  //   }

  //   Node leftMirror = createMirror(root.left);
  //   Node rightMirror = createMirror(root.right);

  //   root.left = rightMirror;
  //   root.right = leftMirror;

  //   return root;
  // }

  // public static void preorder(Node root) {
  //   if(root == null) {
  //     return;
  //   }

  //   System.out.print(root.data + " ");
  //   preorder(root.left);
  //   preorder(root.right);
  // }

  //   // sorted array to balanced BST - {with min possible height}
  // public static Node sortedArrayToBST(int arr[] , int start, int end) {
  //   if(start > end) {
  // }
// 
// 
    // //convert BST to balanced BST
    // public static Node balancedBST(Node root) {
      // //inorder seq
      // ArrayList<Integer> inorder = new ArrayList<>();
      // getInorder(root, inorder);
// 
// 
      // //sorted inorder -> balanced BST
      // root = createBST(inorder, 0, inorder.size()-1);
      // return root;
// 
    // }
// 
    // public static void getInorder(Node root, ArrayList<Integer> inorder) {
      // if(root == null) {
        // return;
      // }
      // getInorder(root.left, inorder);
      // inorder.add(root.data);
      // getInorder(root.right, inorder);
    // }
// 
    // public static Node createBST(ArrayList<Integer> inorder, int start , int end) {
      // if(start > end) {
        // return null;
      // }
// 
      // int mid =(start+end)/2;
      // Node root = new Node(inorder.get(mid));
      // root.left = createBST(inorder, start, mid-1);
      // root.right = createBST(inorder, mid+1, end);
      // return root;
    // }
// 
// 
    // //size of largest BST in a BT
    // static  class Info {
      // boolean isBST;
      // int size;
      // int min;
      // int max;
// 
      // public Info(boolean isBST, int size, int min, int max) {
        // this.isBST = isBST;
        // this.size = size;
        // this.min = min;
        // this.max = max;
      // }
// 
    // }
// 
    // public static int maxBST = 0;
// 
    // public static Info largestBST(Node root) {
      // if(root == null) {
        // return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
      // }
// 
      // Info leftInfo = largestBST(root.left);
      // Info rightInfo = largestBST(root.right);
// 
      // int size = leftInfo.size + rightInfo.size + 1;
      // int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
      // int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));
// 
      // if(root.data <= leftInfo.max || root.data >= rightInfo.min) {
        // return new Info(false, size, min, max);
      // }
// 
      // if(leftInfo.isBST && rightInfo.isBST) {
        // maxBST= Math.max(maxBST, size);
        // return new Info(true, size, min, max);
      // }
// 
      // return new Info(false, size, min, max);
// 
    // }
// 
// 
// 
    // //Merge 2 BSTs
    // public static Node mergeBSTs(Node root1, Node root2) {
      // // step1
      // ArrayList<Integer> arr1 = new ArrayList<>();
      // getInorder(root1, arr1);
// 
      // //step2
      // ArrayList<Integer> arr2 = new ArrayList<>();
      // getInorder(root2, arr2);
// 
      // //step 3 - merge
      // int i=0, j=0;
      // ArrayList<Integer> finalArr = new ArrayList<>();
      // while(i<arr1.size() && j<arr2.size()) {
        // if(arr1.get(i) <= arr2.get(j)) {
          // finalArr.add(arr1.get(i));
          // i++;
        // } else {
          // finalArr.add(arr2.get(j));
          // j++;
        // }
      // }
// 
      // while(i<arr1.size()) {
        // finalArr.add(arr1.get(i));
        // i++;
      // }
// 
      // while(j<arr2.size()) {
        // finalArr.add(arr2.get(j));
        // j++;
      // }
      // 
      // //step4 - sorted arraylist -> balanaced BST
      // return createBST(finalArr, 0, finalArr.size()-1);
    // }










    //AVL
    static class Node {
      int data, height;
      Node left, right ;

      Node(int data) {
        this.data = data;
        height = 1;
      }
    }

    public static Node root;

    public static int height(Node root) {
      if(root == null) {
        return 0;
      }
      return root.height;
    }


    // left rotate subtree rotated with x
    public static Node leftRotate(Node x) {
      Node y = x.right;
      Node T2 = y.left;

      // perform rotation
      y.left = x;
      x.right = T2;

      //update heights
      x.height = Math.max(height(x.left), height(x.right)) + 1;
      y.height = Math.max(height(y.left), height(y.right)) + 1;

      //return new root
      return y;
    }

    // right rotate subtree rotated with y
    public static Node rightRotate(Node y) {
      Node x = y.left;
      Node T2 = x.right;

      //perform rotation using 3 nodes
      x.right = y;
      y.left = T2;

      //update heights
      y.height = Math.max(height(y.left), height(y.right)) + 1;
      x.height = Math.max(height(x.left), height(x.right)) + 1;

      // return new root
      return x;

    }



    //get balance factor of node
    public static int getBalance(Node root) {
      if(root == null) {
        return 0;
      }

      return height(root.left) - height(root.right);
    }


    public static Node insert(Node root, int key) {
      if(root == null) {
        return new Node(key);
      }

      if(key < root.data) {
        root.left = insert(root.left, key); 
      } else if (key > root.data) {
        root.right = insert(root.right, key);
      } else {
        return root; // dupictae keys not allowed
      }

      //update root height
      root.height = 1 + Math.max(height(root.left), height(root.right));

      //get root's balance factor
      int bf = getBalance(root);

      // left left case
      if(bf > 1 && key < root.left.data) 
        return rightRotate(root);

      // right right case
      if(bf < -1 && key > root.right.data) 
        return leftRotate(root);

      // left right case
      if(bf > 1 && key > root.left.data) {
        root.left = leftRotate(root.left);
        return rightRotate(root);
      }

      // right left case
      if(bf < -1 && key < root.right.data) {
        root.right = rightRotate(root.right);
        return leftRotate(root);
      }

      return root; // returned if AVL balanced
    
    }

    public static void preorder(Node root) {
    if(root == null) {
      return;
    }

    System.out.print(root.data + " ");
    preorder(root.left);
    preorder(root.right);
  }

    

  public static void main(String args[]) {

    // // build a BST
    // int values[] = {5, 1, 3, 4, 2, 7};
    // Node root = null;

    // for(int i=0; i<values.length; i++) {
    //   root = insert(root, values[i]);
    // }

    // inorder(root);
    // System.out.println();

    // // // search a BST

    // // if(search(root, 6)) {
    // //   System.out.println("found");
    // // } else {
    // //   System.out.println("not found");
    // // }


    // // // delete a node
    // // root = delete(root, 2) ;
    // // System.out.println();

    // // inorder(root);



    // // //print in range
    // // printInRange(root, 1, 4);



    // // // root to leaf paths
    // // printRoot2Leaf(root, new ArrayList<>());



    // // // validate BST
    // // if(isValidBST(root, null, null)) {
    // //   System.out.println("valid ");
    // // } else {
    // //   System.out.println("not valid");
    // // }





    // //  mirror a BST
    // Node root = new Node(8);
    // root.left = new Node(5);
    // root.right = new Node(10);
    // root.left.left = new Node(3);
    // root.left.right = new Node(6);
    // root.right.right = new Node(11);


    // root = createMirror(root);
    // preorder(root);




    // // sorted array to balanced BST - {with min possible height}
    // int arr[] = {3, 5, 6, 8, 10, 11, 12};

    // Node root = sortedArrayToBST(arr, 0, arr.length-1);
    // preorder(root);




    // // convert BST to balanced BST
    // Node root = new Node(8);
    // root.left = new Node(6);
    // root.left.left = new Node(5);
    // root.left.left.left = new Node(3);
    

    // root.right = new Node(10);
    // root.right.right = new Node(11);
    // root.right.right.right = new Node(12);



    // // convert BST to balanced BST - O(n)
    // root = balancedBST(root);
    // preorder(root);





    // // size of largest BST in BT
    // Node root = new Node(50);
    // root.left = new Node(30);
    // root.left.left = new Node(5);
    // root.left.right = new Node(20);

    // root.right = new Node(60);
    // root.right.left = new Node(45);
    // root.right.right = new Node(70);
    // root.right.right.left = new Node(65);
    // root.right.right.right = new Node(80);


    // Info info = largestBST(root);
    // System.out.println("largest BST size: " + maxBST);




    // // merge 2 BSTs - linear time complexity

    // // BST1
    // Node root1 = new Node(2);
    // root1.left = new Node(1);
    // root1.right = new Node(4);

    // // BST2
    // Node root2 = new Node(9);
    // root2.left = new Node(3);
    // root2.right = new Node(12);


    // Node root = mergeBSTs(root1, root2);
    // preorder(root);












    
    
    
    
    
    // AVL trees - (self balancing BST) 
    root = insert(root, 10);
    root = insert(root, 20);
    root = insert(root, 30);
    root = insert(root, 40);
    root = insert(root, 50);
    root = insert(root, 25);


    preorder(root);





  }
}

