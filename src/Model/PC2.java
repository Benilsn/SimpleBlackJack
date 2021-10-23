package Model;

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

    public static void Play() {
        try {
            cards.add(rn.nextInt(10)+1);
            cards.add(rn.nextInt(10)+1);
            System.out.println("Player 2 takes a hidden card.");
            Thread.sleep(1000);
            visible_card = cards.get(1);
            System.out.println("Player 2 takes " + visible_card+".");

        }catch(InterruptedException e){

        }
    }

    public static void Draw(){
        int c = rn.nextInt(10)+1;
        visible_card += c;
        cards.add(c);
        System.out.println("Player 2 takes "+c);
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
}
