package snake.gui;

public class MoveNotAllowedException extends Exception {
    public MoveNotAllowedException(){
        super();
    }

    public MoveNotAllowedException(String msg){
        super(msg);
    }
}