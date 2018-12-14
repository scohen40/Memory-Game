package board;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class GameMainView extends JFrame {
    
    private int rows = 4;
    private int cols = 4;
    private board.BoardView boardView = new board.BoardView(rows, cols);
    private final JPanel panel = new JPanel(new BorderLayout());
    
    private final JMenuBar menuBarMain = new JMenuBar();
    
    private final JMenu menuDifficulty = new JMenu("Difficulty");
    private final String[] difficulty = {"Easy", "Medium", "Hard"};
    private final JMenuItem[] menuItemDifficulty = new JMenuItem[difficulty.length];
    
    private Thread difficultyThread;
    
    public GameMainView(){       
        setTitle("MEMORY GAME");
        setSize(900, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel.setBorder(new EmptyBorder(20, 20, 20, 5));
        panel.add(boardView);
        add(panel, BorderLayout.CENTER);
                
        for (int i = 0; i < menuItemDifficulty.length; i++){
            menuItemDifficulty[i] = new JMenuItem(difficulty[i]);
            menuItemDifficulty[i].addActionListener(new DifficultyAction((i*2)+2));
            menuDifficulty.add(menuItemDifficulty[i]);
        }
       
        menuBarMain.add(menuDifficulty);
        
        setJMenuBar(menuBarMain);
    
    }

    public static void main(String[] args) {      
        new GameMainView().setVisible(true);
       
    }
    
    private class DifficultyAction implements ActionListener{
        int size;
        
        public DifficultyAction(int size){
            this.size = size;
            
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            boardView.resizeBoard(size);

        }
        
    }

}