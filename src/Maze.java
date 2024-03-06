import java.util.*;

public class Maze {
    String[][] maze;
    ArrayList<String> correctPath; // stores the correct coordinates
    boolean[][] coordsVisited; // new array to track which coordinates were visited already
    ArrayList<Forks> forks; // stores the forks encountered
    int x;
    int y;

    // no dead end mazes (no forks array list)
    public Maze(String[][] maze, ArrayList<String> correctPath, boolean[][] coordsVisited, int x, int y) {
        this.correctPath = new ArrayList<>();
        this.coordsVisited = new boolean[maze.length][maze[0].length];
        this.x = x;
        this.y = y;
    }

    // dead end mazes
    public Maze(String[][] maze, ArrayList<String> correctPath, boolean[][] coordsVisited, ArrayList<Forks> fork, int x, int y) {
        this.correctPath = new ArrayList<>();
        this.coordsVisited = new boolean[maze.length][maze[0].length];
        this.forks = new ArrayList<>();
        this.x = x;
        this.y = y;
    }

    public ArrayList<String> getCorrectPath() {
        return correctPath;
    }

    public void setCorrectPath(ArrayList<String> correctPath) {
        this.correctPath = correctPath;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
