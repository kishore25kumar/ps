package cci.dp;

import org.junit.*;

import java.util.*;

public class Parens {
    public void printParens(int left, int right, Stack<Character> parens) {
        if (left == 0 && right == 0) {
            System.out.println(parens);
        }

        if (left < right) {
            parens.push('}');
            printParens(left, right - 1, parens);
            parens.pop();
        }

        if (left > 0) {
            parens.push('{');
            printParens(left - 1, right, parens);
            parens.pop();
        }
    }

    @Test
    public void test1() {
        printParens(3, 3, new Stack<Character>());
    }
}
