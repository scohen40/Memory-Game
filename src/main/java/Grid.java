package main.java;

public class Grid {
    private int cardsNumber;
    private int width;
    private int height;

    private final Card grid[][];

    public Grid(int cardsTypes) {
        this.cardsNumber = cardsTypes * 2;
        this.width = width;
        this.height = height;
        grid = new Card[width][height];

        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                grid[i][j] = new Card();
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
