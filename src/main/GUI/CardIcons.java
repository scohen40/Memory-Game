package main.GUI;

import main.CardsBuilder;
import main.State;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javax.imageio.ImageIO.read;

public class CardIcons {

    private List<BufferedImage> cardIconList;
    private CardsBuilder cardsBuilder;
    private BufferedImage cardHiddenIcon;

    public CardIcons(CardsBuilder cardsBuilder) {
        cardIconList = new ArrayList<>();
        this.cardsBuilder = cardsBuilder;
    }


    protected void setCardIcons() {
        BufferedImage cardIcon;
        StringBuilder cardName = new StringBuilder();
        for (int i = 0; i < cardsBuilder.getNames().length; i++) {
            cardName.append("src/images/");
            cardName.append(cardsBuilder.getNames()[i]);
            cardName.append(".png");
            try {
                cardIcon = read(new File(cardName.toString()));
                cardIconList.add(cardIcon);
            } catch (IOException e) {
                e.printStackTrace();
            }
            cardName.setLength(0);
        }
    }
    protected List<BufferedImage> getCardIconList(){
        return getCardIconList();
    }

    protected void setCardHiddenIcon(){
        try {
            cardHiddenIcon = read(new File("src/images/hidden_image.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected BufferedImage getCardHiddenIcon(){
        return cardHiddenIcon;
    }


}
