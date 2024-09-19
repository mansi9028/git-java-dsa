public class bitManipulation {
  public static void oddOrEven(int n) {
    int bitMask = 1;

    if((n & bitMask) == 0) {
      // even
      System.out.println("even");
    } else {
      // odd
      System.out.println("odd");
    }
  }

  public static int getIthBit(int n, int i) {
    int bitMask = 1<<i;
    if((n & bitMask) == 0) {
      return 0;
    } else {
      return 1;
    }
  }

  public static int setIthBit(int n, int i) {
    int bitMask = 1<<i;
    return n | bitMask;
  }

  public static int clearIthBit(int n, int i) {
    int bitMask = ~(1<<i);
    return n & bitMask;
  }
  
  public static int updateIthBit(int n, int i, int newBit) {
    // if(newBit == 0) {
    //   return clearIthBit(n, i);
    // } else {
    //   return setIthBit(n, i);
    // }
    // OR 
    n = clearIthBit(n, i);
    int bitMask = newBit<<i;
    return n | bitMask;
  }

  public static int clearIBits(int n, int i) {
    int bitMask = (~0)<<i;
    return n & bitMask;
  }

  public static int clearRangeOfBits(int n, int i, int j) {
    int a = ((~0)<<(j+1));
    int b = (1<<i)-1;
    int bitMask= a | b;
    return n & bitMask;
  }
      
  public static boolean isPowerOfTwo(int n) {
    return (n&(n-1)) == 0;
  }

  public static int countSetBits(int n) {
    int count=0;
    while(n > 0) {
      if((n&1) != 0) {
        count++;
      }
      n = n>>1;
    }
    return count;
  }
  
  public static int fastExpo(int a, int n) {
    int ans=1;

    while(n>0) {
      if((n & 1) != 0) {// check LSB
        ans = ans*a;
      }
      a = a*a;
      n = n>>1;
    }
    return ans;
  }
  public static void main(String[] args) {
    // oddOrEven(13);


    // operations - get ith bit, set ith bit, clear ith bit

    // get ith bit
    // System.out.println(getIthBit(10, 3));

    // set ith bit
    // System.out.println(setIthBit(10, 0));

    // clear ith bit
    // System.out.println(clearIthBit(10, 1));



    // update ith bit
    // System.out.println(updateIthBit(10, 1, 0));



    // clear i bits
    // System.out.println(clearIBits(15, 2));


    // clear range of bits
    // System.out.println(clearRangeOfBits(10, 2, 4));


    // power of 2
    // System.out.println(isPowerOfTwo(15));



    // count set bits in a number - set bits mtlb bits jo ki 1 h
    // System.out.println(countSetBits(15)); // eg1
    // System.out.println(countSetBits(16)); // eg2


    // fast exponentiation
    // System.out.println(fastExpo(5, 3));



    // assignment
    //q2 - swapping without using third variable
    // int x=3, y=4;
    // System.out.println("before swap: x = " + x + " , y = " + y);
    // // swap using xor
    // x = x ^ y;
    // y = y ^ x;
    // x = x ^ y;
    // System.out.println("after swap: x = " + x + " , y = " + y);


    // q3 - add 1 to the integer using bit manipulation
    // int x = 6;
    // System.out.println(x + " + 1 is: " + -~x);
    // x = 44;
    // System.out.println(x + " + 1 is: " + -~x);


    // q4 - convert uppercase characters to lowercase using bits
    for(char ch='A'; ch<='Z'; ch++) {
      System.out.print((char)(ch | ' '));
    }


  }
}
