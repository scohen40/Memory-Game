package main;


import java.util.ArrayList;
import java.util.List;

public class Game {

    private GridBuilder gridBuilder;
    private CardsBuilder cardsBuilder;
    private List<Card> cardSet;

    public Game(int rows, int cols){

        gridBuilder = new GridBuilder(rows, cols);
        cardsBuilder = gridBuilder.getCardsBuilder();
        cardSet = cardsBuilder.getCards().getCards();
    }




    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< cardSet.size(); i++){
            sb.append("- ");
            sb.append(cardSet.get(i).getName());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void printGridSize(){
        System.out.println(cardSet.size());
    }

    public static void main(String args[]) {

    Game game = new Game(4,4);
    game.printGridSize();
    System.out.println(game.toString());
    }
}
