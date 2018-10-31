package main.GUI;

import main.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorConvertOp;
import java.awt.image.ColorModel;
import java.util.ArrayList;
import java.util.Arrays;

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
    protected ArrayList<ImageIcon> imageList = new ArrayList<>();
    private Play play;

    public GameView(int rows, int cols) {
        gridBuilder = new GridBuilder(rows, cols);
        cardsBuilder = gridBuilder.getCardsBuilder();
        icons = new CardIcons(cardsBuilder);
        play = new Play(icons.getCardSet());
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.addMouseListener(this);
        Graphics2D g = (Graphics2D) graphics;
       // paintGrid(g);
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
       // g.fillRect(0, 0, (rows * cardWidth), (cols * cardHeight));

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
                imageIcon = new ImageIcon(bufferedImage);
                imageList.add(imageIcon);
                // g.drawImage(bufferedImage, point.x, point.y, null);

                counter++;
            }

        }
    }
    public ArrayList<ImageIcon> getImageIconList(){
        for(int i = 0 ; i < cardsBuilder.getCards().getCards().size(); i++){
            bufferedImage = icons.getCardIcon(i);
            imageIcon = new ImageIcon(bufferedImage);

            imageList.add(imageIcon);
        }
        return imageList;
    }

    protected ImageIcon getImageIcon(int index){
        imageIcon = imageList.get(index);
        return imageIcon;
    }



    public Play startGame() {
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
