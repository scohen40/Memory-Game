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

    public CardIcons(CardsBuilder cardsBuilder) {
        cardIconsMap = new HashMap<>();

        this.cardsBuilder = cardsBuilder;
        cardSet = cardsBuilder.getCards().getCards();
        setHiddenCardIcon();
    }



    protected void assignCardIcons() {
        BufferedImage cardIcon = null;
        StringBuilder cardName = new StringBuilder();
        for (int i = 0; i < cardSet.size(); i++) {

            String name = cardsBuilder.getNames()[i];

            cardName.append("src/images/");
            cardName.append(name);
            cardName.append(".png");
            try {
                cardIcon = read(new File(cardName.toString()));
                cardIconsMap.put(name, cardIcon);

            } catch (IOException e) {
                e.printStackTrace();
            }

            cardName.setLength(0);
        }
    }
    protected HashMap<String, BufferedImage> getCardIconsMap(){
        return cardIconsMap;
    }



    protected void setHiddenCardIcon(){
        try {
            cardHiddenIcon = read(new File("src/images/hidden_image.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected BufferedImage getHiddenCardIcon(){
        return cardHiddenIcon;
    }

    protected State getCurrentCardStatus(String cardName){
        int index = getCardIndex(cardName);
        return cardsBuilder.getCards().getCards().get(index).getState();
    }

    private int getCardIndex(String cardName){
        int cardIndex = 0;
        for(int i = 0; i < cardsBuilder.getNames().length; i++){
            if(cardsBuilder.getNames()[i].equals(cardName)){
                cardIndex = i;
            }
        }
        return cardIndex;
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
