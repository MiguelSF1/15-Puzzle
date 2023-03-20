import java.util.*;

class BFS {

    public static Node bfs(Node initial, Game goal) {
        Deque<Node> q = new LinkedList<>();
        ArrayList<Node> v = new ArrayList<>();

        q.add(initial);
        v.add(initial);

        while (true) {
            Node cur = q.removeFirst();

            if (goal.isEqual(cur.getGame())) {
                return cur;
            }

            Node nextu = new Node(cur.getGame().up(), cur, cur.getDepth() + 1, "up");
            if (!nextu.contains(v)) {
                q.add(nextu);
                v.add(nextu);
            }

            Node nextd = new Node(cur.getGame().down(), cur, cur.getDepth() + 1, "down");
            if (!nextd.contains(v)) {
                q.add(nextd);
                v.add(nextd);
            }

            Node nextl = new Node(cur.getGame().left(), cur, cur.getDepth() + 1, "left");
            if (!nextl.contains(v)) {
                q.add(nextl);
                v.add(nextl);
            }
            Node nextr = new Node(cur.getGame().right(), cur, cur.getDepth() + 1, "right");
            if (!nextr.contains(v)) {
                q.add(nextr);
                v.add(nextr);
            }

        }
    }
}