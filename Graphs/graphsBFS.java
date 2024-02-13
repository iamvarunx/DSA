import java.util.*;

public class graphsBFS{
     int v;
    private static ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
 
    graphsBFS(int v)
    {
        this.v=v;
        for(int i=0;i<v;i++)
        ar.add(new ArrayList<Integer>());
    }
    public void add(int n,int e)
    {
     ar.get(n).add(e);
    }
    public void BFS(int n)
    {
        Queue<Integer> q = new LinkedList<>();
        boolean b[] = new boolean[v];
        b[n]=true;
        q.add(n);
        System.out.print(n+" ");
        while (!q.isEmpty()) {
            int s=q.poll();
            
            for(int i=0;i<ar.get(s).size();i++)
            {   
                if(!b[ar.get(s).get(i)])
                {
                    q.add(ar.get(s).get(i));
                    b[ar.get(s).get(i)]=true;
                    System.out.print(ar.get(s).get(i)+" ");
                }
            }
        }

    }

    public static void main(String[] args) {
        graphsBFS g = new graphsBFS(5);
        g.add(0,1);
        g.add(0,2);
        g.add(1,2);
        g.add(2,0);
        g.add(2,3);
        g.add(3,3);
        g.BFS(0);
    }
}