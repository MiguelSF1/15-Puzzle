import java.util.*;

class IDFS {

    public static void idfs(Stack<Node> s, Node cur, int depth, List<Node> v) {
        if (cur.getDepth() == depth)
            return;

        Node nextu = new Node(cur.getGame().up(), cur, cur.getDepth() + 1, "up");
        if (!nextu.contains(v)) {
            s.add(nextu);
            v.add(nextu);
            idfs(s, nextu, depth, v);
            v.remove(nextu);
        }

        Node nextl = new Node(cur.getGame().left(), cur, cur.getDepth() + 1, "left");
        if (!nextl.contains(v)) {
            s.add(nextl);
            v.add(nextl);
            idfs(s, nextl, depth, v);
            v.remove(nextl);
        }

        Node nextd = new Node(cur.getGame().down(), cur, cur.getDepth() + 1, "down");
        if (!nextd.contains(v)) {
            s.add(nextd);
            v.add(nextd);
            idfs(s, nextd, depth, v);
            v.remove(nextd);
        }

        Node nextr = new Node(cur.getGame().right(), cur, cur.getDepth() + 1, "right");
        if (!nextr.contains(v)) {
            s.add(nextr);
            v.add(nextr);
            idfs(s, nextr, depth, v);
            v.remove(nextr);

        }
    }
}