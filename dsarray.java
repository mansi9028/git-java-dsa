// import java.util.*;
public class dsarray {
  public static int linearSearch(String menu[], String key) {
    for(int i=0; i<menu.length; i++) {
      if(menu[i] == key) {
        return i;
      }
    }
    return -1;
  } 

  public static int getLargest(int numbers[]) {
    int largest = Integer.MIN_VALUE;
    int smallest = Integer.MAX_VALUE;

    for(int i=0; i<numbers.length; i++) {
      if(largest<numbers[i]) {
        largest = numbers[i];
      }
      if(smallest>numbers[i]) {
        smallest = numbers[i];
      }
    }
    System.out.println("Smallest is: " + smallest);

    return largest;
  }

  public static int binarySearch(int numbers[], int key) {
    int start=0;
    int end= numbers.length - 1;

    while(start<=end) {
      int mid =(start+end) / 2;

      // comparisions
      if(numbers[mid]==key) {
        return mid;
      }
      if(numbers[mid]<key) {
        start=mid+1;
      } else{
        end=mid-1;
      }
    }
    return -1;
  }

  public static void reverse(int numbers[]) {
    int first=0, last=numbers.length-1;
    while(first<last) {
      //swap
      int temp=numbers[last];
      numbers[last]=numbers[first];
      numbers[first] = temp;

      first++;
      last--;
    }
  }

  public static void printPairs(int numbers[]) {
    int totalPairs=0;
    for(int i=0; i<numbers.length; i++) {
      int current=numbers[i];
      for(int j=i+1; j<numbers.length; j++) {
        System.out.print("(" + current +"," + numbers[j] + ") ");
        totalPairs++;
      }
      System.out.println();
    }
    System.out.println("total number of pairs: " + totalPairs);
    System.out.println();
  }

  public static void printSubarrays(int numbers[]) {
    int totalSubarrays=0;
    for(int i=0; i<numbers.length; i++) {
      int start=i;
      for(int j=i; j<numbers.length; j++) {
        int end=j;
        for(int k=start; k<=end; k++) {
          System.out.print(numbers[k] + "  ");
        }
        totalSubarrays++;
        System.out.println();
      }
      System.out.println();
    }
    System.out.println("total pair of subarrays: " + totalSubarrays);
  }

  public static void main(String args[]) {
    // linear search
    // String menu[] = {"kulcha" , "dosa" , "samosa"};
    // String key = "dosa";

    // int index = linearSearch(menu, key);
    // if(index == -1) {
    //   System.out.println("NOT FOUND");
    // } else {
    //   System.out.println("index is: " + index);
    // }


    // largest and smallest of an array
    // int numbers[] = {1, 8, 9, 3, 5};
    // System.out.println("Largest is: " + getLargest(numbers));



    // binary search
    // int numbers[] = {2, 4, 6, 8, 10, 12, 14};
    // int key = 10;
    //   System.out.println("index for key is: " + binarySearch(numbers, key));




    // reverse an array
    // int numbers[] = {2, 4, 6, 8, 10};
    // reverse(numbers);

    // for(int i=0; i<numbers.length;i++) {
    //   System.out.print(numbers[i] + "  ");
    // }
    // System.out.println();




    // pairs in an array,  qalso a formulae for finding total number of pairs in a given array --- (n(n-1)) / 2
    // int numbers[] = {2, 4, 6, 8, 10};
    // printPairs(numbers);
    // time complexity -- O(n^2)



    // print subarrays --- a continuous part of array ;;;;;; number of subarrays --- (n(n+1) / 2)
    int numbers[] = {2, 4, 6, 8, 10};
    printSubarrays(numbers);



  }
}
