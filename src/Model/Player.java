package Model;

import View.Cards.FirstCard;
import View.Cards.OtherCard;
import View.Deck;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Player {

    private final String name;
    private final List<Integer> cards = new ArrayList<>();
    private final Random rn = new Random();
    private final Scanner sc = new Scanner(System.in);
    public boolean player_passed = false;
    public Deck player_deck;

    public Player(String name){
        this.name = name;
        int x = rn.nextInt(10)+1;
        int y = rn.nextInt(10)+1;
        int suit = rn.nextInt(3)+1;
        cards.add(x);
        cards.add(y);
        Deck deck = new Deck(new FirstCard(suit, convertValue(x)));
        deck.cardToDeck(new OtherCard(suit,convertValue(y)));
        player_deck = deck;

    }

    public String playerGetName(){
        return name;
    }

    public void Play() {

        try {
            Thread.sleep(1000);
            System.out.println(name + " takes a hidden card.\n(It's a " + cards.get(0) + ")");
            System.out.println(name + " takes " + cards.get(1));
            player_deck.ShowDeck();
            Thread.sleep(1500);
        }catch (InterruptedException e){

        }
    }

    public void Draw(){

        System.out.print("Take another card?");
        String ans = sc.nextLine();

        if(ans.contains("y")||ans.contains("yes")){

            try {
                int c = rn.nextInt(10) + 1;
                int suit = rn.nextInt(3) + 1;
                Thread.sleep(1500);
                System.out.println(name + " takes " + c);
                player_deck.cardToDeck(new OtherCard(suit, convertValue(c)));
                cards.add(c);
                player_deck.ShowDeck();
                Thread.sleep(1500);
            }catch (InterruptedException e){

            }

        }else{
            player_passed = true;
            System.out.println(name+" Passes.");
        }
    }

    public void Total() {

        int total = 0;
        for (int c : cards) {
            total += c;
        }
        System.out.println(name + " has " + total + " total point(s).");
    }

    public int TotalPoints(){
        int total = 0;

        for (int c : cards) {
            total += c;
        }
        return total;
    }

    public String convertValue(int value){

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
