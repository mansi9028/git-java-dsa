public class recursion {
  public static void printDec(int n) {
    if(n == 1) {
      System.out.print(n);
      return;
    }
    System.out.print(n + " ");
    printDec(n-1);
  }

  public static void printInc(int n) {
    if(n == 1) {
      System.out.print(n);
      return;
    }
    printInc(n-1);
    System.out.print(n + " ");

  }

  public static int fact(int n) {

    if(n == 0) {
      return 1;
    }
    int fnm1 =  fact(n-1);
    int fn = n * fnm1;
    return fn;

  }

  public static int sum(int n) {
    if(n == 1) {
      return 1;
    }

    int snm1 = sum(n-1);
    int sn = n + snm1;
    return sn;
  }

  public static int nthFibonacci(int n) {
    if( n == 0 || n == 1) {
      return n;
    }
    int fnm1 = nthFibonacci(n-1);
    int fnm2 = nthFibonacci(n-2);
    return fnm1+fnm2;
  }

  public static boolean isSorted(int arr[], int i) {
    if(i == arr.length-1) {
      return true;
    }
    if(arr[i] > arr[i+1]) {
      return false;
    }
    return isSorted(arr, i+1);
  }

  public static int firstOccurence(int arr[], int key, int i) {
    if(i == arr.length) {
      return -1;
    }
    if(arr[i] == key) {
      return i;
    }
    return firstOccurence(arr, key, i+1);
  }

  public static int lastOccurence(int arr[], int key, int i) {
    if(i == arr.length) {
      return -1;
    }
    int isFound = lastOccurence(arr, key, i+1);
    if(isFound == -1 && arr[i] == key) {
      return i;
    }
    return isFound;
  }

  public static int power(int x, int n) {
    if(n == 0) {
      return 1;
    }
    // int xpnm1 = power(x, n-1);
    // int xpn = x * xpnm1;
    // return xpn;

    return x * power(x, n-1);
  }

  public static int optimizedPower(int a, int n) {
    if(n == 0) {
      return 1;
    }
    int halfPower = optimizedPower(a, n/2);
    int halfPowerSq = halfPower * halfPower;

    // n is odd
    if(n%2 != 0) {
      halfPowerSq = a * halfPowerSq;
    }
    return halfPowerSq;
  }
  public static void main(String[] args) {
    
    // print numbers from n to 1(decreasing order)
    // int n =10;
    // printDec(n);


    // print numbers from 1 to n (increasing order)
    // int n = 10;
    // printInc(n);


    // print factorial of a numbers n
    // int n = 5;
    // System.out.println(fact(n));


    // print sum of first n natural numbers
    // int n = 5;
    // System.out.println(sum(n));



    // print Nth fibonacci number
    // int n=25;
    // System.out.println(nthFibonacci(n));



    // check if the given arary is sorted or not
    // int arr[] = {2, 5, 6, 9};
    // System.out.println(isSorted(arr, 0));



    // WAF to find the first occurence of an element in an array
    // int arr[] = {8, 3, 6, 9, 5, 10, 2, 5, 3};
    // System.out.println(firstOccurence(arr, 5, 0));



    // WAF to find the last occurence of an element in an array
    // int arr[] = {8, 3, 6, 9, 5, 10, 2, 5, 3};
    // System.out.println(lastOccurence(arr, 5, 0));


    // print x to the power n - O(n)
    // System.out.println(power(2, 10));
    // optimized approach - O(logn)
    int a=2;
    int n=5;
    System.out.println(optimizedPower(a, n));


  }
}

