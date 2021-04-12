import java.util.ArrayList;

class CFG_adjList {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        // adj.get(v).add(u);
    }

    static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex" + i);
            System.out.print("head");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> " + adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    static void printCyclo(ArrayList<ArrayList<Integer>> adj) {

    }

    // Driver Code
    public static void main(String[] args) {
        // Creating a graph with 5 vertices
        int V = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        // Adding edges one by one
        System.out.println(adj);
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 7);
        addEdge(adj, 2, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 3, 10);
        addEdge(adj, 4, 5);
        addEdge(adj, 4, 6);
        addEdge(adj, 5, 10);
        addEdge(adj, 6, 10);
        addEdge(adj, 7, 8);
        addEdge(adj, 7, 9);
        addEdge(adj, 8, 10);
        addEdge(adj, 9, 10);

        // printGraph(adj);
        printCyclo(adj);
    }
}