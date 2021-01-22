public class toi {
    public static void main(String[] args) {
        solve(10, 'A', 'B', 'C');
    }

    static void solve(int disks, char source, char middle, char destination) {
        if (disks == 0) {
            System.out.println("Plate " + disks + " from " + source + " to " + destination);
            return;
        }

        solve(disks - 1, source, destination, middle);
        System.out.println("Plate " + disks + " from " + source + " to " + destination);
        solve(disks - 1, middle, source, destination);
    }
}
