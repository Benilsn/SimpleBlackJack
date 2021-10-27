package View;

import View.Cards.FirstCard;
import View.Cards.OtherCard;
import View.Cards.TurnedCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

    private TurnedCard turnedCard;
    private FirstCard firstCard;
    private final List<OtherCard> otherCard = new ArrayList<>();

    public Deck(FirstCard firstCard){
        this.firstCard = firstCard;
    }
    public Deck(TurnedCard turnedCard){
        this.turnedCard = turnedCard;
    }

    public void cardToDeck(OtherCard card){
        otherCard.add(card);
    }

    public FirstCard getFirst(){
        return firstCard;
    }

    public TurnedCard getFirstT(){
        return turnedCard;
    }

    public List<OtherCard> getOther(){
        return otherCard;
    }

    public void ShowDeck(){

        if (turnedCard == null) {
            System.out.print(firstCard.getTop());
            for (OtherCard c : otherCard) {
                System.out.print(c.getTop());
            }
            System.out.println();
            System.out.print(firstCard.getValue());
            for (OtherCard c : otherCard) {
                System.out.print(c.getValue());
            }

            System.out.println();
            System.out.print(firstCard.getBot());
            for (OtherCard c : otherCard) {
                System.out.print(c.getBot());
            }
            System.out.println();
        }else{
            System.out.print(turnedCard.getTop());
            for (OtherCard c : otherCard) {
                System.out.print(c.getTop());
            }
            System.out.println();
            System.out.print(turnedCard.getMid());
            for (OtherCard c : otherCard) {
                System.out.print(c.getValue());
            }

            System.out.println();
            System.out.print(turnedCard.getBot());
            for (OtherCard c : otherCard) {
                System.out.print(c.getBot());
            }
            System.out.println();
        }
    }

}
