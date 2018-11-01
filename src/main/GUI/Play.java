package main.GUI;

import main.Card;
import main.State;

import java.awt.*;
import java.util.List;

public class Play {

    private int a;
    private int b;
    private String cardA;
    private String cardB;
    private List<Card> cardSet;

    private State matched = State.valueOf("matched") ;
    private State viewing = State.valueOf("guessed") ;
    private State hidden = State.valueOf("hidden") ;

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
        guess(a,b);

    }

    public Play(List<Card> cardSet){
        this.cardSet = cardSet;

    }

    public void flipACard(int a) {
        changeOne(a, viewing);
    }

    public void flipBCard(int b) {
        changeOne(b, viewing);

    }

    public void guess(int guessA, int guessB){

        changeOne(b, viewing);
        changeOne(a, viewing);

        cardA = cardSet.get(guessA).getName();
        cardB = cardSet.get(guessB).getName();
        System.out.println("viewing..." + cardA + " & " +cardB);

       if(isViewing(guessA) && isViewing(guessB)){
            if(isSet(cardA,cardB) && cardSet.size() > 2){
                changeState(guessA, guessB, matched);
                System.out.println("ITS A MATCH!");
            }
            else if(!isSet(cardA, cardB)){
                changeState(guessA, guessB, hidden);
                System.out.println("SORRY..");
            }
        }


    }


    private boolean isViewing(int guess){

        return (cardSet.get(guess).getState().equals(viewing));
    }

    public boolean isSet(String cardA, String cardB){

        return cardA.equals(cardB);
    }

    public boolean isMatch(int guess){
        return cardSet.get(guess).getState().equals(matched);
    }

    private void changeState(int guessA, int guessB, State state){
        cardSet.get(guessA).setState(state);
        cardSet.get(guessB).setState(state);

    }

    private void changeOne(int guess, State state){
        cardSet.get(guess).setState(state);

    }

    public State checkState(int index){
        return cardSet.get(index).getState();
    }
    public List<Card> getCardSet() {
        return cardSet;
    }
}
