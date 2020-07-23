//Gas Station
public class P134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalTank = 0;
        int currTank = 0;
        int startingStation = 0;

        for (int i = 0; i < n; i++) {
            totalTank += gas[i] - cost[i];
            currTank += gas[i] - cost[i];

            if (currTank < 0) {
                startingStation = i + 1;
                currTank = 0;
            }
        }

        return totalTank >= 0 ? startingStation : -1;
    }
}