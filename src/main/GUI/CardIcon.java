package main.GUI;

import main.Grid;
import main.GridBuilder;

import javax.swing.*;
import java.awt.*;

import java.util.HashMap;
import java.util.Map;


public class CardIcon extends JButton {

    private static final String FILE_PREFIX = "src/images/";
    private static final String FILE_SUFFIX = ".png";
    private final ImageIcon HIDDEN_ICON = new ImageIcon("src/images/hidden_image.png");
    private ImageIcon cardIcon;
    private GridBuilder board;
    private Map<Point, ImageIcon> boardDisplayed;

    public CardIcon(int rows, int columns){
        board = new GridBuilder(rows, columns);
        boardDisplayed = new HashMap<>();
        setBoard(rows, columns);
    }

    private void setBoard(int rows, int columns){
        for(int x = 0; x < rows; x++){

            for(int y = 0; y < columns; y++){
                String name = board.cardLocator(x, y).getName();
                if(board.cardLocator(x, y).isHidden()){
                    board.cardLocator(x, y).setCardIcon(HIDDEN_ICON);
                }
                else{
                    board.cardLocator(x, y).setCardIcon(addCardImageIcon(name));
                }

            }

        }

    }

    public void displayIcons(int index){

            String name = board.getCardsBuilder().getCards().getCards().get(index).getName();
            if(board.findCard(index).isHidden()){
                board.getCardsBuilder().getCards().getCards().get(index).setCardIcon(addCardImageIcon(name));
            }
            else{
                board.findCard(index).setCardIcon(addCardImageIcon(name));
            }

    }

    private ImageIcon addCardImageIcon(String name) {
        StringBuilder cardName = new StringBuilder();
        cardName.append(FILE_PREFIX);
        cardName.append(name);
        cardName.append(FILE_SUFFIX);
        cardIcon = new ImageIcon(String.valueOf(cardName));

        return cardIcon;
    }

    public String getCardName(int x, int y){
        Point p = new Point(x,y);
        int length = boardDisplayed.get(p).getDescription().length();
        return boardDisplayed.get(p).getDescription().substring(11, length-4);
    }

    public GridBuilder getBoard(){
        return board;
    }

    public Map<Point, ImageIcon> getBoardDisplayed(){
        return boardDisplayed;
    }

}
