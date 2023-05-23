import java.util.*;
public class toposorting {
     //---------------EDGE CLASS-------------------
     static class edge{
        int src;
        int dest;
        
        public edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
//--------------CREATE GRAPH--------------------
    static void creategaph(ArrayList<edge> graph []){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new edge(2, 3));

        graph[3].add(new edge(3, 1));

        graph[4].add(new edge(4, 0));
        graph[4].add(new edge(4, 1));

        graph[5].add(new edge(5, 0));
        graph[5].add(new edge(5, 2));

    }

    public static void topsort(ArrayList<edge>[] graph){
        boolean vis[] = new boolean [graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                topsortutil(graph, i, vis, s);

            }
        }
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");

        }
    }

    public static void topsortutil(ArrayList<edge>[] graph, int curr, boolean vis[], Stack<Integer> s){
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            edge e = graph[curr].get(i);

            if(!vis[e.dest] ){
                topsortutil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

     //----------------MAIN CLASS----------------------------------
     public static void main(String args[]){
       
        int V=6;

        //int arr[] = new arr[V];
        ArrayList<edge>[] graph= new ArrayList[V]; //null -> empty arraylist
        creategaph(graph);

         topsort(graph);
        
    }
}
