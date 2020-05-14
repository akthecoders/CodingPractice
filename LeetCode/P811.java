import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Subdomain Visit Count
public class P811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<String> ans = new ArrayList<String>();

        for (String s : cpdomains) {
            processDomain(s, map);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue() + " " + entry.getKey());
        }

        return ans;
    }

    public void processDomain(String cpdomain, Map<String, Integer> map) {
        int index = cpdomain.indexOf(' ');
        int times = Integer.valueOf(cpdomain.substring(0, index));
        String domain = cpdomain.substring(index + 1);

        while (domain.indexOf(".") != -1) {
            map.put(domain, map.getOrDefault(domain, 0) + times);
            domain = domain.substring(domain.indexOf(".") + 1, domain.length());
        }
        map.put(domain, map.getOrDefault(domain, 0) + times);
    }
}