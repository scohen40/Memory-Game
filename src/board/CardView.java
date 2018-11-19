package board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class CardView extends JComponent implements ActionListener, MouseListener {

    private int rows;
    private int cols;
    private static final Color backgroundColor = new Color(205, 212, 205);
    private static final ImageIcon HIDDEN_ICON = createHiddenCardImage();
    private static final String FILE_PREFIX = "src/images/";
    private static final String FILE_SUFFIX = ".png";
    private ImageIcon imageIcon;

    private Board board;


    public CardView(int rows, int cols) {
        super();
        this.rows = rows;
        this.cols = cols;
        board = new Board(rows, cols);
        setLayout(new GridLayout(rows, cols, 10, 10));
        board.createBoard();
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                setBounds(x, y, 100,120 );
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
        g.fillRect(0, 0, getWidth()-20, getHeight());
    }


    public void displayBoard() {

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                assignCards(x, y);
            }
        }
    }


    public void assignCards(int x, int y) {
        String name = getCardName(x, y);
            imageIcon = createCardImage(name);
        if (board.cardLocator(x, y).isHidden()) {
            board.getBoard()[x][y].setIcon(HIDDEN_ICON);

        }
        if (board.cardLocator(x, y).isViewing()) {
            imageIcon = createCardImage(name);
            board.getBoard()[x][y].setCardIcon(imageIcon);
        }
        if (board.cardLocator(x, y).isMatched()) {
            imageIcon = createCardImage(name);
            board.getBoard()[x][y].setCardIcon(imageIcon);
        }
    }
    private void showImage(int x, int y) {
        String name = getCardName(x, y);
        imageIcon = createCardImage(name);

        board.getBoard()[x][y].setIcon(imageIcon);

    }

    private ImageIcon createCardImage(String name) {
        StringBuilder cardName = new StringBuilder();
        cardName.append(FILE_PREFIX);
        cardName.append(name);
        cardName.append(FILE_SUFFIX);
        return new ImageIcon(cardName.toString());
    }

    public String getCardName(int x, int y) {
        return board.cardLocator(x, y).getName();
    }

    public ImageIcon getCardImage(int x, int y) {
        return board.getBoard()[x][y].getCardIcon();
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
        showImage(x, y);
    }
    private static ImageIcon createHiddenCardImage() {
        return new ImageIcon("src/images/hidden_image.png");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Point location = getCardLocation((Card) e.getSource());
      //  flipCard(location.x, location.y);
        board.getBoard()[location.x][location.y].setViewing(true);
        flipCard(location.x, location.y);
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
}

