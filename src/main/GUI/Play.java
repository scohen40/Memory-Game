package main.GUI;

import main.Card;
import main.State;

import java.util.List;

public class Play {

    private List<Card> cardSet;

    public Play(List<Card> cardSet){
        this.cardSet = cardSet;
    }


    public void guess(int guessA, int guessB){
        guessA = 3;
        guessB = 7;
        String cardA = cardSet.get(guessA).getName();
        String cardB = cardSet.get(guessB).getName();

        while(isViewing(guessA, guessB)){
            if(isSet(cardA,cardB) && cardSet.size() > 2){
                removeSet(guessA, guessB);
            }
        }
        if(!isSet(cardA, cardB)){
            State hidden = State.valueOf("hidden") ;
            changeState(guessA, guessB, hidden);
        }

    }


    private boolean isViewing(int guessA, int guessB){
        State viewing = State.valueOf("guessed") ;
        return (cardSet.get(guessA).getState().equals(viewing)
                && cardSet.get(guessB).getState().equals(viewing));
    }

    private boolean isSet(String cardA, String cardB){
        return cardA.equals(cardB);
    }

    private void removeSet(int guessA, int guessB){
        State matched = State.valueOf("matched") ;
        changeState(guessA, guessB, matched);
        cardSet.remove(guessA);
        cardSet.remove(guessB);

    }

    private void changeState(int guessA, int guessB, State state){
        cardSet.get(guessA).setState(state);
        cardSet.get(guessB).setState(state);
    }

}
