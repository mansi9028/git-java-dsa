public class divideAndConquer {

  public static void mergeSort(int arr[], int si, int ei) {
    if(si >= ei) {
      return;
    }
    int mid = si + (ei - si)/2;
    mergeSort(arr, si, mid); // left part
    mergeSort(arr, mid+1, ei); // right part

    merge(arr, si, mid, ei);

  }
  public static void merge(int arr[], int si, int mid, int ei) {
    int temp[] = new int[ei-si+1];
    int i = si; // iterator for left part
    int j = mid+1; // iterator for right part
    int k = 0; // iterator for temp arr

    while(i <= mid && j <= ei) {
      if(arr[i] < arr[j]) {
        temp[k] = arr[i];
        i++;
       // k++;
      } else {
        temp[k] = arr[j];
        j++;
        // k++;
      }
      k++;
    }
    while(i <= mid) {
      temp[k++] = arr[i++];
    }
    while(j <= ei) {
      temp[k++] = arr[j++];
    }
    // copy temp to original arr
    for(k = 0, i=si; k < temp.length; k++, i++) {
      arr[i] = temp[k];
    }
  }

  public static void printArr(int arr[]) {
    for(int i=0; i<arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void quickSort(int arr[], int si, int ei) {
    if(si >= ei) {
      return;
    }
    // pivot - last element
    int pIdx = partition(arr, si, ei);
    quickSort(arr, si, pIdx-1); // left
    quickSort(arr, pIdx+1, ei); // right
  }

  public static int partition(int arr[], int si, int ei) {
    int pivot = arr[ei];
    int i = si-1; // to make place for elements smaller than pivot

    for(int j=si; j<ei; j++) {
      if(arr[j] <= pivot) {
        i++;
        // swap
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
      }
    }
    i++;
    // swap
    int temp = pivot;
        arr[ei] = arr[i]; // donot do pivot = arr[i]
        arr[i] = temp;
        return i;

  }

  public static int search(int arr[], int target, int si, int ei) {
    // base case
    if(si >ei) {
      return -1;
    }

    int mid = si + (ei-si)/2;
    // case found
    if(arr[mid] == target) {
    return mid;
    }

    // mid on L1
    if(arr[si] <= arr[mid]) {
      // case A: left
      if(arr[si] <= target && target <= arr[mid]) {
        return search(arr, target, si, mid-1);
      }
      else {
        // case B: right
        return search(arr, target, mid+1, ei);
      }
    }

    // mid on L2
    else {
    // case C: right
      if(arr[mid] <= target && target <= arr[ei]) {
        return search(arr, target, mid+1, ei);
    } else {
      // case D: left
        return search(arr, target, si, mid-1);
      }
    }
  }
  

  public static void main(String[] args) {
    // merge sort - nlogn
    // int arr[] = {6, 3, 9, 5, 2, 8, -2};
    // mergeSort(arr, 0, arr.length-1);
    // printArr(arr);


    // quick sort - pivot and partition - worst case occurs when pivot is always the smallest or the largest element
    // int arr[] = {6, 3, 9, 8, 2, 5};
    // quickSort(arr, 0, arr.length-1);
    // printArr(arr);



    // sorted and rotated array search
    // int arr[] = {4, 5, 6, 7, 0, 1, 2}; // originally given was an array sorted in ascending order, it is now rotated around pivot point 2.
    // int target = 0; // output is index 4
    // int tarIdx = search(arr, target, 0, arr.length-1);
    // System.out.println(tarIdx);



    // assignment questions
    // q1 - apply merge sort to sort an array of strings
    // String arr[] = {"sun", "earth", "mars", "mercury"};


  }
}
