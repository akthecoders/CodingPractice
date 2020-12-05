import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class PrimeAirRoute {
    static class PairRoute {
        int id;
        int dist;

        public PairRoute(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }
    public static void main(String [] args) {
        List<PairRoute> forwardRouteListTC1 = new ArrayList<>();
        forwardRouteListTC1.add(new PairRoute(1, 2000));
        forwardRouteListTC1.add(new PairRoute(2, 4000));
        forwardRouteListTC1.add(new PairRoute(3, 6000));
        
        List<PairRoute> returnRouteListTC1 = new ArrayList<>();
        returnRouteListTC1.add(new PairRoute(1, 2000));
        
        
        List<PairRoute> output = optimizeRoutes(forwardRouteListTC1, returnRouteListTC1, 7000);
        
        System.out.println("TC1 output is: ");
        for(PairRoute single : output) {
            System.out.println(single.id + ", " + single.dist);
        }
    }

    public static List<PairRoute> optimizeRoutes(List<PairRoute> forwardRoutes, List<PairRoute> backwardRoutes, int totalCapacity) {
        List<PairRoute> result = new ArrayList<>();

        TreeMap<Integer, List<PairRoute>> map = new TreeMap<>();
        
        for(PairRoute forwardRoute: forwardRoutes) {
            for(PairRoute backwardRoute: backwardRoutes) {
                int total = forwardRoute.dist + backwardRoute.dist;
                if(total <= totalCapacity) {
                    map.putIfAbsent(total, new ArrayList<>());
                    map.get(total).add(new PairRoute(forwardRoute.id, backwardRoute.id));
                }
            }
        }
        try {
            result = map.lastEntry().getValue();
        }
        catch (Exception e) {
            System.out.println("No output");
        }
        return result;
    }
}
