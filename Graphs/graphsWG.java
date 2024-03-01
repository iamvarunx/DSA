//5
//5
//1 2 5
//2 4 5
//1 3 4
//3 4 4
//4 5 1

//1 5

//OUTPUT - 9

import java.util.*;
public class graphsWG{
    public static ArrayList<ArrayList<Node>> ar = new ArrayList<>();
    public static int minWeight =Integer.MAX_VALUE;
    public int v;
    static class Node{
        int d;
        int w;
        public  Node(int d,int w)
        {
            this.d=d;
            this.w=w;
        }
    }
    public  graphsWG(int v)
    {
        this.v=v;
        for(int i=0;i<v;i++)
        ar.add(new ArrayList<Node>());
    }
    public static void add(int s,int d,int w)
    {
        ar.get(s).add(new Node(d,w));
    }
    public static boolean dfs(int sr,int des,boolean[] vis,int weight)
    {
        if(sr==des)
        {
            minWeight  = Math.min(minWeight,weight);
            return false;
        }
           vis[sr]=true;
           for(int i=0;i<ar.get(sr).size();i++)
           {
               if(!vis[ar.get(sr).get(i).d])
               {
                    if(dfs(ar.get(sr).get(i).d,des,vis,weight+ar.get(sr).get(i).w))
                    return true;
               }
           }
           vis[sr]=false;
           return false;
    }
    @SuppressWarnings({ "static-access", "resource" })
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        graphsWG g = new graphsWG(v);
        for(int i=0;i<e;i++)
        g.add(sc.nextInt(),sc.nextInt(),sc.nextInt());
        int source =sc.nextInt();
        int des =sc.nextInt();
        boolean[] vis = new boolean[v+1];
        g.dfs(source,des,vis,0);
        System.out.print(minWeight);
    }
}