public class DP2 {
  public static int knapsackRecursion(int val[], int wt[], int W, int n) {
    if(W == 0 || n == 0) {
      return 0;
    }

    if(wt[n-1] <= W) { //valid
      // include
      int ans1  = val[n-1] + knapsackRecursion(val, wt, W-wt[n-1], n-1);
      // exclude
      int ans2 = knapsackRecursion(val, wt, W, n-1);
      return Math.max(ans1, ans2);
    } else { //not valid
      return knapsackRecursion(val, wt, W, n-1);
    }
  }

  public static int knapsackMemoization(int val[], int wt[], int W, int n, int dp[][]) { // O(n * W)
    if(W == 0 || n == 0) {
      return 0;
    }

    if(dp[n][W] != -1) {
      return dp[n][W];
    }

    if(wt[n-1] <= W) { //valid
      // include
      int ans1  = val[n-1] + knapsackMemoization(val, wt, W-wt[n-1], n-1,dp);
      // exclude
      int ans2 = knapsackMemoization(val, wt, W, n-1,dp);
      dp[n][W] =  Math.max(ans1, ans2);
      return dp[n][W];
    } else { //not valid
      dp[n][W] = knapsackMemoization(val, wt, W, n-1,dp);
      return dp[n][W];
    }
  }

  public static void print(int dp[][]) {
    for(int i=0; i<dp.length; i++) {
      for(int j=0; j<dp[0].length; j++) {
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }


  public static int knapsackTabulation(int val[], int wt[], int W) { // O(n * W)
    int n = val.length;
    int dp[][] = new int[n+1][W+1];
    for(int i=0; i<dp.length;i++) {
      dp[i][0] = 0;
    }  
    for(int j=0; j<dp[0].length; j++) {
      dp[0][j] = 0;
    }
    for(int i=1; i<n+1; i++) {
      for(int j=1; j<W+1; j++) {
        int v = val[i-1];
        int w = wt[i-1];
        if(w <= j) { //valid condition
          int incProfit = v + dp[i-1][j-w];
          int excProfit  = dp[i-1][j];
          dp[i][j] = Math.max(incProfit, excProfit);  
        } else { // invalid
          int excProfit  = dp[i-1][j];
          dp[i][j] = excProfit;
        }
      }
    }
    // printing matrix just for clarity
    print(dp);
    return dp[n][W];
  }

  public static boolean targetSumSubset(int arr[], int sum) {  // O(n * sum)
    int n = arr.length;
    boolean dp[][] = new boolean[n+1][sum+1];
    // i is items and j is target sum
    for(int i=0; i<n+1; i++) {
      dp[i][0] = true;
    }

    for(int i=1; i<n+1; i++) {
      for(int j=1; j<sum+1; j++) {
        // include
        int v = arr[i-1];
        if(v<=j && dp[i-1][j-v] == true) {
          dp[i][j] = true;
        } else if(dp[i-1][j] == true) {
          dp[i][j] = true;
        }
      }
    }
    // printing just for clarity
    print(dp);
    return dp[n][sum];
  }

  public static void print(boolean dp[][]) {
    for(int i=0; i<dp.length; i++) {
      for(int j=0; j<dp[0].length; j++) {
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }



  public static int unboundedKnapsack(int val[], int wt[], int W) {  // O(n * W)
    int n=val.length;
    int dp[][] = new int[n+1][W+1];

    for(int i=0; i<n+1; i++) {
      dp[i][0] = 0;
    }
    for(int j=0; j<W+1; j++) {
      dp[0][j] = 0;
    }
    for(int i=1; i<n+1; i++) {
      for(int j=1; j<W+1; j++) {
        if(wt[i-1] <= j) { // valid
          dp[i][j] = Math.max(val[i-1] + dp[i][j-wt[i-1]], dp[i-1][j]);
        } else { //invalid
          dp[i][j] = dp[i-1][j];  
        }
      }
    }
    return dp[n][W];
  }
  public static void main(String[] args) {
    // // Knapsack problems
    // // 0-1 Knapsack
    // int val[] = {15, 14, 10, 45, 30};
    // int wt[] = {2, 5, 1, 3, 4};
    // int W = 7; // capacity/total allowed weight

    // // using recursion
    // System.out.println(knapsackRecursion(val, wt, W, val.length));

    // // using memoization
    // int dp[][] = new int[val.length+1][W+1];
    // for(int i=0; i<dp.length; i++) {
    //   for(int j=0; j<dp[0].length; j++) {
    //     dp[i][j] = -1;
    //   }
    // }
    // System.out.println(knapsackMemoization(val, wt, W, val.length, dp));

    // // using tabulation
    // System.out.println(knapsackTabulation(val, wt, W));




    // // Target sum subset using tabulation { variation of 0-1 knapsack}
    // int arr[] = {4, 2, 7, 1, 3};
    // int sum = 10;
    // System.out.println(targetSumSubset(arr, sum));



    // Unbounded knapsack {using tabulation}
    int val[] = {15, 14, 10, 45, 30};
    int wt[] = {2, 5, 1, 3, 4};
    int W = 7; // capacity/total allowed weight

    System.out.println(unboundedKnapsack(val, wt, W) );

  }
}
