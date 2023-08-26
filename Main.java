import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[][] s = new int[4][4];
        System.out.println("Initial state: ");

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                s[i][j] = in.nextInt();

        Game initial = new Game(s);
        int[][] g = new int[4][4];
        System.out.println("Final state: ");

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                g[i][j] = in.nextInt();

        Game goal = new Game(g);

        if (!(initial.solvable(goal))) {
            System.out.println("It's impossible to give a solution");
            in.close();
            return;
        }

        System.out.println("Which algorithm do you want?");
        System.out.println("1: A* | 2: Greedy | 3: DFS | 4: IDFS | 5: BFS");
        int opt = in.nextInt();

        if (opt == 1 || opt == 2) GSA.GeneralSearchAlgorithm(initial, goal, in, opt);
        else GSA.GeneralSearchAlgorithm(initial, goal, opt);

        in.close();
    }
}
