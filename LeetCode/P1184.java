// Distance Between Bus Stops
public class P1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start == destination)
            return 0;
        int n = distance.length;
        if (start > destination) {
            int t = start;
            start = destination;
            destination = t;
        }
        int cs = 0, acs = 0;
        for (int i = start; i < destination; i++)
            cs += distance[i];

        while (destination != start) {
            acs += distance[destination];
            destination = (destination + 1) % n;
        }

        if (cs > acs)
            return acs;
        else
            return cs;
    }
}