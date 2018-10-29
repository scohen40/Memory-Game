package main;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Game {
    public static void main(String args[]) {

        GridBuilder gb =  new GridBuilder(6, 6);
        CardsBuilder cb = new CardsBuilder(12);


        System.out.println(cb.getCards().getCards().get(11).getName());
    }
}
