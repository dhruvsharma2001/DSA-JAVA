import java.util.*;
public class kahnsalgo {
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
//----------------INDEGREE---------------------------------
    public static void calcindeg(ArrayList<edge>[] graph, int indeg[]){
        for(int i=0;i<graph.length;i++){
            int v =i;
            for(int j=0;j<graph[v].size();j++){
                edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
    }
}

//---------------TOPOLOGICAL SORT-----------------------------
    public static void topsort(ArrayList<edge>[] graph){
        int indeg[] = new int[graph.length];
        calcindeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<indeg.length;i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        //bfs

        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+" "); //topologicsl sort print

            for(int i=0;i<graph[curr].size();i++){
                edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest] == 0){
                    q.add(e.dest);
                }
            }

        }
        System.out.println();
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
