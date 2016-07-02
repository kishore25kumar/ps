package cci;

public class Insertion51 {
    public int insert(int n, int m, int i, int j) {
        for(int startIndex = i; startIndex <=j; startIndex += 1) {
            int mask = ~(1<<startIndex);
            // Clearing bit startIndex
            n = n & mask;
            int bitStartIndexInM = m & 1;
            mask = bitStartIndexInM << startIndex;
            n = n | mask;
            m = m >> 1;
        }

        return n;
    }

    public int insertM1(int n, int m, int i, int j) {
        int mask = ((1<<(j - i + 1)) - 1) << i;
        n = n & ~mask;
        n = n | (m << i);
        return n;
    }

    public static void main(String[] args) {
        Insertion51 insertion51 = new Insertion51();
        assert insertion51.insert(8, 2, 1, 2) == 12;
        assert insertion51.insertM1(8, 2, 1, 2) == 12;
        assert insertion51.insert(1024, 19, 2, 6) == 1100;
        assert insertion51.insertM1(1024, 19, 2, 6) == 1100;
    }
}
