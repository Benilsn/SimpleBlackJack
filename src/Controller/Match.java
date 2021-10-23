package Controller;

import Model.PC1;
import Model.PC2;
import Model.PC3;
import Model.Player;

import java.util.Scanner;

public class Match {

    private static Player player;
    private static final Scanner sc = new Scanner(System.in);

    public Match(){

        System.out.print("Welcome to Simple 21!\n" +
                "You'll play against 3 other players (computers).\n" +
                "Try to get as close to 21 as possible, without going over.\nWhat's your name? ");
        String name = sc.nextLine();
        System.out.println();
         player = new Player(name);
    }

    public void GameStart(){

        try {
            Thread.sleep(500);
            player.Play();
            Thread.sleep(500);
            PC1.Play();
            Thread.sleep(500);
            PC2.Play();
            Thread.sleep(500);
            PC3.Play();
            Thread.sleep(1000);
            Total();


        }catch(InterruptedException e){

        }
    }

    public void GamePlay(){
        try{

            Thread.sleep(500);
            if (!player.player_passed){
                player.Draw();
            }

            Thread.sleep(500);
            if (!PC1.player_passed){
                if (PC1.TotalPoints() < 21){
                    PC1.Draw();
                }else{
                    System.out.println("Player 1 passes.");
                    PC1.PlayerPass();
                }
            }

            Thread.sleep(500);
            if (!PC2.player_passed){
                if (PC2.TotalPoints() < 21){
                    PC2.Draw();
                }else{
                    System.out.println("Player 2 passes.");
                    PC2.PlayerPass();
                }
            }

            Thread.sleep(500);
            if (!PC3.player_passed){
                if (PC3.TotalPoints() < 21){
                    PC3.Draw();
                }else {
                    System.out.println("Player 3 passes.");
                    PC3.PlayerPass();
                }
            }

            Thread.sleep(1000);

            if (player.player_passed == false){
                Total();
            }
            else{
                System.out.println();
            }

        }catch(InterruptedException e){

        }
    }

    public static void Total(){
        System.out.println();
        player.Total();
        PC1.VisiblePoints();
        PC2.VisiblePoints();
        PC3.VisiblePoints();
        System.out.println();
    }

    public boolean GameNotOver(){
        if (player.player_passed == true
                && PC1.player_passed == true
                && PC2.player_passed == true
                && PC3.player_passed == true){

            System.out.println("\nGame Over");
            System.out.println(player.playerGetName()+" has "+player.TotalPoints()+" total point(s).");
            System.out.println("Player 1 has "+PC1.TotalPoints()+" total point(s).");
            System.out.println("Player 2 has "+PC2.TotalPoints()+" total point(s).");
            System.out.println("Player 3 has "+PC3.TotalPoints()+" total point(s).");
            System.out.print(ChecksWinner());
            return false;
        }else{
            return true;
        }
    }

    public String ChecksWinner(){
        if (player.TotalPoints() == 21
                && PC1.TotalPoints() != 21
                && PC2.TotalPoints() != 21
                && PC3.TotalPoints() != 21 )
        {return player.playerGetName()+ " wins with 21 point (s).";}

        else if (PC1.TotalPoints() == 21
                && player.TotalPoints() != 21
                && PC2.TotalPoints() != 21
                && PC3.TotalPoints() != 21)
        {return "Player 1 wins with 21 point (s).";}

        else if (PC2.TotalPoints() == 21
                && player.TotalPoints() != 21
                && PC1.TotalPoints() != 21
                && PC3.TotalPoints() != 21)
        {return "Player 2 wins with 21 point (s).";}

        else if (PC3.TotalPoints() == 21
                && player.TotalPoints() != 21
                && PC1.TotalPoints() != 21
                && PC2.TotalPoints() != 21)
        {return "Player 3 wins with 21 point (s).";}

        else if ((player.TotalPoints() == 21 && PC1.TotalPoints() == 21)
                || (player.TotalPoints() == 21 && PC2.TotalPoints() == 21)
                || (player.TotalPoints() == 21 && PC3.TotalPoints() == 21)
                || (PC1.TotalPoints() == 21 && PC2.TotalPoints() == 21)
                || (PC1.TotalPoints() == 21 && PC3.TotalPoints() == 21)
                || (PC2.TotalPoints() == 21 && PC3.TotalPoints() == 21))
        {return "Tie, nobody wins.\n";}

        else {
            int twenty_one = 21;
            int player_points = player.TotalPoints() - 21;
            int pc1_points = PC1.TotalPoints() - 21;
            int pc2_points = PC2.TotalPoints() - 21;
            int pc3_points = PC3.TotalPoints() - 21;
            int closer = 0;

            if (player_points < pc1_points
                    && player_points < pc2_points
                    && player_points < pc3_points) {
                return player.playerGetName() + " wins with " + player.TotalPoints();
            } else if (pc1_points < pc2_points
                    && pc1_points < pc3_points) {
                return "Player 1 wins with " + PC1.TotalPoints();
            } else if (pc2_points < pc3_points) {
                return "Player 2 wins with" + PC2.TotalPoints();
            } else {
                return "Player 3 wins with" + PC3.TotalPoints();
            }
        }

    }
}
