public class DP5 {
  public static boolean wildcardMatch(String s, String p) { // O(n * m)
    int n = s.length();
    int m = p.length();

    boolean dp[][] = new boolean[n+1][m+1];

    //initialize
    dp[0][0] = true;
    for(int i=1; i<n+1; i++) {// pattern = " "
      dp[i][0] = false;  
    }

    //s = " "
    for(int j=1; j<m+1; j++) {
      if(p.charAt(j-1) == '*') {
        dp[0][j] = dp[0][j-1]; 
      }
    }

    //bottom up
    for(int i=1; i<n+1; i++) {
      for(int j=1; j<m+1; j++) {
        // case 1
        if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
          dp[i][j] = dp[i-1][j-1];
        } else if (p.charAt(j-1) == '*') {
          dp[i][j] = dp[i-1][j] || dp[i][j-1];
        } else {
          dp[i][j] = false;
        }
      }
    }
    return dp[n][m];
  }
  public static void main(String[] args) {

    // questions

    //wildcard matching
    String s = "baaabab";
    String p = "*****ba*****ab";
    // ans is true
    System.out.println(wildcardMatch(s, p));


    //  Catalan's number(using recusrion, memoization and tabulation)



    // counting trees (BSTs)


    // mounting ranges
    // mountains and valleys

    
  }
}
