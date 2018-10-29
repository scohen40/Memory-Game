package main.GUI;

import main.CardsBuilder;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static javax.imageio.ImageIO.read;


public class CardIcons {

    protected List<BufferedImage> cardIconList;
    protected CardsBuilder cardsBuilder;


    public CardIcons(CardsBuilder cardsBuilder){
        cardIconList = new ArrayList<>();
        this.cardsBuilder = cardsBuilder;
    }


    public void setCardIcons() {
        BufferedImage cardIcon;
        StringBuilder cardName = new StringBuilder();
        for(int i = 0; i < cardsBuilder.getCards().getCards().size(); i++){
            cardName.append("src/images/");
            cardName.append(cardsBuilder.getCards().getCards().get(i).getName());
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
}
