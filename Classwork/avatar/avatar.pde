float x = random(255);
float y = random(255);
float z = random(255);

void setup(){
  size(600, 600);
  background(0, 0, 0);
  stroke(255, 255, 255);
  fill(0, 0, 0);
  triangle(100, 100, 100, 470, 470, 100);
  triangle(500, 500, 130, 500, 500, 130);
  fill(255, 255, 255);
  triangle(150, 150, 150, 355, 355, 150);
  triangle(450, 450, 245, 450, 450, 245);
  stroke(0, 0, 0);
  quad(245, 325, 275, 355, 355, 275, 325, 245);
}

void draw(){
  delay(300);
  stroke(x, y, z);
  fill(0, 0, 0);
  triangle(100, 100, 100, 470, 470, 100);
  triangle(500, 500, 130, 500, 500, 130);
  fill(x, y, z);
  triangle(150, 150, 150, 355, 355, 150);
  triangle(450, 450, 245, 450, 450, 245);
  quad(245, 325, 275, 355, 355, 275, 325, 245);
  x = random(255);
  y = random(255);
  z = random(255);
}
