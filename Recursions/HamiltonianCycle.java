public class HamiltonianCycle {
    private int numOfVertexes;
    private int[] hamiltonianPath;
    private int[][] adjacencyMatrix;

    public HamiltonianCycle(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.hamiltonianPath = new int[adjacencyMatrix.length];
        this.numOfVertexes = adjacencyMatrix.length;

        this.hamiltonianPath[0] = 0;

    }

    public void solve() {
        if (findFeasibleSolution(1)) {
            showHamiltonianPath();
        } else {
            System.out.println("No feasible solution ...");
        }
    }

    private boolean findFeasibleSolution(int position) {

        if (position == numOfVertexes) {
            // check connects last vertex to first vertex
            if (adjacencyMatrix[hamiltonianPath[position - 1]][hamiltonianPath[0]] == 1) {
                return true;
            } else {
                return false;
            }
        }

        for (int vertexIndex = 1; vertexIndex < numOfVertexes; ++vertexIndex) {
            if (isFeasible(vertexIndex, position)) {
                hamiltonianPath[position] = vertexIndex;

                if (findFeasibleSolution(position + 1)) {
                    return true;
                }

                // Backtrack !!!

            }
        }
        return false;
    }

    private boolean isFeasible(int vertexIndex, int actualPosition) {
        // first creteria : whether two nodes are connected?

        if (adjacencyMatrix[hamiltonianPath[actualPosition - 1]][vertexIndex] == 0) {
            return false;
        }
        // second criteria : whether we visited or not
        for (int i = 0; i < actualPosition; i++) {
            if (hamiltonianPath[i] == vertexIndex) {
                return false;
            }
        }
        return true;
    }

    private void showHamiltonianPath() {
        System.out.println("Hamiltonian Cycle: ");

        for (int i = 0; i < hamiltonianPath.length; i++) {
            System.out.print(hamiltonianPath[i] + " ");
        }
        System.out.print(hamiltonianPath[0]);
    }
}
