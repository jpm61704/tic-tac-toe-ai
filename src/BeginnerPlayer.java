/**
 * Created by Jack on 10/05/2016.
 */
public class BeginnerPlayer extends Player {
    public BeginnerPlayer(char piece) {
        super(piece);
    }

    @Override
    public int[] getMove(GameBoard board) {
        for(Row row : board.getPlayerRowsOfLengthL(getPiece(), 2) ){
            if(row.isOpen()){
                return row.getOpenEnds().get(0);
            }
        }
        for(Row row : board.getOpponantsRowsOfLengthL(getPiece(), 2)){
            if(row.isOpen()){
                return row.getOpenEnds().get(0);
            }
        }
        char board_arr[][] = board.getBoard();

        for(int j = 0; j < board_arr.length; j++){
            for(int i = 0; i < board_arr.length; i++){
                if(board_arr[j][i] == '_'){
                    int move[] = {i,j};
                    return move;
                }
            }
        }
        return null;
    }
}
