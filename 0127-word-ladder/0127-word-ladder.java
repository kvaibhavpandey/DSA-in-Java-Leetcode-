
import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int steps = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int j = 0; j < size; j++) {
                String word = queue.poll();

                if (word.equals(endWord)) {
                    return steps;
                }

                char[] arr = word.toCharArray();

                for (int i = 0; i < arr.length; i++) {
                    char original = arr[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        arr[i] = ch;
                        String newWord = new String(arr);

                        if (words.contains(newWord)) {
                            queue.offer(newWord);
                            words.remove(newWord);
                        }
                    }

                    arr[i] = original;
                }
            }

            steps++;
        }

        return 0;
    }
}
