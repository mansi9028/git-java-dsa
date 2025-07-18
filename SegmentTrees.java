public class SegmentTrees {
  static int tree[];

  public static void init(int n) {
    tree = new int[4*n];
  }

  public static int buildBST(int arr[], int sti, int start, int end) { //sti is segment tree's ith index
  // O(n)
    if(start == end) {
      tree[sti] = arr[start];
      return arr[start];
    }

    int mid = (start+end)/2;
    buildBST(arr, 2*sti+1, start, mid); //left subtree
    buildBST(arr, 2*sti+2, mid+1, end); //right subtree
    tree[sti] = tree[2*sti+1] + tree[2*sti+2];
    return tree[sti];
  }


  public static int getSumUtil(int i, int si, int sj, int qi, int qj) {
    if(qj <= si || qi>= sj) { //non overlapping
      return 0;
    } else if ((si >= qi && sj<=qj)) { // complete overlap
      return tree[i];
    } else { // partial overlap
      int mid = (si+sj) / 2;
      int left = getSumUtil(2*i+1, si, mid, qi, qj) ; 
      int right = getSumUtil(2*i+2, mid+1, sj, qi, qj);
      return left+right;
    }
  }
  public static int getSum(int arr[], int qi, int qj) {
    int n = arr.length;
    return getSumUtil(0, 0, n-1, qi, qj);
  }

  public static void updateUtil(int i, int si, int sj, int idx, int diff) { // O(logn)
    if(idx > sj || idx < si) {
      return;
    }
    tree[i] += diff;
    if(si != sj) {
      int mid = (si+sj)/2;
      updateUtil(2*i+1, si, mid, idx, diff); //left
      updateUtil(2*i+2, mid+1, sj, idx, diff); //right
    }
  }

  public static void update(int arr[], int idx, int newVal) {
    int n = arr.length;
    int diff = newVal - arr[idx];
    arr[idx] = newVal;

    updateUtil(0, 0, n-1, idx, diff);
  }
  public static void main(String[] args) {
     // Segment trees - Introduction
    //Count & meaning of nodes

    // creation of ST
    int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
    int n = arr.length;
    init(n);
    buildBST(arr, 0, 0, n-1);

    for(int i=0; i<tree.length; i++) {
      System.out.print(tree[i] + " ");
    }
    System.out.println();



    // query in ST
    System.out.println(getSum(arr, 2, 5));



    //update on ST
    update(arr, 2, 2);
    System.out.println(getSum(arr, 2, 5));



    // max/min ST (creation, query, update)


  }
}
