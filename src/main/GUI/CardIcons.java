package main.GUI;

import main.Card;
import main.CardsBuilder;

import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javax.imageio.ImageIO.read;

public class CardIcons implements MouseListener {

    private static final String FILE_PREFIX = "src/images/";
    private static final String FILE_SUFFIX = ".png";

    private BufferedImage cardHiddenIcon;
    private BufferedImage cardIcon;
    private List<Card> cardSet;
    private ArrayList<JLabel> labelsList = new ArrayList<>();


    public CardIcons(CardsBuilder cardsBuilder) {
        cardSet = cardsBuilder.getCards().getCards();

        System.out.println(toString());

    }


    private void assignCardIcon(String name) {
        StringBuilder cardName = new StringBuilder();
        cardName.append(FILE_PREFIX);
        cardName.append(name);
        cardName.append(FILE_SUFFIX);
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

        BufferedImage currentIcon = null;
        if (cardSet.get(index).isHidden()) {
            currentIcon = getHiddenCardIcon();
        }
        else if (cardSet.get(index).isViewing() || cardSet.get(index).isMatched()) {
            lookupCardIcon(index);
            currentIcon = cardIcon;

        }

        return currentIcon;
    }

    private void assignHiddenCardIcon() {
        try {
            cardHiddenIcon = read(new File("src/images/hidden_image.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BufferedImage getHiddenCardIcon() {
        assignHiddenCardIcon();
        return cardHiddenIcon;
    }



    public JLabel assignLabel(final int index){
            final JLabel cardLabel = new JLabel();
            cardIcon = getCardIcon(index);
            final String name = cardSet.get(index).getName();
            ImageIcon icon = new ImageIcon(cardIcon);
            final StringBuilder cardName = new StringBuilder();
            cardName.append("src/images/");
            cardName.append(name);
            cardName.append(".png");

            cardLabel.addMouseListener(new MouseAdapter() {

                public void mouseClicked(MouseEvent evt) {

                        cardLabel.setIcon(new ImageIcon(cardName.toString()));

                }
                public void mouseReleased(MouseEvent evt) {
                    cardLabel.setIcon(new ImageIcon(cardHiddenIcon));
                }
            });
        cardLabel.setIcon(icon);
            return cardLabel;
    }


    public ArrayList<JLabel> getCards(){
        for(int i = 0; i < cardSet.size(); i++){
            labelsList.add(assignLabel(i));
        }
        return labelsList;
    }

    public List<Card> getCardSet() {
        return cardSet;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
    }




    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

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
