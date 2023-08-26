import java.util.*;
import java.lang.Runtime;

class GSA {

    public static void GeneralSearchAlgorithm(Game initial, Game goal, Scanner in, int a) {
        long start, end;

        System.out.println("Which heuristic do you want?");
        System.out.println("1: Summation difference | 2: Manhattan distance");
        int h = in.nextInt();

        Node first = new Node(initial, 0);
        Node node;

        if (a == 1) {
            start = System.currentTimeMillis();
            first.setCost(Greedy.cost(first, goal, h));
            node = Greedy.greedy(first, goal, h);
            end = System.currentTimeMillis();
        }
        else {
            start = System.currentTimeMillis();
            first.setCost(Astar.cost(first, goal, h));
            node = Astar.astar(first, goal, h);
            end = System.currentTimeMillis();
        }
        solution(node, end - start);
    }

    public static void GeneralSearchAlgorithm(Game initial, Game goal, int a) {
        long start, end;
        Node first;
        int depth;
        Stack<Node> s = new Stack<>();
        ArrayList<Node> v = new ArrayList<>();

        switch (a) {
            case 3 -> {
                first = new Node(initial, 0);
                start = System.currentTimeMillis();
                s.add(first);
                v.add(first);
                DFS.dfs(s, first, goal, v);

                while (!s.isEmpty()) {
                    Node node = s.pop();
                    if (goal.isEqual(node.getGame())) {
                        end = System.currentTimeMillis();
                        solution(node, end - start);
                        return;
                    }
                }
                System.out.println("Solution not found");
            }
            case 4 -> {
                depth = 1;
                while (depth < 21) {
                    first = new Node(initial, 0);
                    start = System.currentTimeMillis();
                    s.add(first);
                    v.add(first);
                    IDFS.idfs(s, first, depth, v);

                    while (!s.isEmpty()) {
                        Node node = s.pop();
                        if (goal.isEqual(node.getGame())) {
                            end = System.currentTimeMillis();
                            solution(node, end - start);
                            return;
                        }
                    }
                    depth++;
                }
                System.out.println("Solution not found");
            }
            case 5 -> {
                start = System.currentTimeMillis();
                Node node = BFS.bfs(new Node(initial, 0), goal);
                end = System.currentTimeMillis();
                solution(node, end - start);
            }
            default -> {}
        }
    }

    private static void solution(Node n, long time) {
        int k = n.getDepth() - 1;
        String[] pathFinder = new String[k+1];

        while (n != null) {
            if (n.getPath() != null) pathFinder[k] = n.getPath();

            n = n.getParent();
            k--;
        }

        System.out.println("Solution: ");
        for (String str : pathFinder) System.out.println(str);
        System.out.println("Depth: " + pathFinder.length);
        System.out.println("Time elapsed: " + time + "ms");
        System.out.println("Memory used: "+(Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())/(1000*1000)+"M");
    }
}
