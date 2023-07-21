package LLD.Trello;

import java.util.Scanner;
import java.util.UUID;

import LLD.Trello.entity.Board;
import LLD.Trello.entity.PrivacyType;
import LLD.Trello.service.TrelloDataService;

public class Main {
    public static void main(String args[]) {
        TrelloDataService trelloDataService = new TrelloDataService();
        String uniqueId = UUID.randomUUID().toString();
        String url = "https://localhost:8080/trello/board/" + uniqueId;
        Board board = new Board(uniqueId, "Trello", PrivacyType.PUBLIC, url);

        final String CREATE_BOARD = "create_board";
        final String EXIT = "exit";
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Enter Command: ");
            String cmd = scanner.next();
            switch(cmd){
                case CREATE_BOARD:
                    trelloDataService.createBoard(board);
                    break;
                case EXIT:
                    return;    
            }
        }
    }
}
