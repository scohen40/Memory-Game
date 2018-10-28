package main.java;

import java.util.*;

public class Cards {
    private List<Card> cards;
    private int numOfMatches;

    public Cards(int numOfMatches) {
        this.numOfMatches = numOfMatches;
        cards = new ArrayList<Card>();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public int getNumOfMatches() {
        return numOfMatches;
    }

    public void setNumOfMatches(int numOfMatches) {
        this.numOfMatches = numOfMatches;
    }

}

//dynamically add the cards list to a rectangular(if possible) 2d array
