package Model;

import View.Cards.OtherCard;
import View.Cards.TurnedCard;
import View.Deck;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PC2 {

    private static final List<Integer> cards = new ArrayList<>();
    private static final Random rn = new Random();
    private static final Scanner sc = new Scanner(System.in);
    private static int visible_card;
    public static boolean player_passed = false;
    public static Deck pc2_deck;

    public static void Play() {
        try {
            int x = rn.nextInt(10)+1;
            int y = rn.nextInt(10)+1;
            int suit = rn.nextInt(3)+1;
            pc2_deck = new Deck(new TurnedCard());
            pc2_deck.cardToDeck(new OtherCard(suit, convertValue(y)));
            cards.add(x);
            cards.add(y);
            Thread.sleep(1000);
            System.out.println("Player 2 takes a hidden card.");
            visible_card = cards.get(1);
            Thread.sleep(1000);
            System.out.println("Player 2 takes " + y +"." );
            pc2_deck.ShowDeck();
            Thread.sleep(1500);

        }catch(InterruptedException e){

        }
    }

    public static void Draw(){
        try {
            int c = rn.nextInt(10) + 1;
            int suit = rn.nextInt(3) + 1;
            pc2_deck.cardToDeck(new OtherCard(suit, convertValue(c)));
            visible_card += c;
            cards.add(c);
            Thread.sleep(1000);
            System.out.println("Player 2 takes " + c);
            Thread.sleep(1000);
            pc2_deck.ShowDeck();
            Thread.sleep(1500);
        }catch (InterruptedException e){

        }
    }

    public static void VisiblePoints(){
        System.out.println("Player 2 has "+visible_card+" visible point(s).");
    }

    public static int TotalPoints(){

        int total = 0;
        for (int c : cards) {
            total += c;
        }

        return total;
    }

    public static void PlayerPass(){
        player_passed = true;
    }

    public static String convertValue(int value){

        Random rn = new Random();
        String string_value;
        int x = rn.nextInt(2)+1;

        if (value == 10){
            if (x == 1){
                string_value = "K";
            }else if(x == 2){
                string_value = "Q";
            }else {
                string_value = "J";
            }
            return string_value;
        }else{
            return String.valueOf(value);
        }
    }
}