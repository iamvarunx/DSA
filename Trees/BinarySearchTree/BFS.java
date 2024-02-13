import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static Node root=null;
    public class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
        
    }

    public Node add(int val)
    {
        return add2(root,val);
    }
    public Node add2(Node root,int val)
    {
        if(root==null)
        return new Node(val); 
         
        if(root.data<val)
        root.right=add2(root.right,val);
        else
        root.left=add2(root.left,val);

        return root;
    }
    //BFS
    //LEVEL ORDER TRAVERSAL
    public ArrayList<ArrayList<Integer>> bfs(Node root){
        ArrayList<ArrayList<Integer>> ans= new ArrayList<>();
        if(root==null)
        return ans;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            ArrayList<Integer> a = new ArrayList<>();
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                Node s = q.poll();
                if(s.left!=null)
                q.add(s.left);
                if(s.right!=null)
                q.add(s.right);
                
                a.add(s.data);
            }
            ans.add(a);
        }

        return ans; 
    }
    public static void main(String[] args)
    {
        BFS b= new BFS();
        root = b.add(4);
        b.add(1);
        b.add(2);
        b.add(8);
        b.add(15);
        b.add(6);
        b.add(10);
        b.add(16);
        b.add(17);
        ArrayList<ArrayList<Integer>> list = b.bfs(root);
        System.out.println(list);
    }
}