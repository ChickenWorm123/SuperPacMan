import java.util.*;

public class SuperPacMan_Maze {
    // Grid dimensions (must be odd numbers for wall/path carving)
    private static final int r = 29;
    private static final int c = 31;

    // Tile characters
    private static final char w = '0';
    private static final char d = '.';
    private static final char p = 'o';
    private static final char s = 'S';
    private static final char e = 's';
    private static final char pm = 'p';
    private static final char g = 'g';
    private static final char t = 'w';
    private static final char k = 'k';

    private char[][] grid;
    private Random rand = new Random();

    public SuperPacMan_Maze() {
        grid = new char[r][c];
        generateMaze();
    }

    private void generateMaze() {
        for (int i = 0; i < r; i++) {
            Arrays.fill(grid[i], w);
        }


        int m = c / 2;

        carve(1, 1, m);

        removeEnds(m);

        for (int i = 0; i < r; i++) {
            for (int l = 0; l < m; l++) {
                grid[i][c - 1 - l] = grid[i][l];
            }
        }


        addBox(r / 2, m);
        addSides(r / 2);


        placeEntities();
        placeKeys();
    }

    private void carve(int rows, int cols, int maxCol) {
        grid[rows][cols] = d;

        int[][] motion = {{-2, 0}, {2, 0}, {0, -2}, {0, 2}};
        Collections.shuffle(Arrays.asList(motion), rand);

        for (int[] v : motion) {
            int nr = rows + v[0];
            int nc = cols + v[1];


            if (nr > 0 && nr < r - 1 && nc > 0 && nc <= maxCol) {
                if (grid[nr][nc] == w) {

                    grid[rows + v[0] / 2][cols + v[1] / 2] = d;
                    carve(nr, nc, maxCol);
                }
            }
        }
    }

    private void removeEnds(int maxCol) {
        for (int i = 1; i < r - 1; i += 2) {
            for (int l = 1; l <= maxCol; l += 2) {
                if (grid[i][l] == d) {
                    int walls = countWalls(i, l);

                    if (walls >= 2) {
                        openWall(i, l, maxCol);
                    }
                }
            }
        }
    }

    private int countWalls(int rows, int cols) {
        int count = 0;
        if (grid[rows - 1][cols] == w) count++;
        if (grid[rows + 1][cols] == w) count++;
        if (grid[rows][cols - 1] == w) count++;
        if (grid[rows][cols + 1] == w) count++;
        return count;
    }

    private void openWall(int rows, int cols, int maxCol) {
        int[][] motion = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Collections.shuffle(Arrays.asList(motion), rand);
        for (int[] v : motion) {
            int nr = rows + v[0];
            int nc = cols + v[1];
            if (nr > 0 && nr < r - 1 && nc > 0 && nc <= maxCol && grid[nr][nc] == w) {
                grid[nr][nc] = d;
                break;
            }
        }
    }

    private void addBox(int midR, int midC) {
        for (int i = midR - 1; i <= midR + 1; i++) {
            for (int l = midC - 2; l <= midC + 2; l++) {
                grid[i][l] = w;
            }
        }

        grid[midR][midC] = e;
        grid[midR][midC - 2] = g;
        grid[midR][midC - 1] = g;
        grid[midR][midC + 1] = g;
        grid[midR][midC + 2] = g;
        grid[midR - 1][midC] = '-';
    }

    private void addSides(int midR) {
        grid[midR][0] = e;
        grid[midR][1] = e;
        grid[midR][c - 1] = e;
        grid[midR][c - 2] = e;
    }

    private void placeEntities() {
        // Power pellets near the corners
        grid[1][1] = p;
        grid[1][c - 2] = p;
        grid[r - 2][1] = p;
        grid[r - 2][c - 2] = p;

        // Pac-Man starting position near bottom center
        grid[(r / 2) + 5][c / 2] = pm;
        grid[(r / 2) + 5][c / 2 + 1] = d;
        grid[(r / 2) + 6][c / 2] = d;
        grid[(r / 2) + 4][c / 2] = d;
        grid[(r / 2) + 5][c / 2 - 1] = d;
        for (int i = 16; i < r-1; i++)
        {
            for (int l = 2; l < c/2; l++)
            {
                if (grid[i][l] == d && grid[i+1][l+1] == w && grid[i-1][l-1] == w && grid[i-1][l+1] == w && grid[i+1][l-1] == w)
                {
                    grid[i][l] = s;
                    grid[i][c-l-1] = s;
                    if (grid[i+1][l] != w)
                    {
                        grid[i+1][l] = t;
                        grid[i+1][c-l-1] = t;
                    }
                    if (grid[i-1][l] != w)
                    {
                        grid[i-1][l] = t;
                        grid[i-1][c-l-1] = t;
                    }
                    if (grid[i][l+1] != w)
                    {
                        grid[i][l+1] = t;
                        grid[i][c-l+1-1] = t;
                    }
                    if (grid[i][l-1] != w)
                    {
                        grid[i][l-1] = t;
                        grid[i][c-l-1-1] = t;
                    }
                    return;
                }
            }
        }
    }
    private void placeKeys()
    {
        while (!checkKey())
        {
            int row = (int)(Math.random()*28)+1;
            int col = (int)(Math.random()*15)+1;
            if (grid[row][col] == d)
            {
                grid[row][col] = k;
            }
        }
        while (!check2Key())
        {
            int row = (int)(Math.random()*28)+1;
            int col = (int)(Math.random()*15)+16;
            if (grid[row][col] == d)
            {
                grid[row][col] = k;
            }
        }
    }
    public int getR()
    {
        return r;
    }
    public int getC()
    {
        return c;
    }
    private boolean checkKey()
    {
        boolean check = false;
        for (int i = 0; i < r; i++)
        {
            for (int l = 0; l < c/2; l++)
            {
                if (grid[i][l] == k)
                    check = true;
            }
        }
        return check;
    }
    private boolean check2Key()
    {
        boolean check = false;
        for (int i = 0; i < r; i++)
        {
            for (int l = c/2 + 1; l < c-1;l++)
            {
                if (grid[i][l] == k)
                    check = true;
            }
        }
        return check;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < r; i++) {
            for (int l = 0; l < c; l++) {
                str += grid[i][l] + " ";
            }
            str += "\n";
        }
        return str;
    }
}


