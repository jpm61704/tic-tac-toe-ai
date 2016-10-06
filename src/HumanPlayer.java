import java.util.Scanner;

/**
 * Created by Jack on 10/06/2016.
 */
public class HumanPlayer extends Player {
    public HumanPlayer(char piece) {
        super(piece);
    }

    @Override
    public int[] getMove(GameBoard board) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Please enter your move (use form x,y): ");

        int x = 0,y = 0;


            String move_str = reader.nextLine();

            char[] movearr = move_str.toCharArray();


                x = Integer.parseInt("" + movearr[0]);
                y = Integer.parseInt("" + movearr[2]);



        int move[] = {x,y};

        return move;

    }
}
