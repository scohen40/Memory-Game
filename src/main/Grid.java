package main;

public class Grid {
    private int rows;
    private int columns;

    private final Card grid[][];

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        grid = new Card[rows][columns];
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
