import java.awt.*;
import java.util.*;

public class Tiger extends Critter {

    private Random rand = new Random();
    private Color color;
    private int numMoves = 0;

    public Tiger() {

        super();
        setColor();

    }

    public Color getColor() {
        return this.color;
    }

    public String toString() {
        return "TGR";
    }

    public Action getMove(CritterInfo info) {
        incrementMoves();
        Neighbor n = info.getFront();
        Neighbor r = info.getRight();
        if (n==Neighbor.OTHER) {
            return Action.INFECT;
        } else if (n==Neighbor.WALL||r==Neighbor.WALL) {
            return Action.LEFT;
        } else if (n==Neighbor.SAME) {
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }
    }

    private void incrementMoves() {
        this.numMoves++;
        if (numMoves == 3){
            setColor();
            this.numMoves = 0;
        }
    }

    private void setColor() {
        int i = rand.nextInt(3);
        if (i==0) {
            this.color = Color.RED;
        } else if (i==1) {
            this.color = Color.GREEN;
        } else {
            this.color = Color.BLUE;
        }
    }
}
