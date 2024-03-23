import java.util.*;

public class Maze {
    String[][] maze;
    ArrayList<String> correctPath; // stores the correct coordinates
    boolean[][] coordsVisited; // new array to track which coordinates were visited already
    ArrayList<Forks> forks; // stores the forks encountered
    int x;
    int y;

    public Maze(String[][] maze, int x, int y) {
        this.maze = maze;
        this.correctPath = new ArrayList<>();
        this.coordsVisited = new boolean[maze.length][maze[0].length];
        this.forks = new ArrayList<>();
        this.x = x;
        this.y = y;
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

    // returns the coordinates as strings
    public String formatCoordinates(int x, int y) {
        return "(" + x + ", " + y + ")";
    }

    // gets available directions
    public ArrayList<String> getDirections(int x, int y) {
        ArrayList<String> dir = new ArrayList<>();
        if (x > 0 && !coordsVisited[x-1][y] && maze[x-1][y].equals(".")) {
            dir.add("up"); // can go up
        }
        if (y > 0 && !coordsVisited[x][y-1] && maze[x][y-1].equals(".")) {
            dir.add("left"); // can go left
        }
        if (x < maze.length - 1 && !coordsVisited[x+1][y] && maze[x+1][y].equals(".")) {
            dir.add("down"); // can go down
        }
        if (y < maze[0].length - 1 && !coordsVisited[x][y+1] && maze[x][y+1].equals(".")) {
            dir.add("right"); // can go right
        }
        return dir;
    }

    public ArrayList<String> solveMaze() {
        coordsVisited[x][y] = true;
        correctPath.add(formatCoordinates(x, y));
        while (!(x == maze.length - 1 && y == maze[0].length - 1)) {
            ArrayList<String> directions = getDirections(x, y);
            boolean moved = false;

            if (directions.size() == 0) {
                // backtrack to the last fork
                Forks lastFork = forks.remove(forks.size() - 1);
                x = lastFork.getX();
                y = lastFork.getY();
                // remove the wrong path taken from the last fork
                while (!correctPath.get(correctPath.size() - 1).equals(formatCoordinates(x, y))) {
                    correctPath.remove(correctPath.size() - 1);
                }
            }
            else {
                for (String dir : directions) {
                    int newX = x;
                    int newY = y;
                    if (dir.equals("up")) {
                        newX--;
                    }
                    else if (dir.equals("down")) {
                        newX++;
                    }
                    else if (dir.equals("left")) {
                        newY--;
                    }
                    else if (dir.equals("right")) {
                        newY++;
                    }

                    if (!coordsVisited[newX][newY] && !moved) {
                        if (directions.size() > 1) {
                            forks.add(new Forks(x, y));
                        }
                        setX(newX);
                        setY(newY);
                        coordsVisited[x][y] = true;
                        correctPath.add(formatCoordinates(x, y));
                        moved = true;
                    }
                }
            }
        }
        return correctPath;
    }
}
