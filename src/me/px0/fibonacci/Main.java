package me.px0.fibonacci;

import java.util.*;

class Main {
    public static final String FIB = "fibonacci";
    public static final String OVR = "overlap";
    public static final String STS = "stats";

    private static class Range {
        private final int start;
        private final int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean overlaps(Range other) {
            return start <= other.start && end >= other.start || start <= other.end && end >= other.end || start >= other.start && end >= other.end || start <= other.start && end <= other.end;
        }
    }

    public static String getInput() {
        return "";
    }

    public static void main(String args[]) {
        // Output the solution to the console
        System.out.println(codeHere(getInput()));
    }
    public static String codeHere(String inputData) {
        Map<String, Integer> counts = new HashMap<>();
        counts.put(FIB, 0);
        counts.put(OVR, 0);
        List<String> output = new ArrayList<>();

        Arrays.stream(inputData.split("\n")).forEach(line -> {
            String[] args = line.split(" ");
            if (FIB.equals(args[0])) {
                increment(counts, FIB);
                output.add(fibonacci(args[1]));
            } else if (OVR.equals(args[0])) {
                increment(counts, OVR);
                output.add(overlap(line.substring(8)));
            } else if (STS.equals(args[0])) {
                output.add(stats(counts));
            }
        });

        return String.join("", output);
    }

    public static String fibonacci(String inputString) {
        int number = 0;
        try {
            number = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            return "error\n";
        }
        if (number <= 0)
            return "error\n";

        StringBuilder output = new StringBuilder();
        int num1 = 0, num2 = 1;
        int counter = 0;

        while (num1 <= number) {
            output.append(num1).append(" ");
            int num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
            counter = counter + 1;
        }

        return output.substring(0, output.length()-1) + "\n";
    }

    public static String overlap(String inputString) {
        String[] inputArray = inputString.split(" ");
        List<Range> ranges = new ArrayList<>();

        for (int i = 0; i < inputArray.length; i++) {
            String[] range = inputArray[i].split(",");
            try {
                ranges.add(new Range(Integer.parseInt(range[0]), Integer.parseInt(range[1])));
            } catch (NumberFormatException e) {
                return "error\n";
            }
        }
        String output = "false\n";

        for (int i = 0; i < ranges.size(); i++) {
            for (int j = i+1; j < inputArray.length; j++) {
                if (ranges.get(i).overlaps(ranges.get(j))) {
                    output = "true\n";
                    break;
                }
            }
            if (output.equals("true\n"))
                break;
        }
        return output;
    }

    public static String stats(Map<String, Integer> counts) {
        return counts.get(FIB) + " " + counts.get(OVR);
    }

    public static void increment(Map<String, Integer> counts, String method) {
        counts.put(method, counts.get(method) + 1);
    }

}