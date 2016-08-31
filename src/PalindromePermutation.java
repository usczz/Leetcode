/**
 * Created by davidzhou on 8/30/16.
 */

import java.util.*;

public class PalindromePermutation {

    // Beats 5.26% submissions
    public boolean canPermutePalindromeV1(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int oddCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer count = map.get(s.charAt(i));
            if (count == null) {
                map.put(s.charAt(i), 1);
                oddCount++;
            } else {
                map.put(s.charAt(i), count + 1);
                oddCount = (count % 2 == 0) ? oddCount + 1 : oddCount - 1;
            }
        }

        return oddCount == 0 || oddCount == 1;
    }

    // Beats 13.63% submission
    public boolean canPermutePalindromeV2(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer cnt = map.get(c);
            if (cnt == null) {
                cnt = 0;
            }
            map.put(c, cnt + 1);
        }
        boolean hasOdd = false;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer cnt = entry.getValue();
            if (cnt % 2 != 0) {
                if (!hasOdd) {
                    hasOdd = true;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    // Beats 34.28% submission
    public boolean canPermutePalindromeV3(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer cnt = map.get(c);
            if (cnt == null) {
                cnt = 0;
            }
            map.put(c, cnt + 1);
        }

        boolean hasOdd = false;
        for(Character c : map.keySet()) {
            if (map.get(c) % 2 == 1) {
                if (!hasOdd) {
                    hasOdd = true;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    // Beats 89.61% submission
    public boolean canPermutePalindromeV4(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        // Assume there are only 256 characters available
        int[] counts = new int[256];
        int odd = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (counts[c] % 2 == 0) {
                odd++;
            } else {
                odd--;
            }
            counts[c]++;
        }
        return odd <= 1;
    }
}
