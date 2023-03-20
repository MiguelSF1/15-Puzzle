import java.util.*;

public class Game15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] s = new int[4][4];
        System.out.println("Initial state: ");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                s[i][j] = in.nextInt();
            }
        }

        Game initial = new Game(s);
        int[][] g = new int[4][4];
        System.out.println("Final state: ");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                g[i][j] = in.nextInt();
            }
        }

        Game goal = new Game(g);
        if (!(initial.solvable(goal))) {
            System.out.println("It's impossible to give a solution");
            in.close();
            return;
        }

        System.out.println("Which algorithm do you want?");
        System.out.println("1: A* | 2: Greedy | 3: DFS | 4: IDDFS | 5: BFS");
        int opt = in.nextInt();
        switch(opt) {
            case 1: GSA.GeneralSearchAlgorithm(initial, goal, in, opt);
            break;
            case 2: GSA.GeneralSearchAlgorithm(initial, goal, in, opt);
            break;
            case 3: GSA.GeneralSearchAlgorithm(initial, goal, opt);
            break;
            case 4: GSA.GeneralSearchAlgorithm(initial, goal, opt);
            break;
            case 5: GSA.GeneralSearchAlgorithm(initial, goal, opt);
            break; 

            default: break;
        }
    }
}
