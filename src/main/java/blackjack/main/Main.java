package blackjack.main;

import blackjack.game.Game;
import blackjack.model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        game.start();

        System.out.println("=== Player Hand ===");
        printHand(game.getPlayer());
        System.out.println("Score: " + game.getPlayer().getScore());

        // Spelarens tur
        while (true) {
            System.out.print("\nDo you want to hit or stand? (h/s): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("h")) {
                Card newCard = game.drawCardForPlayer();
                System.out.println("You drew: " + newCard.getRank() + " of " + newCard.getSuit());
                printHand(game.getPlayer());
                System.out.println("Score: " + game.getPlayer().getScore());

                if (game.getPlayer().getScore() > 21) {
                    System.out.println("You busted!");
                    break;
                }
            } else if (input.equals("s")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter 'h' or 's'.");
            }
        }

        // Dealerns tur
        System.out.println("\n=== Dealer's Turn ===");
        while (game.getDealer().wantsToHit()) {
            Card card = game.drawCardForDealer();
            System.out.println("Dealer drew: " + card.getRank() + " of " + card.getSuit());
        }

        System.out.println("\n=== Final Hands ===");
        System.out.println("Player:");
        printHand(game.getPlayer());
        System.out.println("Score: " + game.getPlayer().getScore());

        System.out.println("\nDealer:");
        printHand(game.getDealer());
        System.out.println("Score: " + game.getDealer().getScore());

        System.out.println("\n=== Result ===");
        System.out.println(game.determineWinner());
    }

    private static void printHand(Participant participant) {
        for (Card card : participant.getHand().getCards()) {
            System.out.println(card.getRank() + " of " + card.getSuit());
        }
    }
}
