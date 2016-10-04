import java.util.ArrayList;

/**
 * Created by Jack on 10/04/2016.
 */


public class GameBoard {
    public static int BOARDSIZE = 4;
    private char[][] board;
    private ArrayList<ArrayList<Row>> rows; //first indice is size of row - 1, second is order added

    public GameBoard() {
        board = new char[BOARDSIZE][BOARDSIZE];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = '_';
            }
        }

        rows = new ArrayList<ArrayList<Row>>();
        for(int i = 0; i < 4; i++){
            rows.add(new ArrayList<Row>());
        }
    }

    public ArrayList<Row> getPlayerRowsOfLengthL(char player, int l){
        ArrayList<Row> arr = new ArrayList<Row>();
        for(Row row : rows.get(l-1)){
            if(row.getPlayer() == player){
                arr.add(row);
            }
        }

        return arr;
    }

    public ArrayList<Row> getPlayerRows(char player){
        ArrayList<Row> arr = new ArrayList<Row>();
        for(int i = 0; i < rows.size(); i++){
            arr.addAll(getPlayerRowsOfLengthL(player, i+1));
        }
        return arr;
    }

    public char[][] getBoard() {
        return board;
    }

    public void addPiece(char player, int x, int y){
        if(x >= BOARDSIZE || y >= BOARDSIZE || x < 0 || y < 0){
            return;
        }
        if(board[x][y] != '_'){
            return;
        }

        board[x][y] = player;

        for(ArrayList<Row> bucket : rows){
            for(Row row : bucket){
                boolean remove = removeIfEndTaken(row, x, y);
                if(remove){
                    removeRow(row);
                }
            }
        }

        //add new rows for this piece
    }

    private void removeRow(Row row){
        int i = row.getLength() - 1;
        rows.get(i).remove(row);
    }

    private boolean removeIfEndTaken(Row row, int x, int y) {
        ArrayList<int[]> ends = row.getOpenEnds();

        if(ends.size() != 0){
            int end1[], end2[];
            if(ends.size() >= 1){
                end1 = ends.get(0);
                if(end1[0] == x && end1[1] == y){
                    return true;
                }
            }
            if(ends.size() == 2){
                end2 = ends.get(1);
                if(end2[0] == x && end2[1] == y){
                    return true;
                }
            }

        }

        return false;
    }
}
