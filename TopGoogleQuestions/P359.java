import java.util.HashMap;

// Logger Rate Limiter
public class P359 {
    HashMap<String, Integer> dict;

    /** Initialize your data structure here. */
    public P359() {
        dict = new HashMap<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp,
     * otherwise returns false. If this method returns false, the message will not
     * be printed. The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!this.dict.containsKey(message)) {
            this.dict.put(message, timestamp);
            return true;
        }

        Integer oldTimeStamp = this.dict.get(message);
        if (timestamp - oldTimeStamp >= 10) {
            this.dict.put(message, timestamp);
            return true;
        } else {
            return false;
        }
    }
}
