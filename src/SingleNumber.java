/**
 * Created by davidzhou on 9/23/16.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
