package board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BoardView extends JComponent implements ActionListener {

    private int rows;
    private int cols;
    private static final Color backgroundColor = new Color(200, 226, 206);

    private board.Card cardA;
    private board.Card cardB;

    public int matches;

    private board.Board board;
    private board.CardView cardView;

    protected int scores_of_player1;
    protected int scores_of_player2;
    JLabel jLabel_of_score,jLabel_of_score2;

    private int turn;






    public BoardView(int rows, int cols) {
        super();
        this.rows = rows;
        this.cols = cols;
        init();


    }

    public void init(){

        removeAll();

        board = new board.Board(rows, cols);
        board.createBoard();

        matches = 0;

        cardView = new board.CardView(board);

        setLayout(new GridLayout(rows, cols, 10, 10));
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                add(board.getBoard()[x][y]);
                board.getBoard()[x][y].addActionListener(this);
            }
        }
        displayBoard();

    }
        public void paintComponent(Graphics graphics) {

        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(backgroundColor);
        g.fillRect(0, 0, getWidth(), getHeight());

        }


    public void displayBoard() {

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                cardView.assignCards(x, y);

            }
        }
    }



    private board.Card getClickedCard(Point point) {

        return board.getBoard()[point.x][point.y];
    }

    private Point getCardLocation(board.Card card) {
        Point p = new Point();

        for (int column = 0; column < rows; column++) {
            for (int row = 0; row < cols; row++) {
                if (board.getBoard()[column][row] == card) {
                    p.setLocation(column, row);

                    return p;
                }
            }
        }
        return null;
    }

    private void flipCard(int x, int y) {
        board.getBoard()[x][y].setViewing(true);
        displayBoard();
    }

    private void hideCard(int x, int y) {
        board.getBoard()[x][y].setHidden(true);
        board.getBoard()[x][y].setViewing(false);
    }
    private void matchCard(int x, int y) {
        board.getBoard()[x][y].setHidden(false);
        board.getBoard()[x][y].setViewing(false);
        board.getBoard()[x][y].setMatched(true);

    }





    @Override
    public void actionPerformed(ActionEvent e) {



        Point pointA = getCardLocation((board.Card)e.getSource());
        Point pointB;
       if(cardA == null){
           cardA = getClickedCard(pointA);
           pointA = getCardLocation(cardA);
           flipCard(pointA.x, pointA.y );

       }
       if(cardA != null){
           pointB = getCardLocation((board.Card)e.getSource());
           cardB = getClickedCard(pointB);
           pointB = getCardLocation(cardB);
            if(!cardA.equals(cardB)){
                flipCard(pointB.x, pointB.y );

                turn++;
                delay();
                pointA = getCardLocation(cardA);
                if(cardA.getName().equals(cardB.getName())){

                    GameMainView gameMainView=new GameMainView();
                     if (gameMainView.choice_2players.getModel().isPressed())
                    {
                        {
                            if (turn % 2 == 1) {
                                updateScore();
                            } else {
                                updateScore2();
                            }
                        }
                    }

                     else
                     {
                         updateScore();
                     }
                    matchCard(pointA.x, pointA.y);
                    matchCard(pointB.x, pointB.y);
                    matches++;



                }
                hideCard(pointA.x, pointA.y);
                hideCard(pointB.x, pointB.y);
                cardA = null;
                cardB = null;
            }


            checkTotalMatches();

       }
    }



    private void delay() {

        Action displayBoardAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                displayBoard();
            }
        };

        Timer timer = new Timer(2500, displayBoardAction);
        timer.setRepeats(false);
        timer.start();
    }




    String sco;
    {
        int2str();
        jLabel_of_score=new JLabel(sco);

    }

    public void int2str() {
        jLabel_of_score = new JLabel(sco);
        add(jLabel_of_score);
        sco= String.valueOf("PLAYER1 : " + scores_of_player1);
    }




    public void updateScore() {
        scores_of_player1++;
        int2str();
        jLabel_of_score.setSize(50,50);
        add(jLabel_of_score);
        jLabel_of_score.setText(sco);
    }



    String sco2;
    {
        int2str2();
        jLabel_of_score2=new JLabel(sco2);

    }

    public void int2str2() {
        jLabel_of_score2= new JLabel(sco2);
        add(jLabel_of_score2,BorderLayout.CENTER);
        sco2 = String.valueOf("PLAYER2 : " + scores_of_player2);
    }




    public void updateScore2() {
        scores_of_player2++;
        int2str2();
        jLabel_of_score2.setSize(50,50);
        add(jLabel_of_score2,BorderLayout.NORTH);
        jLabel_of_score2.setText(sco2);
    }


    public void checkTotalMatches() {
        if (isWon()) {
            if (scores_of_player1>scores_of_player2)
            {

                JOptionPane.showMessageDialog(null,"WINNER IS PLAYER1");
            }
            else if (scores_of_player2>scores_of_player1)
            {
                JOptionPane.showMessageDialog(null,"WINNER IS PLAYER2");

            }
            else {
                JOptionPane.showMessageDialog(null,"DRAW");
            }
            scores_of_player1=0;
            scores_of_player2=0;
            delay();

            endGameQuery();
        }
    }

    public void endGameQuery() {

        int userAnswer;

        userAnswer = JOptionPane.showConfirmDialog(null,
                "Would you like to play again?",
                "You have a great memory.",
                JOptionPane.YES_NO_OPTION);

        if(userAnswer == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Thank you for gameViewing!");
            System.exit(0);
        } else if(userAnswer == JOptionPane.YES_OPTION) {
            resetBoard();

        }

    }


    private void resetBoard() {
        init();
    }

    public boolean isWon(){

        return matches == board.getMatches();
    }

    public void resizeBoard(int size) {
        rows = size;
        cols = size;

        resetBoard();

    }

}







