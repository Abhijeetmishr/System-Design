package LLD.Trello.entity;

import java.util.ArrayList;
import java.util.List;

public class CardList {
    String id;
    String name;
    List<Card> cards;
    public CardList(String id, String name) {
        this.id = id;
        this.name = name;
        cards = new ArrayList<>();
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Card> getCards() {
        return cards;
    }
    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
    
}
