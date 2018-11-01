package main.GUI;

import main.Card;
import main.State;

import java.awt.*;
import java.util.List;

public class Play {

    int a;
    int b;

    private List<Card> cardSet;

    private State matched = State.valueOf("matched") ;
    private State viewing = State.valueOf("guessed") ;
    private State hidden = State.valueOf("hidden") ;

    public void setA(int a) {
        this.a = a;
        flipACard(a);
    }

    public void setB(int b) {
        this.b = b;
        flipBCard(b);
        if (a != b){
            guess(a,b);
        }


    }

    public Play(List<Card> cardSet){
        this.cardSet = cardSet;

    }

    public void flipACard(int a) {
        cardSet.get(a).setState(viewing);
    }

    public void flipBCard(int b) {
        cardSet.get(b).setState(viewing);
    }

    public void guess(int guessA, int guessB){


        String cardA = cardSet.get(guessA).getName();
        String cardB = cardSet.get(guessB).getName();
        System.out.println("viewing..." + cardA + " & " +cardB);

        while(isViewing(guessA, guessB)){

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


    private boolean isViewing(int guessA, int guessB){

        return (cardSet.get(guessA).getState().equals(viewing)
                && cardSet.get(guessB).getState().equals(viewing));
    }

    private boolean isSet(String cardA, String cardB){
        return cardA.equals(cardB);
    }


    private void changeState(int guessA, int guessB, State state){
        cardSet.get(guessA).setState(state);
        cardSet.get(guessB).setState(state);

    }



    public State checkState(int index){
        return cardSet.get(index).getState();
    }
    public List<Card> getCardSet() {
        return cardSet;
    }
}
