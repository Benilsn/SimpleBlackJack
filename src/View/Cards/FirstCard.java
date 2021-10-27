package View.Cards;

public class FirstCard {

    private final String card1 = "┏━━━┓";
    private final String[] card2 = new String[]{"┃","",""," ┃"};
    private final String card3 = "┗━━━┛";

    public FirstCard(int suit, String value){
        switch (suit) {
            case 1:
                card2[1] = "♠";
                break;
            case 2:
                card2[1] = "♣";
                break;
            case 3:
                card2[1] = "♥";
                break;
            case 4:
                card2[1] = "♦";
                break;
        }
        card2[2] = String.valueOf(value);
    }

    public String getTop(){
        return card1;
    }

    public String getBot(){
        return card3;
    }

    public String getValue(){
        return card2[0]+card2[1]+card2[2]+card2[3];
    }

}
