public class QueenBoard{
  //fields
  private int[][] board;
  private boolean animated;
  private int delay;

  // constructors
  public QueenBoard(){
    board = new int[8][8];
    for (int i = 0; i < 8; i++){
      for (int j = 0; j < 8; j++){
        board[i][j] = 0;
      }
    }
    this.delay = 1000;
    this.animated = false;
  }

  public QueenBoard(int size){
    board = new int[size][size];
    for (int i = 0; i < size; i++){
      for (int j = 0; j < size; j++){
        board[i][j] = 0;
      }
    }
    this.delay = 1000;
    this.animated = false;
  }

  public QueenBoard(int size, int delay){
    board = new int[size][size];
    for (int i = 0; i < size; i++){
      for (int j = 0; j < size; j++){
        board[i][j] = 0;
      }
    }
    this.delay = delay;
    this.animated = false;
  }

 // mutator methods
 public void setAnimate(boolean newValue){
   this.animated = newValue;
 }

 public void setDelay(int newValue){
   if (newValue < 0) this.delay = 0;
   this.delay = newValue;
 }
  /**
          *@return The output string formatted as follows:
          *All numbers that represent queens are replaced with 'Q'
          *all others are displayed as underscores '_'
          *There are spaces between each symbol:
          *_ _ Q _
          *Q _ _ _
          *_ _ _ Q
          *_ Q _ _
          *excludes the characters up to the comment(*)
          */
          public String toString(){
            String bd = "";
            for (int i = 0; i < board.length; i++){
              for (int j = 0; j < board[i].length; j++){
                if (board[i][j] >= 0){
                  System.out.print("_ ");
                } else {
                  System.out.print("Q ");
                }
              }
              System.out.println();
            }
            return bd;
          }

          /**
          *@return true when the queen added correctly, false Otherwise
          *@precondition r and c are valid indices of the board array
          *@postcondition the board is only changed when the function returns true
          * in which case the queen is added and all it's threatened positions are incremented
          */
          private boolean addQueen(int r, int c){
            if (board[r][c] == 0){
              board[r][c] = -1;
              int co = c+1;
              int co2 = c-1;
              for (int i = r+1; i < board.length; i++){
                board[i][c]++;
                if (co < board.length){
                  board[i][co]++;
                  co++;
                }
                if (co2 >= 0){
                  board[i][co2]++;
                  co2--;
                }
              }
              if(animated){
            System.out.println(Text.go(1,1));
            System.out.println(this);//can modify here
            Text.wait(delay);
          }
              return true;
            }
            if(animated){
              System.out.println(Text.go(1,1));
              System.out.println(this);//can modify here
              Text.wait(delay);
            }
            return false;
          }

          /**Remove the queen that was added to r,c
          *@precondition r and c are valid indices of the board array and there is a queen at position r,c
          *@postcondition the board is modified to remove that queen and all it's
          *threatened positions are decremented
          */
          private void removeQueen(int r, int c){
            board[r][c] = 0;
            int co = c+1;
            int co2 = c-1;
            for (int i = r+1; i < board.length; i++){
              board[i][c]--;
              if (co < board.length){
                board[i][co]--;
                co++;
              }
              if (co2 >= 0){
                board[i][co2]--;
                co2--;
              }
            }
            if(animated){
              System.out.println(Text.go(1,1));
              System.out.println(this);//can modify here
              Text.wait(delay);
            }
          }

          /**Find the first solution configuration possible for this size board. Start by placing
          *  the 1st queen in the top left corner, and each new queen in the next ROW. When backtracking
          *  move the previous queen to the next valid space. This means everyone will generate the same
          *  first solution.
          *@postcondition: the board remains in a solved state.
          *@return false when the board is not solveable and leaves the board filled with zeros;
          *        returns true when the board is solveable, and leaves the board in a solved state
          *@throws IllegalStateException when the board starts with any non-zero value (e.g. you solved a 2nd time.)
          */
          public boolean solve(){
            if (board[0][0] != 0) throw new IllegalStateException("Board does not start with 0");
            return solve(0);

          }

          public boolean solve(int r){
            if (r == board.length){
              return true;
            } else {
              for (int i = 0; i < board[r].length; i++){
                if (addQueen(r, i)){
                  if (solve(r+1)){
                    return true;
                  }
                  removeQueen(r, i);
                }
              }
              return false;
            }
          }

          /**Find all possible solutions to this size board.
          *@return the number of solutions found, and leaves the board filled with only 0's
          *@throws IllegalStateException when the board starts with any non-zero value (e.g. you ran solve() before this method)
          */
          public int countSolutions(){
            if (board[0][0] != 0) throw new IllegalStateException("Board does not start with 0");
            return countSolutions(0);
          }

          public int countSolutions(int r){
            int joe = 0;
            if (r == board.length){
              joe++;
            } else {
              for (int i = 0; i < board[r].length; i++){
                if (addQueen(r, i)){
                  if (solve(r+1)){
                    joe++;
                  }
                  removeQueen(r, i);
                }
                removeQueen(0, i);
              }
            }
            return joe;
          }
}
