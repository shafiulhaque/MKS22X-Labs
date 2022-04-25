ArrayList<Orb>orbList;
Orb bruh;

void setup() {
  size(1000, 700);
  orbList = new ArrayList<Orb>();
  bruh = new Orb(500, 350, 0, 0, 20);
}

void mouseClicked() {
  //add a new Orb to the orbList, constructed as follows:
  //The x and y positions are the same as the mouse
  //the radius should be between in the range [20.0,70.0)
  //the xSpeed and ySpeed should be in the range [-3.0,3.0)
  float radius = (float)Math.random()*50.0 + 20.0;
  float xSpeed = (float)Math.random()*6.0 - 3.0;
  float ySpeed = (float)Math.random()*6.0 - 3.0;
  Orb phys = new Orb(mouseX, mouseY, xSpeed, ySpeed, radius);
  orbList.add(phys);
}

void draw() {
  background(255);
  bruh.display();
  for (Orb o : orbList) {
    bruh.attract(o);
    o.move();
    o.display();
  }
  fill(0);
  text(frameRate, 20, 20);
  text(orbList.size(), 20, 40);
}
 
