import java.util.*;

class Astar {

    public static Node astar(Node initial, Game goal, int h) {
        ArrayList<Node> v = new ArrayList<>();
        PriorityQueue<Node> q = new PriorityQueue<>();
        Node cur = initial;

        q.add(initial);

        while (!q.isEmpty()) {
            cur = q.poll();

            v.add(cur);

            if (goal.isEqual(cur.getGame())) return cur;


            Node nextu = new Node(cur.getGame().up(), cur, cur.getDepth() + 1, "up");
            if (nextu.notContains(v)) {
                nextu.setCost(cost(nextu, goal, h));
                q.add(nextu);
            }

            Node nextl = new Node(cur.getGame().left(), cur, cur.getDepth() + 1, "left");
            if (nextl.notContains(v)) {
                nextl.setCost(cost(nextl, goal, h));
                q.add(nextl);
            }

            Node nextd = new Node(cur.getGame().down(), cur, cur.getDepth() + 1, "down");
            if (nextd.notContains(v)) {
                nextd.setCost(cost(nextd, goal, h));
                q.add(nextd);
            }

            Node nextr = new Node(cur.getGame().right(), cur, cur.getDepth() + 1, "right");
            if (nextr.notContains(v)) {
                nextr.setCost(cost(nextr, goal, h));
                q.add(nextr);
            }
        }

        return cur;
    }


    public static int cost(Node cur, Game goal, int h) {
        if (cur.getParent() == null)
            return Heuristic.SummationDifferent(cur.getGame(), goal);
        if (h == 1)
            return Math.max(cost(cur.getParent(), goal, h), cur.getDepth() + Heuristic.SummationDifferent(cur.getGame(), goal));

        return Math.max(cost(cur.getParent(), goal, h), cur.getDepth() + Heuristic.ManhattanDistance(cur.getGame(), goal));
    }
}