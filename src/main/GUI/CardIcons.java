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


    private CardsBuilder cardsBuilder;
    private BufferedImage cardHiddenIcon;
    private BufferedImage cardIcon;

    private List<Card> cardSet;

    public CardIcons(CardsBuilder cardsBuilder) {
        cardsBuilder = cardsBuilder;
        cardSet = cardsBuilder.getCards().getCards();
    }


    protected void assignCardIcon(String name) {
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

    private void lookupCardIcon(int index) {
        String name = cardSet.get(index).getName();
        assignCardIcon(name);

    }

    protected BufferedImage getCardIcon(int index) {
        State hidden = State.valueOf("hidden");
        State guess = State.valueOf("guessed");
        BufferedImage currentIcon = null;
        if (getCardState(index).equals(hidden)) {
            currentIcon = getHiddenCardIcon();
        }
        else if (getCardState(index).equals(guess)) {
            lookupCardIcon(index);
            currentIcon = cardIcon;
        }
        return currentIcon;
    }

    protected void assignHiddenCardIcon() {
        try {
            cardHiddenIcon = read(new File("src/images/hidden_image.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected BufferedImage getHiddenCardIcon() {
        assignHiddenCardIcon();
        return cardHiddenIcon;
    }


    private State getCardState(int index) {
        return cardSet.get(index).getState();

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cardSet.size(); i++) {
            sb.append("- ");
            sb.append(cardSet.get(i).getName());
            sb.append("\n");
        }
        return sb.toString();
    }
}
