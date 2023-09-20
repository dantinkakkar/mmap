public class MMap {
    public static void main(String[] args) {
        if (args.length == 0)
            throw new RuntimeException("Expected 1 argument, filename missing");
        if (args.length > 1)
            throw new RuntimeException("Too many arguments");
        final String filename = args[0];
    }
}
