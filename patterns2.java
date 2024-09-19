public class patterns2 {
  public static void hollow_rectangle(int totRows, int totCols) {
    // outer loop - rows
    for(int i = 1; i <= totRows; i++) {
      // inner loop - columns
      for(int j = 1; j <= totCols; j++) {
        // cell(i,j)
        if(i ==1 || i == totRows || j == 1 || j == totCols) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  public static void inverted_rotated_half_pyramid(int n) {
    // outer loop
    for(int i =1; i<=n; i++) {
      // spaces
      for(int j = 1; j <= n-i; j++) {
        System.out.print(" ");
      }
      // stars 
      for(int j = 1; j<= i; j++) {
        System.out.print("*");
      }
    System.out.println();

    }
  }

  public static void inverted_half_pyramid_withNumbers(int n) {
    for(int i = 1; i<=n;i++) {
      for(int j = 1; j <= n-i+1 ; j++) {
        System.out.print(j + " ");
      }
      System.out.println();
    }
  }

  public static void floydsTriangle(int n) {
    int counter = 1;
    for(int i = 1; i<=n; i++) {
      for(int j=1; j<=i; j++) {
        System.out.print(counter + " ");
        counter++;
      }
      System.out.println();
    }
  }

  public static void zero_one_triangle(int n) {
    for(int i=1; i<=n; i++) {
      for(int j=1; j<=i; j++) {
        if((i+j) % 2 ==0) { // even
          System.out.print("1");
        } else { // odd
          System.out.print("0");
        }
      }
      System.out.println();
    }
  }

  public static void butterfly(int n) {
    //first half
    for(int i=1; i<=n; i++) {
      //stars - i
      for(int j=1; j<=i; j++) {
        System.out.print("*");
      }
      
      // spaces - 2*(n-i)
      for(int j=1; j<=2*(n-i); j++) {
        System.out.print(" ");
      }

      // stars - i
      for(int j=1; j<=i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }

    // second half
    for(int i=n; i>=1; i--) {
      //stars - i
      for(int j=1; j<=i; j++) {
        System.out.print("*");
      }
      
      // spaces - 2*(n-i)
      for(int j=1; j<=2*(n-i); j++) {
        System.out.print(" ");
      }

      // stars - i
      for(int j=1; j<=i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
  public static void solid_rhombus(int n) {
    for(int i=1; i<=n; i++) {
      // spaces - n-i
      for(int j=1; j<= (n-i); j++) {
        System.out.print(" ");
      }
      // stars - n
      for(int j=1; j<=n ; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  public static void hollow_rhombus(int n) {
    for(int i=1; i<=n; i++) {
      // spaces
      for(int j=1; j<= (n-i); j++) {
        System.out.print(" ");
      }

      // hollow rectangle 
      
      for(int j = 1; j <= n; j++) {
        // cell(i,j)
        if(i ==1 || i == n || j == 1 || j == n) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
    
public static void diamond_pattern(int n) {
  // 1st half
  for(int i=1; i<=n; i++) {
    // spaces - n-i
    for(int j=1; j<= (n-i); j++) {
      System.out.print(" ");
    }

    
    // stars - 2i-1
    for(int j=1; j<=(2*i)-1; j++) {
      System.out.print("*");
    }
    System.out.println();
  }

  // 2nd half
  for(int i=n; i>=1; i--) {
     // spaces - n-i
    for(int j=1; j<= (n-i); j++) {
      System.out.print(" ");
    }

    
    // stars - 2i-1
    for(int j=1; j<=(2*i)-1; j++) {
      System.out.print("*");
    }
    System.out.println();

  }
}



  public static void main(String args[]) {

    // hollow rectangle
    // hollow_rectangle(4, 5);



    // inverted rotated half pyramid
    // inverted_rotated_half_pyramid(5);


    // inverted half pyramid with numbers
    // inverted_half_pyramid_withNumbers(7);


    // floyd's triangle
    // floydsTriangle(7);


    // 0-1 triangle
    // zero_one_triangle(6);



    // butterfly pattern
    // butterfly(5);


    // solid rhombus
    // solid_rhombus(5);


    // hollow rhombus
    // hollow_rhombus(5);


    // diamond pattern
    diamond_pattern(5);
  }
}
