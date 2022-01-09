import java.util.*;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        if ((s1 + s2).length() != s3.length()) {
            return false;
        }
        Queue<String> queue = new ArrayDeque<>();
        String strSet = s1 + " " + s2;
        queue.add(strSet);

        while (s3.length() != 0 && !queue.isEmpty()) {

            HashSet<String> set = new HashSet<>();

            while (!queue.isEmpty()) {
                set.add(queue.poll());
            }

            for (String strings : set) {
                String[] stringSet = strings.split(" ");
                if (stringSet.length == 1) {
                    if (stringSet[0].charAt(0) == s3.charAt(0)) {
                        queue.add(stringSet[0].substring(1));
                    }
                } else {
                    if (stringSet[0].length() > 0 && stringSet[0].charAt(0) == s3.charAt(0)) {
                        queue.add(stringSet[0].substring(1) + " " + stringSet[1]);
                    }
                    if (stringSet[1].length() > 0 && stringSet[1].charAt(0) == s3.charAt(0)) {
                        queue.add(stringSet[0] + " " + stringSet[1].substring(1));
                    }
                }
            }

            if (!queue.isEmpty()) {
                s3 = s3.substring(1);
            }

        }

        return s3.length() == 0;
    }
}