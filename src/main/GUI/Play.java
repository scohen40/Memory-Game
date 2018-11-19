package main.GUI;

import main.Card;

import java.util.List;

public class Play {
    private List<Card> cardSet;



    public Play(List<Card> cardSet) {
        this.cardSet = cardSet;
    }
/*

    public void flipCard(int position) {
        changeState(position, viewing);
    }

    public boolean guess(int guessA, int guessB) {

        String cardAName = cardSet.get(guessA).getName();
        String cardBName = cardSet.get(guessB).getName();
        System.out.println("viewing..." + cardAName + " & " + cardBName);

        // if both cards are equal show it to the user and then on next click hide both.
        if (isSet(cardAName, cardBName)) {
            changeState(guessA, matched);
            changeState(guessB, matched);
            System.out.println("ITS A MATCH!");
            return true;
            // if the cards do not match then need to hide the first card and show the second only
        } else if(!isSet(cardAName, cardBName)){
            changeState(guessA, hidden);
            changeState(guessB, hidden);
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

    public String getState(int index){
        State state = cardSet.get(index).getState();
        return String.valueOf(state);
    }


    public String viewCard(int guess){
        String cardName = cardSet.get(guess).getName();
        return cardName;
    }
    public List<Card> getCardSet() {
        return cardSet;
    }
*/



}
