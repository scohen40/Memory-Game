package main.GUI;

import main.Card;
import main.CardsBuilder;
import main.State;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static javax.imageio.ImageIO.read;

public class CardIcons {

    protected HashMap<String, BufferedImage> cardIconsMap;

    private CardsBuilder cardsBuilder;
    private BufferedImage cardHiddenIcon;
    private List<Card> cardSet;
    private BufferedImage cardIcon;

    public CardIcons(CardsBuilder cardsBuilder) {
        cardIconsMap = new HashMap<>();

        this.cardsBuilder = cardsBuilder;
        cardSet = cardsBuilder.getCards().getCards();
        assignCardIcons();
        assignHiddenCardIcon();
    }

    public List<Card> getCardSet() {
        return cardSet;
    }

    private void lookupCardIcon(int index){
         String name = cardSet.get(index).getName();
         assignCardIcon(name);

    }

    public BufferedImage getCardIcon(int index){
        lookupCardIcon(index);
        return cardIcon;
    }

    protected void assignCardIcons() {

        for (int i = 0; i < cardSet.size(); i++) {
            String name = cardsBuilder.getNames()[i];
            assignCardIcon(name);
        }

    }
    protected HashMap<String, BufferedImage> getCardIconsMap(){
        return cardIconsMap;
    }


    protected void assignHiddenCardIcon(){
        try {
            cardHiddenIcon = read(new File("src/images/hidden_image.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected BufferedImage getHiddenCardIcon(){
        return cardHiddenIcon;
    }


    protected void assignCardIcon(String name){
        StringBuilder cardName = new StringBuilder();
        cardName.append("src/images/");
        cardName.append(name);
        cardName.append(".png");
        try {
            cardIcon = read(new File(cardName.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
}
