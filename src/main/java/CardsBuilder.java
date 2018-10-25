package main.java;

public class CardsBuilder {
    private Cards cards;
    private int numberOfMatches;

    public CardsBuilder(int numberOfMatches) {
        this.numberOfMatches = numberOfMatches;
        cards = new Cards(numberOfMatches);



    }

}
