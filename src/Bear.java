import java.awt.*;

public class Bear extends Critter {

    private boolean polar;
    private Color color;
    private String slash = "/";

    public Bear(boolean polar) {

        super();

        this.polar = polar;

        if (polar) {
            this.color = Color.WHITE;
        } else {
            this.color = Color.BLACK;
        }
    }

    public Color getColor() {
        return this.color;
    }

    public String toString() {
        if (this.slash.equals("/")) {
            this.slash = "\\";
            return "/";
        } else {
            this.slash = "/";
            return "\\";
        }
    }

    public Action getMove(CritterInfo info) {
        Neighbor n = info.getFront();
        if (n == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (n == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.LEFT;
        }
    }

}
