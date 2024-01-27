package dev.lpa.collectionMethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionMinMaxFreq {
    public static void main(String[] args) {
        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        var sortingLogic = Comparator.comparing(Card::rank).thenComparing(Card::suit);
        Card tenOfHearts = Card.getNumericCard(Card.Suit.HEART,10);
        Collections.sort(deck,sortingLogic);
        int tenIndex = Collections.binarySearch(deck,tenOfHearts,sortingLogic);
        System.out.println("Using binary search-tenIndex: "+tenIndex);
        System.out.println(deck.get(tenIndex));

        System.out.println("Using index of: "+ deck.indexOf(tenOfHearts));

        Card tenOfClubs = Card.getNumericCard(Card.Suit.CLUB,10);
        Collections.replaceAll(deck,tenOfClubs,tenOfHearts);
        Card.printDeck(deck.subList(32,36),"Replaced rows",1);

        Collections.replaceAll(deck,tenOfHearts,tenOfClubs);
        Card.printDeck(deck.subList(32,36),"replaced hearts",1);

        System.out.println("Freq of 10Clubs: "+ Collections.frequency(deck,tenOfClubs));

        System.out.println("Best Card: "+Collections.max(deck,sortingLogic));
        System.out.println("Worst Card: "+Collections.min(deck,sortingLogic));

        var sortBySuitRank = Comparator.comparing(Card::suit).thenComparing(Card::rank);
        deck.sort(sortBySuitRank);
        Card.printDeck(deck,"Sorted by suit & rank",4);

        List<Card> copied = new ArrayList<>(deck.subList(0,13));
        Collections.rotate(copied,2);
        System.out.println("Unrotated list: "+ deck.subList(0,13));
        System.out.println("rotated list: "+ copied);

        copied = new ArrayList<>(deck.subList(0,13));
        Collections.rotate(copied,-3);
        System.out.println("Unrotated list: "+ deck.subList(0,13));
        System.out.println("rotated list: "+ copied);

        Collections.swap(copied,0,6);
        Card.printDeck(copied,"after swap",1);
    }
}
