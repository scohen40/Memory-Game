package board;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class GameMainView extends JFrame {
    
    private static int rows = 4;
    private static int cols = 4;
    private static board.BoardView boardView = new board.BoardView(rows, cols);
    private static final JPanel panel = new JPanel(new BorderLayout());
    
    private static final JMenuBar mnubarMain = new JMenuBar();
    
    private static final JMenu mnuDifficulty = new JMenu("Difficulty");
    private static final String[] difficulty = {"Easy", "Medium", "Hard"};
    private static final JMenuItem mnuitmDifficulty[] = new JMenuItem[difficulty.length];
    
    public GameMainView(){       
        setTitle("MEMORY GAME");
        setSize(900, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(340, 80);
        setLocationRelativeTo(null);

        panel.setBorder(new EmptyBorder(20, 20, 20, 5));
        panel.add(boardView);
        add(panel, BorderLayout.CENTER);
                
        for (int i = 0; i < mnuitmDifficulty.length; i++){
            mnuitmDifficulty[i] = new JMenuItem(difficulty[i]);
            mnuitmDifficulty[i].addActionListener(new DifficultyAction(i));
            mnuDifficulty.add(mnuitmDifficulty[i]);
        }
       
        mnubarMain.add(mnuDifficulty);
        
        setJMenuBar(mnubarMain);
    
    }

    public static void main(String[] args) {      
        new GameMainView().setVisible(true);
       
    }
    
    private static class DifficultyAction implements ActionListener{
        int item = 0;
        
        public DifficultyAction(int item) {
            this.item = item;
            
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (item) {
                case 0:
                    boardView.rows = 2;
                    boardView.cols = 2;
                    boardView.init();
                    break;
                case 1:
                    boardView.rows = 4;
                    boardView.cols = 4;
                    boardView.init();
                    break;
                case 2:
                    boardView.rows = 6;
                    boardView.cols = 6;
                    boardView.init();
                    break;
                default:
                    break;
            }
                
        }
        
    }

}


