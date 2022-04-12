void setup(){
  size(600, 600);
  background(173,216,230);
  
  //hair
  fill(101, 67, 33);
  stroke(101, 67, 33);
  ellipse(300, 275, 260, 300);
  
  //head
  stroke(0, 0, 0);
  fill(240, 221, 215);
  ellipse(300, 300, 260, 300);
  
  //eyes
  fill(255, 255, 255);
  ellipse(255, 250, 45, 30);
  ellipse(345, 250, 45, 30);
  
  //pupil
  fill(0, 0, 0);
  ellipse(255, 250, 12, 10);
  ellipse(345, 250, 12, 10);
  
  //other part of hair
  fill(101, 67, 33);
  stroke(101, 67, 33);
  rect(210, 170, 180, 10);
  rect(230, 150, 140, 20);
  
  //smile
  fill(255,192,203);
  stroke(0, 0, 0);
  arc(300, 350, 100, 100, 0, PI);
}
