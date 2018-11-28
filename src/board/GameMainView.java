import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GameMainView extends JFrame {

    private JPanel board = new JPanel(new BorderLayout());
    private int rows = 4;
    private int cols = 4;
    private BoardView boardView = new BoardView(rows, cols);
    private final JPanel panel = new JPanel(new BorderLayout());

    public GameMainView(){
        setTitle("MEMORY GAME");
        setSize(900, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(340, 80);
       // Border border = BorderFactory.createEmptyBorder(20, 20, 20, 20);
        panel.setBorder(new EmptyBorder(20, 20, 20, 5));




        panel.add(boardView);
        add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new GameMainView().setVisible(true);
    }

}
