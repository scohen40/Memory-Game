package board;

public class Game {

    public static void main (String[]args){
        int rows = 4;
        int cols = 4;
        Board board = new Board(rows, cols);
        board.createBoard();
        for(int x = 0; x < rows; x++){
            for(int y = 0; y < cols; y++){
                System.out.print(board.cardLocator(x, y).getName()+ ", ");
            }
        }
    }
}
