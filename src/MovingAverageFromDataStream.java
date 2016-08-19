/**
 * Created by davidzhou on 8/18/16.
 */

import java.util.*;

public class MovingAverageFromDataStream {
    private Deque<Integer> queue;
    private int currentSum;
    private int size;
    /** Initialize your data structure here. */
    public MovingAverageFromDataStream(int size) {
        queue = new LinkedList<Integer>();
        currentSum = 0;
        this.size = size;
    }

    public double next(int val) {
        if (queue.size() >= size) {
            Integer first = queue.pollFirst();
            currentSum -= first;
        }
        queue.offerLast(val);
        currentSum += val;

        return currentSum / (queue.size() + 0.0);
    }
}
