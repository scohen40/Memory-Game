package main.GUI;

import main.*;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

public class GameView extends JComponent {

    private int rows;
    private int cols;
    private int cardWidth;
    private int cardHeight;


    protected GridBuilder gridBuilder;

    private CardsBuilder cardsBuilder;

    private CardIcons icons;

    public GameView(int rows, int cols) {
        gridBuilder = new GridBuilder(rows, cols);
        cardsBuilder = gridBuilder.getCardsBuilder();
        icons = new CardIcons(cardsBuilder);
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        paintGrid(g);
        paintCards(g);
    }

    public void paintGrid(Graphics graphics) {
        cardWidth = getWidth() / rows;
        cardHeight = getHeight() / cols;
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.black);
        BasicStroke bs = new BasicStroke(3, 1, BasicStroke.JOIN_ROUND);
        g.setStroke(bs);
        Color backgroundColor = new Color(205, 212, 205);
        g.setColor(backgroundColor);
        g.fillRect(0, 0, (rows * cardWidth), (cols * cardHeight));

    }

    private void paintCards(Graphics graphics) {
        cardWidth = getWidth() / rows;
        cardHeight = getHeight() / cols;
        Point point = new Point(0, 0);
        Graphics2D g = (Graphics2D) graphics;
        int counter = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                point.setLocation(getX() + (cardWidth * j), getY() + (cardHeight * i));

                g.drawImage(icons.getCardIcon(counter), point.x, point.y, null);
                counter++;
                   // g.drawImage(icons.getHiddenCardIcon(), point.x, point.y, null);

            }

        }
    }

    public void drawCardIcon(int index){
        for (int i = 0; i < icons.getCardSet().size(); i++){

        }
    }




    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }


}
