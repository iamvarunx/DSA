
// Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
// Output: true
// Explanation: There are two paths from vertex 0 to vertex 2:
// - 0 → 1 → 2
// - 0 → 2
import java.util.*;
class graph {
    int v;
    public ArrayList<ArrayList<Integer>> ar = new ArrayList<>();

    graph(int v) {
        this.v = v;
        for (int i = 0; i < v; i++)
            ar.add(new ArrayList<Integer>());
    }

    public void add(int n, int e) {
        ar.get(n).add(e);
        ar.get(e).add(n);
    }

    public boolean path(int s, int d, int n) {
        boolean b[] = new boolean[n];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(s);
        b[s] = true;
        while (!stack.isEmpty()) {
            int st = stack.pop();
            for (int i = 0; i < ar.get(st).size(); i++) {
                if (!b[ar.get(st).get(i)]) {
                    stack.push(ar.get(st).get(i));
                    b[ar.get(st).get(i)] = true;

                }
            }
        }
        return b[d];
    }
}

class Solution {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        graph g = new graph(n);
        for (int i = 0; i < edges.length; i++) {
            g.add(edges[i][0], edges[i][1]);
        }
        return g.path(source, destination, n);
    }
}