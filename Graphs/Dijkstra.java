import java.util.*;
public class Dijkstra {
//---------------EDGE CLASS-------------------
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
//--------------CREATE GRAPH--------------------
static void creategaph(ArrayList<edge> graph []){
    for(int i=0;i<graph.length;i++){
        graph[i] = new ArrayList<>();
    }
    graph[0].add(new edge(0, 1, 2));
    graph[0].add(new edge(0, 2, 4));

    graph[1].add(new edge(1, 3, 7));
    graph[1].add(new edge(1, 2, 1));

    graph[2].add(new edge(2, 4, 3));

    graph[3].add(new edge(3, 5, 1));

    graph[4].add(new edge(4, 3, 2));
    graph[4].add(new edge(4, 5, 5));

}

static class Pair implements Comparable<Pair> {
    int n; //node
    int path;

    public Pair(int n, int path){
        this.n = n;
        this.path = path;
    }

    @Override
    public int compareTo(Pair p2){
        return this.path - p2.path; //path based sorting for my pairs
    }
}

public static void dijkstraAlgo(ArrayList<edge>[] graph, int src){
    int dist[] = new int[graph.length]; //dis[i] -> src to i
    for(int i=0; i<graph.length;i++){
        if(i !=src){
            dist[i] = Integer.MAX_VALUE; // +infinity

        }
    }
    boolean vis[] = new boolean[graph.length];
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    pq.add(new Pair(src, 0));

    //loop
    while(!pq.isEmpty()){
        Pair curr = pq.remove();

        if(!vis[curr.n]){
            vis[curr.n] = true;
            //neighbours
            for(int i=0; i<graph[curr.n].size();i++){ //curr = pair value // curr.n = index
                edge e = graph[curr.n].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if(dist[u]+wt < dist[v]){ //update distance
                    dist[v] = dist[u] + wt;
                    pq.add(new Pair(v, dist[v]));

                }

            }
        }
    }
    //print all source to vertices shortest path
    for(int i=0; i<dist.length;i++){
        System.out.print(dist[i] +" ");
    }
    System.out.println();
}
//----------------MAIN CLASS----------------------------------
public static void main(String args[]){
       
    int V=6;

    //int arr[] = new arr[V];
    ArrayList<edge>[] graph= new ArrayList[V]; //null -> empty arraylist
    creategaph(graph);

    int src = 0;
    dijkstraAlgo(graph, src);
    
    
}
}
