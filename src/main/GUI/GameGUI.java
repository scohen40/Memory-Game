package main.GUI;

import main.CardsBuilder;
import main.Game;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GameGUI extends JFrame {
    private JPanel panel = new JPanel();

    private int rows = 4;
    private int cols = 4;
    private GameView gameView = new GameView(rows, cols);

    private int guessA, guessB;


    public GameGUI() {
        gameView.setRows(rows);
        gameView.setCols(cols);
        setTitle("MEMORY GAME");
        setSize(1000, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(340, 90);
        Border border = BorderFactory.createEmptyBorder(20, 20, 20, 20);
        panel.setBorder(border);
        panel.setLayout(new BorderLayout());


        panel.add(gameView, BorderLayout.CENTER);
        add(panel);

        /*for(int i = 0 ; i < gameView.imageList.size(); i++){

            icon = gameView.getImageIcon(i);
            button = new JButton(icon);
            panel.add(button);

        }*/



    }






    public static void main(String[] args) {
        new GameGUI().setVisible(true);
    }
}
