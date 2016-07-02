package atlassian;

import org.junit.*;

import java.util.*;

public class Validation {
    public String validator(String input) {
        String errorOutput = "0:0:0:format_error";
        if (!input.contains("~n")) {
            return errorOutput;
        }

        if (!(input.charAt(input.length() - 1) == 'n' && input.charAt(input.length() - 2) == '~')) {
            return errorOutput;
        }

        input = input.substring(0, input.length() - 2);

        String[] records = input.split("~n");
        int emptyCount = 0;
        String fieldsRecord = records[0].substring(1, records[0].length() - 1);
        String[] fieldNames = split(fieldsRecord);
        int fieldsCount = fieldNames.length;
        int maxFields = fieldsCount;
        int[] recordValuesCount = new int[records.length - 1];

        for (int i = 1; i < records.length; i += 1) {
            String record = records[i].substring(1, records[i].length() - 1);
            String[] values =split(record);

            maxFields = values.length > maxFields ? values.length : maxFields;
            recordValuesCount[i - 1] = values.length;
            for (int j = 0; j < values.length; j += 1) {
                if (values[j].isEmpty()) {
                    emptyCount += 1;
                }
            }
        }

        for (int i = 0; i < recordValuesCount.length; i += 1) {
            emptyCount += maxFields - recordValuesCount[i];
        }

        String lastFieldName = fieldNames[fieldNames.length - 1];

        if (maxFields - fieldsCount > 0) {
            lastFieldName = fieldNames[fieldNames.length - 1] + "_" + Integer.toString(maxFields - fieldsCount);
        }

        return Integer.toString(records.length - 1) + ":" + Integer.toString(maxFields) + ":" + Integer.toString(emptyCount) + ":" + lastFieldName;
    }

    public boolean areFieldNamesValid(String[] fieldNames) {
        HashSet<String> set = new HashSet<String>();
        for(int i = 0; i < fieldNames.length; i += 1) {
            if (fieldNames[i].isEmpty()) {
                return false;
            }

            if (set.contains(fieldNames[i])) {
                return false;
            } else {
                set.add(fieldNames[i]);
            }
        }

        return true;
    }

    public String[] split(String record) {
        String[] values = record.split("\\|(?!\\~\\|)");
        if (values.length == 0) {
            return new String[0];
        }
        List<String> valuesList = new ArrayList<String>();
        StringBuilder value = new StringBuilder(values[0]);
        for (int i = 1; i < values.length; i += 1) {
            if (value.charAt(value.length() - 1) == '~') {
                value.append("|");
                value.append(values[i]);
            } else {
                valuesList.add(value.toString());
                value = new StringBuilder(values[i]);
            }
        }

        valuesList.add(value.toString());

        return valuesList.toArray(new String[valuesList.size()]);
    }

    @Test
    public void test1() {
        System.out.println(validator("|name|address|~n|Partric|pat~|GR|pat|~n|Anne||anni|~n"));
    }
}
