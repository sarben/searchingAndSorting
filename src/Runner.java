public class Runner {

    public static void main(String[] args){
        Deck sarah = new Deck(true);
        sarah.shuffleDeck();
        sarah.dealHand(7);
        sarah.listHand();
        sarah.bubbleSortHand();
        System.out.println("");
        System.out.println("Bubble Sort:");
        System.out.println("");
        //System.out.println("Merge Sort:");
        //sarah.mergeSort();
        sarah.listHand();
        sarah.binarySearch(2);
    }
}
