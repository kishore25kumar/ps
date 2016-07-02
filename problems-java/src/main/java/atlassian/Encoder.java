package atlassian;

import org.junit.*;

public class Encoder {
    public String encode(long number) {
        Character[] encodingChars = new Character[] {'0', 'a', 't', 'l', 's', 'i', 'n'};
        StringBuilder sb = new StringBuilder();

        while (number > 0) {
            long remainder = number % 7;
            sb.append(encodingChars[(int) remainder]);
            number = number / 7;
        }

        return sb.reverse().toString();
    }

    @Test
    public void test1() {
        System.out.println(encode(0));
    }
}
