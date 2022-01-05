import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        if ((s1 + s2).length() != s3.length()) {
            return false;
        }
        Queue<String[]> queue = new ArrayDeque<>();
        String[] stringSet = new String[]{s1, s2};
        queue.add(stringSet);

        while (s3.length() != 0 && !queue.isEmpty()) {

            List<String[]> list = new ArrayList<>();

            while (!queue.isEmpty()) {
                list.add(queue.poll());
            }

            for (String[] strings : list) {
                if (strings[0].length() > 0 && strings[0].charAt(0) == s3.charAt(0)) {
                    queue.add(new String[]{strings[0].substring(1), strings[1]}.clone());
                }
                if (strings[1].length() > 0 && strings[1].charAt(0) == s3.charAt(0)) {
                    queue.add(new String[]{strings[0], strings[1].substring(1)}.clone());
                }
            }

            if (!queue.isEmpty()) {
                s3 = s3.substring(1);
            }

        }

        return s3.length() == 0;
    }
}

//Failed with time limit exceeded