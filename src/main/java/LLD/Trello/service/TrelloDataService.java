package LLD.Trello.service;

import LLD.Trello.entity.Board;
import LLD.Trello.entity.Card;
import LLD.Trello.repository.TrelloDataRepository;

public class TrelloDataService {
    
    TrelloDataRepository trelloDataRepository;
    Board board;
    Card card;

    public void createBoard(Board board){
        trelloDataRepository = new TrelloDataRepository();
        this.board = board;
        trelloDataRepository.initializeBoard(board);
        System.out.println("Created Board: " + board.getId());
    }

    public void createCard(Card card) {
        trelloDataRepository = new TrelloDataRepository();
        this.card = card;
        trelloDataRepository.initializeCard(card);
        System.out.println("Created card: " + card.getId());
    }
}
