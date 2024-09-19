// // import java.util.*;

// public class functions_methods {
//   public static int multiply(int a, int b) {
//     int product = a * b;
//     return product;
//   }
//   public static int fact(int n) {
//     int f = 1;
//     for(int i = 1; i<=n; i++) {
//       f *= i;
//     }
//     return f;
//   }

//   public static int binCoeff(int n, int r) {
//     int nfact = fact(n);
//     int rfact = fact(r);
//     int nmrfact = fact(n-r);
//     int binomialCoefficient = nfact / (rfact * nmrfact);
//     return binomialCoefficient;
//   }
//   // public static boolean isPrime(int n) { // non optimized process
//   //   // corner cases
//   //   if(n == 2) {
//   //     return true;
//   //   }
//   //   for(int i = 2; i<= n-1; i++) {
//   //     if(n % i == 0) { // completely dividing
//   //     return false;
//   //     }
//   //   }
//   //   return true;

//   // }

//   public static boolean isPrime(int n) {
//     if(n == 2) {
//       return true;
//     }
//     for(int i =2; i<= Math.sqrt(n); i++) {
//       if(n % i == 0) { // completely dividing
//             return false;
//             }
//           }
//           return true;
//         }

//   public static void primesInRange(int n) {
//     for(int i = 2; i<=n;i++) {
//       if(isPrime(i)) {// true
//         System.out.print(i + " ");}
//     }
//     System.out.println();
//   }

//   public static void binToDec(int binNum) {
//     int myNum = binNum;
//     int pow = 0;
//     int decNum = 0;

//     while(binNum > 0) {
//       int lastDigit = binNum % 10;
//       decNum = decNum + (lastDigit * (int)Math.pow(2, pow));

//       pow++;
//       binNum /= 10;
//     }
//     System.out.println("decimal of " + myNum + " is : " + decNum);
//   }

//   public static void decToBin(int decNum) {
//     int myNum = decNum;
//     int pow = 0;
//     int binNum = 0;

//     while(decNum > 0) {
//       int rem = decNum % 2;
//       binNum = binNum + (rem * (int)Math.pow(10,pow));

//       pow++;
//       decNum /= 2;
//     }
//     System.out.println("binary of " + myNum + " : " + binNum);
//   }

//   public static void avg(int a, int b,int c) {
//     int sum = (a+b+c) / 3;
//     System.out.println("average if three numbers is: " + sum);
//   }

//   public static boolean isEven(int n) {
//     if(n % 2 == 0) {
//       return true;
//     } 
//     else {
//       return false;
//     }

//   }

//   public static void sumOfDigits(int n) {
//     int sum = 0;
//     while(n > 0) {
//       int lastDigit = n % 10;
//       sum += lastDigit;
//       n /= 10;

//     }
//     System.out.println(sum);
//   }
//   public static void main(String args[]) {
//     // multiplication of two numbers
//     // System.out.println(multiply(5, 75));


//     // factorial of a number, n
//     // int factorial = fact(5);
//     // System.out.println("factorial of is: " + factorial);


//     // binomial coefficient
//     // System.out.println(binCoeff(5, 2));


//     // check if a number is prime or not
//     // System.out.println(isPrime(22));



//     // priting primes in a range
//     // primesInRange(30);



//     // code - binary to decimal
//     // binToDec(1000);


//     // code - decimal to binary
//     // decToBin(8);



//     // avg of three numbers
//     // avg(10, 10, 10);


//     // // isEven
//     // if(isEven(225)) {
//     //   System.out.println("even");
//     // }
//     // else {
//     // System.out.println("odd");
//     // }


//     // sum of digits
//     sumOfDigits(11521);
//   }
// }
