package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PC1 {

    private static final List<Integer> cards = new ArrayList<>();
    private static final Random rn = new Random();
    private static final Scanner sc = new Scanner(System.in);
    private static int visible_card;
    public static boolean player_passed = false;

    public static void Play() {

        cards.add(rn.nextInt(10)+1);
        cards.add(rn.nextInt(10)+1);
        System.out.println("Player 1 takes a hidden card.");
        visible_card = cards.get(1);
        System.out.println("Player 1 takes " + visible_card +"." );
    }

    public static void Draw(){

        int c = rn.nextInt(10)+1;
        visible_card += c ;
        cards.add(c);
        System.out.println("Player 1 takes "+c);
    }

    public static void VisiblePoints(){
        System.out.println("Player 1 has "+ visible_card +" visible point(s).");
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