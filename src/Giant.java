import java.awt.*;

public class Giant extends Critter {

    private Color color = Color.GRAY;
    private int numMoves = 0;
    private String symbol = "fee";

    public Giant() {
        super();
    }

    public Color getColor() {
        return this.color;
    }

    public String toString() {
        return this.symbol;
    }

    public Action getMove(CritterInfo info) {
        incrementMoves();
        Neighbor n = info.getFront();
        if (n == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (n == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }
    }

    private void incrementMoves() {
        this.numMoves++;
        if (numMoves < 6) {
            this.symbol = "fee";
        } else if (numMoves < 12) {
            this.symbol = "fie";
        } else if (numMoves<18) {
            this.symbol = "foe";
        } else if (numMoves < 24) {
            this.symbol = "fum";
        } else {
            numMoves = 1;
            this.symbol = "fee";
        }
    }

}
