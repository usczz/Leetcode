/**
 * Created by davidzhou on 8/17/16.
 */
public class ReverseString {
    private void swap(char[] buffer, int left, int right) {
        char tmp = buffer[left];
        buffer[left] = buffer[right];
        buffer[right] = tmp;
    }

    public String reverseString(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        char[] buffer= s.toCharArray();
        int left = 0, right = buffer.length - 1;
        while (left < right) {
            swap(buffer, left++, right--);
        }
        return new String(buffer);
    }
}
