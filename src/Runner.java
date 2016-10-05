/**
 * Created by Jack on 10/04/2016.
 */
public class Runner {

    public static void main(String[] args){
        Player x = new BeginnerPlayer('X');
        Player o = new BeginnerPlayer('O');

        GameLoop.playGame(x,o);

    }
}
