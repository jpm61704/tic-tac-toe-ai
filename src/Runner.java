/**
 * Created by Jack on 10/04/2016.
 */
public class Runner {

    public static void main(String[] args){
        GameBoard board = new GameBoard();

        board.addPiece('p', 1, 1);
        board.addPiece('p', 1, 0);
        board.addPiece('p', 0, 1);
        board.addPiece('p', 1, 2);





        BoardUtility.printAll(board, "pa".toCharArray());

        board.addPiece('a', 0, 0);

        BoardUtility.printAll(board, "pa".toCharArray());

    }
}
