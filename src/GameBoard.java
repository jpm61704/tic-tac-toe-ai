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
        if(board[y][x] != '_'){
            return;
        }

        board[y][x] = player;

        /**for(ArrayList<Row> bucket : rows){
            for(Row row : bucket){
                boolean remove = removeIfEndTaken(row, x, y);
                if(remove){
                    removeRow(row);
                }
            }
        }**/
        for(int i = 0; i < rows.size(); i++){
            ArrayList<Row> bucket = rows.get(i);
            for(int j = 0; j < bucket.size(); j++){
                Row row = bucket.get(j);
                boolean remove = removeIfEndTaken(row, x, y, player);
                if(remove){
                    bucket.remove(j);
                }
            }
        }

        expandNewRows(x,y);
    }

    private void expandNewRows(int x, int y) {
        char player = board[y][x];

        checkUpDown(player, x, y);
        checkLeftRight(player, x, y);
        checkBRTL(player, x, y);
        checkBLUR(player, x ,y);
    }

    private void checkUpDown(char player, int x, int y) {
        Row updown = new Row(player);

        int current_y = y;

        while(current_y < 4 && board[current_y][x] == player){
            updown.addCell(x,current_y);
            current_y++;
        }
        if(current_y < 4 && board[current_y][x] == '_'){
            updown.addOpenEnd(x,current_y);
        }

        current_y = y-1;
        while(current_y >= 0 && board[current_y][x] == player){
            updown.addCell(x,current_y);
            current_y--;
        }
        if(current_y >= 0 && board[current_y][x] == '_'){
            updown.addOpenEnd(x,current_y);
        }

        rows.get(updown.getLength()-1).add(updown);
    }

    private void checkLeftRight(char player, int x, int y){
        Row updown = new Row(player);

        int current_x = x;

        while(current_x < 4 && board[y][current_x] == player){
            updown.addCell(current_x, y);
            current_x++;
        }
        if(current_x < 4 && board[y][current_x] == '_'){
            updown.addOpenEnd(current_x, y);
        }

        current_x = x-1;
        while(current_x >= 0 && board[y][current_x] == player){
            updown.addCell(current_x, y);
            current_x--;
        }
        if(current_x >= 0 && board[y][current_x] == '_'){
            updown.addOpenEnd(current_x, y);
        }

        rows.get(updown.getLength()-1).add(updown);
    }

    private void checkBRTL(char player, int x, int y) {
        Row BRTL = new Row(player);

        int current_y = y;
        int current_x = x;

        while(current_y < 4 && current_x < 4 && board[current_y][current_x] == player){
            BRTL.addCell(current_x,current_y);
            current_y++;
            current_x++;
        }
        if(current_y < 4 && current_x < 4 &&board[current_y][current_x] == '_'){
            BRTL.addOpenEnd(current_x,current_y);
        }

        current_y = y-1;
        current_x = x-1;
        while(current_y >= 0 && current_x >= 0 && board[current_y][current_x] == player){
            BRTL.addCell(current_x,current_y);
            current_y--;
            current_x--;
        }
        if(current_y >= 0 && current_x >= 0 && board[current_y][current_x] == '_'){
            BRTL.addOpenEnd(current_x,current_y);
        }

        rows.get(BRTL.getLength()-1).add(BRTL);
    }

    private void checkBLUR(char player, int x, int y) {
        Row BRTL = new Row(player);

        int current_y = y;
        int current_x = x;

        while(current_y < 4 && current_x >= 0 && board[current_y][current_x] == player){
            BRTL.addCell(current_x,current_y);
            current_y++;
            current_x--;
        }
        if(current_y < 4 && current_x >= 0 && board[current_y][current_x] == '_'){
            BRTL.addOpenEnd(current_x,current_y);
        }

        current_y = y-1;
        current_x = x+1;
        while(current_y >= 0 && current_x < 4 && board[current_y][current_x] == player){
            BRTL.addCell(current_x,current_y);
            current_y--;
            current_x++;
        }
        if(current_y >= 0 && current_x < 4 && board[current_y][current_x] == '_'){
            BRTL.addOpenEnd(current_x,current_y);
        }

        rows.get(BRTL.getLength()-1).add(BRTL);
    }

    private boolean removeIfEndTaken(Row row, int x, int y, char player) {
        ArrayList<int[]> ends = row.getOpenEnds();

        if(ends.size() != 0){
            int end1[], end2[];
            if(ends.size() >= 1){
                end1 = ends.get(0);

                if(end1[0] == x && end1[1] == y){
                    row.getOpenEnds().remove(0);
                }
                if(end1[0] == x && end1[1] == y && row.getPlayer() == player){
                    return true;
                }

            }
            if(ends.size() == 2){
                end2 = ends.get(1);
                if(end2[0] == x && end2[1] == y){
                    row.getOpenEnds().remove(1);
                }
                if(end2[0] == x && end2[1] == y && row.getPlayer() == player){
                    return true;
                }

            }

        }

        return false;
    }
}
