package board;

import java.util.*;

public class Board {

    private int rows;
    private int cols;
    private board.Card board[][];
    private int matches;
    private Random RANDOM = new Random();
    private List<String> names;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        board = new board.Card[rows][cols];
        names = createRandomCards();
    }


    public void createBoard() {
        int counter = 0;
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                board[x][y] = new board.Card();
                setBoard(x, y, counter);
                counter++;
            }
        }
    }

    public void setBoard(int x, int y, int counter) {
        board[x][y].setName(names.get(counter));
    }


    public List<String> createRandomCards() {
        matches = (rows * cols) / 2;
        names = new ArrayList<>();
        for (int i = 0; i < matches; i++) {
            int index = RANDOM.nextInt(CardName.getList().size());
            if (!names.contains(CardName.getList().get(index).cardName)) {
                names.add(CardName.getList().get(index).cardName);
                names.add(CardName.getList().get(index).cardName);
            }
            else {
                i--;
            }
        }
        Collections.shuffle(names);
        return names;
    }

    public board.Card cardLocator(int x, int y) {
        return board[x][y];
    }

    public board.Card[][] getBoard() {
        return board;
    }

    public int getMatches() {
        return matches;
    }
}
