public class Main {

    public static void main(String[] args) {
        System.out.println("Initializing Game...");
        Game game = new Game();

        while (!game.isGameWon()) {
            game.newTurn();
        }
        //stop game
    }
}
