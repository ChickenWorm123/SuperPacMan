public class SuperPacMan_Maze {
    private int[][] grid;
    public void maze()
    {
        grid = new int[28][31];
        for (int i = 0; i < 28; i++)
        {
            for (int l = 0; l < 31; l++)
            {
                if (i==0 || i == 27 || l == 0 || l == 30)
                {
                    if (i == 14)
                    {
                        grid[i][l] = 1;
                    }
                    else
                        grid[i][l] = 0;
                }
                else
                    grid[i][l] = 1;
            }
        }
    }
    public void box()
    {
        for(int i  = 11; i < 16; i++)
        {
            for (int l = 11; l < 19; l++)
            {
                if (i == 11 || i == 15 || l == 11 || l == 18)
                {
                    if (l == 14 || l == 15)
                    {
                        grid[i][l] = 2;
                    }
                    else
                        grid[i][l] = 0;
                }
                else
                    grid[i][l] = 2;
            }
        }
    }

    public String toString() {
        String s = "";
        for (int[] r : grid) {
            for (int c : r)
                s += c + " ";
            s += "\n";
        }
        return s;
    }
}
