public class HamiltonianCycleMain {
    public static void main(String[] args) {

        int[][] matrix = { { 0, 1, 1 }, { 1, 0, 1 }, { 1, 1, 0 } };
        int[][] matrix2 = { { 0, 1, 1, 1, 0, 0 }, { 1, 0, 1, 0, 1, 1 }, { 1, 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 0, 1 },
                { 0, 1, 0, 0, 0, 1 }, { 0, 1, 1, 1, 1, 0 } };
        HamiltonianCycle cycle = new HamiltonianCycle(matrix2);

        cycle.solve();
    }
}
