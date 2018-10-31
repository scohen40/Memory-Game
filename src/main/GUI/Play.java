package main.GUI;

import main.Card;

import java.util.List;

public class Play {


    public Play(List<Card> cardSet){

    }



    public void guess(int guessA, int guessB, List<Card> cardSet){
        String cardA = cardSet.get(guessA).getName();
        String cardB = cardSet.get(guessB).getName();
        while(matched(cardA,cardB) && cardSet.size() > 2){
            removeMatch(guessA, guessB, cardSet);
        }
    }


    private boolean matched(String cardA, String cardB){
        return cardA.equals(cardB);
    }

    private void removeMatch(int guessA, int guessB, List<Card> cardSet){
        cardSet.remove(guessA);
        cardSet.remove(guessB);
    }



}
