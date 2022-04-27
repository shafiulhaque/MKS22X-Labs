ArrayList<Orb>orbList;
Orb bruh;
String mode;
boolean backgroundMode;
boolean gravityMode;
final float SPRING_LENGTH = 50;
final float SPRING_DAMPEN = 0.995;
final float SPRING_CONSTANT = 0.015;

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
  if (backgroundMode){
    background(255);
  }
  bruh.display();
  if (mode.equals("ORBIT")){
  for (Orb o : orbList) {
    bruh.attract(o);
    o.move(mode);
    o.display();
    if (gravityMode) o.ySpeed += .15;
  }
  } 
  if (mode.equals("SPRING")){
  for (Orb o : orbList) {
    bruh.attractSpring(o);
    o.move(mode);
    o.display();
    if (gravityMode) o.ySpeed += .15;
  }
  }
  if (mode.equals("GRAVITY")){
    for (Orb o : orbList) {
    o.move(mode);
    o.display();
    if (gravityMode) o.ySpeed += .15;
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
