package Graph;

import java.util.LinkedList;
import java.util.Queue;

//level order traversal of the graph
public class BFS {

    private LinkedList<Integer>[] adj;
    private int E;
    private int V;

    public BFS(int nodes){
        this.V = nodes;
        this.E = 0;
        this.adj = new LinkedList[nodes];
        for(int v = 0; v < V; v++){
            adj[v] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v){
        adj[u].add(v);
        adj[v].add(u);
        E++;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(V + " Vertices, " + E + " Edges " + "\n");
        for(int v =0; v < V; v++){
            stringBuilder.append((v + ": "));
            for(int w: adj[v]){
                stringBuilder.append(w+" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    //Level Order Traversal
    public void bfs_search(int s){
        boolean[] visited = new boolean[V];

        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.offer(s);

        while(!queue.isEmpty()){
            int u = queue.poll();
            System.out.println(u+" ");

            for(int v: adj[u]){
                if(!visited[v]){
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS graph = new BFS(5);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,0);
        graph.addEdge(2,4);
        graph.bfs_search(0);

    }
}
