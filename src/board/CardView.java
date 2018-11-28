import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CardView  {


    private static final ImageIcon HIDDEN_ICON = createHiddenCardImage();
    private static final String FILE_PREFIX = "src/images/";
    private static final String FILE_SUFFIX = ".png";
    private ImageIcon imageIcon;
    private Board board;


    public CardView(Board board) {
        this.board = board;

    }

    private void showImage(int x, int y) {
        String name = getCardName(x, y);
        imageIcon = createCardImage(name);
        board.getBoard()[x][y].setIcon(imageIcon);

    }

    private void showHiddenImage(int x, int y) {
        String name = getCardName(x, y);
        imageIcon = createCardImage(name);
        board.getBoard()[x][y].setIcon(HIDDEN_ICON);

    }

    public String getCardName(int x, int y) {
        return board.cardLocator(x, y).getName();
    }

    private ImageIcon createCardImage(String name) {
        StringBuilder cardName = new StringBuilder();
        cardName.append(FILE_PREFIX);
        cardName.append(name);
        cardName.append(FILE_SUFFIX);
        return new ImageIcon(cardName.toString());
    }


    private static ImageIcon createHiddenCardImage() {
        return new ImageIcon("src/images/hidden_image.png");
    }


    public void assignCards(int x, int y) {

        if (board.cardLocator(x, y).isHidden()) {
            showHiddenImage(x, y);
        }
        if (board.cardLocator(x, y).isViewing()) {
            showImage(x, y);
        }
        if (board.cardLocator(x, y).isMatched()) {
            showImage(x, y);
        }
    }
}