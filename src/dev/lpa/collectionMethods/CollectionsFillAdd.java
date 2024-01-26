package dev.lpa.collectionMethods;

import java.util.*;

public class CollectionsFillAdd {
    public static void main(String[] args) {
        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Card[] cardArr = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART,'A');
        Arrays.fill(cardArr,aceOfHearts);
//        System.out.println(Arrays.toString(cardArr));
//        Card.printDeck(List.of(cardArr),"Aces of Hearts",1);
        Card.printDeck(Arrays.asList(cardArr),"Aces of Hearts",1);

        List<Card> cards = new ArrayList<>(52);
        Collections.fill(cards,aceOfHearts);
        System.out.println(cards);
        System.out.println(cards.size());

        List<Card> acesOfHearts = Collections.nCopies(13,aceOfHearts);
        Card.printDeck(acesOfHearts,"Aces of Hearts",1);

        Card kingOfClub = Card.getFaceCard(Card.Suit.CLUB,'K');
        List<Card> kingsOfClubs = Collections.nCopies(13,kingOfClub);
        Card.printDeck(kingsOfClubs,"Kings of Club",1);

        Collections.addAll(cards,cardArr);
        Collections.addAll(cards,cardArr);
        Card queenOfSpade = Card.getFaceCard(Card.Suit.SPADE,'Q');
        List<Card> queensOfSpade = Collections.nCopies(20,queenOfSpade);
        Card.printDeck(queensOfSpade,"Queens of Spade",1);
        cards.addAll(queensOfSpade);
//        cards.addAll(List.of(cardArr));
//        cards.addAll(Arrays.asList(cardArr));
        Card.printDeck(cards,"Card Collection",3);

        Collections.copy(cards,queensOfSpade);
        Card.printDeck(cards,"Card Collection",3);

        List<Card> cardsCopy = List.copyOf(queensOfSpade);
        Card.printDeck(cardsCopy,"List Copy function",2);
    }
}
