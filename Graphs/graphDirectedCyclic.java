
//INPUT FOR CYCLIC GRAPH DETECTION IN DIRECTED GRAPH
    // 4
    // 6
    // 0 1
    // 0 2
    // 1 2
    // 2 0
    // 2 3
    // 3 3
    //OUTPUT _-TRUE;
import java.util.*;
public class graphDirectedCyclic{
    private static ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
    public  int v;
    
    public graphDirectedCyclic(int v){
        this.v=v;
        for(int i=0;i<v;i++)
        ar.add(new ArrayList<Integer>());
    }
    public void add(int n,int e)
    {
        ar.get(n).add(e);
    }
    public static boolean dfs(int s,boolean[] visited,boolean[] path)
    {
        visited[s]=true;
        path[s]=true;
        for(int i=0;i<ar.get(s).size();i++)
        {
            if(!visited[ar.get(s).get(i)]){
            if(dfs(ar.get(s).get(i),visited,path))
            return true;
            }
            else if(path[ar.get(s).get(i)])
            {
                return true;
            }
        }
        path[s]=false;
        return false;
    }
 

    @SuppressWarnings("resource")
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        graphDirectedCyclic g =new graphDirectedCyclic(n);
        int m=sc.nextInt();
        for(int i=0;i<m;i++)
        g.add(sc.nextInt(),sc.nextInt());
        boolean visited[] = new boolean[n+1];
        boolean path[] = new boolean[n+1];
       for(int i=0;i<n;i++)
       {
           if(!visited[i]){
           if(dfs(i,visited,path)){
                System.out.print("true");
                return;
           }
           }
       }
        System.out.print("false");
    }
}