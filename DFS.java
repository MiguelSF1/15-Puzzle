import java.util.*;

class DFS {
    private static final int md = 20;

    public static void dfs(Stack<Node> s, Node cur, Game goal, List<Node> v) {
        if (goal.isEqual(cur.getGame())) return;

        if (cur.getDepth() == md) return;

        Node nextu = new Node(cur.getGame().up(), cur, cur.getDepth() + 1, "up");
        if (nextu.notContains(v)) {
            s.add(nextu);
            v.add(nextu);
            dfs(s, nextu, goal, v);
            v.remove(nextu);
        }

        Node nextl = new Node(cur.getGame().left(), cur, cur.getDepth() + 1, "left");
        if (nextl.notContains(v)) {
            s.add(nextl);
            v.add(nextl);
            dfs(s, nextl, goal, v);
            v.remove(nextl);
        }

        Node nextd = new Node(cur.getGame().down(), cur, cur.getDepth() + 1, "down");
        if (nextd.notContains(v)) {
            s.add(nextd);
            v.add(nextd);
            dfs(s, nextd, goal, v);
            v.remove(nextd);
        }

        Node nextr = new Node(cur.getGame().right(), cur, cur.getDepth() + 1, "right");
        if (nextr.notContains(v)) {
            s.add(nextr);
            v.add(nextr);
            dfs(s, nextr, goal, v);
            v.remove(nextr);

        }
    }
}