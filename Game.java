class Game {
    public int[][] game = new int[4][4];
    public int x = 0, y = 0;

    Game(int[][] board) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                game[i][j] = board[i][j];
                if (game[i][j] == 0) {
                    x = i;
                    y = j;
                }
            }
        }
    }

    public Game up() {
        int[][] m = new int[4][4];
        if (x != 0) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    m[i][j] = game[i][j];
                }
            }
            int t = game[x - 1][y];
            m[x - 1][y] = 0;
            m[x][y] = t;
            Game r = new Game(m);
            return r;
        }
        return this;
    }

    public Game down() {
        int[][] m = new int[4][4];
        if (x != 3) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    m[i][j] = game[i][j];
                }
            }
            int t = game[x + 1][y];
            m[x + 1][y] = 0;
            m[x][y] = t;
            Game r = new Game(m);
            return r;
        }
        return this;
    }

    public Game left() {
        int[][] m = new int[4][4];
        if (y != 0) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    m[i][j] = game[i][j];
                }
            }
            int t = game[x][y - 1];
            m[x][y - 1] = 0;
            m[x][y] = t;
            Game r = new Game(m);
            return r;
        }
        return this;
    }

    public Game right() {
        int[][] m = new int[4][4];
        if (y != 3) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    m[i][j] = game[i][j];
                }
            }
            int t = game[x][y + 1];
            m[x][y + 1] = 0;
            m[x][y] = t;
            Game r = new Game(m);
            return r;
        }
        return this;
    }

    public int inverse(int[][] m) {
        int flat[] = new int[16];
        int c = 0;
        int inv = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                flat[c] = m[i][j];
                c++;
            }
        }
        for (int i = 0; i < 16; i++) {
            for (int j = i + 1; j < 16; j++) {
                if (flat[i] > flat[j] && flat[i] != 0 && flat[j] != 0) {
                    inv++;
                }
            }
        }
        return inv;
    }

    public boolean solvable(Game fin) {
        boolean s1 = (inverse(game) % 2 == 0) == (x % 2 == 1);
        boolean s2 = (inverse(fin.game) % 2 == 0) == (fin.x % 2 == 1);
        if (s1 == s2) {
            return true;
        }
        return false;
    }

    public boolean isEqual(Game comp) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (this.game[i][j] != comp.game[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void myToString() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(game[i][j] + " ");
            }
            System.out.println();
        }

    }
}