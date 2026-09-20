class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < words.length) {

            int j = i;
            int lineLength = 0;

            while (j < words.length) {

                int wordLength = words[j].length();

                int requiredLength = lineLength + wordLength + (j - i);

                if (requiredLength > maxWidth) {
                    break;
                }

                lineLength += wordLength;
                j++;
            }
            int numberOfWords = j - i;

            if (j == words.length || numberOfWords == 1) {

                StringBuilder line = new StringBuilder();

                for (int k = i; k < j; k++) {
                    line.append(words[k]);

                    if (k < j - 1) {
                        line.append(" ");
                    }
                }

                while (line.length() < maxWidth) {
                    line.append(" ");
                }

                result.add(line.toString());
            }

            else {

                int totalSpaces = maxWidth - lineLength;

                int gaps = numberOfWords - 1;

                int spacesPerGap = totalSpaces / gaps;

                int extraSpaces = totalSpaces % gaps;

                StringBuilder line = new StringBuilder();

                for (int k = i; k < j; k++) {

                    line.append(words[k]);

                    if (k < j - 1) {

                        int spaces = spacesPerGap;

                        if (k - i < extraSpaces) {
                            spaces++;
                        }

                        for (int s = 0; s < spaces; s++) {
                            line.append(" ");
                        }
                    }
                }

                result.add(line.toString());
            }

            i = j;
        }

        return result;
    }
}