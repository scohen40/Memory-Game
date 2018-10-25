package main.java;

public class Grid {
    private int width;
    private int height;

    private final Card grid[][];

    public Grid(int width, int height, Enum<Name> names) {
        this.width = width;
        this.height = height;
        grid = new Card[width][height];

        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                grid[i][j] = new Card(i);
            }
        }

    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Card[][] getGrid() {
        return grid;
    }



}
