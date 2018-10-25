package main.java;

import java.util.Arrays;

public class GridBuilder {
    private Grid grid;
    int width;
    int height;
    private String[] names;

    public GridBuilder(int width, int height, Name name) {
        this.width = width;
        this.height = height;

        grid = new Grid(width, height);

        //put all the enum names into the names array
        names = setNamesWithEnum(name);

        fillGrid();
    }

    /**
     * The fillGrid() method populates the cards in the grid with names from the Name enum. It fills half of it up
     * with as many names as allowed and then fills the second half with a copy of the first half, to have doubles of
     * every name.
     * Then it shuffles all the names to have a random ordered grid.
     */
    public void fillGrid() {
        int counter = 0;
        //fill first half of grid
        for(int row = 0; row < height/2; row++) {
            for(int col = 0; col < width; col++) {
                grid.getGrid()[row][col].setName(names[counter]);
                counter++;
            }
        }
        counter = 0;
        //fil second half of grid
        for(int row = height/2; row < height; row++) {
            for(int col = 0; col < width; col++) {
                grid.getGrid()[row][col].setName(names[counter]);
                counter++;
            }
        }
        //shuffle the whole grid
        for(int row = 0, row < grid.getGrid().length; row++) {

        }
    }

    public String[] setNamesWithEnum(Name name) {
        return Arrays.toString(name.values()).replaceAll("^.|.$", "").split(", ");
    }


}
