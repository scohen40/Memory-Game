package main.GUI;

import javafx.scene.paint.Stop;
import main.CardsBuilder;
import main.GridBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class GameView extends JComponent {



    private int rows;
    private int cols;
    private int cardWidth;
    private int cardHeight;

    private GridBuilder gridBuilder;

    private CardsBuilder cards;

    private CardIcons icons;

    public GameView() {
        gridBuilder = new GridBuilder(rows, cols);
        cards = gridBuilder.getCardsBuilder();
        icons = new CardIcons(cards);


    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        paintGrid(g);
        paintBoard(g);

    }

    public void paintGrid(Graphics graphics){
        cardWidth = getWidth() / rows;
        cardHeight = getHeight() / cols;
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.black);
        BasicStroke bs = new BasicStroke(3, 1, BasicStroke.JOIN_ROUND);
        g.setStroke(bs);
        Color lightGreen = new Color(220, 240, 190);
        g.setColor(lightGreen);
        g.fillRect(0, 0, (rows * cardWidth), (cols * cardHeight));

    }

    private void paintBoard(Graphics graphics){
        cardWidth = getWidth() / rows;
        cardHeight = getHeight() / cols;
        Point point = new Point(0,0);
        icons.setCardIcons();
        Graphics2D g = (Graphics2D) graphics;

        for(int i = 0; i < rows ; i++){
            for(int j = 0; j < cols; j++){
                icons.setCardHiddenIcon();
                point.setLocation(getX()+ (cardWidth*j), getY() + (cardHeight*i));
                g.setColor(Color.black);
                paintCard(g, point.x, point.y);
              //  g.drawOval(point.x-15, point.y-15, 140, 140);
                g.drawImage(icons.getCardHiddenIcon(), point.x, point.y, null);
                System.out.println(point.x +", "+point.y);

            }



        }

    }

    private void paintCard(Graphics graphics, int x, int y){
        cardWidth = getWidth() / rows;
        cardHeight = getHeight() / cols;
        Graphics2D g = (Graphics2D) graphics;

        g.setColor(Color.white);
        g.fillOval(x-15, y-20, cardWidth-35, cardHeight-20);
        BasicStroke bs = new BasicStroke(11, 1, BasicStroke.JOIN_ROUND);
        g.setStroke(bs);
        g.setColor(Color.lightGray);
        g.drawOval(x-11, y-16, cardWidth-45, cardHeight-30);

        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        Point center = new Point(x-15, y-20);
        float radius = cardWidth-50;
        float[] dist = {0f, 1f};
        Color[] colors = {new Color(0, 0, 0, 0), new Color(0, 0, 0, 255)};

        RadialGradientPaint rgp = new RadialGradientPaint(center, radius, dist, colors);
        g.setPaint(rgp);
        g.fill(new Ellipse2D.Double(center.x, center.y, radius , radius));
        g.fillOval(x-15, y-20, cardWidth-35, cardHeight-20);

    }
    
    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }


}
