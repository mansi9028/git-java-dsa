import java.util.*;
public class string {
  public static boolean isPalindrome(String str) {
    for(int i=0; i<str.length()/2; i++) {
      int n=str.length();
      if(str.charAt(i) != str.charAt(n-1-i)) { // not a palindrome
        return false;
      }
    }
    return true;
  }

  public static float getShortestPath(String path) {
    int x=0, y=0; 

    for(int i=0; i<path.length(); i++) {
      char direction = path.charAt(i);

      if(direction == 'S') {
        y--;
      }
      else if(direction == 'N') {
        y++;
      }
      else if(direction == 'W') {
        x--;
      }
      else {
        x++;
      }
    }
    int X2 = x*x;
    int Y2 = y*y;
    return (float)(Math.sqrt(X2 * Y2));
  }

  public static String uppercase(String str) {
    StringBuilder sb = new StringBuilder("");

    char ch= Character.toUpperCase(str.charAt(0));
    sb.append(ch);

    // O(n)
    for(int i=1; i<str.length(); i++) {
      if(str.charAt(i) == ' ' && i<str.length()-1) {
        sb.append(str.charAt(i));
        i++;
        sb.append(Character.toUpperCase(str.charAt(i)));
      } else {
        sb.append(str.charAt(i));
      }
    }
    return sb.toString();
  }

  public static String compress(String str) {
    String newStr="";

    for(int i=0; i<str.length();i++) { // O(n)
      Integer count = 1;
      while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
        count++;
        i++;
      }
      newStr += str.charAt(i);
      if(count>1) {
        newStr += count.toString();
      }
    }
    return newStr;
  }
  public static void main(String[] args) {
    // check if a string is a palindrome - O(n)
    // String str = "mansi";
    // System.out.println(isPalindrome(str));


    // shortest path - direction -- given a route containing 4 directions(E, W, N,S), find the shortest path(displacement) to reach the destination
    // N y+1
    // S y-1
    // W x-1
    // E x+1
    // String path = "NNNNWEEEESS";
    // System.out.println(getShortestPath(path));


    // compare to functions
  //   String fruits[] = {"apple", "mango", "banana"};

  //   String largest = fruits[0];
  //   for(int i=1; i<fruits.length; i++) {
  //     if(largest.compareTo(fruits[i]) < 0) {
  //       largest = fruits[i];
  //     }
  //   }
  // System.out.println(largest);




  // String Builder
  // StringBuilder sb = new StringBuilder("");
  // for(char ch='a'; ch<='z'; ch++) {
  //   sb.append(ch);
  // } // O(26)
  // System.out.println(sb);
  // System.out.println(sb.length());



    // for a given string convert each the first letter of each word to uppercase
    // String str="hi, i am mansi";
    // System.out.println(uppercase(str));


    // String Compression ***
    // String str = "aaaabbbccd";
    // System.out.println(compress(str));




    // assignment
    // q1 - count how many times lowercase vowels occured in a String entered by the user
    // String str = new Scanner(System.in).next();
    // int count=0;

    // for(int i=0; i<str.length(); i++) {
    //   char ch= str.charAt(i);
    //   if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ) {
    //     count++;
    //   }
    // }
    // System.out.println("count of vowels is: " + count);


    // q4 - determine if 2 strings are anagrams or not
    String str1 = "earth";
    String str2 = "heart";

    str1.toLowerCase();
    str2.toLowerCase();

    if(str1.length() == str2.length()) {
      char[] str1charArray = str1.toCharArray();
      char[] str2charArray = str2.toCharArray();

      Arrays.sort(str1charArray);
      Arrays.sort(str2charArray);

      boolean result = Arrays.equals(str1charArray, str2charArray);
      if(result) {
        System.out.println(str1 + " and " + str2 + " are anagrams of each other");
      } else {
        System.out.println(str1 + " and " + str2 + " are not anagrams of each other");
      }
    } else {
      System.out.println(str1 + " and " + str2 + " are not anagrams of each other");
    }
  }
}


