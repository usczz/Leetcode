/**
 * Created by davidzhou on 8/18/16.
 */

import java.util.*;

public class LoggerRateLimiter {
    private Map<String, Integer> map;
    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
        map = new HashMap<String, Integer>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer lastTimeStamp = map.get(message);
        if (lastTimeStamp == null) {
            map.put(message, timestamp);
            return true;
        }

        if (lastTimeStamp <= timestamp - 10) {
            map.put(message, timestamp);
            return true;
        }

        return false;
    }
}
