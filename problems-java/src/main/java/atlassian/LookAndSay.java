package atlassian;

import org.junit.*;

public class LookAndSay {
    public String lookAndSay(String inputString) {
        if (inputString.isEmpty()) {
            return "";
        }

        StringBuilder output = new StringBuilder();
        Character currentCharacter = inputString.charAt(0);
        int currentCharCount = 1;
        for (int i = 1; i < inputString.length(); i += 1) {
            if (inputString.charAt(i) == currentCharacter) {
                currentCharCount += 1;
            } else {
                output.append(Integer.toString(currentCharCount));
                output.append(currentCharacter);
                currentCharacter = inputString.charAt(i);
                currentCharCount = 1;
            }
        }
        output.append(Integer.toString(currentCharCount));
        output.append(currentCharacter);

        return output.toString();
    }

    public String lookAndSay(String inputString, int n) {
        String output = inputString;
        for(int i = 0; i < n; i += 1) {
            output = lookAndSay(output);
        }

        return output;
    }

    @Test
    public void test1() {
        System.out.println(lookAndSay("1", 5));
    }
}
