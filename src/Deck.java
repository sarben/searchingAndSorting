import java.util.*;

public class Deck {
    Card[] allCards = new Card[52];
    Card[]  hand = new Card[7];
    static int cardCount = 0;

    public Deck(boolean fullDeck){
        cardCount = 0;
        if(fullDeck){
         for(int i = 1; i <= 4; i++){
             for(int j = 1; j <= 13; j++){
                 allCards[cardCount] = new Card(i,j);
                 cardCount++;
             }
         }
        }
        else {

        }
    }
    public void swap(int first, int second) {
        Card x = hand[first];
        hand[first] = hand[second];
        hand[second] = x;
    }

    public void shuffleDeck(){
        Collections.shuffle(Arrays.asList(allCards));
    }

    public void dealHand(int numCards){
        for (int n = 0; n < numCards; n++){
            hand[n] = allCards[n];
        }
    }

    public void listHand(){
        for (int i = 0; i < hand.length; i++ ){
            System.out.println(hand[i].name);
        }
    }
    public static void list(Card[] hand){
        for (int i = 0; i < hand.length; i++ ){
            System.out.println(hand[i].name);
        }
    }

    //the sorting algorithms

    public void selectionSortHand() {
        //Find the lowest value in the array. Keep track of which index that card resides at.
        //Swap the lowest card with the first card.
        //Repeat steps 1 and 2 by finding the lowest card in the rest of the array. On step 2, swap with the first card in the unsorted section.

        for (int i = 0; i < hand.length - 1; i++) {
            int lowest = i;
            for (int z = i+1; z < hand.length ; z++) {
                if (hand[z].value < hand[lowest].value) {
                    lowest = z;
                }
            }
                swap(i, lowest);
        }
    }

    public void mergeSort(){
       mergeSortHand(hand);
    }

    public static Card[] leftHalf(Card[] array) {
        int size = array.length / 2;
        Card[] left = new Card[size];
        for (int i = 0; i < size; i++) {
            left[i] = array[i];
        }
        System.out.println("LeftSide ");
        list(left);
        return left;
    }
    public static Card[] rightHalf(Card[] array) {
        int size = array.length / 2;
        int sizeB = array.length - size;
        Card[] right = new Card[sizeB];
        for (int i = 0; i <= sizeB - 1; i++) {
            right[i] = array[i - 1 + sizeB];
        }
        System.out.println("RightSide ");
        list(right);
        return right;
    }

    public void mergeSortHand(Card[] cards) {
        if (cards.length > 2 && cards[0].value < cards[cards.length - 1].value) {
            Card[] leftSide = leftHalf(cards);
            Card[] rightSide = rightHalf(cards);
            mergeSortHand(leftSide);
            mergeSortHand(rightSide);
            DoMerge(cards, leftSide, rightSide);
        }
    }

    public static void DoMerge(Card[] result, Card[] left, Card[] right) {
        int indexLeft = 0;
        int indexRight = 0;
        for (int i = 0; i < result.length; i++) {
            if (indexRight >= right.length || (indexLeft < left.length && left[indexLeft].value <= right[indexRight].value)) {
                result[i] = left[indexLeft];
                indexLeft++;
            } else {
                result[i] = right[indexRight];
                indexRight++;
            }
        }
        System.out.println("Result: ");
        list(result);
    }
    public boolean binarySearch(int val){
        //http://www.cs.toronto.edu/~reid/search/bincode.html
        int low = 0;
        int high = hand.length - 1;
        while(high >= low) {
           int middle = (low + high) / 2;
           if(hand[middle].value == val) {
               System.out.println("true, it's at " + middle);
               return true;
           }
            if(hand[middle].value < val) {
               low = middle + 1;
            }
          if(hand[middle].value > val) {
               high = middle - 1;
          }
      }
        System.out.println("false");
        return false;
    }

    public void bubbleSortHand() {
        for (int z = 0; z < hand.length - 1; z++){
            for (int i = 0; i < hand.length - 1; i++){
                if (hand[i].value > hand[i+1].value){
                    swap(i, i+1);
                }
            }
        }
    }
}
