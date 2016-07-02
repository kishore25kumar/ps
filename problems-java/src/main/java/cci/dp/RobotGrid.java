package cci.dp;

import org.junit.*;

import java.util.*;

public class RobotGrid {
    public boolean pathExists(int row, int column, boolean[][] isVisited, boolean[][] graph, List<String> route, int maxRows, int maxColumns) {
        if (row == maxRows - 1 && column == maxColumns - 1) {
            return true;
        }

        if (row >= maxRows || column >= maxColumns || isVisited[row][column] || !graph[row][column]) {
            return false;
        }

        route.add(row + " " + column);
        isVisited[row][column] = true;

        boolean solution = pathExists(row + 1, column, isVisited, graph, route, maxRows, maxColumns);

        if (solution) {
            return solution;
        }

        solution = pathExists(row, column + 1, isVisited, graph, route, maxRows, maxColumns);

        if (solution) {
            return solution;
        }

        route.remove(route.size() - 1);

        return false;
    }

    @Test
    public void test1() {
        boolean[][] graph = new boolean[][] {
                {true, false, true},
                {true, true, false},
                {true, true, true}
        };

        boolean[][] isVisited = new boolean[][] {
                {false, false, false},
                {false, false, false},
                {false, false, false}
        };

        List<String> route = new ArrayList<String>();

        pathExists(0, 0, isVisited, graph, route, 3, 3);

        System.out.println(route);
    }
}
