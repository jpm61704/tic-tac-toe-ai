import java.util.ArrayList;

/**
 * Created by Jack on 10/05/2016.
 */
public class GameLoop {
    public static void playGame(Player p1, Player p2){
        GameBoard board = new GameBoard();
        Player winner = null;

        System.out.println("Tic-Tac-Toe 4x4");

        while(winner == null){

            System.out.println("Player " + p1.getPiece() + " it is your turn");
            BoardUtility.printBoard(board);

            int move[] = p1.getMove(board);
            board.addPiece(p1.getPiece(), move[0], move[1]);
            if(check_win(board) == p1.getPiece()){
                winner = p1;
                break;
            }

            System.out.println("Player " + p1.getPiece() + " it is your turn");
            BoardUtility.printBoard(board);

            move = p2.getMove(board);
            board.addPiece(p2.getPiece(), move[0], move[1]);
            if(check_win(board) == p2.getPiece()){
                winner = p2;
            }
        }

        System.out.println("Player " + winner.getPiece() + " Wins!");
        BoardUtility.printBoard(board);

    }

    private static char check_win(GameBoard board){
        ArrayList<Row> bucket = board.getRowsofLength(3);
        if(bucket.size() != 0){
            return  bucket.get(0).getPlayer();
        }
        return '_';
    }
}
