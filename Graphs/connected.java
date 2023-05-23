import java.util.*;
public class connected {
    static class edge{
        int src;
        int dest;
        int wt;

        public edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void creategaph(ArrayList<edge> graph []){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new edge(0, 1, 1));
        graph[0].add(new edge(0, 2, 1));

        graph[1].add(new edge(1, 0, 1));
        graph[1].add(new edge(1, 3, 1));

        graph[2].add(new edge(2, 0, 1));
        graph[2].add(new edge(2, 4, 1));

        graph[3].add(new edge(3, 1, 1));
        graph[3].add(new edge(3, 4, 1));
        graph[3].add(new edge(3, 5, 1));

        graph[4].add(new edge(4, 2, 1));
        graph[4].add(new edge(4, 3, 1));
        graph[4].add(new edge(4, 5, 1));

        graph[5].add(new edge(5, 3, 1));
        graph[5].add(new edge(5, 4, 1));
        graph[5].add(new edge(5, 6, 1));

        graph[5].add(new edge(6, 5, 1));
    }
    public static void Breadthfs(ArrayList<edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                Breadthfsutil(graph, vis);
            }
        }

    }

    public static void Breadthfsutil(ArrayList<edge>[] graph, boolean vis[]){ //O(V+E)
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0);//source = 0

        while(!q.isEmpty()){
            int curr = q.remove();

            if(!vis[curr]){ //visit curr
                System.out.print(curr + " ");
                vis[curr] = true;
                for(int i=0;i<graph[curr].size();i++){
                    edge e = graph[curr].get(i);
                    q.add(e.dest);
                }

            }
        }
    }
    public static void dfs(ArrayList<edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            
                dfsutil(graph, i, vis);
            }
        }

    public static void dfsutil(ArrayList<edge>[] graph, int curr, boolean vis[]){
        //visit
        System.out.print(curr + " ");
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfsutil(graph, e.dest, vis);
            }

        }

    }

    public static void main(String args[]){
        int V=7;

        //int arr[] = new arr[V];
        ArrayList<edge>[] graph= new ArrayList[V]; //null -> empty arraylist
        creategaph(graph);
        
        

    }
}
