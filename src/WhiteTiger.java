import java.awt.*;

public class WhiteTiger extends Critter {

    private Color color = Color.WHITE;
    private String symbol = "tgr";


    public WhiteTiger() {
        super();
    }

    public Color getColor() {
        return this.color;
    }

    public String toString() {
        return this.symbol;
    }

    public Action getMove(CritterInfo info) {
        Neighbor n = info.getFront();
        Neighbor r = info.getRight();
        if (n==Neighbor.OTHER) {
            // if it infects, update symbol
            this.symbol = "TGR";
            return Action.INFECT;
        } else if (n==Neighbor.WALL||r==Neighbor.WALL) {
            return Action.LEFT;
        } else if (n==Neighbor.SAME) {
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }
    }

}
