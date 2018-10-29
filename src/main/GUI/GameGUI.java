package main.GUI;

import main.CardsBuilder;

public class GameGUI {


    public static void main(String[]args){
        CardsBuilder cb = new CardsBuilder(10);
        CardIcons ci = new CardIcons(cb );
        ci.setCardIcons();
    }
}
