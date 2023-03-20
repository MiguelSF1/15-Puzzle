import java.util.*;

class Greedy {
    
    public static Node greedy(Node initial, Game goal, int h) {
        ArrayList<Node> v = new ArrayList<>();
        PriorityQueue<Node> q = new PriorityQueue<>();
        Node cur = initial;

        q.add(initial);

        while (q.size() > 0) {
            cur = q.poll();
            v.add(cur);

            if (cur.getCost() == 0) {
                return cur;
            }

            Node nextu = new Node(cur.getGame().up(), cur, cur.getDepth() + 1, "up");

            if (!nextu.contains(v)) {

                nextu.setCost(cost(nextu, goal, h));
                q.add(nextu);
            }

            Node nextl = new Node(cur.getGame().left(), cur, cur.getDepth() + 1, "left");
            if (!nextl.contains(v)) {

                nextl.setCost(cost(nextl, goal, h));
                q.add(nextl);
            }
            Node nextd = new Node(cur.getGame().down(), cur, cur.getDepth() + 1, "down");
            if (!nextd.contains(v)) {

                nextd.setCost(cost(nextd, goal, h));
                q.add(nextd);
            }
            Node nextr = new Node(cur.getGame().right(), cur, cur.getDepth() + 1,
                    "right");
            if (!nextr.contains(v)) {

                nextr.setCost(cost(nextr, goal, h));
                q.add(nextr);
            }

        }
        return cur;
    }



    public static int cost(Node cur, Game goal, int h) {
        if (cur == null)
            return 0;
        if (h == 1)
            return Heuristic.SummationDifferent(cur.getGame(), goal);
        else
            return Heuristic.ManhattanDistance(cur.getGame(), goal);
    }
}