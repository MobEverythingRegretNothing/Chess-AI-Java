package chess.model;

public class Game  implements Runnable {
    private  GameState gameState;


    @Override
    public void run() {
        gameState = new GameState().init();


    }
}
