package LLD.SnakeAndLadder;

import java.util.Deque;
import java.util.LinkedList;

import LLD.SnakeAndLadder.Models.Board;
import LLD.SnakeAndLadder.Models.Cell;
import LLD.SnakeAndLadder.Models.Dice;
import LLD.SnakeAndLadder.Models.Player;

public class Game {
    Board board;
    Dice dice;
    Player winner;
    Deque<Player> playerList = new LinkedList<>();

    public Game() {
        initializeGame();
    }

    private void initializeGame() {
        board = new Board(10, 5, 4);
        dice = new Dice(1);
        winner = null;
        addPlayers();
    }

    private void addPlayers() {
        Player player1 = new Player("p1", 0);
        Player player2 = new Player("p2", 0);

        playerList.add(player1);
        playerList.add(player2);
    }

    public void startGame(){
        while(winner == null){
            //check whose turn now
            Player playerTurn = findPlayerTurn();
            System.out.println("player turn is:" + playerTurn.getId() + " current position is: " + playerTurn.getCurrentPosition());

            //roll the dice
            int diceNumbers = dice.rollDice();

            //get the new position
            int playerNewPosition = playerTurn.getCurrentPosition() + diceNumbers;
            playerNewPosition = jumpCheck(playerNewPosition);
            playerTurn.setCurrentPosition(playerNewPosition);
            System.out.println("player turn is:" + playerTurn.getId() + " new position is: " + playerNewPosition);

            //check for winning condition
            if(playerNewPosition > board.cells.length * board.cells.length - 1) {
                winner = playerTurn;
            }
        }
        System.out.println("WINNER IS: " + winner.getId());
    }

    private Player findPlayerTurn(){
        Player playerTurns = playerList.removeFirst();
        playerList.addLast(playerTurns);
        return playerTurns;
    }

    private int jumpCheck(int playerNewPosition) {
        if(playerNewPosition > board.cells.length * board.cells.length - 1) {
            return playerNewPosition;
        }
        
        Cell cell = board.getCell(playerNewPosition);
        if(cell.jump != null && cell.jump.start == playerNewPosition) {
            String jumpBy = (cell.jump.start < cell.jump.end) ? "ladder" : "snake";
            System.out.println("jump done by: " + jumpBy);
            return cell.jump.end;
        }
        return playerNewPosition;
    }
}
