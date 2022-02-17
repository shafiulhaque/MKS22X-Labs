public class Text{
            public static final String CLEAR_SCREEN =  "\033[2J";
            public static final String HIDE_CURSOR =  "\033[?25l";
            public static final String SHOW_CURSOR =  "\033[?25h";
            //use this to go back to normal terminal colors
            public static final String RESET = "\033[0m"+SHOW_CURSOR;

            //terminal specific character to move the cursor to a location
            //top left is 1,1
            public static String go(int x,int y){
              return ("\033[" + x + ";" + y + "H");
            }

            public static void wait(int millis){
              try {
                Thread.sleep(millis);
              }
              catch (InterruptedException e) {
              }
            }

            public static final int BLACK = 30;
            public static final int RED = 31;
            public static final int GREEN = 32;
            public static final int YELLOW = 33;
            public static final int BLUE = 34;
            public static final int MAGENTA = 35;
            public static final int CYAN = 36;
            public static final int WHITE = 37;

            /*Text modifiers to be ADDED to a color*/
            public static final int BACKGROUND = 10;
            public static final int BRIGHT = 60;

            /*Text modifiers that are separate from color*/
            public static final int BOLD = 1;
            public static final int UNDERLINE = 4;
            public static final int INVERTED = 7;

            /*Reset colors*/
            public static void reset(){
              System.out.print("\u001b[0m");
            }


            public static void hideCursor(){
              System.out.print("\u001b[?25l");
            }

            public static void showCursor(){
              System.out.print("\u001b[?25h");
            }

            /*Erases all text on the terminal.*/
            public static void clear(){
              System.out.print("\u001b[2J");
            }

            /*Overloaded Colorize methods.
            c1,c2 and c3 are any color modifiers such as bold/color/background color etc.
            */
            public static String colorize(String text,int c1){
              return ("\u001b[" + c1 + "m"+text+"\u001b[0m");
            }
            public static String colorize(String text,int c1,int c2){
              return ("\u001b[" + c1 + ";" + c2 + "m"+text+"\u001b[0m");
            }
            public static String colorize(String text,int c1,int c2,int c3){
              return ("\u001b[" + c1 + ";" + c2 + ";" + c3 + "m"+text+"\u001b[0m");
            }
          }
