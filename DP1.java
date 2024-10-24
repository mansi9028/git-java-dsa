// import java.util.Arrays;

public class DP1 {
  public static int fib(int n, int f[]) {
    if(n == 0 || n == 1) {
      return n;
    }
    if(f[n] != 0) { //fib{n} is already calculated
      return f[n];
    }
    f[n] = fib(n-1, f) + fib(n-2, f);
    return f[n];
  }

  public static int fibTabulation(int n) { // O(n)
    int dp[] = new int[n+1];
    dp[0] = 0;
    dp[1] = 1;
    for(int i=2; i<=n ; i++) {
      dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n];
  }

  public static int climbStairCountWays(int n) { // recursion 
    // O(2^n)
    if(n==0) {
      return 1;
    } 
    if(n<0) {
      return 0;
    }
    return climbStairCountWays(n-1) + climbStairCountWays(n-2);
  } 



  public static int climbStairsCountWaysMemoization(int n, int ways[]) { // Memoization
    // O(n)
    if(n==0) {
      return 1;
    } 
    if(n<0) {
      return 0;
    }
    if(ways[n] != -1) {
      return ways[n];
    }
    ways[n] =  climbStairsCountWaysMemoization(n-1, ways) + climbStairsCountWaysMemoization(n-2, ways);
    return ways[n];

  }


  public static int climbStairCountWaysTabulation(int n) { // O(n)
    int dp[] = new int[n+1];
    dp[0] = 1;

    //tabulation loop
    for(int i=1; i<=n; i++) {
      if(i == 1) {
        dp[i] = dp[i-1] + 0;
      } else {
        dp[i] = dp[i-1] + dp[i-2];
      }
    }
    return dp[n];
  }
  public static void main(String args[]) {
    //Recursion
    // int n=5;
    // int f[] = new int[n+1];
    // System.out.println(fib(n, f));

    // System.out.println(fibTabulation(n));






    // // climbing stairs
    // int n=5;

    // // climbing stairs(Recursion)
    // System.out.println(climbStairCountWays(n));

    // // climbing stairs(Memoization DP)
    // int ways[] = new int[n+1];
    // Arrays.fill(ways, -1);
    // System.out.println(climbStairsCountWaysMemoization(n, ways));

    //climbing stairs variation
    
    // climbing stairs (Tabulation)
    int n=5;
    System.out.println(climbStairCountWaysTabulation(n));

  }
}
