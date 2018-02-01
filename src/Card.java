public class Card {
    int suit;
    int value;
    String name = "";

    public Card (int suit, int value) {
        this.suit = suit;
        this.value = value;
        if (value == 1){
            this.name = "Ace";
        }
        else if (value < 11 && value > 1){
            this.name += value;
        }
        if (value == 11){
            this.name += "Jack";
        }
        if (value == 12){
            this.name += "Queen";
        }
        if (value == 13){
            this.name += "King";
        }
        if (suit == 1){
            this.name += " of spades";
        }
        if (suit == 2){
            this.name += " of hearts";
        }
        if (suit == 3){
            this.name += " of clubs";
        }
        if (suit == 4 ){
            this.name += " of diamonds";
        }
    }
}
