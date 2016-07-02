package tc;

import utils.list.*;

import java.util.*;

public class TopBiologist {
    public String findShortestNewSequence(String sequence) {
        String[] acgt = new String[] {"A", "C", "G", "T"};
        List<String> acgtArray = new ArrayList<String>(Arrays.asList(acgt));
        int start = 1;
        CartesianProduct<String> cartesianProduct = new CartesianProduct<String>();
        while (true) {
            List<List<String>> combinations = cartesianProduct.cartesianProduct(acgtArray, start);
            for (int i = 0; i < combinations.size(); i += 1) {
                List<String> combination = combinations.get(i);
                String combinationString = Arrays.toString(combination.toArray());
                combinationString = combinationString.substring(1, combinationString.length() - 1);
                combinationString = combinationString.replaceAll(" ", "");
                combinationString = combinationString.replaceAll(",", "");
                if(!sequence.contains(combinationString)) {
                    return combinationString;
                }
            }

            start += 1;
        }
    }
}
