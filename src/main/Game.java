package main;


import java.util.ArrayList;
import java.util.List;

public class Game {

    private GridBuilder gridBuilder;
    private CardsBuilder cardsBuilder;
    private List<Card> cardList;
    Card card;
    int rows = 6;
    int cols = 6;
    public Game(int rows, int cols){

        gridBuilder = new GridBuilder(rows, cols);
        cardList = new ArrayList<>();
        Card card = new Card();
        createCardSet();

    }

    public void createCardSet(){
        for(int i = 0; i < rows+cols; i++){
            int id = i;
            cardList.set(id, card);

        }
        System.out.println(cardList.size());

    }

    public static void main(String args[]) {

    Game game = new Game(6,6);

    }
}
