/**
 * Created by davidzhou on 8/18/16.
 */
public class NestedListWeightSum {
    private int depthSum(NestedInteger nestedList, int current, int depth) {
        if (nestedList.isInteger()) {
            return current + nestedList.getInteger() * depth;
        }
        List<NestedInteger> sublist = nestedList.getList();
        for (NestedInteger nl : sublist) {
            current = depthSum(nl, current, depth + 1);
        }
        return current;
    }
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        int sum = 0;
        for (NestedInteger nl : nestedList) {
            sum = depthSum(nl, sum, 1);
        }
        return sum;
    }
}
