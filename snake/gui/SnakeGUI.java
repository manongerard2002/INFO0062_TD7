package snake.gui;

import be.uliege.boigelot.oop.sokoban.gui.SokobanError;
import be.uliege.boigelot.oop.sokoban.gui.SokobanGUI;

import snake.cells.CellType;
import snake.cells.Coordinate;

public class SnakeGUI extends SokobanGUI {

    private final int background;
    private final int body;
    private final int head;
    private final int fruit;

    public SnakeGUI(int width, int height, String path) throws SokobanError {
        super(width, height);
        background = super.loadImage(path + "/background.png");
        body = super.loadImage(path + "/body.png");
        head = super.loadImage(path + "/head.png");
        fruit = super.loadImage(path + "/fruit.png");
    }

    private int cellTypeId(CellType type) {
        switch (type){
            default:
                return background;
            case BODY:
                return body;
            case HEAD:
                return head;
            case FRUIT:
                return fruit;
        }
    }

    public void setCell(int x, int y, CellType type) throws SokobanError {
        super.setCell(x, y, cellTypeId(type));
    }
}
