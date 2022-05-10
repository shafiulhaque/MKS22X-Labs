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
    if (first.next == last) {
      first.next = orb;
    }
  }

  /**
   *complete this method
   *process all nodes by running move.
   */
  void processAll() {
    OrbNode current = first;
    //advance current to next until it is null, move() each of the nodes
  }
  /**
   *complete this method
   *Display all nodes by running their display().
   */
  void display() {
    OrbNode current = first;
    //advance current to next until it is null, display() each of the nodes
  }
}
