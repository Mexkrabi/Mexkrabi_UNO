import java.util.*;

public class Game {

    public Card[] allCards = new Card[108];
    private Card[] deckArr = new  Card[108];

    public List<Card> deck = new ArrayList<>();
    //create when needed:
    //public ListIterator<Card> deck_it = deck.listIterator();     //Link: http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_13_003.htm#t2t34

    public List<Player> players = new ArrayList<>();
    //same here:
    //public ListIterator<Player> players_it = players.listIterator();


    public Game() {
        System.out.println("Initialising game...");

/**
 * card order/ids:
 *      0-9: red_1 0-9
 *      10-19: yellow_1 0-9
 *      20-29: green_1 0-9
 *      30-39: blue_1 0-9
 *
 *      40-48: red_2 1-9
 *      49-57: yellow_2 1-9
 *      58-66: green_2 1-9
 *      67-75: blue_2 1-9
 *
 *      76-77: red skip
 *      78-79: yellow skip
 *      80-81: green skip
 *      82-83: blue skip
 *
 *      84-85: red reverse
 *      86-87: yellow reverse
 *      88-89: green reverse
 *      90-91: blue reverse
 *
 *      92-93: red +2
 *      94-95: yellow +2
 *      96-97: green +2
 *      98-99: blue +2
 *
 *      100-103: black choose
 *      104-107: black +4
 */

        int id = 0;
//normal cards +0
        int val = 0;
        while (0 <= id && id <= 9) {
            allCards[id] = new Card(id, "red", val, false);
            val++;
            id++;
        }
        val = 0;
        while (10 <= id && id <= 19) {
            allCards[id] = new Card(id, "yellow", val, false);
            val++;
            id++;
        }
        val = 0;
        while (20 <= id && id <= 29) {
            allCards[id] = new Card(id, "green", val, false);
            val++;
            id++;
        }
        val = 0;
        while (30 <= id && id <= 39) {
            allCards[id] = new Card(id, "blue", val, false);
            val++;
            id++;
        }

//normal cards -0
        val = 1;
        while (40 <= id && id <= 48) {
            allCards[id] = new Card(id, "red", val, false);
            val++;
            id++;
        }
        val = 1;
        while (49 <= id && id <= 57) {
            allCards[id] = new Card(id, "yellow", val, false);
            val++;
            id++;
        }
        val = 1;
        while (58 <= id && id <= 66) {
            allCards[id] = new Card(id, "green", val, false);
            val++;
            id++;
        }
        val = 1;
        while (67 <= id && id <= 75) {
            allCards[id] = new Card(id, "blue", val, false);
            val++;
            id++;
        }

//skip cards
        val = 10;
        while (76 <= id && id <= 77) {
            allCards[id] = new Card(id, "red", val, true);
            id++;
        }
        while (78 <= id && id <= 79) {
            allCards[id] = new Card(id, "yellow", val, true);
            id++;
        }
        while (80 <= id && id <= 81) {
            allCards[id] = new Card(id, "green", val, true);
            id++;
        }
        while (82 <= id && id <= 83) {
            allCards[id] = new Card(id, "blue", val, true);
            id++;
        }

//reverse cards
        val = 11;
        while (84 <= id && id <= 85) {
            allCards[id] = new Card(id, "red", val, true);
            id++;
        }
        while (86 <= id && id <= 87) {
            allCards[id] = new Card(id, "yellow", val, true);
            id++;
        }
        while (88 <= id && id <= 89) {
            allCards[id] = new Card(id, "green", val, true);
            id++;
        }
        while (90 <= id && id <= 91) {
            allCards[id] = new Card(id, "blue", val, true);
            id++;
        }

//+2 cards
        val = 12;
        while (92 <= id && id <= 93) {
            allCards[id] = new Card(id, "red", val, true);
            id++;
        }
        while (94 <= id && id <= 95) {
            allCards[id] = new Card(id, "yellow", val, true);
            id++;
        }
        while (96 <= id && id <= 97) {
            allCards[id] = new Card(id, "green", val, true);
            id++;
        }
        while (98 <= id && id <= 99) {
            allCards[id] = new Card(id, "blue", val, true);
            id++;
        }

//black cards

//choose cards
        val = 13;
        while (100 <= id && id <= 103) {
            allCards[id] = new Card(id, "black", val, true);
            id++;
        }

//+4 cards
        val = 14;
        while (104 <= id && id <= 107) {
            allCards[id] = new Card(id, "black", val, true);
            id++;
        }

        //create and mix deck       //help in this Link: https://stackoverflow.com/questions/20039025/java-array-of-unique-randomly-generated-integers
/*
        int counter = 0;
        while (counter < 108) {
            int randomNumber = getRandomNumberInRange(0, 108);
            if(allCards[randomNumber].isMixedIntoDeck() == false) {
                deck[counter] = allCards[randomNumber];
                allCards[randomNumber].setMixedIntoDeck(true);
                counter++;
            }
        }
*/
        //create and mix deck           Special thanks to @nicex000
        Integer[] nums = getInts();
        for(int i = 0; i < 108; i++){
            deckArr[i] = allCards[nums[i]];
            allCards[i].setMixedIntoDeck(true);
        }
        System.out.println("Deck order:");
        for (int i = 0; deckArr.length > i; i++) {
            System.out.print("pos " + i + " = " + "card ");
            System.out.println(deckArr[i].getId()/*now it works, thanks to @nicex000*/ );
        }
        // deckArr (array) to deck (ArrayList) //see code line 10
        ArrayList deck = new ArrayList(Arrays.asList(deckArr));

        //create players
        Player p1 = new Player("Player 1", 1, 7);
        Player p2 = new Player("Player 2", 2, 7);
        Player p3 = new Player("Player 3", 3, 7);
        Player p4 = new Player("Player 4", 4, 7);
        players.add(0, p1);
        players.add(1, p2);
        players.add(2, p3);
        players.add(3, p4);

        //draw cards
        for (int i = 0; i < 7; i++) {
            p1.drawCard();
            p2.drawCard();
            p3.drawCard();
            p4.drawCard();
        }
        System.out.println("Player 1's cards: " + p1.getPlayercards());
        System.out.println("Player 2's cards: " + p2.getPlayercards());
        System.out.println("Player 3's cards: " + p3.getPlayercards());
        System.out.println("Player 4's cards: " + p4.getPlayercards());
    }

    //gets random number
    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    //Special thanks to @nicex000
    public static Integer[] getInts(){
        List<Integer> a;
        a = new ArrayList<>();
        for (int i = 0; i <108; i++){
            a.add(i);
        }
        Collections.shuffle(a);
        Integer arr[] = new Integer[a.size()];
        arr = a.toArray(arr);
        return arr;
    }
}
