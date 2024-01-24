package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public record Card(Suit suit, String face, int rank) {
    public enum Suit {
        CLUB, DIAMOND, HEART, SPADE;

        public char getImage() {
            char[] imageList = {9827, 9830, 9829, 9824};
            return imageList[this.ordinal()];
        }
    }

    @Override
    public String toString() {
        int index = face.equals("10") ? 2 : 1;
        String faceString = face.substring(0, index);
        return "%s%c(%d)".formatted(faceString, suit.getImage(), rank);
    }

    public static Card getNumericCard(Suit suit, int cardNumber) {
        if (cardNumber > 1 && cardNumber < 11) {
            return new Card(suit, String.valueOf(cardNumber), cardNumber - 2);
        }
        System.out.println("Invalid Numeric Card selected");
        return null;
    }

    public static Card getFaceCard(Suit suit, char face) {
        int charIndex = "JQKA".indexOf(face);
        if (charIndex > -1) {
            return new Card(suit, "" + face, charIndex + 9);
        }
        System.out.println("Invalid Face Card selected");
        return null;
    }

    public static List<Card> getStandardDeck(){
        List<Card> deck = new ArrayList<>(52);
        for(Suit suit: Suit.values()){
            for(int i=2;i<11;i++){
                deck.add(Card.getNumericCard(suit,i));
            }

            for(char c: "JQKA".toCharArray()){
                deck.add(Card.getFaceCard(suit,c));
            }
        }
        return deck;
    }

    public static void printDeck(List<Card> deck, String description, int rows){
        System.out.println("-".repeat(30));
        if(description !=null){
            System.out.println(description);
        }
        int cardCols=deck.size()/rows;
        for(int i=0;i<rows;i++){
            int start = i*cardCols;
            int end = start+cardCols;
            deck.subList(start,end).forEach(card-> System.out.print(card+""));
            System.out.println();
        }

    }

    public static void printDeck(List<Card> deck){
        printDeck(deck,"Current deck",4);
    }
}
