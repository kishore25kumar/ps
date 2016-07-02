package utils.list;

import java.util.*;

public class CartesianProduct<T> {
    public List<List<T>> cartesianProduct(List<T> list, int repeat) {
        List<List<T>> lists = new ArrayList<List<T>>();
        for (int i =0; i < repeat; i += 1) {
            lists.add(new ArrayList<T>(list));
        }

        return cartesianProduct(lists);
    }

    public List<List<T>> cartesianProduct(List<List<T>> lists) {
        List<T> product = new ArrayList<T>();
        List<List<T>> allResults = new ArrayList<List<T>>();
        int startArray = 0;
        cartesianProduct(lists, product, allResults, startArray);
        return allResults;
    }

    private void cartesianProduct(List<List<T>> lists, List<T> product, List<List<T>> allResults, int listIndex) {
        if (lists.size() == 0) {
            return;
        }
        if (listIndex >= lists.size()) {
            allResults.add(new ArrayList<T>(product));
            return;
        }

        List<T> currentList = lists.get(listIndex);
        for (int i = 0; i < currentList.size(); i += 1) {
            product.add(currentList.get(i));
            cartesianProduct(lists, product, allResults, listIndex + 1);
            product.remove(product.size() - 1);
        }
    }
}
