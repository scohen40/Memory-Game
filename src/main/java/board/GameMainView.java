package board;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GameMainView extends JFrame {

    private static int rows = 2;
    private static int cols = 2;
    private static board.BoardView boardView = new board.BoardView(rows, cols);
    private final JPanel panel = new JPanel(new BorderLayout());

    public GameMainView(){
        setTitle("MEMORY GAME");
        setSize(900, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(340, 80);
        panel.setBorder(new EmptyBorder(20, 20, 20, 5));

        panel.add(boardView);
        add(panel, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        new GameMainView().setVisible(true);
    }

}


