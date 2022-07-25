package me.px0.fibonacci;

public class InputSupplier {

    private InputSupplier() {}

    public static String getInput() {
        return """
                fibonacci 31
                overlap 2,2 2,7
                fibonacci dd
                fibonacci 120
                overlap 1,1 2,6 7,9 10,20
                stats""";
    }
}
