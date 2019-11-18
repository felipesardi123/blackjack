package io.github.guilhermedelemos.blackjack;

public class Card {

    public static final String ACE = "A";
    public static final String JACK = "J";
    public static final String QUEEN = "Q";
    public static final String KING = "K";

    private String rank;
    private Suit suit;
    private int value;

    public Card() {
        super();
    }

    public Card(String rank, Suit suit, int value) {
        this.rank = rank;
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
