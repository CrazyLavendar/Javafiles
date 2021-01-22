
import java.util.ArrayList;
import java.util.List;

public class Graph {

    static int CycloMaticComplexity = 0;
    private int v;
    private ArrayList<Integer>[] adjList;

    // Constructor
    public Graph(int vertices) {

        // initialise vertex count
        this.v = vertices;

        // initialise adjacency list
        initAdjList();
    }

    // adjacency list
    @SuppressWarnings("unchecked")
    private void initAdjList() {
        adjList = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    // add edge from u to v
    public void addEdge(int u, int v) {
        // Add v to u's list.
        adjList[u].add(v);
    }

    // 's' to 'd'
    public void printAllPaths(int s, int d) {
        boolean[] isVisited = new boolean[v];
        ArrayList<Integer> pathList = new ArrayList<>();

        // add source to path[]
        pathList.add(s);

        // Call recursive utility
        printAllPathsUtil(s, d, isVisited, pathList);
    }

    private void printAllPathsUtil(Integer u, Integer d, boolean[] isVisited, List<Integer> localPathList) {

        if (u.equals(d)) {
            System.out.println(localPathList);
            // if match found then no need to traverse more till depth
            CycloMaticComplexity++;
            return;
        }

        // Mark the current node
        isVisited[u] = true;

        // adjacent to current vertex
        for (Integer i : adjList[u]) {
            if (!isVisited[i]) {
                // store current node in path[]
                localPathList.add(i);
                printAllPathsUtil(i, d, isVisited, localPathList);

                // remove current node in path[]
                localPathList.remove(i);

            }

        }

        // Mark the current node
        isVisited[u] = false;

    }

    public static void main(String[] args) {

        Graph adj = new Graph(11);
        adj.addEdge(0, 1);
        adj.addEdge(1, 2);
        adj.addEdge(1, 7);
        adj.addEdge(2, 3);
        adj.addEdge(2, 4);
        adj.addEdge(3, 10);
        adj.addEdge(4, 5);
        adj.addEdge(4, 6);
        adj.addEdge(5, 10);
        adj.addEdge(6, 10);
        adj.addEdge(7, 8);
        adj.addEdge(7, 9);
        adj.addEdge(8, 10);
        adj.addEdge(9, 10);

        // source
        int s = 0;

        // destination
        int d = 10;

        System.out.println("List of paths from Start Node " + s + " to End Node " + d);
        adj.printAllPaths(s, d);
        System.out.println("CyclomaticComplexity of the graph (Unique paths) : " + CycloMaticComplexity);
    }
}