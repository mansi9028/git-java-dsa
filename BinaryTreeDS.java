import java.util.*;

public class BinaryTreeDS {

  static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }
    static class BinaryTree {
      static int idx = -1;

      public static Node buildTree(int nodes[]) {
        idx++;
        if(nodes[idx] == -1) {
          return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
      
        return newNode;
      }

      //preorder traversal
      public static void preorder(Node root) {
        if(root == null) {
          return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
      }


      //inorder traversal
      public static void inorder(Node root) {
        if(root == null) {
          return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
      }

      //postorder traversal
      public static void postodrder(Node root) {
        if(root == null) {
          return;
        }
        postodrder(root.left);
        postodrder(root.right);
        System.out.print(root.data + " ");
        
      }

      //level order traversal
      public static void levelOrder(Node root) {
        if(root == null) {
          return;
        }
        
        Queue<Node> q = new LinkedList<>(); 
        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
          Node currNode = q.remove();
          if(currNode == null) {
            System.out.println();
            if(q.isEmpty()) {
              break;
            } else {
              q.add(null);
            }
          } else {
              System.out.print(currNode.data + " ");
              if(currNode.left != null) {
                q.add(currNode.left);
              }
              if(currNode.right != null) {
                q.add(currNode.right);
              }
          }
        }       
      }
    }



  //  height of a tree 
  public static int height(Node root) {
    if(root == null) {
      return 0;
    }
    int lh = height(root.left);
    int rh = height(root.right);
    return Math.max(lh, rh) + 1;
  }


  // count of nodes 
  public static int count(Node root) {
    if(root == null) {
      return 0;
    }
    int leftcount = count(root.left);
    int rightcount = count(root.right);
    return leftcount+rightcount+1;
  }




  // sum of nodes
  public static int sum(Node root) {
    if(root == null) {
      return 0;
    }
    int leftSum = sum(root.left);
    int rightSum = sum(root.right);
    return leftSum+rightSum+root.data;
  }

  
  //diameter of a tree
  public static int diameter1(Node root) { // O(n^2)
    if(root == null) {
      return 0;
    }

    int leftDia = diameter1(root.left);
    int leftHt = height(root.left);
    int rightDia = diameter1(root.right);
    int rightHt = height(root.right);

    int selfHt = leftHt + rightHt + 1;

    return Math.max(Math.max(rightDia, leftDia), selfHt);
    
  } 

    // static class Info {
    //   int diam;
    //   int ht;

    //   public Info(int diam, int ht) {
    //     this.diam = diam;
    //     this.ht = ht;
    //   }
    // }
    // public static Info diameter(Node root) { //O(n)
    //   if(root == null) {
    //     return new Info(0, 0);
    //   }

    //   Info leftInfo = diameter(root.left);
    //   Info rightInfo = diameter(root.right);

    //   int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
    //   int ht = Math.max(leftInfo.ht , rightInfo.ht) + 1;

    //   return new Info(diam, ht);
    // } 

    public static boolean isIdentical(Node node, Node subRoot) {
      if(node == null && subRoot == null) {
        return true;
      } else if(node == null || subRoot == null || node.data != subRoot.data) {
        return false;
      }
      
      if(!isIdentical(node.left, subRoot.left)) {
        return false;
      }
      if(!isIdentical(node.right, subRoot.right)) {
        return false;
      }

      return true;
    }
    //subtree
    public static boolean isSubtree(Node root, Node subRoot) {
      if(root == null) {
        return false;
      }

      if(root.data == subRoot.data) {
        if(isIdentical(root, subRoot)) {
          return true;
        }
      }

      return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }



    static class topInfo {
      Node node;
      int hd; //horizontal distance

      public topInfo(Node node, int hd) {
        this.node = node;
        this.hd = hd;
      }
    }
    // top view of a tree
    public static void topView(Node root) {
      // level order traversal
      Queue<topInfo> q = new LinkedList<>();
      HashMap<Integer, Node> map = new HashMap<>();

      int min = 0;
      int max = 0;
      q.add(new topInfo(root, 0));
      q.add(null);

      while(!q.isEmpty()) {
        topInfo curr = q.remove();
        if(curr == null) {
          if(q.isEmpty()) {
            break;
          } else {
            q.add(null);
          }
        } else {

        if(!map.containsKey(curr.hd)) {
          map.put(curr.hd, curr.node);
        }
        
        if(curr.node.left != null) {
          q.add(new topInfo(curr.node.left, curr.hd-1));
          min = Math.min(min, curr.hd-1);
        }

        if(curr.node.right != null) {
          q.add(new topInfo(curr.node.right, curr.hd+1));
          max = Math.max(max, curr.hd+1);
        }
      }
    }

      for(int i=min; i<max;i++) {
        System.out.print(map.get(i).data + " ");
      }
      System.out.println();

    }


    // Kth level O(n)
    public static void kLevel(Node root, int level, int k) {
      if(root == null) {
        return;
      }

      if(level == k) {
        System.out.print(root.data + " ");
        return;
      }

      kLevel(root.left, level+1, k);
      kLevel(root.right, level+1, k);
    }





    // lowest common ancestor O(n) - lca

    //approach - 1
    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
      if(root == null) {
        return false;
      }

      path.add(root);
      
      if(root.data == n) {
        return true;
      }

      boolean foundLeft = getPath(root.left, n, path);
      boolean foundRight = getPath(root.right, n, path);

      if(foundLeft || foundRight) {
        return true;
      }

      path.remove(path.size()-1);
      return false;
    }

    public static Node lca(Node root, int n1, int n2) {
      ArrayList<Node> path1 = new ArrayList<>();
      ArrayList<Node> path2 = new ArrayList<>();

      getPath(root, n1, path1);
      getPath(root, n2, path2);

      int i = 0;
      for(; i<path1.size() && i<path2.size(); i++) {
        if(path1.get(i) != path2.get(i)) {
          break;
        }
      }

      //last equal node -> (i-1)th index
      Node lca = path1.get(i-1);

      return lca;
    }

    // approach - 2
    public static Node lca2(Node root, int n1, int n2) {

      if(root == null || root.data == n1 || root.data == n2) {
        return root;
      }

      Node leftLca = lca2(root.left, n1, n2);
      Node rightLca = lca2(root.right, n1, n2);

      //leftLca = valid, rightLca = null
      if(rightLca == null) {
        return leftLca;
      }
      //rightLca  = valid, leftLca = valid
      if(leftLca == null) {
        return rightLca;
      }

      return root;


    }


    //min distance b/w nodes
    public static int lcaDist(Node root, int n) {
      if(root== null) {
        return -1;
      }
      if(root.data == n) {
        return 0;
      }

      int leftDist = lcaDist(root.left, n);
      int rightDist = lcaDist(root.right, n);

      if(leftDist == -1 && rightDist == -1) {
        return -1;
      } else if(leftDist == -1) {
        return rightDist+1;
      } else {
        return leftDist+1;
      }
    }
    public static int minDis(Node root, int n1, int n2) {
      Node lca = lca2(root, n1, n2);
      int dist1 = lcaDist(lca, n1);
      int dist2 = lcaDist(lca, n2);

      return dist1 + dist2;
    }



    // Kth ancestor of node
    public static int kAncestor(Node root, int n, int k) {
      if(root == null) {
        return -1;
      }
      if(root.data == n) {
        return 0;
      }

      int leftDist = kAncestor(root.left, n, k);
      int rightDist = kAncestor(root.right, n, k);

      if(leftDist == -1 && rightDist == -1) {
        return -1;
      }

      int max = Math.max(leftDist, rightDist);
      if(max+1 == k) {
        System.out.println(root.data);
      }
      return max+1;
    }


    // transform to sum tree - O(n)
    public static int transform(Node root) {
      if(root == null) {
        return 0;
      }
      int leftChild = transform(root.left);
      int rightChild = transform(root.right);

      int data = root.data;

      int newLeft = root.left == null ? 0 : root.left.data;
      int newRight = root.right == null ? 0 : root.right.data;

      root.data = newLeft + leftChild + newRight + rightChild;
      return data;
    }

    public static void preorder(Node root) {
      if(root == null) {
        return;
      }

      System.out.print(root.data + " ");
      preorder(root.left);;
      preorder(root.right);
    }
  public static void main(String[] args) {
    // // bulid tree preorder
    // int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
    // BinaryTree tree = new BinaryTree();
    // Node root = tree.buildTree(nodes);
    // System.out.println(root.data);


    // //preorder - O(n)
    // tree.preorder(root);


    // //inorder - O(n)
    // tree.inorder(root);


    // //postodrder - O(n)
    // tree.postodrder(root);


    // //level order traversal
    // tree.levelOrder(root);



      Node root = new Node(1);
      root.left = new Node(2);
      root.right = new Node(3);
      root.left.left = new Node(4);
      root.left.right = new Node(5);
      root.right.left = new Node(6);
      root.right.right = new Node(7);
      /*
       *        1
       *       / \
       *      2   3
       *     / \ / \
       *    4  5 6  7
       * 
       */


      // //height - O(n)
      // System.out.println(height(root));


      // //count of nodes - O(n)
      // System.out.println(count(root));



      // //sum of nodes
      // System.out.println(sum(root));




      // //diameter of a tree
      // System.out.println(diameter(root).diam);
      // //height
      // System.out.println(diameter(root).ht);





      // // subtree of another tree
      // Node subRoot = new Node(2);
      // subRoot.left = new Node(4);
      // subRoot.right = new Node(5);

      // System.out.println(isSubtree(root, subRoot));





      // //top view of a tree
      // topView(root);




      // // Kth level of a tree
      // int k = 2; 
      // kLevel(root, 2, k);



      // lowest common ancestor 
      // // approach 1
      // System.out.println(lca(root, 4, 5).data);

      // // approach 2
      // System.out.println(lca2(root, 4, 7).data);



      // // min distance b/w nodes
      // int n1 = 4, n2 = 6;
      // System.out.println(minDis(root, n1, n2));



      // // Kth ancestor of node
      // int n=5, k=2;
      // kAncestor(root, n, k);



      // //transform to a sum tree
      // /*
      //  * expected sum tree
      //  *        27
      //  *       /  \
      //  *      9   13
      //  *     / \ /  \
      //  *    0  0 0   0
      //  * 
      //  * 
      //  */
      // transform(root);
      // preorder(root);




      
      
      
      
          // Binary tree ques
            // Assignment


  }
}
