package io.github.guilhermedelemos.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private boolean typeComputer;
    private int points;
    private List<Card> cards;

    public Player() {
        super();
        this.initialize();
    }

    public Player(String name, boolean typeComputer) {
        this.initialize();
        this.name = name;
        this.typeComputer = typeComputer;
    }

    private void initialize() {
        this.name = "PLAYER";
        this.typeComputer = false;
        this.points = 0;
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        this.cards.add(card);
        this.calculatePoints();
    }

    private void calculatePoints() {
        this.points = this.cards.stream().mapToInt(cards -> cards.getValue()).sum();
        /*
        int soma = 0;
        for(int i = 0; i< this.cards.size(); i++) {
            soma += this.cards.get(i).getValue();
        }
        */
    }

    public List<Card> getAllCards() {
        List<Card> cards = this.cards;
        this.cards = new ArrayList<>();
        return cards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTypeComputer() {
        return typeComputer;
    }

    public void setTypeComputer(boolean typeComputer) {
        this.typeComputer = typeComputer;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
