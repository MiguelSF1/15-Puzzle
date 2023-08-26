class Heuristic {
    
    public static int SummationDifferent(Game initial, Game goal) {
        int sum = 0;

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                if (initial.game[i][j] != goal.game[i][j]) sum++;

        return sum;
    }

    public static int ManhattanDistance(Game initial, Game goal) {
        int sum = 0;

        for (int i1 = 0; i1 < 4; i1++)
            for (int j1 = 0; j1 < 4; j1++)
                for (int i2 = 0; i2 < 4; i2++)
                    for (int j2 = 0; j2 < 4; j2++)
                        if (initial.game[i1][j1] == goal.game[i2][j2])
                            sum += Math.abs(i1 - i2) + Math.abs(j1 - j2);

        return sum;
    }
}
