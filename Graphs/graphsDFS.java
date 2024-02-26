import java.util.*;

// USING ARRAY OF ARRAYLIST

public class graphsDFS {
    int v;
    private ArrayList<Integer> ar[];

    @SuppressWarnings("unchecked")
    graphsDFS(int v)
    {
        this.v=v;
        ar = new ArrayList[v];
        for(int i=0;i<v;i++)
            ar[i]=new ArrayList<Integer>();
    }
    public void add(int n,int e)
    {
        ar[n].add(e);
    }
    public void DFS(int n)
    {
        Stack<Integer> st = new Stack<Integer>();
        boolean[] b= new boolean[v];
        st.push(n);
        b[n]=true;
        // System.out.print(n+" ");
        while (!st.isEmpty()) {
            int s =st.pop();
            for(int i=0;i<ar[s].size();i++)
            {
                if(!b[ar[s].get(i)])
                {
                    st.push(ar[s].get(i));
                    b[ar[s].get(i)]=true;
                }
            }
            System.out.print(s+" ");
        }
//           RECURSIVE

//  public void dfs(int s,boolean brr[])
//     {
//         brr[s]=true;
//         System.out.print(s+" ");
//         for(int i=0;i<al.get(s).size();i++)
//         {
//             if(!brr[al.get(s).get(i)])
//             {
//                 brr[al.get(s).get(i)]=true;
//                 dfs(al.get(s).get(i),brr);
//             }
//         }
//     }
    }
    public static void main(String[] args) {
        graphsDFS g = new graphsDFS(5);
        g.add(0,1);
        g.add(0,2);
        g.add(1,2);
        g.add(2,0);
        g.add(2,3);
        g.add(3,3);
        g.DFS(2);
    }
}

