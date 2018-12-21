package board;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMainView extends JFrame {

    private static int rows = 4;
    private static int cols = 4;
    private static board.BoardView boardView = new board.BoardView(rows, cols);
    private final JPanel panel = new JPanel(new BorderLayout());
    public JButton choice_1player,choice_2players;
    private JPanel buttonPanel;
    private Container container;

    public ClassicGame classicGame=new ClassicGame();
    public DoubleGame doubleGame=new DoubleGame();


    public GameMainView(){
        setTitle("MEMORY GAME");
        setSize(900, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(340, 80);
        panel.setBorder(new EmptyBorder(20, 20, 20, 5));
        container =getContentPane();

        buttonPanel=new JPanel();
        buttonPanel.setBounds(200,200,300,150);
        buttonPanel.setLayout(new GridLayout(2,1));
        buttonPanel.setBackground(Color.green);

        choice_1player=new JButton("1_PLAYER");
        choice_1player.setBackground(Color.green);
        choice_1player.setForeground(Color.white);
        buttonPanel.add(choice_1player);
        choice_1player.addActionListener(classicGame);

        choice_2players=new JButton("2_PLAYERS");
        choice_2players.setBackground(Color.green);
        choice_2players.setForeground(Color.white);
        buttonPanel.add(choice_2players);
        choice_2players.addActionListener(doubleGame);


        container.add(buttonPanel);






    }

    public void one_player_Game(){
        buttonPanel.setVisible(false);
        panel.add(boardView);
        add(panel, BorderLayout.CENTER);



    }

    public void two_players_Game()
    {
        buttonPanel.setVisible(false);
        panel.add(boardView);
        add(panel, BorderLayout.CENTER);


    }

    public class ClassicGame implements ActionListener {
        public void actionPerformed(ActionEvent event){

            one_player_Game();
        }
    }

    public class DoubleGame implements ActionListener{
        public void actionPerformed(ActionEvent event){
            two_players_Game();


        }
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

