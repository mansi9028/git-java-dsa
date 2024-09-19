import java.util.ArrayList;
import java.util.Collections;

public class arraylist { // ArrayList is a part of Java Collection Framework


  public static void swap(ArrayList<Integer> swapNum, int idx1, int idx2) {
    int temp = swapNum.get(idx1);
    swapNum.set(idx1, swapNum.get(idx2));
    swapNum.set(idx2, temp);

  }

  // public static int storeWater(ArrayList<Integer> height) {
  //   int maxWater = 0;

      // BRUTE FORCE 
  //   for(int i=0; i<height.size(); i++) {
  //     for(int j=i+1; j<height.size(); j++) {
  //       int ht = Math.min(height.get(i), height.get(j));
  //       int width = j-i;
  //       int currWater = ht*width;
  //       maxWater = Math.max(maxWater, currWater);

  //     }
  //   }
  //   return maxWater;
  // }


  public static int storeWater(ArrayList<Integer> height) {
    // 2 POINTER APPROACH  O(n)
    int maxWater = 0;
    int lp = 0; // left ponter   
    int rp = height.size()-1;  // right pointer

    while(lp < rp) {
      // calculate water area
      int ht = Math.min(height.get(lp), height.get(rp));
      int width = rp - lp;
      int currWater = ht * width;
      maxWater = Math.max(maxWater, currWater);

      // update pointer
      if(height.get(lp) < height.get(rp)) {
        lp++;
      } else {
        rp--;
      }
    }
    return maxWater;
  }

  public static boolean pairSum1(ArrayList<Integer> list, int target) {
    // 2 POINTER APPROACH
    int lp=0;
    int rp = list.size()-1;

    while(lp != rp) { // case 1
      if(list.get(lp) + list.get(rp) == target) {
        return true;
      }

      // case 2
      if(list.get(lp) + list.get(rp) < target) {
        lp++;
      } else {
        // case 3
        rp--;
      }
    }
    return false;
  }

  public static boolean pairSum2(ArrayList<Integer> list2, int target) { // O(n)
    // 2 POINTER APPROACH
    int bp=-1; // pivot - breaking point
    int n = list2.size();
    for(int i=0; i<list2.size(); i++) {
      if(list2.get(i) > list2.get(i+1)) {
        bp = i;
        break;
      }
    }

  int lp = bp+1;
  int rp = bp;

  while(lp != rp) {
    // case 1
    if(list2.get(lp) + list2.get(rp) == target) {
      return true;
    }
    // case 2
    if(list2.get(lp) + list2.get(rp) < target) {
      lp = (lp+1) % n; 
    } else {
      // case 3
      rp = (n+rp-1) % n;
    }
  }
  return false;
  }

  public static boolean isMonotonic(ArrayList<Integer> list) {
    boolean inc = true;
    boolean dec = true;

    for(int i=0; i<list.size()-1; i++) {
      if(list.get(i) < list.get(i+1)) 
          dec = false;
      if(list.get(i) > list.get(i+1)) 
          inc = false;
    }
    return inc || dec;
  }

  public static ArrayList<Integer> findLonely(ArrayList<Integer> nums) {
    Collections.sort(nums);

    ArrayList<Integer> list = new ArrayList<>();
    for(int i =1; i<nums.size()-1; i++) {
      if(nums.get(i-1) + 1 < nums.get(i) && nums.get(i) + 1 < nums.get(i+1)) {
        list.add(nums.get(i));
      }
    }

    if(nums.size() == 1) {
      list.add(nums.get(0));
    }

    if(nums.size() > 1) {
      if(nums.get(0) + 1 < nums.get(1)) {
        list.add(nums.get(0));
      }
      if(nums.get(nums.size() - 2) + 1 < nums.get(nums.size()-1)) {
        list.add(nums.get(nums.size()-1));
      }
    }
    return list;
  }

