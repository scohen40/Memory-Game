package main.GUI;

import main.*;
import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameView extends JComponent implements ActionListener {

    private int rows;
    private int cols;
    private int cardWidth;
    private int cardHeight;

    protected GridBuilder gridBuilder;
    private CardsBuilder cardsBuilder;
    private CardIcons icons;
    private int selectedCards;
    private Play play;


    private static final int MAX_SELECTED_CARDS = 2;
    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int VISIBLE_DELAY = (int) 2 * 1000;
    private static final int PEEK_DELAY = (int) 2 * 1000;


    public GameView(int rows, int cols) {
        gridBuilder = new GridBuilder(rows, cols);
        cardsBuilder = gridBuilder.getCardsBuilder();
        icons = new CardIcons(cardsBuilder);
        play = new Play(icons.getCardSet());
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        paintGrid(g);
       // paintCards(g);
    }

    public void paintGrid(Graphics graphics) {
        cardWidth = getWidth() / rows;
        cardHeight = getHeight() / cols;
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.black);
        BasicStroke bs = new BasicStroke(3, 1, BasicStroke.JOIN_ROUND);
        g.setStroke(bs);
        Color backgroundColor = new Color(205, 212, 205);
        g.drawRect(0, 0, getWidth(), getHeight());
        g.setColor(backgroundColor);
        g.fillRect(0, 0, (rows * cardWidth), (cols * cardHeight));
    }


    public ArrayList<JLabel> getBoard(){
      return icons.getCards();
    }



    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e == null) {
            System.out.println("actionPermormed(ActionEvent) received null");
            return;
        }

        if (!(e.getSource() instanceof Card)) {
            return;
        }




    }

    private void peek() {

        Action showImagesAction = new AbstractAction() {

            private static final long serialVersionUID = 1L;

            public void actionPerformed(ActionEvent e) {

            }
        };

        Timer timer = new Timer(PEEK_DELAY, showImagesAction);
        timer.setRepeats(false);
        timer.start();
    }
}
