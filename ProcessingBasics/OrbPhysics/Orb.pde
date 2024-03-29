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
    fill(c);
    stroke(255);
    ellipse(x, y, 2*radius, 2*radius);
    stroke(0);
    line(x, y, x + 5*xSpeed, y + 5*ySpeed);
  }

  void move() {
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
    x += xSpeed;
    y += ySpeed;
  }
  
  void attract(Orb other){
    float d = dist(x, y, other.x, other.y);
    other.xSpeed += 20 * (x - other.x)/(d*d);
    other.ySpeed += 20 * (y - other.y)/(d*d);
  }
  
  void attractSpring(Orb other){
    float d = dist(x, y, other.x, other.y);
    other.xSpeed += (d - SPRING_LENGTH)*(SPRING_CONSTANT)*(x-other.x)/d;
    other.ySpeed += (d - SPRING_LENGTH)*(SPRING_CONSTANT)*(y-other.y)/d;
    other.xSpeed *= SPRING_DAMPEN;
    other.ySpeed *= SPRING_DAMPEN;
  }
  
}
