package main.GUI;

import main.Card;
import main.State;

import java.awt.*;
import java.util.List;

public class Play {
    private List<Card> cardSet;

    private State matched = State.valueOf("matched");
    private State viewing = State.valueOf("guessed");
    private State hidden = State.valueOf("hidden");

    public Play(List<Card> cardSet) {
        this.cardSet = cardSet;
    }

    public void flipCard(int position) {
        changeState(position, viewing);
    }

    public boolean guess(int guessA, int guessB) {

        String cardAName = cardSet.get(guessA).getName();
        String cardBName = cardSet.get(guessB).getName();
        System.out.println("viewing..." + cardAName + " & " + cardBName);

        // if both cards are equal show it to the user and then on next click hide both.
        if (isSet(cardAName, cardBName)) {
            changeStates(guessA, guessB, matched);
            System.out.println("ITS A MATCH!");
            return true;
            // if the cards do not match then need to hide the first card and show the second only
        } else if(!isSet(cardAName, cardBName)){
            changeState(guessA,  hidden);
            System.out.println("SORRY..");
            return false;
        }
		return false;
    }

    public boolean isSet(String cardA, String cardB) {
        return cardA.equals(cardB);
    }

    public void changeState(int guess, State state) {
        cardSet.get(guess).setState(state);

    }
    
    public void hideEverything() {
    	for(Card ca : cardSet) {
    		ca.setState(hidden);
    	}
    }

    private void changeStates(int guessA, int guessB, State state) {
        cardSet.get(guessA).setState(state);
        cardSet.get(guessB).setState(state);

    }

    public List<Card> getCardSet() {
        return cardSet;
    }



    //
//    public boolean isMatch(int guess) {
//        return cardSet.get(guess).getState().equals(matched);
//    }
}
