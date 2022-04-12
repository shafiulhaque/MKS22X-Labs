int xp, yp;

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

void setup(){
  background(0);
  size(800,600);
  xp = 0;
  yp = 0;
}

void draw(){
  background(0);
  avatar(xp,yp);
  xp++;
  yp++;
  avatar(100,100);
  avatar(600,300);
}
