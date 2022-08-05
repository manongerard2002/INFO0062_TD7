package snake.player;

import snake.GameState;
import snake.cells.CellType;
import snake.cells.Coordinate;
import snake.gui.MoveNotAllowedException;
import snake.gui.SnakeGUI;

import java.util.Vector;

public class Player {
    private GameState gameState;
    private Coordinate head;
    private Vector<Coordinate> body;
    private int growingCnt;

    public Player(GameState gameState, Coordinate head, Vector<Coordinate> body) {
        this.gameState = gameState;
        this.head = head;
        this.body = body;
        growingCnt = 0;
    }


    public void move(int action) throws MoveNotAllowedException {
        Coordinate newHead = new Coordinate(head.x, head.y);
        switch (action){
            case SnakeGUI.UP:
                if (newHead.y == 0){
                    newHead.y = GameState.HEIGHT - 1;
                }else{
                    newHead.y--;
                }
                break;
            case SnakeGUI.DOWN:
                if (newHead.y == GameState.HEIGHT - 1){
                    newHead.y = 0;
                }else{
                    newHead.y++;
                }
                break;
            case SnakeGUI.LEFT:
                if (newHead.x == 0){
                    newHead.x = GameState.WIDTH - 1;
                }else{
                    newHead.x--;
                }
                break;
            case SnakeGUI.RIGHT:
                if (newHead.x == GameState.WIDTH - 1){
                    newHead.x = 0;
                }else{
                    newHead.x++;
                }
                break;
            default:
                return;
        }
        switch (gameState.getCellType(newHead)){
            case FRUIT:
                growingCnt += gameState.getFruit().eat();
            case BACKGROUND:
                move(newHead);
                break;
            default:
                throw new MoveNotAllowedException();
        }
    }

    private void move(Coordinate newHead) {
        Coordinate coordinate;

        if (growingCnt == 0){
            coordinate = body.remove(0);
            gameState.setCellType(coordinate, CellType.BACKGROUND);
        }else{
            growingCnt--;
        }

        body.add(head);
        gameState.setCellType(head, CellType.BODY);

        head = newHead;
        gameState.setCellType(head, CellType.HEAD);
    }
}