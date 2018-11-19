package main;

public class GridBuilder {
    int rows;
    int columns;
    private int numberOfMatches;

    private Grid grid;
    private CardsBuilder cardsBuilder;



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

    public Card cardLocator(int x, int y){
        return grid.getGrid()[x][y];
    }

    public Card findCard(int index){
        return cardsBuilder.getCards().getCards().get(index);
}

    public Grid getGrid() {
        return grid;
    }

    public CardsBuilder getCardsBuilder(){
        return cardsBuilder;
    }

}
