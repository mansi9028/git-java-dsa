public class recursion2 {

  public static int tilingProblem(int n) {
    // base case
    if(n == 0 || n == 1) {
      return 1;
    }


    int verticalTiles = tilingProblem(n-1);
    int horizontalTiles = tilingProblem(n-2);
    int totalWays = verticalTiles + horizontalTiles;
    return totalWays;

  }

  public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]) {
    if(idx == str.length()) {
      System.out.println(newStr);
      return;
    }

    char currChar = str.charAt(idx);
    if(map[currChar-'a'] == true)  {
      // duplicate
      removeDuplicates(str, idx+1, newStr, map);
    } else {
      map[currChar-'a']  = true;
      removeDuplicates(str, idx+1, newStr.append(currChar), map);
    }
  }

  public static int friendsPairing(int n) {
    if(n == 1 || n == 2) {
      return n;
    }
    // choice
    //single
    int fnm1 = friendsPairing(n-1);

    //pair
    int fnm2 = friendsPairing(n-2);
    int pairWays = (n-1) * fnm2;

    //totalways
    int totWays = fnm1 + pairWays;
    return totWays;

    //OR
    // return friendsPairing(n-1) + (n-1) * friendsPairing(n-2);
  }

  public static void printBinaryStrings(int n, int lastPlace, String str) {
    //base case 
    if(n == 0) {
      System.out.println(str);
      return;
    }

    printBinaryStrings(n-1, 0, str+"0");
    if(lastPlace == 0) {
      printBinaryStrings(n-1, 1, str+"1");
    }
  }

  public static void allOccurences(int arr[], int key, int i) {
    if(i == arr.length) {
      return;
    }
    if(arr[i] == key) {
      System.out.print(i + " ");
    }
    allOccurences(arr, key, i+1);
  }

  public static void main(String args[]) {

    // tiling problem - 2 X n floor and 2 X 1 tiles
    // System.out.println(tilingProblem(5));
    // System.out.println(tilingProblem(3));



    // remove duplicates in a string
    // String str = "apnnacollege";
    // removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);


    // friends pairing problem
    // System.out.println(friendsPairing(3));


    // binary strings problem
    // ques - print all binary strings of size N without consecutive ones
    // printBinaryStrings(3, 0, "");


    // assignment
    // q1 - for a given integer array of size N. You have to find all the occurrences(indices) of a given element(Key) and print them. 
    // int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
    // int key = 2;
    // allOccurences(arr, key, 0);
    // System.out.println();


    // q2
    

    
  }
}
