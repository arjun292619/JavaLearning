package dev.lpa.collectionMethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsSubListSort {
    public static void main(String[] args) {
        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Collections.shuffle(deck);
        Card.printDeck(deck, "Shuffled Deck", 4);

        Collections.reverse(deck);
        Card.printDeck(deck, "Reversed Deck", 4);

        var sortingLogic = Comparator.comparing(Card::rank).thenComparing(Card::suit);
        Collections.sort(deck, sortingLogic);
        Card.printDeck(deck, "sorted Deck", 13);

        Collections.reverse(deck);
        Card.printDeck(deck, "Reversed Deck", 13);

        List<Card> kings = new ArrayList<>(deck.subList(4, 8));
        Card.printDeck(kings, "Kings in Deck", 1);

        List<Card> jacks = new ArrayList<>(deck.subList(12, 16));
        Card.printDeck(jacks, "Jacks in Deck", 1);

        List<Card> tens = new ArrayList<>(deck.subList(16, 20));
        Card.printDeck(tens, "Tens in Deck", 1);

//        Collections.shuffle(deck);
        int subListIndex = Collections.indexOfSubList(deck, tens);
        System.out.println("sublist index for 10s: " + subListIndex);
        System.out.println("Contains 10s: " + deck.containsAll(tens));

        boolean disjoint10sDeck = Collections.disjoint(deck,tens);
        System.out.println("disjoint10sDeck: "+disjoint10sDeck);

        boolean disjoint10sKings = Collections.disjoint(tens,kings);
        System.out.println("disjoint10sKings: "+disjoint10sKings);
    }
}
