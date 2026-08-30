class Solution {

    public List<List<String>> findLadders(
        String beginWord,
        String endWord,
        List<String> wordList
    ) {

        List<List<String>> result = new ArrayList<>();

        Set<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord)) {
            return result;
        }

        Map<String, List<String>> parent = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();

        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);
        distance.put(beginWord, 0);

        boolean found = false;

        while (!queue.isEmpty() && !found) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String current = queue.poll();

                int currentDistance = distance.get(current);

                char[] chars = current.toCharArray();

                for (int j = 0; j < chars.length; j++) {

                    char original = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {

                        if (c == original) {
                            continue;
                        }

                        chars[j] = c;

                        String next = new String(chars);

                        if (!words.contains(next)) {
                            continue;
                        }
                        if (!distance.containsKey(next)) {

                            distance.put(next, currentDistance + 1);

                            parent.put(next, new ArrayList<>());
                            parent.get(next).add(current);

                            queue.offer(next);

                            if (next.equals(endWord)) {
                                found = true;
                            }
                        }
                        else if (distance.get(next) == currentDistance + 1) {

                            parent.get(next).add(current);
                        }
                    }

                    chars[j] = original;
                }
            }
        }

        if (!distance.containsKey(endWord)) {
            return result;
        }

        List<String> path = new ArrayList<>();
        path.add(endWord);

        dfs(
            endWord,
            beginWord,
            parent,
            path,
            result
        );

        return result;
    }

    private void dfs(
        String current,
        String beginWord,
        Map<String, List<String>> parent,
        List<String> path,
        List<List<String>> result
    ) {

        if (current.equals(beginWord)) {

            List<String> sequence = new ArrayList<>(path);

            Collections.reverse(sequence);

            result.add(sequence);

            return;
        }

        for (String previous : parent.get(current)) {

            path.add(previous);

            dfs(
                previous,
                beginWord,
                parent,
                path,
                result
            );

            path.remove(path.size() - 1);
        }
    }
}