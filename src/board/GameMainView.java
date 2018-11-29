import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GameMainView extends JFrame {

    private static int rows = 4;
    private static int cols = 4;
    private static BoardView boardView = new BoardView(rows, cols);
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
        playGame();
    }

    private static void playGame() {
        GameMainView gameView = new GameMainView();
        int userAnswer;
        boolean gameViewing = true;

        while(gameViewing) {

            while(!boardView.getGameWon()) {
                gameView.setVisible(true);
            }
            gameView.dispose();

            userAnswer = JOptionPane.showConfirmDialog(null,
                    "Would you like to play again?",
                    "You have a great memory.",
                    JOptionPane.YES_NO_OPTION);
            if(userAnswer == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Thank you for gameViewing!");
                System.exit(0);
            } else if(userAnswer == JOptionPane.YES_OPTION) {
                reloadGame();
            }
            gameViewing = false;

        }

        reloadGame();

    }

    private static void reloadGame() {
        boardView = new BoardView(rows, cols);
        playGame();
    }
}


