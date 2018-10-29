package main;

public class Grid {
    private int rows;
    private int columns;

    private final Card grid[][];

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        grid = new Card[rows][columns];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                grid[i][j] = new Card();
            }
        }

    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public Card[][] getGrid() {
        return grid;
    }

}
