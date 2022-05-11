static int SPRING = 2;
static float SPRING_LENGTH = 50;
static float SPRING_DAMPEN = 0.990;
static float SPRING_CONSTANT = 0.015;
static float GRAVITY = 0.35;
static int MODE = SPRING;
OrbList orbs;
static int CLICK_MODE = 0;

void setup() {
  size(1000, 800);
  orbs = new OrbList();
}

void mouseClicked() {
  if (CLICK_MODE == 0) {
    orbs.add(new OrbNode(mouseX, mouseY, 0, 0, 30));
  }
  if (CLICK_MODE == 1) {
    orbs.add(mouseX, new OrbNode(mouseX, mouseY, 0, 0, 30));
  }
  if (CLICK_MODE == 2) {
  }
}

void keyPressed() {
  if (key == '1') {
    SPRING_CONSTANT += 0.005;
  }
  if (key == '2') {
    if (SPRING_CONSTANT - 0.005 >= 0) {
      SPRING_CONSTANT -= 0.005;
    }
  }
  if (key == '3') {
    if (SPRING_DAMPEN + 0.005 <= 1.0) {
      SPRING_DAMPEN += 0.005;
    }
  }
  if (key == '4') {
    if (SPRING_DAMPEN - 0.005 >= 0) {
      SPRING_DAMPEN -= 0.005;
    }
  }
  if (key == '5') {
    SPRING_LENGTH += 0.5;
  }
  if (key == '6') {
    if (SPRING_LENGTH - 0.5 >= 0) {
      SPRING_LENGTH -= 0.5;
    }
  }
  if (key == '7') {
    GRAVITY += 0.01;
  }
  if (key == '8') {
    if (GRAVITY - 0.005 >= 0) {
      GRAVITY -= 0.01;
    }
  }
  if (keyCode == 32){
    if (CLICK_MODE < 2){
      CLICK_MODE++;
    } else {
      CLICK_MODE = 0;
    }
  }
}

void draw() {
  background(255);
  orbs.processAll();
  orbs.display();
  text("Click Mode: " + CLICK_MODE, 20, 20);
  text("Spring Length: " + SPRING_LENGTH, 20, 40);
  text("Spring Dampen: " + SPRING_DAMPEN, 20, 60);
  text("Spring Constant: " + SPRING_CONSTANT, 20, 80);
  text("Gravity: " + GRAVITY, 20, 100);
}
