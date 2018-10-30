package main;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CardsBuilder {
    private Cards cards;
    private int numberOfMatches;
    private String[] names;

    public CardsBuilder(int numberOfMatches) {
        this.numberOfMatches = numberOfMatches;
        cards = new Cards();
        names = setNamesFromEnum();
        buildCards(cards, numberOfMatches);
        shuffleCards(cards.getCards());
    }

    /**
     * The method setNamesFromEnum() fills the Array names with all of the names in the enum Name.
     * @return String
     */
    public String[] setNamesFromEnum() {
        return Arrays.toString(Name.values()).replaceAll("^.|.$", "").split(", ");
    }

    /**
     * The method buildDeck() takes the number of matches and creates a deck of cards with that number of pairs of
     * names from the emum class Name, the highest amount being the number of names in that enum class.
     */
    public void buildCards(Cards deck, int numberOfMatches) {
        for(int i = 0; i < numberOfMatches; i++) {
            Card card = new Card();
            card.setName(names[i]);
            deck.getCards().add(card);
        }
        for(int i = 0; i < numberOfMatches; i++) {
            Card card = new Card();
            card.setName(names[i]);
            deck.getCards().add(card);
        }
    }

    public void shuffleCards(List cards) {
        Collections.shuffle(cards);
    }


    public Cards getCards() {
        return cards;
    }

    public String[] getNames(){
        return names;
    }

    public void setCards(Cards cards) {
        this.cards = cards;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public void setNumberOfMatches(int numberOfMatches) {
        this.numberOfMatches = numberOfMatches;
    }


}
