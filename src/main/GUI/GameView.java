package main.GUI;

import main.CardsBuilder;

public class GameView {

    protected int numberOfMatches;
    protected CardsBuilder cb;

    public GameView(int numberOfMatches) {

        this.numberOfMatches = numberOfMatches;
        cb = new CardsBuilder(numberOfMatches);

    }

    public void setCards(){

    }


}
