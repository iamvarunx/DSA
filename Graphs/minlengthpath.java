//5
//6
//1 2
//1 3
//1 4
//2 4
//3 4
//4 5

//1 5

//OUTPUT - 2
import java.util.*;
public class minlengthpath{
    private static ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
    public static int v;
    public static int min=Integer.MAX_VALUE;
    public minlengthpath(int v)
    {
        this.v =v;
        for(int i=0;i<=v;i++)
        ar.add(new ArrayList<Integer>());
    }
    public static void add(int n,int e)
    {
        ar.get(n).add(e);
    }
    public static void dfs(int s,int d,boolean vis[],int count)
    {
        if(s==d)
        {
            min=Math.min(min,count);
            return;
        }
        vis[s]=true;
        for(int i=0;i<ar.get(s).size();i++)
        {
            if(!vis[ar.get(s).get(i)])
            {
                dfs(ar.get(s).get(i),d,vis,count+1);
            }
        }
        vis[s]=false;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        minlengthpath g = new minlengthpath(n);
        int m=sc.nextInt();
        for(int i=0;i<m;i++)
        {
            g.add(sc.nextInt(),sc.nextInt());
        }
        int s=sc.nextInt();
        int d=sc.nextInt();
        boolean vis[] = new boolean[n+1];
        dfs(s,d,vis,0);
        if(min==Integer.MAX_VALUE)
            System.out.print(0);
        else
        System.out.print(min);
    }
}