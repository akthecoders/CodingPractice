import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * NoOfEmployee
 */
public class NoOfEmployee {
    static Map<String, Integer> result = new HashMap<>();
    public static void main(String[] args) {
        Map<String, String> dataSet = new HashMap<>();
        dataSet.put("A", "C"); 
        dataSet.put("B", "C"); 
        dataSet.put("C", "F"); 
        dataSet.put("D", "E"); 
        dataSet.put("E", "F"); 
        dataSet.put("F", "F"); 
  
        populateResult(dataSet); 
        System.out.println("result = " + result); 
    }

    public static void populateResult(Map<String, String> dataSet) {
        Map<String, List<String>> reverseMap = new HashMap<>();

        for(Map.Entry<String, String> entry: dataSet.entrySet()) {
            String emp = entry.getKey();
            String manager = entry.getValue();
            if(!emp.equals(manager)) {
                List<String> directReportList = reverseMap.get(manager);
                if(directReportList == null) {
                    directReportList = new ArrayList<String>();
                    reverseMap.put(manager, directReportList);
                }
                directReportList.add(emp);
            }
        }
        for (String mngr: dataSet.keySet()) 
            populateResultUtil(mngr, reverseMap); 
    }

    public static int populateResultUtil(String manager, Map<String, List<String>> reverseMap ) {
        int count = 0;
        if(!reverseMap.containsKey(manager)) {
            result.put(manager, 0);
            return 0;
        }
        else if(result.containsKey(manager)) {
            count = result.get(manager);
        }
        else {
            List<String> directReportEmployee = reverseMap.get(manager);
            count = directReportEmployee.size();
            for (String directReportEmp: directReportEmployee) 
               count +=  populateResultUtil(directReportEmp, reverseMap); 
            
           result.put(manager, count); 
        }
        return count;
    }
}