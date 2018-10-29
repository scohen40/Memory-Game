package main.GUI;

import main.Card;
import main.CardsBuilder;
import main.State;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static javax.imageio.ImageIO.read;

public class CardIcons {

    protected HashMap<Integer, BufferedImage> cardIconsMap;

    private CardsBuilder cardsBuilder;
    private BufferedImage cardHiddenIcon;

    public CardIcons(CardsBuilder cardsBuilder) {
        this.cardsBuilder = cardsBuilder;
        cardIconsMap = new HashMap<>();
        setHiddenCardIcon();
    }



    protected void assignCardIcons() {
        BufferedImage cardIcon = null;
        StringBuilder cardName = new StringBuilder();
        for (int i = 0; i < cardsBuilder.getNames().length; i++) {
            String name = cardsBuilder.getNames()[i];
            cardName.append("src/images/");
            cardName.append(name);
            cardName.append(".png");
            int cardId = cardsBuilder.getCards().getCards().get(i).getId();
            try {
                cardIcon = read(new File(cardName.toString()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            cardIconsMap.put(cardId, cardIcon);
            cardName.setLength(0);
        }
        System.out.println(cardsBuilder.getCards().getCards().size());
    }
    protected HashMap<Integer, BufferedImage> getCardIconsMap(){
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

    protected State getCurrentCardStatus(int id){
        return cardsBuilder.getCards().getCards().get(id).getState();

    }
}
