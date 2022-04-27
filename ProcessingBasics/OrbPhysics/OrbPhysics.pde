ArrayList<Orb>orbList;
Orb bruh;
String mode;
boolean backgroundMode;
boolean gravityMode;
//final int GRAVITY = 0;
//final int ORBIT 1;
//final int SPRING = 2;
//final float springlength = 50;
//final float dampen = 0.995;
//final float constant = 0.015;
//int MODE;
//boolean backgroundMode;
//boolean gravityMode;

void setup() {
  size(1000, 800);
  background(255);
  orbList = new ArrayList<Orb>();
  bruh = new Orb(width/2, height/2, 0, 0, 10);
  mode = "GRAVITY";
  backgroundMode = true;
  gravityMode = true;
}

void mouseClicked() {
  float radius = 20.0;
  float xSpeed = 5.0;
  float ySpeed = 0.0;
  Orb phys = new Orb(mouseX, mouseY, xSpeed, ySpeed, radius);
  orbList.add(phys);
}

void draw() {
  if (backgroundMode) background(255);
  bruh.display();
  if (mode.equals("ORBIT")){
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
  text(mode, 20, 60);
}

void keyPressed(){
  if (keyCode == BACKSPACE){
    orbList = new ArrayList<Orb>();
  }
  if (keyCode == 32){
    if (mode.equals("ORBIT")){
      mode = "GRAVITY";
    } else if (mode.equals("GRAVITY")){
      mode = "SPRING";
    } else {
      mode = "ORBIT";
    }
  }
  if (keyCode == 66){
    if (backgroundMode){
      backgroundMode = false;
    } else {
      backgroundMode = true;
    }
  } 
  if (keyCode == 71){
    if (gravityMode){
      gravityMode = false;
    } else {
      gravityMode = true;
    }
  } 
}
