package src;
import java.util.ArrayList;
import java.util.List;

public class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class MazeSolver {
    private static final int[][] dir = {
        {-1, 0}, // left
        {0, -1}, // up
        {1, 0},  // right
        {0, 1},  // down
    };

    private static boolean walk(String[] maze, String wall, Point curr, Point end, boolean[][] seen, List<Point> path) {
        if (curr.x < 0 || curr.x >= maze[0].length() || curr.y < 0 || curr.y >= maze.length) {
            return false;
        }

        if (maze[curr.y].charAt(curr.x) == wall.charAt(0)) {
            return false;
        }

        if (curr.x == end.x && curr.y == end.y) {
            path.add(end);
            return true;
        }

        if (seen[curr.y][curr.x]) {
            return false;
        }

        seen[curr.y][curr.x] = true;
        path.add(curr);

        for (int i = 0; i < dir.length; ++i) {
            int x = dir[i][0];
            int y = dir[i][1];
            if (walk(maze, wall, new Point(curr.x + x, curr.y + y), end, seen, path)) {
                return true;
            }
        }

        path.remove(path.size() - 1);

        return false;
    }

    public static List<Point> solve(String[] maze, String wall, Point start, Point end) {
        boolean[][] seen = new boolean[maze.length][maze[0].length()];
        List<Point> path = new ArrayList<>();

        walk(maze, wall, start, end, seen, path);
        return path;
    }
}
