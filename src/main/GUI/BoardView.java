package main.GUI;

import main.Card;
import main.GridBuilder;

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BoardView extends JPanel implements  ActionListener, MouseListener {

    private final int PEEK =  2 * 1000;
    private int rows;
    private int columns;
    private int cardsDisplayed = 0;
    private ArrayList<Card> guesses = new ArrayList<>();
    private Card[] cardChecker = new Card[2];
    private CardIcon[][] board;
    private CardIcon cardIcon;
    private Point point;
    private int size;

    public BoardView(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        cardIcon = new CardIcon(rows, columns);
        setBackground(Color.lightGray);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setLayout(new GridLayout(rows, columns));
        size = cardIcon.getBoard().getCardsBuilder().getCards().getCards().size();
        displayBoard();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        point = e.getPoint();
        System.out.println(point);
        if(cardIcon.getBoardDisplayed().containsKey(point)){
            System.out.println(point);
        }
        else {
            System.out.println("no");
        }
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
    public void actionPerformed(ActionEvent e) {
    showCardImages();

        if(e.getSource() instanceof JButton){
          if(getBoard().containsValue(point)){
            //  System.out.println(((JButton) e.getSource()).getBounds());

          }
        }
        else{
            return;
        }

    }

    public Card getCardAtLoc(Point point){
        return cardIcon.getBoard().cardLocator(point.x, point.y);
    }

    private void setSelectedCards(Card firstGuess, Card secondGuess) {

        if (firstGuess.equals(secondGuess)) {

            firstGuess.setMatched(true);
            secondGuess.setMatched(true);
            firstGuess.setViewing(false);
            secondGuess.setViewing(false);
            cardIcon.displayIcons(0);
            displayCard();

        } else {

            firstGuess.setMatched(false);
            secondGuess.setMatched(false);
            firstGuess.setViewing(false);
            secondGuess.setViewing(false);
            cardIcon.displayIcons(0);
            displayCard();
        }
        cardsDisplayed = 0;
    }

    public void displayBoard(){
        for(int i = 0; i < size; i++){
            JButton button = new JButton(new ImageIcon());
            cardIcon.displayIcons(i);
            button.setSize(20, 30);
            button.addActionListener(this);
            add(button);

        }
    }

    public void displayCard() {

        Action showImagesAction = new AbstractAction() {

            private static final long serialVersionUID = 1L;

            public void actionPerformed(ActionEvent e) {
                showCardImages();
            }
        };

        Timer timer = new Timer(PEEK, showImagesAction);
        timer.setRepeats(false);
        timer.start();
    }


    public void showCardImages() {
        System.out.println(getLocation());

    }
    private void Guess(Card card) {

        if (card != null) {
            if (!guesses.contains(card)) {
                guesses.add(card);
            }
        }

    }

    public Map<Point, ImageIcon> getBoard(){
       return cardIcon.getBoardDisplayed();
    }


    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setCols(int cols) {
        this.columns = cols;
    }

}
