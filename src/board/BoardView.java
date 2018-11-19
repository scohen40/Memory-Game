package board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class BoardView extends JComponent implements ActionListener {

    private int rows;
    private int cols;
    private static final Color backgroundColor = new Color(205, 212, 205);

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
        setBackground(backgroundColor);
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
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Point location = getCardLocation((Card) e.getSource());
        assert location != null;

        flipCard(location.x, location.y);
        cardView.assignCards(location.x, location.y);

    }


}

