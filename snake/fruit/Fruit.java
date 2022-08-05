package snake.fruit;

import snake.GameState;
import snake.cells.CellType;
import snake.cells.Coordinate;

public class Fruit {
    private final static int GROWING_CST = 2;
    private GameState gameState;
    private Coordinate place;

    public Fruit(GameState gameState, Coordinate place){
        this.gameState = gameState;
        this.place = place;
    }

    public int eat() {
        findEmptyPlace();
        gameState.setCellType(place, CellType.FRUIT);
        return GROWING_CST;
    }

    private void findEmptyPlace() {
        while (true) {
            int x = (int)(Math.random() * (GameState.WIDTH - 1));
            int y = (int)(Math.random() * (GameState.HEIGHT- 1));
            Coordinate targetCell = new Coordinate(x, y);
            if (gameState.getCellType(targetCell) == CellType.BACKGROUND){
                place = targetCell;
                return;
            }
        }
    }
}