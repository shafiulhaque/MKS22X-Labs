public class OrbList {
  OrbNode first, last;

  //FIXED ORB
  OrbList() {
    first = new FixedOrbNode(0, height/5);
    last = new FixedOrbNode(width, height/5);
    first.next = last;
    last.prev = first;
  }

  void add(OrbNode orb) {
    orb.prev = last.prev;
    orb.next = last;
    orb.prev.next = orb;
    last.prev = orb;
  }
  
  void add(int xcor, OrbNode toBeAdded){
    OrbNode current = first;
    while (current.next != null && xcor > current.x){
      current = current.next;
    }
    current.prev.next = toBeAdded;
    toBeAdded.prev = current.prev;
    current.prev = toBeAdded;
    toBeAdded.next = current;
  }

  void processAll() {
    OrbNode current = first;
    while (current.next != null) {
      current.move();
      current = current.next;
    }
    current.move();
  }

  void display() {
    OrbNode current = first;
    while (current.next != null) {
      current.display();
      current = current.next;
    }
    current.display();
  }
}
