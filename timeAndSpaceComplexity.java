public class timeAndSpaceComplexity {
  class SqrtNum {
    static int floorSqrt(int x) {
      if(x == 0 || x == 1) {
        return x;
      }
      int i=1, result = 1;
      while(result <= x) {
        i++;
        result = i*i;
      }
      return i-1;
    }
  }
  public static void main(String[] args) {
    // assignment
    // q1 - find the time and space complexity of floorSqrt function int the following code to calculate square root of a number
    // int x = 11;
    // System.out.print(floorSqrt(x));

  }
}
