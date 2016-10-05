import java.util.ArrayList;

/**
 * Created by Jack on 10/04/2016.
 */
public class Row {
    private char player;
    private int length;
    private ArrayList<int[]> cells, openEnds;

    public Row(char player) {
        this.player = player;
        cells = new ArrayList<int[]>();
        openEnds = new ArrayList<int[]>();
        length = 0;
    }

    public ArrayList<int[]> getOpenEnds() {
        return openEnds;
    }

    public int getLength() {
        return length;
    }

    public char getPlayer() {
        return player;
    }

    public ArrayList<int[]> getCells() {
        return cells;
    }

    public boolean isOpen(){
        return getOpenEnds().size() != 0;
    }

    public void addCell(int x, int y){
        int cell[] = {x,y};
        length++;
        cells.add(cell);
    }

    public void addOpenEnd(int x, int y){
        int arr[] = {x,y};
        openEnds.add(arr);
    }
}
