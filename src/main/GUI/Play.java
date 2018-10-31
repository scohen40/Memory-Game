package main.GUI;

import main.Card;
import main.State;

import java.util.List;

public class Play {


    private List<Card> cardSet;

    private State matched = State.valueOf("matched") ;
    private State viewing = State.valueOf("guessed") ;
    private State hidden = State.valueOf("hidden") ;


    public Play(List<Card> cardSet){
        this.cardSet = cardSet;
    }

    public int flipFirstCard(int a) {
        cardSet.get(a).setState(viewing);
        return a;
    }



    public void guess(int guessA, int guessB){
         int a = flipFirstCard(guessA);
         int b = guessB;

        String cardA = cardSet.get(a).getName();
        String cardB = cardSet.get(b).getName();

        if(isViewing(guessA, guessB)){

            if(isSet(cardA,cardB) && cardSet.size() > 2){
                changeState(guessA, guessB, matched);
            }
            else if(!isSet(cardA, cardB)){
                changeState(guessA, guessB, hidden);
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


    private void removeSet(int guessA, int guessB){
        cardSet.remove(guessA);
        cardSet.remove(guessB);

    }

    public State checkState(int index){
        return cardSet.get(index).getState();
    }
    public List<Card> getCardSet() {
        return cardSet;
    }
}
