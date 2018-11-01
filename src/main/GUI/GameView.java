package main.GUI;

import main.*;
import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
    boolean result = false;

    private BufferedImage bufferedImage;
    private ArrayList<Integer> pointersList = new ArrayList<>();

    private ArrayList<Rectangle> rectangleArrayList;
    private Play play;

    private Rectangle rect;

    public GameView(int rows, int cols) {
        gridBuilder = new GridBuilder(rows, cols);
        cardsBuilder = gridBuilder.getCardsBuilder();
        icons = new CardIcons(cardsBuilder);
        play = new Play(icons.getCardSet());
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

                bufferedImage = icons.getCardIcon(counter);
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                rect = new Rectangle(point.x, point.y, bufferedImage.getWidth() - 10, bufferedImage.getHeight() - 10);
                rectangleArrayList.add(rect);

                g.drawImage(bufferedImage, rect.x, rect.y, null);
                counter++;
            }

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int positionA;
        int positionB;
        
        
        Point P = e.getPoint();
        
        int index = isInBounds(P);
        
        if(index == -1 || pointersList.contains(index)) {
        	return;
        }
        
        if(result) {
    		play.hideEverything();
    		System.out.println("hid everything");
    		result = false;
    	}
       
        pointersList.add(index);
        //if there's only one pointer in the list, get the location of the first card and put it in positionA
        if(pointersList.size() == 1) {
            positionA = pointersList.get(0);
            if (positionA != -1) {
                play.flipCard(positionA);
                repaint();
            }
        }
        //if there's two pointers in the list, get the location of both cards
        if (pointersList.size() == 2) {
            positionA = pointersList.get(0);
            positionB = pointersList.get(1);
            if (positionB != -1) {
                play.flipCard(positionB);
                result = play.guess(positionA, positionB);
                repaint();
                Integer integer = pointersList.get(1);
            	pointersList.clear();
            	pointersList.add(integer);
            }
        }

    }

    public int isInBounds(Point point) {
        Rectangle rectangle;
        for (int i = 0; i < rectangleArrayList.size(); i++) {
            rectangle = rectangleArrayList.get(i);
            if (rectangle.contains(point)) {
                return i;
            }

        }
        return -1;
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

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }


}
