package atlassian;

import org.junit.*;

import java.util.*;

public class Robot {
    public String getBlocks(String input) {
        int[] counts = new int[10];
        Arrays.fill(counts, 0);
        int robotPosition = 0;
        boolean hasBlock = false;

        for(int i = 0; i < input.length(); i += 1) {
            char currentChar = input.charAt(i);

            switch (currentChar) {
            case 'P':
                robotPosition = 0;
                hasBlock = true;
                break;

            case 'M':
                if (robotPosition >= 0 && robotPosition < 9) {
                    robotPosition += 1;
                }
                break;

            case 'L':
                if (counts[robotPosition] < 15 && hasBlock) {
                    counts[robotPosition] += 1;
                    hasBlock = false;
                }
                break;

            default:
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        Character[] hex = new Character[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        for(int i = 0; i < 10; i += 1) {
            sb.append(hex[counts[i]]);
        }

        return sb.toString();
    }

    @Test
    public void test1() {
        System.out.println(getBlocks("PLPLPLPLPLPLPLPLPLPL"));
    }
}
