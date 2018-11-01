package test;

import main.Card;
import main.Cards;
import main.CardsBuilder;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;


public class CardsBuilderTest {

    @Test
    public void testSetNamesFromEnum() {
        //given
        CardsBuilder cardsBuilder = new CardsBuilder(5);
        String[] names;

        //when
        names = cardsBuilder.setNamesFromEnum();

        //then
        assertEquals("glasses",names[0]);
        assertTrue(names.length == 18);
    }

    @Test
    public void testBuildCards() {
        //given
        CardsBuilder cardsBuilder = new CardsBuilder(5);
        Cards cards = new Cards();

        //when
        cardsBuilder.buildCards(cards, 5);

        //then
        assertNotNull(cards.getCards());
        assertTrue(cards.getCards().size() == 10);
        assertEquals("glasses", cards.getCards().get(0).getName());
        assertEquals("bicycle", cards.getCards().get(4).getName());
        assertEquals("bicycle", cards.getCards().get(9).getName());

    }

    @Test
    public void testShuffleCards() {
        //given
        CardsBuilder cardsBuilder = new CardsBuilder(5);
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card();
        card1.setId(1);
        Card card2 = new Card();
        card2.setId(2);
        Card card3 = new Card();
        card3.setId(3);
        Card card4 = new Card();
        card4.setId(4);
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);

        //when
        cardsBuilder.shuffleCards(cards);

        //then
        assertFalse((cards.get(0).getId() == 1)
                && (cards.get(1).getId() == 2)
                && (cards.get(2).getId() == 3)
                && (cards.get(3).getId() == 4));

    }


}
