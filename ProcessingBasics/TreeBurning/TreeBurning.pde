/**IMPORTANT:
   *Please read through the logic of this sketch before you try to modify anything.
   *Please answer ALL questions in the source code BEFORE writing any code.
   */
  BurnTrees treeSim;
  int ROWS;
  int COLS;
  double DENSITY;
  int SQUARESIZE;

  void setup() {
    size(600, 500);
    ROWS = 50;
    COLS = 60;
    /**question 1 *********************************
     *At this point you have initialized width, height,ROWS,COLS. You can change these values
     *to alter the screen size, but you cannot just change one value!
     *What must be true about the ratio of these values in order for this simulation to display squares?
     *ANSWER HERE:
     The ratio of these values, from the width to columns and the height to rows is always 10. In this example, the width is 600 and the COLS is 60, while the height is 500 and the ROWS is 50.
     Both of 
     */

    DENSITY = .61;
    treeSim = new BurnTrees(ROWS, COLS, DENSITY);
    /**question 2 *********************************
     *Given that you can change the size() and the number of ROWS and COLS,
     *How do you calculate the SQUARESIZE (size of each square you draw) using an expression?
     *ANSWER : replace squareSize = 8; with the correct square size.
     * DO NOT just write a number, it must work when you change the size() command or the ROWS and COLS
     */
    SQUARESIZE = 8;//side length

  }

  /*DO NOT UPDATE THIS METHOD*/
  void draw() {
    background(0);
    //frameCount tells you how many times the draw method was called.
    if (frameCount % 10 == 0) {
      treeSim.tick();
    }
    /**question 3 *********************************
     *How is the behavior going to change if you only call tick() when the frameCount % 10 == 0?
     *Why do we do this?
     *hint:  If you cannot figure this out analytically, experiment to test
     *       the difference by changing the code.
     *ANSWER HERE:
     */

    String[]lines = treeSim.toString().split("\n");

    //Convert the 2D array into a grid of RED/GREEN/WHITE/GREY Squares.
    stringToSquares(lines);

    //Output the resulting time and dimensions of the simulation
    if (treeSim.done()) {
      fill(0);
      textSize(20);
      text("Simulation of "+COLS+"by"+ROWS+" board lasted "+treeSim.getTicks()+" ticks", 20, 20);
    }
  }

  /**
   *Clicking the mouse will reset the simulation by re-constructing the treeSim variable.
   */
  void mouseClicked() {
    /**question 4 *********************************
     *We can easily reset the simulation by clicking the mouse.
     *Please use the same values that it was initialized with in the setup.
     * ANSWER: UPDATE THE NEXT LINE
     */
    treeSim = null;
  }


  /** question 5 *********************************
   *Write the method that will take an array of the different lines of the board string,
   *and draw ROWSxCOLS colored squares on the screen
   *@param lines: an array of the lines of the toString method that has ROWS strings, each having a length of COLS
   *              e.g. [ "@ @@","@@@ "," @ @"] for a ROWS=3, COLS=4 board.
   *ANSWER: Complete this method.
   */
  void stringToSquares(String[]lines) {
    /**Complete this method.
     *1. Break up your screen by drawing ROWSxCOLS rectangles of the same color.
     *2. Decide how to fill them in using the String[] parameter
     *   Colors: Fire = RED, Tree = GREEN, SPACE = WHITE, ASH = GREY
     */

  }


  /***THIS IS YOUR PRIOR LAB (only a subset of methods)***/

  import java.util.*;
  public class BurnTrees {
    private int[][]map;
    private int ticks;
    private static final int TREE = 2;
    private static final int FIRE = 1;
    private static final int ASH = 3;
    private static final int SPACE = 0;
    private ArrayDeque<Integer>frontier;


    /**Determine if the simulation is still burning
     *@return false if any fires are still burning, true otherwise
     */
    public boolean done() {
      return frontier.size() == 0;
    }


    public void spread(int row, int col) {
      map[row][col]=ASH;

      if (row > 0) {
        if (map[row-1][col]==TREE) {
          map[row-1][col]=FIRE;
          frontier.add(row-1);
          frontier.add(col);
        }
      }
      if (row < map.length-1) {
        if (map[row+1][col]==TREE) {
          map[row+1][col]=FIRE;
          frontier.add(row+1);
          frontier.add(col);
        }
      }
      if (col > 0) {
        if (map[row][col-1]==TREE) {
          map[row][col-1]=FIRE;
          frontier.add(row);
          frontier.add(col-1);
        }
      }
      if (col < map[0].length-1) {
        if (map[row][col+1]==TREE) {
          map[row][col+1]=FIRE;
          frontier.add(row);
          frontier.add(col+1);
        }
      }
    }

    /**This is the core of the simulation. All of the logic for advancing to the next round goes here.
     *All existing fires spread new fires, and turn to ash
     *new fires should remain fire, and not spread.
     */
    public void tick() {
      if (!done()) { //THIS IS THE ONLY MODIFICATION TO THE LAB
        ticks++;
        int fires = frontier.size();
        while (fires > 0) {
          int r = frontier.remove();
          int c = frontier.remove();
          spread(r, c);
          fires-=2;
        }
      }
    }

    /**Initialize the simulation.
     *If you add more instance variables you can add more here,
     *otherwise it is complete
     */
    public BurnTrees(int rows, int cols, double density) {
      frontier = new ArrayDeque<Integer>();
      map = new int[rows][cols];
      for (int r=0; r<map.length; r++ ) {
        for (int c=0; c < map[r].length; c++ ) {
          if (Math.random() < density) {
            map[r][c]=TREE;
          }
        }
      }
      start();//set the left column on fire.
    }

    public void start() {
      for (int i = 0; i < map.length; i++) {
        if (map[i][0]==TREE) {
          map[i][0]=FIRE;
          frontier.add(i);
          frontier.add(0);
        }
      }
    }

    public int getTicks() {
      return ticks;
    }

    public String toString() {
      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < map.length; i++) {
        for (int c = 0; c < map[i].length; c++) {
          if (map[i][c]==SPACE)
            builder.append(" ");
          else if (map[i][c]==TREE)
            builder.append("@");
          else if (map[i][c]==FIRE)
            builder.append("w");
          else if (map[i][c]==ASH)
            builder.append(".");
        }
        builder.append("\n");
      }
      return builder.toString();
    }
  }
