/**
 * Created by Jack on 10/05/2016.
 */
public abstract class Player {
    private char piece;
    public abstract int[] getMove(GameBoard board);

    public Player(char piece) {
        this.piece = piece;
    }


    public char getPiece() {
        return piece;
    }

}