  public static int mostFrequent(ArrayList<Integer> nums, int key) {
    int result[] = new int[1000];

    for(int i=0; i<nums.size()-1; i++) {
      if(nums.get(i) == key) {
        result[nums.get(i+1)-1]++;
      }
    }

    int max = Integer.MIN_VALUE;
    int ans = 0;

    for(int i=0; i<1000; i++) {
      if(result[i]  > max) {
        max = result[i];
        ans = i+1;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    // ArrayList<Integer> list = new ArrayList<>();
    // // opeartion on ArrayList

    // // add element O(1)
    // list.add(1);
    // list.add(2);
    // list.add(31);
    // list.add(15);
    // System.out.println(list);

    // list.add(2, 3);  // O(n)
    // System.out.println(list);

//     // get element O(1)
//     int element = list.get(1);
//     System.out.println(element);


//     // remove(delete) element O(n)
//     list.remove(1);
//     System.out.println(list);



//     // set element at index O(n)
//     list.set(1, 10);
//     System.out.println(list);


//     // contains element O(n)
//     System.out.println(list.contains(10));
//     System.out.println(list.contains(31));


    

    // print reverse of an arraylist   O(n)
    // ArrayList<Integer> printReverse = new ArrayList<>();
    // printReverse.add(1);
    // printReverse.add(2);
    // printReverse.add(3);
    // printReverse.add(4);
    // printReverse.add(5);

    // for(int i=printReverse.size()-1; i>=0; i--) {
    //   System.out.print(printReverse.get(i) + " ");
    // }
    // System.out.println();



    // find max   O(n)
    // ArrayList<Integer> findMax = new ArrayList<>();
    // findMax.add(2);
    // findMax.add(5);
    // findMax.add(9);
    // findMax.add(6);
    // findMax.add(8);

    // int max = Integer.MIN_VALUE;
    // for(int i=0; i<findMax.size(); i++) {
    //   // if(max < findMax.get(i)) {
    //   //   max = findMax.get(i);
    //   // }
    //   // OR
    //   max = Math.max(max, findMax.get(i));
    // }
    // System.out.println("max element is: " + max);



    // swap 2 numbers
    // ArrayList<Integer> swapNum = new ArrayList<>();
    // swapNum.add(2);
    // swapNum.add(5);
    // swapNum.add(9);
    // swapNum.add(3);
    // swapNum.add(6);
    // int idx1 = 1, idx2 = 3;
    // System.out.println(swapNum);
    // swap(swapNum, idx1, idx2);
    // System.out.println(swapNum);




    // sorting an arraylist
    // ArrayList<Integer> sortList = new ArrayList<>();

    // sortList.add(81);
    // sortList.add(2);
    // sortList.add(31);
    // sortList.add(15);

    // System.out.println(sortList);
    // Collections.sort(sortList); // ascending
    // System.out.println(sortList);

    // // descending
    // Collections.sort(sortList, Collections.reverseOrder());
    // System.out.println(sortList);





    // // Multi-dimensional Arraylist
    // ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
    // ArrayList<Integer> list1 = new ArrayList<>();
    // ArrayList<Integer> list2 = new ArrayList<>();
    // ArrayList<Integer> list3 = new ArrayList<>();


    // for(int i=1; i<=5; i++) {
    //   list1.add(i*1); // 1 2 3 4 5 
    //   list2.add(i*2); // 2 4 6 8 10
    //   list3.add(i*3); // 3 6 9 10 15
    // }

    // mainList.add(list1);
    // mainList.add(list2);
    // mainList.add(list3);
    // list1.remove(3);

    // System.out.println(mainList);


    // // using nested loops
    // for(int i=0; i<mainList.size(); i++) {
    //   ArrayList<Integer> currentList = mainList.get(i);
    //   for(int j=0; j<currentList.size(); j++) {
    //     System.out.print(currentList.get(j) + " ");
    //   }
    //   System.out.println();
    // }





    // ***** Container with most water *****
    // for given n lines on x-axis, use 2 lines to form a container such that it holds maximum water
//     ArrayList<Integer> height = new ArrayList<>();
//     height.add(1); height.add(8); 
//     height.add(6); height.add(2); 
//     height.add(5); height.add(4); 
//     height.add(8); height.add(3); 
//     height.add(7);
// System.out.println("max water stored is: " + storeWater(height));




    // pair sum - I (find if any pair in a sorted arraylist has a target sum)
  //   ArrayList<Integer> list = new ArrayList<>();
  //   list.add(1);
  //   list.add(2);
  //   list.add(3);
  //   list.add(4);
  //   list.add(5);
  //   list.add(6);
  // int target = 5;
  // System.out.println(pairSum1(list, target));


    // pair sum - II (find if any pair in a sorted & rotated arraylist has a target sum)
    // ArrayList<Integer> list2 = new ArrayList<>();
    // // below is a sorted and rotated array
    // list2.add(11);
    // list2.add(15);
    // list2.add(6);
    // list2.add(8);
    // list2.add(9);
    // list2.add(10);
    // int target = 16;

    // System.out.println(pairSum2(list2, target));






    // ArrayList   Assignment
    //q1 - Monotonic ArrayList
    // ArrayList<Integer> list = new ArrayList<>();
    // list.add(1);
    // list.add(5);
    // list.add(5);
    // list.add(18);

    // System.out.println(isMonotonic(list));


    //q2 - Lonely numbers
  //   ArrayList<Integer> nums = new ArrayList<>();
  //   nums.add(10);
  //   nums.add(6);
  //   nums.add(5);
  //   nums.add(8);

  // System.out.println(findLonely(nums));



  //q3 - most frequent number following key
    // ArrayList<Integer> nums = new ArrayList<>();
    // nums.add(1);
    // nums.add(100);
    // nums.add(200);
    // nums.add(1);
    // nums.add(100);
    // int key = 1;

    // System.out.println(mostFrequent(nums, key));



    //q4 - beautiful arraylist
    


    
    




  }
}
