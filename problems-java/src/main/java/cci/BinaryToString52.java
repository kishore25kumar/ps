package cci;

public class BinaryToString52 {
    private Integer getIntegerValue(double value) {
        int largest32BitNumber = Integer.MAX_VALUE;
        while (true) {
            if ((int) value - value == 0) {
                break;
            }

            value = value * 10;
            if ((int) value > largest32BitNumber) {
                break;
            }
        }

        if ((int) value > largest32BitNumber) {
            return null;
        } else {
            return (int)value;
        }
    }
    public String convert(double value) {
        Integer intValue = getIntegerValue(value);
        if (intValue == null) {
            return "ERROR";
        } else {
            String output = "";
            while (intValue > 0) {
                output = Integer.toString(intValue & 1) + output;
                intValue = intValue >> 1;
            }

            return output;
        }
    }
}
