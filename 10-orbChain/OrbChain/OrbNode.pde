public class OrbNode {
  float x, y;
  float dx, dy;
  float radius;
  color c;
  OrbNode next, prev;

  public OrbNode() {
  }

  public OrbNode(float x_, float y_) {
    this(x_, y_, 0.0, 0.0, 50.0);
  }

  public OrbNode(float x_, float y_, float dx_, float dy_, float radius_ ) {
    x = x_;
    y = y_;
    dx = dx_;
    dy = dy_;
    radius = radius_;
    c = color(random(255), random(255), random(255), 200);
  }

  void display() {
    fill(c);
    ellipse(x, y, radius*2, radius*2);
    if (next != null) {
      line(x, y, next.x, next.y);
    }
    if (prev != null) {
      line(x, y, prev.x, prev.y);
    }
  }

  void springAttract(OrbNode other) {
    float dist = dist(x, y, other.x, other.y) ;
    float force = (dist - SPRING_LENGTH) * SPRING_CONSTANT;
    float displacex = (x - other.x) ;
    float displacey = (y - other.y) ;
    other.dx += displacex * force / dist;
    other.dy += displacey * force / dist;
    other.dx *= SPRING_DAMPEN;
    other.dy *= SPRING_DAMPEN;
  }

  void move() {
    if (next != null) {
      next.springAttract(this);
    }
    if (prev != null) {
      prev.springAttract(this);
    }
    //VELOCITY
    x+=dx;
    y+=dy;
    //GRAVITY
    dy+=GRAVITY;
  }
}

public class FixedOrbNode extends OrbNode {

  void move() {
    //EMPTY
  }

  FixedOrbNode(float x_, float y_) {
    x = x_;
    y = y_;
    radius = 30;
    c = color(0);
  }
}
