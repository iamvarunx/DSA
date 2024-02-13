
public class BST {
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
    public void display(Node root)
    {
        if(root!=null)
        {
            display(root.left);
            System.out.print(root.data+" ");
            display(root.right);
        }
    }
    public Node delete(Node root,int val)
    {
        if(root==null)
        return root;
        if(root.data==val)
        {
            if(root.left==null&&root.right==null)
            return null;
            else if(root.left!=null&&root.right==null)
            return root.left;
            else if(root.left==null&&root.right!=null)
            return root.right;
            else{
                Node temp = root.right;
                while(temp.left!=null)
                    temp = temp.left;

                root.data=temp.data;
                root.right = delete(root.right,temp.data);    
            }
        }
        else if(root.data<val){
            root.right = delete(root.right, val);
        }
        else if(root.data>val)
        {
            root.left=delete(root.left, val);
        }
        return root;
    }
    public static void main(String[] args)
    {
        BST b = new BST();
        root = b.add(4);
        b.add(1);
        b.add(2);
        b.add(8);
        b.add(15);
        b.add(6);
        b.add(10);
        b.add(16);
        b.add(17);
        b.display(root);
        b.delete(root, 4);
        System.out.println();
        b.display(root);
    }
}
