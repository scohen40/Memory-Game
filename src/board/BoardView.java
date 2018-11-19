package board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class BoardView extends JComponent implements ActionListener {

    private int rows;
    private int cols;
    private static final Color backgroundColor = new Color(200, 226, 206);
    private ArrayList<Card> CardsSelected = new ArrayList();
    private static int selectedCards = 0;
    private Card cardA;
    private Card cardB;



    private Board board;
    private CardView cardView;

    public BoardView(int rows, int cols) {
        super();
        this.rows = rows;
        this.cols = cols;
        board = new Board(rows, cols);
        board.createBoard();

        cardView = new CardView(board);

        setLayout(new GridLayout(rows, cols, 10, 10));
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                add(board.getBoard()[x][y]);
                board.getBoard()[x][y].addActionListener(this);
            }
        }
        displayBoard();

    }

        public void paintComponent(Graphics graphics) {

        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(backgroundColor);
        g.fillRect(0, 0, getWidth(), getHeight());

        }


    public void displayBoard() {

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                cardView.assignCards(x, y);
            }
        }
    }



    private Card getClickedCard(Point point) {

        return board.getBoard()[point.x][point.y];
    }

    private Point getCardLocation(Card card) {
        Point p = new Point();

        for (int column = 0; column < rows; column++) {
            for (int row = 0; row < cols; row++) {
                if (board.getBoard()[column][row] == card) {
                    p.setLocation(column, row);
                    return p;
                }
            }
        }
        return null;
    }

    private void flipCard(int x, int y) {
        board.getBoard()[x][y].setViewing(true);
        displayBoard();
    }

    private void hideCard(int x, int y) {
        board.getBoard()[x][y].setHidden(true);
        board.getBoard()[x][y].setViewing(false);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Point pointA = getCardLocation((Card)e.getSource());
        Point pointB;
       if(cardA == null){
           cardA = getClickedCard(pointA);
           pointA = getCardLocation(cardA);
           flipCard(pointA.x, pointA.y );

       }
       if(cardA != null){
           pointB = getCardLocation((Card)e.getSource());
           cardB = getClickedCard(pointB);

           pointB = getCardLocation(cardB);
            if(!cardA.equals(cardB)){
                flipCard(pointB.x, pointB.y );
                System.out.println(cardA.getName());
                System.out.println(cardB.getName());
                delay();
                pointA = getCardLocation(cardA);
                hideCard(pointA.x, pointA.y);
                hideCard(pointB.x, pointB.y );
                cardA = null;
                cardB = null;
            }


       }





    }


    private void delay() {

        Action displayBoardAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                displayBoard();
            }
        };

        Timer timer = new Timer(2500, displayBoardAction);
        timer.setRepeats(false);
        timer.start();
    }
}




