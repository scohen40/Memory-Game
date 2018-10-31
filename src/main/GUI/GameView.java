package main.GUI;

import main.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameView extends JComponent implements MouseListener {

    private int rows;
    private int cols;
    private int cardWidth;
    private int cardHeight;


    protected GridBuilder gridBuilder;
    private CardsBuilder cardsBuilder;
    private CardIcons icons;

    private BufferedImage bufferedImage;
    private ImageIcon imageIcon;

    private ArrayList<Rectangle> rectangleArrayList;
    private Play play;

    private Rectangle rect;

    public GameView(int rows, int cols) {
        gridBuilder = new GridBuilder(rows, cols);
        cardsBuilder = gridBuilder.getCardsBuilder();
        icons = new CardIcons(cardsBuilder);
        rectangleArrayList = new ArrayList<>();
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.addMouseListener(this);
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
        g.drawRect(0, 0, getWidth(), getHeight());
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
                /*;
                imageIcon = new ImageIcon(bufferedImage);
                imageList.add(imageIcon);*/
                bufferedImage = icons.getCardIcon(counter);
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                rect = new Rectangle(point.x, point.y, bufferedImage.getWidth()-10, bufferedImage.getHeight()-10);
                rectangleArrayList.add(rect);
                g.drawImage(bufferedImage, rect.x, rect.y, null);
                counter++;
            }

        }
    }



    public Play startGame() {
        play = new Play(icons.getCardSet());
        return play;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        Point point = e.getPoint();
        
        for(int i = 0; i < rectangleArrayList.size(); i++){
            Rectangle rectangle = rectangleArrayList.get(i);
            if(rectangle.contains(point)) {
                System.out.println(e.getPoint() + "clicked");

            }

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

}
