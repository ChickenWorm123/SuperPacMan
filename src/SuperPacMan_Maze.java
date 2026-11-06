public class SuperPacMan_Maze {
    private int x;
    private int y;
    private int[][] grid;
    public void maze() {
        grid = new int[28][31];
        for (int i = 0; i < grid.length; i++)
        {
            for (int l = 0; l < grid[0].length; l++)
            {
                if (i == 0 || i == grid.length-1)
                {
                    grid[i][l] = 1;
                }
                else
                    grid[i][l] = 0;
            }
        }
    }
}
