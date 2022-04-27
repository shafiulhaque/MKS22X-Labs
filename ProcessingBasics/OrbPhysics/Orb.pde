public class Orb {
  float x, y;
  float xSpeed, ySpeed;
  float radius;
  color c;

  public Orb(float x_, float y_, float xSpeed_, float ySpeed_, float radius_ ) {
    x = x_;
    y = y_;
    xSpeed = xSpeed_;
    ySpeed = ySpeed_;
    radius = radius_;
    c = color(random(255), random(255), random(255)); //random color... why not.
  }


  void display() {
    //Part 1:
    //draw a ellipse at the x,y position, with the correct radius.
    //make sure it is the correct color
    //make sure you read the parameters of ellipse, so that you have the correct size.
    //radius is NOT one of the parameters of ellipse by default.
    fill(c);
    stroke(255);
    ellipse(x, y, 2*radius, 2*radius);
    stroke(0);
    line(x, y, x + 5*xSpeed, y + 5*ySpeed);
  }

  void move(String mode) {
    //PART 3
    //Change the speed when you collide with the end of the screen (all 4 sides)
    if (mode.equals("GRAVITY")){
    if (x - radius < 0) {
      xSpeed = -1*(xSpeed);
      x += 5;
    }
    if (y - radius < 0) {
      ySpeed = -1*(ySpeed);
      y += 5;
    }
    if (x + radius > width) {
      xSpeed = -1*(xSpeed);
      x -= 5;
    }
    if (y + radius > height) {
      ySpeed = -1*(ySpeed);
      y -= 5;
    }
    }
    //PART 2
    //change the x based on the xSpeed
    //change the y based on the ySpeed
    x += xSpeed;
    y += ySpeed;
  }
  
  void attract(Orb other){
    float d = dist(x, y, other.x, other.y);
    //other.xSpeed += (x - other.x)/(d);
    //other.ySpeed += (y - other.y)/(d);
    other.xSpeed += 20 * (x - other.x)/(d*d);
    other.ySpeed += 20 * (y - other.y)/(d*d);
  }
}