package io.github.guilhermedelemos;

import io.github.guilhermedelemos.blackjack.Card;
import io.github.guilhermedelemos.blackjack.Deck;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {

    @Test void shuffleTest(){
        Deck baralho = new Deck();
        List<Card> baralhoInicial = baralho.listCards();
        String baralho1 = baralhoInicial.get(1).getRank();

        baralho.shuffle(baralhoInicial);
        List<Card> baralhoFinal = baralho.listCards();
        String baralho2 = baralhoFinal.get(1).getRank();

        assertNotEquals(baralho1, baralho2);


    }

    @Test void drawTest() {
        Deck deck = new Deck();
        Card card = deck.draw();
        assertNotNull(card);
    }

    @Test void cardsLeft() {
        Deck deck = new Deck();
        int amount = deck.cardsLeft();
        deck.draw();
        assertTrue(deck.cardsLeft() < amount);
    }

    @Test void cardsDiscarded() {
        Deck deck = new Deck();
        int amount = deck.cardsDiscarded();
        deck.draw();
        assertTrue(deck.cardsDiscarded() > amount);
    }

}
