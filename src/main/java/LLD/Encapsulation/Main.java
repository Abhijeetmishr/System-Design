package LLD.Encapsulation;
class Main {
  public static void main(String[] args) {
        // Create a new Snake object
        Snake snake = new Snake(3, 5, 5, "RIGHT");
        // Test the accessor methods
        // Intialize the body and direction variables here
        // Invoke the methods of snake object here
        System.out.println("Initial Body: " + snake.getSnakeBody());
        System.out.println("Initial Direction: " + snake.getDirection());

        // Test modifying the direction
        // Invoke the methods of snake object here
        snake.setDirection("DOWN");
        System.out.println("New Direction: " + snake.getDirection());

        // Test moving the snake
        // Invoke the methods of snake object here
        snake.move();
        System.out.println("Body after moving: " + snake.getSnakeBody());

        // Test growing the snake
        // Invoke the methods of snake object here
        snake.grow();
        snake.move();
        System.out.println("Body after growing: " + snake.getSnakeBody());


        // Try accessing and modifying the body directly (should not be allowed)        

        // Try modifying the direction directly (should not be allowed)

  }
}
