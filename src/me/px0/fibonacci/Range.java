package me.px0.fibonacci;

public class Range {
    private final int start;
    private final int end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public boolean overlaps(Range other) {
        return start <= other.start && end >= other.start ||
                start <= other.end && end >= other.end ||
                start >= other.start && end >= other.end ||
                start <= other.start && end <= other.end;
    }
}
