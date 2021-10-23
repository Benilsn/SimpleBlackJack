package Play;

import Controller.Match;

public class Program {
    public static void main(String[] args) {

        Match match = new Match();

        match.GameStart();

        while (match.GameNotOver()){
            match.GamePlay();
        }
    }
}


