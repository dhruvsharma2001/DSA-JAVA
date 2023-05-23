import java.util.*;
public class bfs {
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
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];
        q.add(0);//source = 0

        while(!q.isEmpty()){
            int curr = q.remove();

            if(!visited[curr]){ //visit curr
                System.out.print(curr + " ");
                visited[curr] = true;
                for(int i=0;i<graph[curr].size();i++){
                    edge e = graph[curr].get(i);
                    q.add(e.dest);
                }

            }
        }
    }

    public static void dfs(ArrayList<edge>[] graph, int curr, boolean vis[]){
        //visit
        System.out.print(curr + " ");
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }

        }

    }

    public static boolean hasPath(ArrayList<edge>[] graph, int src, int dest, boolean vis[]){
        if(src == dest){
            return true;
        }
        vis[src] = true;
        for(int i=0;i<graph[src].size();i++){
            edge e = graph[src].get(i);
            //e.dest = neighbour
            if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)){
                return true;
            }

        }

        return false;
    }

    public static void main(String args[]){
        int V=7;

        //int arr[] = new arr[V];
        ArrayList<edge>[] graph= new ArrayList[V]; //null -> empty arraylist
        creategaph(graph);
        
        System.out.println(hasPath(graph, 0, 5, new boolean[V]));

    }
}
