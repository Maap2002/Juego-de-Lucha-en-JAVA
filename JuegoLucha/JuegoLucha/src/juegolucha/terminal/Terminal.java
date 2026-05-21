package juegolucha.terminal;

public final class Terminal {
    public static final String NARANJA = "\u001B[38;5;208m";
    public static final String RESET = "\u001B[0m";

    private Terminal() {
    }

    public static void println(String texto) {
        System.out.println(NARANJA + texto + RESET);
    }

    public static void print(String texto) {
        System.out.print(NARANJA + texto + RESET);
    }

    public static void printf(String formato, Object... args) {
        System.out.print(NARANJA);
        System.out.printf(formato, args);
        System.out.print(RESET);
    }
}
