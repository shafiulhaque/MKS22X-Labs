ArrayList<Orb>orbList;
Orb bruh;
int mode;

void setup() {
  size(1000, 800);
  background(255);
  orbList = new ArrayList<Orb>();
  bruh = new Orb(width/2, height/2, 0, 0, 10);
  mode = 1;
}

void mouseClicked() {
  //add a new Orb to the orbList, constructed as follows:
  //The x and y positions are the same as the mouse
  //the radius should be between in the range [20.0,70.0)
  //the xSpeed and ySpeed should be in the range [-3.0,3.0)
  //float radius = (float)Math.random()*50.0 + 20.0;
  //float xSpeed = (float)Math.random()*6.0 - 3.0;
  //float ySpeed = (float)Math.random()*6.0 - 3.0;
  float radius = 20.0;
  float xSpeed = 5.0;
  float ySpeed = 0.0;
  Orb phys = new Orb(mouseX, mouseY, xSpeed, ySpeed, radius);
  orbList.add(phys);
}

void draw() {
  background(255);
  bruh.display();
  if (mode == 2){
  for (Orb o : orbList) {
    bruh.attract(o);
    o.move(mode);
    o.display();
  }
  } else {
    for (Orb o : orbList) {
    o.ySpeed += .15;
    o.move(mode);
    o.display();
  }
  }
  fill(0);
  text(frameRate, 20, 20);
  text(orbList.size(), 20, 40);
  text("MODE: " + mode, 20, 60);
}

void keyPressed(){
  if (keyCode == BACKSPACE) orbList = new ArrayList<Orb>();
  if (keyCode == 32){
    if (mode == 1){
      mode = 2;
    } else {
      mode = 1;
    }
  }
}

 
