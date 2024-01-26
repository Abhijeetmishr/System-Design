package LLD.Encapsulation;


import java.util.LinkedList;

public class Snake{
  
  private int length = 0;
  private String direction;
  private LinkedList<int[]> positions;
  private boolean grow;

  public Snake(int newlength, int x, int y, String newdirection){
    modifyLength(newlength);
    this.positions = new LinkedList<int[]>();
    setDirection(newdirection);
    updateSnakeBody(x, y);
    this.grow = false;
  }

  private void updateSnakeBody(int x, int y){
    if (this.direction.equals("RIGHT")) {
      for (int i = 0; i < length; i++) {
          positions.add(new int[]{x-i, y});
      }
    } else if (this.direction.equals("LEFT")) {
        for (int i = 0; i < length; i++) {
             positions.add(new int[]{x+i, y});
        }
    } else if (this.direction.equals("UP")) {
        for (int i = 0; i < length; i++) {
             positions.add(new int[]{x, y+i});
        }
    } else {
        for (int i = 0; i < length; i++) {
             positions.add(new int[]{x, y-i});
        }
    }
  }

  public LinkedList<LinkedList<Integer>> getSnakeBody() {
    LinkedList<LinkedList<Integer>> ans = new LinkedList<>();
    for(int[] a: positions){
      LinkedList<Integer> list = new LinkedList<>();
      list.add(a[0]);
      list.add(a[1]);
      ans.add(list);
    }
    return ans;
  }
  
  public String getDirection(){
    return direction;
  }
  
  public void setDirection(String newdirection){
   if("UP".equals(newdirection) && "DOWN".equals(direction) 
            || "LEFT".equals(newdirection) && "RIGHT".equals(direction)
            || "DOWN".equals(newdirection) && "UP".equals(direction)
            || "RIGHT".equals(newdirection) && "LEFT".equals(direction)){

        System.out.println("Error: snake cannot turn back on itself");

    } else {
      this.direction = newdirection;
    }
  }
  
  public int getLength(){
    return length;
  }
  
  private void modifyLength(int newlength){
    if(newlength > 0){
      this.length += newlength;
    } else {
      System.out.println("Error: Length cannot be less than 0");
    }
  }

  public void grow() {
    grow = true;
  }

  public boolean move() {
    int[] head = positions.getFirst();
    int[] newHead = new int[]{head[0], head[1]};

    // Update the new head based on the current direction
    if (direction.equals("UP")) {
        newHead[1]++;
    } else if (direction.equals("DOWN")) {
        newHead[1]--;
    } else if (direction.equals("LEFT")) {
        newHead[0]--;
    } else if (direction.equals("RIGHT")) {
        newHead[0]++;
    }

    positions.addFirst(newHead);
    if (grow) {
      grow = false; 
    } else {
        positions.removeLast();
    }
    return true; 
  }

}
