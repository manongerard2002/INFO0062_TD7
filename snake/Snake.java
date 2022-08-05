package snake;

import be.uliege.boigelot.oop.sokoban.gui.SokobanError;
import snake.gui.MoveNotAllowedException;
import snake.gui.SnakeGUI;

public class Snake {
    private SnakeGUI gui;
    private GameState gameState;
    private boolean isRunning;

    public Snake() throws SokobanError {
        gui = new SnakeGUI(GameState.WIDTH, GameState.HEIGHT, "tiles");
        gameState = new GameState();

        show();
    }

    private void show() throws SokobanError {
        gameState.draw(gui);
        gui.show();
    }

    private void update(int event){
        if (event == SnakeGUI.QUIT){
            System.out.println("Leaving game...");
            isRunning = false;
        }else{
            try {
                gameState.getPlayer().move(event);
            } catch (MoveNotAllowedException e) {
                System.out.println("Game Over!");
                isRunning = false;
            }
        }
    }

    public static void main(String args[]) throws SokobanError {
        Snake game = new Snake();
        game.run();
    }

    public void run() throws SokobanError {
        isRunning = true;
        while (isRunning){
            update(gui.getEvent());
            show();
        }
    }
}