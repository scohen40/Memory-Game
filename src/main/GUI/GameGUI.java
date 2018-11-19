package main.GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameGUI extends JFrame implements MouseListener  {
    private JPanel panel = new JPanel();
    private JSplitPane splitPane;

    private int rows = 4;
    private int cols = 4;
    private BoardView board;
    JLabel label;
    ImageIcon imageIcon = new ImageIcon("src/images/hidden_image.png");

    public GameGUI()  {
        board = new BoardView(rows, cols);
        board.setRows(rows);
        board.setCols(cols);
        board.displayCard();
        setTitle("MEMORY GAME");
        setSize(1000, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(340, 90);

        Border border = BorderFactory.createEmptyBorder(20, 20, 20, 20);
        panel.setBorder(border);
        panel.setLayout(new BorderLayout(2, 1));

        JPanel display = new JPanel();
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 40,15);
        display.setLayout(fl);
        display.setBorder(border);
      /*  for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                Point p = new Point(i,j);
                imageIcon = board.getBoard().get(p);
                display.add(new JLabel(imageIcon));
            }
        }*/
        /*splitPane = new JSplitPane();
        add(splitPane, BorderLayout.SOUTH);*/

        display.setBackground(Color.lightGray);

        add(board, BorderLayout.CENTER);

        //add(display);



    }




    public static void main(String[] args) {
        new GameGUI().setVisible(true);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getPoint());
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

