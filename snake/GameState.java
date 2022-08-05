package snake;

import be.uliege.boigelot.oop.sokoban.gui.SokobanError;
import snake.gui.SnakeGUI;

import snake.cells.CellType;
import snake.cells.Coordinate;
import snake.player.Player;
import snake.fruit.Fruit;
import java.util.Vector;

public class GameState {
    public final static int WIDTH = 12;
    public final static int HEIGHT = 18;

    private CellType[][] grid;
    private Player player;
    private Fruit fruit;

    public GameState(){
        initGrid();
        initPlayer();
        initFruit();
    }

    private void initGrid(){
        grid = new CellType[WIDTH][HEIGHT];
        for (int i = 0; i < WIDTH; i++){
            for (int j = 0; j < HEIGHT; j++){
                grid[i][j] = CellType.BACKGROUND;
            }
        }
    }

    private void initPlayer(){
        Vector<Coordinate> body = new Vector<Coordinate>();

        grid[5][9] = CellType.BODY;
        body.add(new Coordinate(5, 9));

        grid[6][9] = CellType.BODY;
        body.add(new Coordinate(6, 9));

        grid[7][9] = CellType.HEAD;
        player = new Player(this, new Coordinate(7, 9), body);
    }

    private void initFruit(){
        grid[2][16] = CellType.FRUIT;
        fruit = new Fruit(this, new Coordinate(2, 16));
    }

    public CellType getCellType(Coordinate coordinate) {
        return grid[coordinate.x][coordinate.y];
    }

    public void setCellType(Coordinate coordinate, CellType type) {
        grid[coordinate.x][coordinate.y] = type;
    }

    public Player getPlayer() {
        return player;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void draw(SnakeGUI gui) throws SokobanError {
        for (int i = 0; i < WIDTH; i++){
            for (int j = 0; j < HEIGHT; j++){
                gui.setCell(i, j, grid[i][j]);
            }
        }
    }
}
