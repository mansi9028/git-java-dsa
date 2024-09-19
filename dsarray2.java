// import java.util.*;
public class dsarray2 {
  public static void bruteForce(int numbers[]) {
    int currSum=0;
    int maxSum = Integer.MIN_VALUE;

    for(int i=0; i<numbers.length; i++) {
      int start=i;
      for(int j=i; j<numbers.length; j++) {
        int end=j;
        currSum=0;
        for(int k=start; k<=end; k++) {
          currSum += numbers[k];
        }
        System.out.println(currSum);
        if(currSum>maxSum) {
          maxSum=currSum;
        }
      }
    }
    System.out.println("max sum: " + maxSum);

  }

  public static void prefixSum(int numbers[]) {
    int currSum=0;
    int maxSum = Integer.MIN_VALUE;
    int prefix[] = new int[numbers.length];

    prefix[0] = numbers[0];
    // calculate prefix array
    for(int i=1; i<prefix.length; i++) {
      prefix[i] = prefix[i-1] + numbers[i];
    }


    for(int i=0; i<numbers.length; i++) {
      int start=i;
      for(int j=i; j<numbers.length; j++) {
        int end=j;
        currSum= start==0? prefix[end] : prefix[end] - prefix[start-1];
        
        // System.out.println(currSum);
        if(currSum>maxSum) {
          maxSum=currSum;
        }
      }
    }
    System.out.println("max sum: " + maxSum);
  }

  public static void kadanes(int numbers[]) {
    int ms = Integer.MIN_VALUE;
    int cs=0;
    for(int i=0; i<numbers.length; i++) {
      cs += numbers[i];
      if(cs<0) {
        cs=0;
      }
      ms = Math.max(cs, ms);

    }
    System.out.println("max subarray sum: " + ms);
  }

  public static int trapping(int height[]) {
    // calculate left max boundary - array
    int leftMax[] = new int[height.length];
    leftMax[0] = height[0];
    for(int i=1; i<height.length; i++) {
      leftMax[i] = Math.max(height[i], leftMax[i-1]);
    }
    // calculate right max boundary - array
    int rightMax[] = new int[height.length];
    rightMax[height.length-1] = height[height.length-1];
    for(int i=height.length-2; i>=0; i--) {
      rightMax[i]= Math.max(height[i], rightMax[i+1]);
    }

    int trappedWater=0;
    // loop
    for(int i=0; i<height.length; i++) {
     // waterlevel = min(leftmax boundary, rightmax boundary)
      int waterLevel = Math.min(rightMax[i], leftMax[i]);
    // trapped water = waterlevel - height[i]
      trappedWater += waterLevel - height[i];
    }
    return trappedWater;
  }

  public static int stocks(int prices[]) {
    int buyPrice= Integer.MAX_VALUE;
    int maxProfit=0;

    for(int i=0; i<prices.length; i++) {
      if(buyPrice<prices[i]) {
        // profit
        int profit=prices[i]-buyPrice; // today's profit
        maxProfit= Math.max(maxProfit, profit);
      } else {
        buyPrice = prices[i];
      }
    }
    return maxProfit;
  }
  // array-assignment
  public static boolean containsDuplicate(int nums[]) {
    // brute force O(n^2)
    for(int i=0; i<nums.length-1; i++) {
      for(int j=i+1; j<nums.length; j++) {
        if(nums[i] == nums[j]) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static void main(String args[]) {
    // max subarray sumI (BRUTE FORCE -- sbse basic approach) { O(n^3)}
    // int numbers[] = {1, -2, 6, -1, 3};
    // bruteForce(numbers);


    // max subarrayII (PREFIX SUM) -- { O(n^2)}
    // int numbers[] = {1, -2, 6, -1, 3};
    // prefixSum(numbers);



    // max subarrayIII (KADANE'S ALGORITHM) -- most optimised approach -- O(n)
    // int numbers[] = {-2, -3, 4, -1, -2, 1, 5, -3};
    // kadanes(numbers);



    // trapping rainwater --- time complexity O(n)
    // int height[] = {4, 2, 0, 6, 3, 2, 5};
    // System.out.println(trapping(height));




    // buy and sell stocks -- O(n)
    // int prices[] = {7, 1, 5, 3, 6, 4};
    // System.out.println(stocks(prices));




    // Arrays-Assignment

    // conatins duplicate or not
    // int nums[] = {1, 2, 3, 1, 5, 5};
    // System.out.println(containsDuplicate(nums));


    
  }
}
