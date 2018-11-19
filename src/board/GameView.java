package board;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GameView extends JFrame {

    private JPanel board = new JPanel(new BorderLayout());
    private int rows = 4;
    private int cols = 4;
    private CardView cardView = new CardView(rows, cols);
    private final ImageIcon HIDDEN_ICON = new ImageIcon("src/images/hidden_image.png");
    private final JPanel panel = new JPanel(new BorderLayout());

    public GameView(){
        setTitle("MEMORY GAME");
        setSize(900, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(340, 80);
       // Border border = BorderFactory.createEmptyBorder(20, 20, 20, 20);
        panel.setBorder(new EmptyBorder(20, 20, 20, 5));




        panel.add(cardView);
        add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new GameView().setVisible(true);
    }

}
