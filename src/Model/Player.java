package Model;

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

    public Player(String name){
        this.name = name;
        cards.add(rn.nextInt(10)+1);
        cards.add(rn.nextInt(10)+1);
    }

    public String playerGetName(){
        return name;
    }

    public void Play() {

        System.out.println(name + " takes a hidden card.\n(It's a " + cards.get(0) + ")");
        System.out.println(name + " takes " + cards.get(1));
    }

    public void Draw(){

        System.out.print("Take another card?");
        String ans = sc.nextLine();

        if(ans.contains("y")||ans.contains("yes")){

            int c = rn.nextInt(10)+1;
            System.out.println(name+" takes "+ c);
            cards.add(c);

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
}
