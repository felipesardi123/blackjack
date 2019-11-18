package io.github.guilhermedelemos.blackjack;

import io.github.guilhermedelemos.blackjack.ui.TextUI;

public class Blackjack {

    private Deck deck;
    private Player player;
    private Player computer;

    private TextUI userInterface;

    public Blackjack() {
        super();
        this.deck = new Deck();
        this.player = new Player();
        this.computer = new Player();
        this.computer.setName("COMUTADOR");

        this.userInterface = new TextUI();
    }

    public void execute() {
        this.userInterface.println("Blackjack");
        this.userInterface.sleep();

        String iniciarJogo = this.userInterface.read("Deseja iniciar o jogo? (S/N)");
        if(iniciarJogo.equals("N")) {
            return;
        }

        this.player.setName(this.userInterface.read("Qual o seu nome?"));
        this.userInterface.println("Boa sorte!");
        this.userInterface.sleep();

        Card firstDraw = this.deck.draw();
        this.computer.addCard(firstDraw);

        this.userInterface.println(
            "O " + this.computer.getName() + " sacou a carta " + firstDraw
        );
        this.userInterface.sleep();

        /* JOGADOR */
        do {
            Card cardDrawn = this.deck.draw();
            this.player.addCard(cardDrawn);
            this.userInterface.println("Você sacou a carta " + cardDrawn);

            this.userInterface.println("PONTUAÇÃO");
            this.userInterface.println(this.computer.getName() + ": " + this.computer.getPoints());
            this.userInterface.println(this.player.getName() + ": " + this.player.getPoints());

            if(this.player.getPoints() == 21) {
                this.userInterface.println("Você venceu. Parabéns!");
                return;
            }

            if(this.player.getPoints() > 21) {
                this.userInterface.println("Você perdeu.");
                return;
            }

        } while(
            this.userInterface.read("Deseja sacar uma carta? (S/N)").equals("S")
        );

        /* COMPUTADOR */
        do {
            Card cardDrawn = this.deck.draw();
            this.computer.addCard(cardDrawn);
            this.userInterface.println("O " + this.computer.getName() + " sacou a carta " + cardDrawn);

            this.userInterface.println("PONTUAÇÃO");
            this.userInterface.println(this.computer.getName() + ": " + this.computer.getPoints());
            this.userInterface.println(this.player.getName() + ": " + this.player.getPoints());

            if(this.computer.getPoints() == 21) {
                this.userInterface.println("O " + this.computer.getName() + " venceu.");
                return;
            }

            if(this.computer.getPoints() > 21) {
                this.userInterface.println("Você venceu.");
                return;
            }

            if(this.computer.getPoints() >= this.player.getPoints()) {
                break;
            }
        } while(true);

        if(this.computer.getPoints() >= this.player.getPoints()) {
            this.userInterface.println("O " + this.computer.getName() + " venceu.");
        } else {
            this.userInterface.println("Você venceu");
        }

    }

}
