import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        String [][] m = getMaze("src/maze_file");
        Maze maze = new Maze(m, 0, 0);
        ArrayList<String> coordinates = maze.solveMaze();
        for (int i = 0; i < coordinates.size(); i++) {
            if (i < coordinates.size() - 1) {
                System.out.print(coordinates.get(i) + " ---> ");
            }
            else {
                System.out.print(coordinates.get(i));
            }
        }
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