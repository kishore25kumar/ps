package cci;

public class FlipBitToWin53 {
    public int max1s(Integer value) {
        String bits = Integer.toBinaryString(value);
        int maxCount = 0;
        int count = 0;
        boolean flipped = false;
        int flippedPos = 0;

        for (int i = 0; i < bits.length(); i += 1) {
            if (bits.charAt(i) == '0') {
                if (!flipped) {
                    flipped = true;
                    count += 1;
                    flippedPos = i;
                } else {
                    i = flippedPos;
                    flipped = false;
                    maxCount = Math.max(count, maxCount);
                    count = 0;
                }
            } else {
                count += 1;
            }
        }

        return Math.max(count, maxCount);
    }
}
