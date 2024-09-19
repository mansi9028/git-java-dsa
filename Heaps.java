// import java.util.ArrayList;
// import java.util.PriorityQueue;
import java.util.*;

public class Heaps {
  // static class Student implements Comparable<Student> { //overrriding
  //   String name;
  //   int rank;

  //   public Student(String name, int rank) {
  //     this.name = name;
  //     this.rank = rank;
  //   }

  //   @Override
  //   public int compareTo(Student s2) {
  //   return this.rank - s2.rank;
  //   }
  // }




  static class Heap {
    ArrayList<Integer> arr = new ArrayList<>();

    public void add(int data) { // O(logn)
      // add at last
      arr.add(data);

      int x = arr.size()-1; // x  =  child index
      int parent = (x - 1)/2; // parent index

      while(arr.get(x) < arr.get(parent)) { // O(logn)
        //swap
        int temp = arr.get(x);
        arr.set(x, arr.get(parent));
        arr.set(parent, temp);

        x = parent;
        parent = (x-1)/2;
      }
    }

    public int peek() {
      return arr.get(0);
    }

    private void heapify(int i) { // O(logn)
      int left = 2*i + 1;
      int right = 2*i + 2;
      int minIdx = i;

      if(left < arr.size() && arr.get(minIdx) > arr.get(left)) {
        minIdx = left;
      }

      if(right < arr.size() && arr.get(minIdx) > arr.get(right)) {
        minIdx = right;
      }
      if(minIdx != i) {
        //swap
        int temp = arr.get(i);
        arr.set(i, arr.get(minIdx));
        arr.set(minIdx, temp);

        heapify(minIdx);
      }
    }

    public int remove() {
      int data = arr.get(0);

      // step1 - swap first and last
      int temp = arr.get(0);
      arr.set(0, arr.get(arr.size()-1));
      arr.set(arr.size()-1, temp);

      // step2 - delete last
      arr.remove(arr.size() - 1);
    
      // step3 - heapify  
      heapify(0);
      return data;
      }

      public boolean isEmpty() {
        return arr.size() == 0;
      }
  }





  public static void heapify(int arr[], int i, int size) {
    int left = 2*i + 1;
      int right = 2*i + 2;
      int maxIdx = i;

      if(left < size && arr[left] > arr[maxIdx]) {
        maxIdx = left;
      }
      if(right < size && arr[right] > arr[maxIdx]) {
        maxIdx = right;
      }

      if(maxIdx != i) {
        //swap
        int temp = arr[i];
        arr[i] = arr[maxIdx];
        arr[maxIdx] = temp;

        heapify(arr, maxIdx, size);
      }
  }

  public static void heapSort(int arr[]) {
    // step1 build maxheap
    int n = arr.length;
    for(int i = n/2; i>=0; i--) {
      heapify(arr, i, n);
    }

    // step2 push largest at end
    for(int i=n-1; i>0; i--) {
      //swapping of largest i.e first index with last index
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;

      heapify(arr, 0, i);
    }
  }



  static class Point implements Comparable<Point> {
    int x, y, distSq, idx;

    public Point(int x, int y, int distSq, int idx) {
      this.x = x;
      this.y = y;
      this.distSq = distSq;
      this.idx = idx;
    }

    @Override
    public int compareTo(Point p2) {
      return this.distSq - p2.distSq;
    }
  }
  public static void main(String[] args) {
    //  HEAPS  /  PRIORITY QUEUES

    // PriorityQueue<Student> pq = new PriorityQueue<>();

    // pq.add(new Student("A", 4));
    // pq.add(new Student("B", 5));
    // pq.add(new Student("C", 2));
    // pq.add(new Student("D", 12));

    // while(!pq.isEmpty()) {
    //   System.out.println(pq.peek().name + " -> " + pq.peek().rank);
    //   pq.remove();
    // }


    // Insert in heap

    // peek from heap

    // delete from heap
    // Heap h = new Heap();
    // h.add(3);
    // h.add(4);
    // h.add(1);
    // h.add(5);

    // while(!h.isEmpty()) { // also called heap sort - O(nlogn)
    //   System.out.println(h.peek());
    //   h.remove();
    // }




    // //heap sort -O(nlogn)
    // // here ascending order

    // int arr[] = {1, 2, 4, 5, 3};
    // heapSort(arr);

    // //print
    // for(int i=0; i<arr.length; i++) {
    //   System.out.print(arr[i] + " ");
    // }
    // System.out.println();















    // // NEARBY CARS
    // int pts[][] = {{3,3}, {5, -1}, {-2,4}};
    // int k=2;

    // PriorityQueue<Point> pq = new PriorityQueue<>();
    // for(int i=0; i<pts.length; i++) {
    //   int distSq = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1];
    //   pq.add(new Point(pts[i][0], pts[i][1], distSq, i));
    // }
    
    // //nearest k cars
    // for(int i=0; i<k; i++) {
    //   System.out.println("C" + pq.remove().idx);
    // }




    // // connect N ropes
    // int ropes[] = {2, 3, 3, 4, 6};

    // PriorityQueue<Integer> pq = new PriorityQueue<>();
    // for(int i=0; i<ropes.length; i++) {
    //   pq.add(ropes[i]);

    // }
    // int cost = 0;
    // while(pq.size()>1) {
    //   int min = pq.remove();
    //   int min2 = pq.remove();
    //   cost += min + min2;
    //   pq.add(min+min2);
    // }

    // System.out.println("cost of connecting N ropes =  " + cost);









    // Weakest soldier





    // sliding window maximum
    

  }
}
