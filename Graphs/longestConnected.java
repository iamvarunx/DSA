// 7
// 5
// 1 2 
// 2 3
// 4 5
// 5 6
// 5 7
// OUTPUT - 4
//largest island among connected componenet --- DIRECTED GRAPH
import java.util.*;
public class longestConnected{
    private static ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
    public static int v;
    public longestConnected(int v)
    {
        this.v=v;
        for(int i=0;i<=v;i++)
        ar.add(new ArrayList<Integer>());
    }
    public static void add(int n,int e)
    {
        ar.get(n).add(e);
    }
    public static int dfs(int s,boolean[] visited)
    {
        int count = 1;
        visited[s]=true;
        for(int i=0;i<ar.get(s).size();i++)
        {
            if(!visited[ar.get(s).get(i)])
            {
                count += dfs(ar.get(s).get(i),visited);
                
            }
        }
        return count;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        longestConnected g = new longestConnected(n);
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        int m=sc.nextInt();
        for(int i=0;i<m;i++)
        {
            int a =sc.nextInt();
            int b =sc.nextInt();
            set.add(a);
            set.add(b);
            g.add(a,b);
        }
        boolean visited[] = new boolean[v+1];
        int max=0;
        for(Integer i:set)
        {
            if(!visited[i])
            {
                max = Math.max(dfs(i,visited),max);
            }
        }
        System.out.print(max);
    }
}