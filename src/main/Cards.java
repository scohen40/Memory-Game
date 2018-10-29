package main;

import java.util.*;

public class Cards {
    private List<Card> cards;

    public Cards() {
        cards = new ArrayList<>();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

}

//dynamically add the cards list to a rectangular(if possible) 2d array
