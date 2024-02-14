import java.util.*;
public class graphsWG {
    
    static class Data {
        int val;
        ArrayList<Integer> d = new ArrayList<>();
    
        Data(int v, int e) {
            this.val = v;
            this.d.add(e);
        }
    }
        int v;
        private ArrayList<ArrayList<Data>> ar;

        graphsWG(int v) {
            this.v = v;
            ar = new ArrayList<>(v);
            for (int i = 0; i < v; i++) {
                ar.add(new ArrayList<>());
            }
        }

        public void add(int n, int e, int val) {
            Data d = new Data(val, e);
            ar.get(n).add(d);
        }
        public void dip()
        {
            System.out.println(ar);
            for(int i=0;i<=5;i++)
            {
                int s =ar.get(i).size();
                for(int j=0;j<s;j++)
                {
                    System.out.println(ar.get(i).get(j).val+" "+ar.get(i).get(j).d+" "+i);
                } 
            }
            // .val+" "+ar.get(i).d);
        }
    public static void main(String[] args) {
        graphsWG g = new graphsWG(5+1);
        g.add(1,2,3);
        g.add(1,3,4);
        g.add(2,4,5);
        g.add(3,4,8);
        g.add(4,5,1);
        int src=1;
        int des=1;
        g.dip();
    }
}