package test;

import main.Card;
import main.Cards;
import main.GridBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class GridBuilderTest {
    @Test
    public void testFillGrid() {
        //given
        GridBuilder gridBuilder = new GridBuilder(2, 2);
        Cards cards = new Cards();
        List list = cards.getCards();
        Card card1 = new Card();
        card1.setId(1);
        Card card2 = new Card();
        card2.setId(2);
        Card card3 = new Card();
        card3.setId(3);
        Card card4 = new Card();
        card4.setId(4);
        list.add(card1);
        list.add(card2);
        list.add(card3);
        list.add(card4);

        //when
        gridBuilder.fillGrid(cards);

        //then
        assertNotNull(gridBuilder.getGrid().getGrid());
        assertEquals(1,gridBuilder.getGrid().getGrid()[0][0].getId());
        assertEquals(2,gridBuilder.getGrid().getGrid()[0][1].getId());
        assertEquals(3,gridBuilder.getGrid().getGrid()[1][0].getId());
        assertEquals(4,gridBuilder.getGrid().getGrid()[1][1].getId());

    }

}
