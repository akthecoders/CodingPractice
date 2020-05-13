import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Reorder Data in Log Files
public class P937 {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLog = new ArrayList<>();
        List<String> numberLog = new ArrayList<>();
        
        for(String log: logs) {
            if(isLetterLog(log)) {
                letterLog.add(log);
            }
            else {
                numberLog.add(log);
            }
        }
        
        Collections.sort(letterLog, (a, b) -> {
            String a1 = removeTags(a);
            String a2 = removeTags(b);
            
            if(a1.equals(a2)) {
                return a.compareTo(b);
            }
            
            return a1.compareTo(a2);
        });
        
        List<String> output = new ArrayList<>();
        output.addAll(letterLog);
        output.addAll(numberLog);
        return output.toArray(new String[logs.length]);
    }
    
    public boolean isLetterLog(String log) {
        String firstLogItem = log.split(" ")[1];
        return firstLogItem.charAt(0) - 'a' >= 0 && firstLogItem.charAt(0) - 'a' <= 26;
    }
    
    public String removeTags(String log) {
        String[] parts = log.split(" ");
        StringBuffer sb = new StringBuffer("");
        
        for (int i = 1; i < parts.length; ++i) {
            sb.append(parts[i]);
            
            if (i != parts.length - 1) {
                sb.append(" ");
            }
        }
        
        return sb.toString();
    }
}