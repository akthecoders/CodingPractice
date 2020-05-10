import java.util.HashSet;
import java.util.List;

//Destination City
public class P1436 {
    public String destCity(List<List<String>> paths) {
        HashSet<String> set = new HashSet<>();
        for (List<String> l : paths) {
            set.add((String) l.get(0));
        }
        String destination = "";
        for (List<String> l : paths) {
            if (!set.contains((String) l.get(1))) {
                destination = (String) l.get(1);
                break;
            }
        }
        return destination;
    }
}