# Snake Class Design - Takehome Assignment

## Goal
The goal of this take-home assignment is to assess your understanding and implementation of object-oriented programming concepts, specifically encapsulation, in designing a Snake class for a snake game.

![snake-gif](snake-gif.gif)

## Requirements
1. Design and implement a Snake class in Java.
2. The Snake class should support following behaviors:
   - Change the direction of the snake.
   - Move the snake's head based on the current direction.
   - Grow the snake's body by adding a new segment to the head.
4. The Snake class should enforce encapsulation by using appropriate access modifiers for fields and methods.

## Tasks
1. Design the Snake class with appropriate attributes and methods.
2. Implement the Snake class according to the design you came up with.
3. Write a driver program to test the functionality of the Snake class.

## Expectations
1. Your design should demonstrate a clear understanding of encapsulation.
2. The Snake class should be properly encapsulated, with private fields and public accessor and mutator methods.
3. The implemented methods should perform their intended functionality correctly.
4. The driver program should showcase the Snake class by creating an instance, modifying its attributes, and testing its behaviors.


**Note:** The focus of this assignment is on designing and implementing the Snake class using encapsulation. You do not need to create a fully functional snake game; the implementation of the Snake class itself is the main objective. The test cases provided below would help in understanding the requirements better.

## Sample Test Cases for Snake Class

**Test Case 1: Initial State**
- Input:
  - Snake size: 3
  - Starting position: (5, 5)
  - Starting direction: RIGHT
- Output:
  - Body: [(5, 5), (4, 5), (3, 5)]
  - Direction: RIGHT

**Test Case 2: Modifying Direction**
- Input:
  - New direction: DOWN
- Output:
  - Direction: DOWN

**Test Case 3: Moving Snake**
- Input: None
- Output:
  - Body after moving: [(5,4 ), (5, 5), (4, 5)]

**Test Case 4: Growing Snake**
- Input: None
- Output:
  - Body after growing: [(5,3), (5,4), (5, 5), (4, 5)]

**Test Case 5: Prevent Turning Back on Itself**
- Input:
  - Direction: UP (current direction: DOWN)
- Output:
  - Direction remains: DOWN (snake cannot turn back on itself)

**Test Case 6: Moving in Different Directions**
- Input:
  - Snake size: 4
  - Starting position: (2, 2)
  - Starting direction: UP
- Output:
  - Body: [(2, 2), (2, 1), (2, 0), (2, -1)]
  - Direction: UP

**Test Case 7: Growing and Changing Direction**
- Input:
  - Direction: LEFT
- Output:
  - Body after moving and growing: [(1, 2), (2, 2), (2, 1), (2, 0), (2, -1)]
  - Direction: LEFT

**Test Case 8: Growing Multiple Times**
- Input: None
- Output:
  - Body after growing: [(0, 2), (1, 2), (2, 2),  (2, 1), (2, 0), (2, -1)]

**Test Case 9: Moving after changing Direction**
- Input:
  - Direction: LEFT
- Output:
  - Body after moving: [(-1, 2), (0, 2), (1, 2), (2, 2),  (2, 1), (2, 0)
