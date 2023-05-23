import java.util.*;
public class cycledetection {
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

        graph[0].add(new edge(0, 1));
        //graph[0].add(new edge(0, 2));
        graph[0].add(new edge(0, 3));

        graph[1].add(new edge(1, 0));
        graph[1].add(new edge(1, 2));

        //graph[2].add(new edge(2, 0));
        graph[2].add(new edge(2, 1));

        graph[3].add(new edge(3, 0));
        graph[3].add(new edge(3, 4));

        graph[4].add(new edge(4, 3));
    }

//----------------CYCLE DETECTION----------------------------

public static boolean detectcycle(ArrayList<edge>[] graph){
    boolean vis[] = new boolean [graph.length];
    for(int i=0;i<graph.length;i++){
        if(!vis[i]){
            if(detectcycleutil(graph, vis, i, -1)){
                return true;
                //cycle exist in one of the parts
            }
        }
    }
    return false;
}

//----------------DETECTCYCLE UTIL---------------------------

public static boolean detectcycleutil(ArrayList<edge>[] graph, boolean vis[], int curr, int par){
    vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            edge e = graph[curr].get(i);

            //case 3
            if(!vis[e.dest]){
                if(detectcycleutil(graph, vis, e.dest, curr)){
                    return true;
                }
            }

            //case 1
            else if(vis[e.dest] && e.dest != par){
                return true;
            }

            //case 2 do nothing

        }
        return false;
}

//----------------MAIN CLASS----------------------------------
    public static void main(String args[]){
        int V=5;

        //int arr[] = new arr[V];
        ArrayList<edge>[] graph= new ArrayList[V]; //null -> empty arraylist
        creategaph(graph);

        System.out.println(detectcycle(graph));
        
    }
}
