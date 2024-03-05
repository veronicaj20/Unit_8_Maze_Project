import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        String [][] maze = getMaze("src/maze_file");
        System.out.println(solveDeadEndMaze(maze));


    }

    // solves maze, no dead ends
    private static ArrayList<String> solveMaze(String[][] maze) {
        ArrayList<String> path = new ArrayList<>();
        boolean[][] coordsVisited = new boolean[maze.length][maze[0].length];
        int x = 0;
        int y = 0;

        coordsVisited[x][y] = true;
        path.add(formatCoordinates(x, y));
        boolean moved = false;
        while (!(x == maze.length - 1 && y == maze[0].length - 1)) {

            if (y + 1 < maze[0].length && !coordsVisited[x][y + 1] && maze[x][y + 1].equals(".")) {
                y++;
                moved = true;
            } else if (x + 1 < maze.length && !coordsVisited[x + 1][y] && maze[x + 1][y].equals(".")) {
                x++;
                moved = true;
            } else if (y - 1 >= 0 && !coordsVisited[x][y - 1] && maze[x][y - 1].equals(".")) {
                y--;
                moved = true;
            } else if (x - 1 >= 0 && !coordsVisited[x - 1][y] && maze[x - 1][y].equals(".")) {
                x--;
                moved = true;
            }

            if (moved) {
                path.add(formatCoordinates(x, y));
                coordsVisited[x][y] = true;
            }
        }

        return path;
    }

    // solves maze with dead ends
    public static ArrayList<String> solveDeadEndMaze(String [][] maze) {
        ArrayList<String> path = new ArrayList<>();
        boolean[][] coordsVisited = new boolean[maze.length][maze[0].length];
        ArrayList<Forks> forks = new ArrayList<>();
        int x = 0;
        int y = 0;

        coordsVisited[x][y] = true;
        path.add(formatCoordinates(x, y));
        while (!(x == maze.length - 1 && y == maze[0].length - 1)) {
            ArrayList<String> directions = getDirections(maze, coordsVisited, x, y);
            boolean moved = false;

        }
        return path;
    }

    // gets available directions
    public static ArrayList<String> getDirections(String [][] maze, boolean [][] v, int x, int y) {
        ArrayList<String> dir = new ArrayList<>();
        if (x > 0 && !v[x-1][y] && maze[x-1][y].equals(".")) {
            dir.add("up"); // can go up
        }
        if (y > 0 && !v[x][y-1] && maze[x][y-1].equals(".")) {
            dir.add("left"); // can go left
        }
        if (x < maze.length - 1 && !v[x+1][y] && maze[x+1][y].equals(".")) {
            dir.add("down"); // can go down
        }
        if (y < maze[0].length - 1 && !v[x][y+1] && maze[x][y+1].equals(".")) {
            dir.add("right"); // can go right
        }
        return dir;
    }

    // returns the coordinates as strings
    public static String formatCoordinates(int x, int y) {
        return "(" + x + ", " + y + ")";
    }

    // to read the file
    public static String[][] getMaze(String fileName) {
        File f = new File(fileName);
        Scanner s = null;
        try {
            s = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }

        ArrayList<String> fileData = new ArrayList<String>();
        while (s.hasNextLine())
            fileData.add(s.nextLine());

        int rows = fileData.size();
        int cols = fileData.get(0).length();

        String[][] maze = new String[rows][cols];

        for (int i = 0; i < fileData.size(); i++) {
            String d = fileData.get(i);
            for (int j = 0; j < d.length(); j++) {
                maze[i][j] = d.charAt(j) + "";
            }
        }
        return maze;

    }


}