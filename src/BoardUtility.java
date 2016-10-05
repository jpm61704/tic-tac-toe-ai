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
        System.out.println("Player: " + player);
        for (Row row : rows) {
            i++;
            System.out.print("\tRow " + i + ": ");
            for (int cell[] : row.getCells()){
                System.out.print("(" + cell[0]  + "," + cell[1] + ")");
            }

            System.out.print(" | Open Ends: ");

            for (int cell[] : row.getOpenEnds()){
                System.out.print("(" + cell[0]  + "," + cell[1] + ")");
            }

            System.out.println();
        }
    }

    public static void printAll(GameBoard board, char[] players){
        printBoard(board);
        for(char player : players){
            printPlayersRows(board, player);
        }
    }
}
