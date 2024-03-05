import java.util.*;

public class Forks {
    private int x;
    private int y;
    private ArrayList<String> pathsAvailable;

    public Forks(int x, int y) {
        this.x = x;
        this.y = y;
        this.pathsAvailable = new ArrayList<>();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ArrayList<String> getPathsAvailable() {
        return pathsAvailable;
    }
}
