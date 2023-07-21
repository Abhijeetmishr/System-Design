package LLD.Trello.repository;

import LLD.Trello.entity.Board;
import LLD.Trello.entity.Card;
import LLD.Trello.entity.User;

public class TrelloDataRepository {
    Board board;
    Card card;
    User user;
    public void initializeBoard(Board board) {
        this.board = board;
    }
    public void initializeCard(Card card) {
        this.card = card;
    }
}
