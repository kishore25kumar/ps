package tc;

import java.util.*;

public class DNASequence {
    public int longestDNASequence(String sequence) {
        String[] dnaSequenceChars = new String[]{"A", "C", "G", "T"};
        List<String> dnaSequenceCharsArray = Arrays.asList(dnaSequenceChars);
        int maxLength = 0;
        int currentCount = 0;
        for (int i = 0; i < sequence.length(); i += 1) {
            char currentChar = sequence.charAt(i);
            if (currentChar == 'A' || currentChar == 'C' || currentChar == 'G' || currentChar == 'T') {
                currentCount += 1;
            } else {
                if (maxLength < currentCount) {
                    maxLength = currentCount;
                }
                currentCount = 0;
            }
        }
        if (currentCount > maxLength) {
            maxLength = currentCount;
        }

        return maxLength;
    }
}
