package tc;

import java.util.*;

public class Lottery {
    class Result {
        public String name;
        public long combinations;
        public Result(String name, long combinations) {
            this.name = name;
            this.combinations = combinations;
        }
    }

    public String[] sortByOdds(String[] rules) {
        int length = rules.length;
        Result[] results = new Result[length];
        for(int i = 0; i < length; i += 1) {
            String[] components = rules[i].split(":");
            String name = components[0];
            String rule = components[1].trim();
            String[] ruleComponents = rule.split(" ");
            int choices = Integer.parseInt(ruleComponents[0]);
            int blanks = Integer.parseInt(ruleComponents[1]);
            String sorted = ruleComponents[2];
            String unique = ruleComponents[3];
            long combinations;
            if (sorted.equals("F") && unique.equals("F")) {
                combinations = (long) Math.pow(choices, blanks);
            } else if (sorted.equals("F")  && unique.equals("T")) {
                combinations = ncr(choices, blanks) * factorial(blanks);
            } else if (sorted.equals("T") && unique.equals("T")) {
                combinations = ncr(choices, blanks);
            } else {
                combinations = ncr(choices + blanks - 1, blanks);
            }

            results[i] = new Result(name, combinations);
        }

        Arrays.sort(results, new Comparator<Result>() {
            public int compare(final Result result, final Result t1) {
                if (result.combinations - t1.combinations > 0) {
                    return 1;
                } else if (result.combinations - t1.combinations < 0) {
                    return -1;
                } else {
                    return result.name.compareTo(t1.name);
                }
            }
        });

        String[] output = new String[length];

        for(int i = 0; i < results.length; i += 1) {
            output[i] = results[i].name;
            System.out.println(output[i] + " " + results[i].combinations);
        }

        return output;
    }

    private long factorial(int n) {
        long fact = 1;
        for (int i = n; i >= 2; i -= 1) {
            fact = fact * i;
        }
        return fact;
    }

    private long ncr(int n, int r) {
        long res = 1;
        for (int i = 0; i < r; i += 1) {
            res *= (n - i);
            res /= (i + 1);
        }

        return res;
    }
}