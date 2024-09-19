public class backtracking {
  public static void changeArr(int arr[], int i, int val) {
    // base case
    if(i == arr.length) {
      printArr(arr);
      return;
    }

    // recursion
    arr[i] = val;
    changeArr(arr, i+1, val + 1);
    arr[i] = arr[i] - 2;

  }
  public static void printArr(int arr[]) {
    for(int i=0; i<arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
  public static void findSubsets(String str, String ans, int i) {
    // base case
    if(i == str.length()) {
      if(ans.length() == 0) {
        System.out.println("null");
      } else {
      System.out.println(ans);
      }
      return;
    }
    // recursion
    //yes choice
    findSubsets(str, ans+str.charAt(i), i+1);
    //no choice
    findSubsets(str, ans, i+1);
  }
  public static void findPermutations(String str, String ans) {
    // base case
    if(str.length() == 0) {
      System.out.println(ans);
      return;
    }
    // recursion
    for(int i = 0; i < str.length(); i++) {
      char curr = str.charAt(i);
      String newStr = str.substring(0, i) + str.substring(i+1);
      findPermutations(newStr, ans+curr);
    }
  }
  public static boolean isSafe(char board[][], int row, int col) {
    // vertically up
    for(int i=row-1; i>=0; i--) {
      if(board[i][col] == 'Q') {
        return false;
      }
    }

    // diagonal left up
    for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
      if(board[i][j] == 'Q') {
        return false;
      }
    }

    // diagonal right up
    for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++) {
      if(board[i][j] == 'Q') {
        return false;
      }
    }
    return true;
  }
  public static void nQueens(char board[][], int row) {
		// base case
		if(row == board.length) {
			//printBoard(board); // solution ko print krne ke place mein total count of soltions le lete h ... uske ke print ko comment out krr lete h 
      count++;
			return;
		}

		// column loop
    for(int j=0; j<board.length ; j++) {
      if(isSafe(board, row, j)) {
        board[row][j] = 'Q';
        nQueens(board, row+1); // function call
        board[row][j] = 'x';  // backtracking step
      }
		}
  }

  public static boolean nQueens1solution(char board[][], int row) {
		// base case
		if(row == board.length) {
			//printBoard(board); // solution ko print krne ke place mein total count of soltions le lete h ... uske ke print ko comment out krr lete h 
      count++;
			return true;
		}

		// column loop
    for(int j=0; j<board.length ; j++) {
      if(isSafe(board, row, j)) {
        board[row][j] = 'Q';
        if(nQueens1solution(board, row+1)) {
          return true;
        } 
        board[row][j] = 'x';  // backtracking step
      }
		}
    return false;
  }

	public static void printBoard(char board[][]) {
		System.out.println("------chess board-----");
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

  static int count=0;

  public static int gridWays(int i, int j, int n, int m) {
    // base case
    if(i == n-1 && j == m-1) { // last cell
        return 1;
    } else if(i == n || j == m) { // boundary cross condition
        return 0;
    }

    int w1 = gridWays(i+1, j, n, m);
    int w2 = gridWays(i, j+1, n, m);
    return w1+w2;
  }

  public static boolean isSafeSudoku(int sudoku[][], int row, int col, int digit) {
    // column
    for(int i=0; i<=8; i++) {
      if(sudoku[i][col] == digit) {
        return false;
      }
    }
    
    // row
    for(int j=0; j<=8; j++) {
      if(sudoku[row][j] == digit) {
        return false;
      } 
    }

    // grid
    int sr = (row/3)*3; // sr = starting row
    int sc = (col/3)*3; // sc = starting column

    // 3 X 3 wale nested grids
    for(int i=sr; i<sr+3; i++) {
      for(int j=sc; j<sc+3; j++) {
        if(sudoku[i][j] == digit) {
          return false;
        }
      }
    }
    return true;
  }

  public static boolean sudokuSolver(int sudoku[][], int row, int col) {
    // base case 
    if(row == 9) {
      return true;
    } 

    // recursion
    int nextRow = row, nextCol = col+1;
    if(col+1 == 9) {
      nextRow = row+1;
      nextCol = 0;
    }

    if(sudoku[row][col] != 0) {
      return sudokuSolver(sudoku, nextRow, nextCol);
    }

    for(int digit = 1; digit<=9; digit++) {
      if(isSafeSudoku(sudoku, row, col, digit)) {
          sudoku[row][col] = digit;
          if(sudokuSolver(sudoku, nextRow, nextCol)) { // solution exists
            return true;
          }
          sudoku[row][col] = 0;

      }
    }
    return false;
  }

  public static void printSudoku(int sudoku[][]) {
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(sudoku[i][j] + " ");
			}
			System.out.println();
		}
	}

  public static boolean solveRatMaze(int ratMaze[][]) {
    int N=ratMaze.length;
    int sol[][]= new int[N][N];
    if(solveMazeUtil(ratMaze, 0, 0, sol) == false) {
      System.out.print("Solution doesn't exist");
      return false; 
    }

    printSolution(sol);
    return true;
  }

  public static boolean isRatMazeSafe(int ratMaze[][], int x, int y) {
    // if (x,y outside) maze then return false
    return (x>=0 && x<ratMaze.length && y>=0 && y<ratMaze.length && ratMaze[x][y] == 1);
  }

  public static void printSolution(int sol[][]) {
    for(int i=0; i<sol.length; i++) {
      for(int j=0; j<sol.length; j++) {
        System.out.print(" " + sol[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static boolean solveMazeUtil(int ratMaze[][], int x, int y, int sol[][]) {
    if(x == ratMaze.length-1 && y == ratMaze.length-1 && ratMaze[x][y] == 1) {
      sol[x][y] = 1;
      return true;
    }

    // check if ratMaze[x][y] is valid
    if(isRatMazeSafe(ratMaze, x, y) == true) {
      if(sol[x][y] == 1) 
        return false;
      sol[x][y] = 1;
      if(solveMazeUtil(ratMaze, x+1, y, sol))
        return true;
      if(solveMazeUtil(ratMaze, x, y+1, sol))
        return true;
      sol[x][y] = 0;
      return false;
    }
    return false;
  }
  public static void main(String[] args) { 
    // backtracking - arrays
    // int arr[] = new int[5];
    // changeArr(arr, 0, 1);
    // printArr(arr);


    // find subsets... eg- abc... a, b, c, ab, bc, ac, abc, " "
    // String str = "abc";
    // findSubsets(str, "", 0);


    // find permutations of a string... abs --- abc, acb, bac, bca, cab, cba
    // O(n * n!)
    // String str = "abc";
    // findPermutations(str, " ");


    // // N-Queens
    // // all ways
    // // O(n!)
    // int n = 4;
    // char board[][] = new char[n][n];
    // //initialize
    // for(int i = 0; i<n; i++) {
    //     for(int j=0; j<n; j++) {
    //       board[i][j] = 'x';
    //     }
    // }
    // nQueens(board, 0);



    // count ways ... O(n!)
    // System.out.println("total ways to solve n-queens = " + count);


    
    
    // // print 1 solution
    // if(nQueens1solution(board, 0)) {
    //   System.out.println("soltion is possible");
    //   printBoard(board);
    // } else {
    //   System.out.println("solution is NOT possible");
    // }




    // Grid Ways (number of ways to reach from (0,0) to (N-1,M-1) in a N X M grid   - allowed moves are right or down)
    // int n=3, m=3;
    // System.out.println(gridWays(0, 0, n, m));



    // Sudoku solver - 9 X 9 consistion of nine 3 X 3
    //   int sudoku[][] = { {0,0,8,0,0,0,0,0,0},
    //                     {4,9,0,1,5,7,0,0,2},
    //                     {0,0,3,0,0,4,1,9,0},
    //                     {1,8,5,0,6,0,0,2,0},
    //                     {0,0,0,0,2,0,0,6,0},
    //                     {9,6,0,4,0,5,3,0,0},
    //                     {0,3,0,0,7,2,0,0,4},
    //                     {0,4,9,0,3,0,0,5,7},
    //                     {8,2,7,0,0,9,0,1,3} };
    // if(sudokuSolver(sudoku, 0 , 0)) {
    //   System.out.println("solution exists");
    //   System.out.println("------SUDOKU-----");
    //   printSudoku(sudoku);
    // } else {
    //   System.out.println("solution does NOT exists");
    // }




    
    
    // Backtracking questions
    // assignment
    
    // q1 - rat maze
    // int ratMaze[][] = { {1, 0, 0, 0},
    // {1, 1, 0, 0},
    // {0, 0, 1, 0},
    // {0, 0, 1, 0} };

    // solveRatMaze(ratMaze);


    //q2, q3



  }
}
