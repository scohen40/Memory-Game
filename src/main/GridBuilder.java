package main;

/**
 * The GridBuilder class creates uses a cardBuilder object to create a mixed deck of cards and then fills a grid that
 * it creates. It takes a number of rows and columns for the grid dimensions. It uses those numbers to also figure
 * out the number of matches in the card deck and on the grid (in the game). The highest number of matches cells in the
 * grid can be 36, because the highest number of matches is 18. Therefore the highest number of rows and columns is 6x6.
 * Additionally to make sure that the number of Matches of a whole number, the number of columns or the numner of rows
 * must be even.
 * These rules would have to be stipulated from the outside.
 * */
public class GridBuilder {
    int rows;
    int columns;
    private int numberOfMatches;

    private Grid grid;
    private CardsBuilder cardsBuilder;


    private String[] names; //never used

    public GridBuilder(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        numberOfMatches = (rows * columns) / 2;

        grid = new Grid(rows, columns);

        cardsBuilder = new CardsBuilder(numberOfMatches);

        fillGrid(cardsBuilder.getCards());
    }


    public void fillGrid(Cards cards) {
        int cardsCounter = 0;
        for (int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                grid.getGrid()[i][j] = cards.getCards().get(cardsCounter);
                cardsCounter++;
            }
        }
    }



    public Grid getGrid() {
        return grid;
    }

    public CardsBuilder getCardsBuilder(){
        return cardsBuilder;
    }

}
