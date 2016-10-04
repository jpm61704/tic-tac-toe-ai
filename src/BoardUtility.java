import java.util.ArrayList;

/**
 * Created by Jack on 10/04/2016.
 */
public class BoardUtility {

    public static void printBoard(GameBoard gameBoard){
        char board[][] = gameBoard.getBoard();
        for(char[] row : board){
            for(char cell : row){
                System.out.print("|" + cell);
            }
            System.out.println("|");
        }
    }

    public static void printPlayersRows(GameBoard board, char player){
        ArrayList<Row> rows = board.getPlayerRows(player);
        int i = 0;
        for (Row row : rows) {
            i++;
            System.out.print("Row " + i + ": ");
            for (int cell[] : row.getCells()){
                if(i != 1) System.out.print(",");
                System.out.print("(" + cell[0]  + "," + cell[1] + ")");
            }
        }
    }
}
