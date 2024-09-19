// import java.util.Arrays;
// import java.util.Collections;

public class basicSortingAlgos {
  
  public static void bubbleSort(int arr[]) {
    for(int i=0; i<arr.length-1; i++) {
      for(int j=0; j<arr.length-i-1; j++) {
        if(arr[j] > arr[j+1]) {
          // swap
          int temp = arr[j];
          arr[j] = arr[j+1] ;
          arr[j+1] = temp;
        }
      }
    }
  }

  public static void printArr(int arr[]) {
    for(int k=0; k<arr.length; k++) {
      System.out.print(arr[k]+ " ");
    }
    System.out.println();
  }

  public static void selectionSort(int arr[]) {
    for(int i=0; i<arr.length-1; i++) {
      int minPosition = i;
      for(int j=i+1; j<arr.length; j++) {
        if(arr[minPosition] > arr[j]) {
          // arr[minPosition] < arr[j] - for decreasing oder sorting
          minPosition=j;
        }
      }
      // swap
      int temp = arr[minPosition];
      arr[minPosition] = arr[i];
      arr[i] = temp;
    }
  }

  public static void insertionSort(int arr[]) {
    for(int i=1; i<arr.length; i++) {
int curr=arr[i];
int prev=i-1;
//finding out the correct position to insert
while(prev>=0 && arr[prev] > curr) {
  arr[prev+1] = arr[prev];
  prev--;
  }
  //insertion
  arr[prev+1] = curr;
    }
  }

  public static void countingSort(int arr[]) {
    int largest= Integer.MIN_VALUE;
    for(int i=0; i<arr.length; i++) {
      largest= Math.max(largest, arr[i]);
    }
    int count[] = new int[largest+1];
    for(int i=0; i<arr.length; i++) {
      count[arr[i]]++;
    }
    // sorting
    int j=0;
    for(int i=0; i<count.length; i++) {
      while(count[i]>0) {
        arr[j] = i;
        j++;
        count[i]--;
      }
    }
  }
  public static void main(String args[]) {
    // bubble sort - adjacent swapping --- O(n^2)
    // int arr[] = {3, 6, 5, 7, 2, 1, 4};
    // bubbleSort(arr);
    // printBubbleSort(arr);


    // selection sort
    // int arr[] = {3, 6, 5, 7, 2, 1, 4};
    // selectionSort(arr);
    // printArr(arr);



    // insertion sort
//     int arr[] = {3, 8, 9, 6, 5, 7, 2, 1, 4};
// insertionSort(arr);
// printArr(arr);



    // inbuilt sort


    // ascending
    // int arr[] = {3, 8, 9, 6, 5, 7, 2, 1, 4};
    //  Arrays.sort(arr);   // O(nlogn)
    //  printArr(arr);

    // Arrays.sort(arr, 0, 4);
    // printArr(arr);



    // descending
    // Integer arr[] = {3, 8, 9, 6, 5, 7, 2, 1, 4};
    // Arrays.sort(arr, Collections.reverseOrder());
    // printArr(arr); // replace int by Integer  in the method


    // counting sort (quantity can be large but range is small)
    int arr[] = {1, 4, 1, 3, 2, 4, 3, 7};
    countingSort(arr);
    printArr(arr);
  }
}
