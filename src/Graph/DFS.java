package Graph;

import java.util.*;

public class DFS {

        private Map<Integer, List<Integer>> graph = new HashMap<>();
        private Set<Integer> visited = new HashSet<>();

        // Add edge
        public void addEdge(int u, int v) {
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u); // undirected
        }

        // DFS recursive
        public void dfs(int node) {
            if (visited.contains(node)) return;

            visited.add(node);
            System.out.print(node + " "); // process node

            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                dfs(neighbor);
            }
        }

        public static void main(String[] args) {
            DFS dfs = new DFS();

            // Create graph
            dfs.addEdge(1, 2);
            dfs.addEdge(1, 3);

            dfs.addEdge(2, 4);
            dfs.addEdge(2, 5);
            dfs.addEdge(3, 6);
            dfs.addEdge(3, 7);


            System.out.println("DFS Recursive Traversal:");
            dfs.dfs(1);
        }
    }

