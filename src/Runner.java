/**
 * Created by Jack on 10/04/2016.
 */
public class Runner {

    public static void main(String[] args){
        GameBoard board = new GameBoard();

        board.addPiece('p', 1, 1);
        board.addPiece('a', 1, 1);
        board.addPiece('a', 4, 4);
        board.addPiece('a', 2, 6);
        board.addPiece('a', 2, 2);


        BoardUtility.printBoard(board);
        BoardUtility.printPlayersRows(board, 'p');

    }
}
