void avatar(int x, int y){
  float a = random(255);
  float b = random(255);
  float c = random(255);
  stroke(255, 255, 255);
  fill(0, 0, 0);
  triangle(x-25, y-25, x+25 - 30/4, y-25, x-25, y+25 - 30/4);
  triangle(x+25, y+25, x-25 + 30/4, y+25, x+25, y-25 + 30/4);
  fill(255, 255, 255);
  stroke(0, 0, 0);
  triangle(x-25 + 50/8, y-25 + 50/8, x-25 + 235/8, y-25 + 50/8, x-25 + 50/8, y-25 + 235/8);
  triangle(x+25 - 50/8, y+25 - 50/8, x+25 - 235/8, y+25 - 50/8, x+25 - 50/8, y+25 - 235/8);
  stroke(0, 0, 0);
  quad(x+25 - 235/8, y + 10, x-10, y-25 + 235/8, x-25 + 235/8, y-10, x+10, y+25 - 235/8);
}

int x,y;
int MODE;

void setup(){
         size(800,800);
         MODE = 3;
         x = width/2;
         y = height/2;
}

void draw(){
         background(255);
         x = change(x);
         y = change(y);
         avatar(x,y);
}

int change(int value){
    /**
     mode 1: return a random location on the screen.
     mode 2: change value by +1, 0, or -1 randomly
     mode 3: change value by +1 , but if it goes past the end of the screen ,
           wrap back around to the other end of the screen.
    */
    switch(MODE){
     case 1:
       return (int)random(800);
     case 2:
       return value + (int)(Math.random()*3) - 1;
     case 3:
     if (value == 800){
       return 0;
     }
       return value + 1;
     default:
       return width/2;
  }
}
