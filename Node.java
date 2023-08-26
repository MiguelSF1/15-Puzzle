import java.util.List;

public class Node implements Comparable<Node> {
    private final Game board;
    private final Node parent;
    private final int depth;
    private int cost;
    private final String path;

    Node(Game init, int depth) {
        this.board = init;
        this.parent = null;
        this.depth = depth;
        this.cost = 0;
        this.path = null;
    }

    Node(Game board, Node parent, int depth, String path) {
        this.board = board;
        this.parent = parent;
        this.depth = depth;
        this.cost = 0;
        this.path = path;
    }

    public Game getGame() { return board;}
    public Node getParent() { return parent;}
    public int getDepth() { return depth;}
    public String getPath() { return path;}

    public int getCost() { return cost;}

    public void setCost(int cost) { this.cost = cost;}

    public boolean notContains(List<Node> list) {
        for (Node n : list)
            if (n.getGame().isEqual(this.getGame())) return false;

        return true;
    }

    @Override
    public int compareTo(Node o) {
        return cost - o.getCost();
    }
}