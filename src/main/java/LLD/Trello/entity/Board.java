package LLD.Trello.entity;

import java.util.ArrayList;
import java.util.List;

public class Board {
    String id;
    String name;
    PrivacyType privacyType;
    String url;
    List<CardList> cardList;
    List<User> user;
    public Board(String id, String name, PrivacyType privacyType, String url) {
        this.id = id;
        this.name = name;
        this.privacyType = privacyType;
        this.url = url;
        this.cardList = new ArrayList<>();
        user = new ArrayList<>();
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
    public PrivacyType getPrivacyType() {
        return privacyType;
    }
    public void setPrivacyType(PrivacyType privacyType) {
        this.privacyType = privacyType;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public List<User> getUser() {
        return user;
    }
    public void setUser(List<User> user) {
        this.user = user;
    }

    public List<CardList> geCardLists() {
        return cardList;
    }

    public void setCardList(List<CardList> cardLists) {
        this.cardList = cardLists;
    }
    
}
