package View.Cards;

public class TurnedCard {

    private final String card1 = "┏━━━┓";
    private final String card2 = "┃║║║┃";
    private final String card3 = "┗━━━┛";

    public String getTop(){
        return card1;
    }

    public String getMid(){
        return card2;
    }

    public String getBot(){
        return card3;
    }


}
