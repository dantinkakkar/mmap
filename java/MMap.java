import java.nio.channels.FileChannel;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;


public class MMap {
    public static void main(String[] args) {
        if (args.length == 0)
            throw new RuntimeException("Expected 1 argument, filename missing");
        if (args.length > 1)
            throw new RuntimeException("Too many arguments");
        final String filename = args[0];
        try (
            final RandomAccessFile randomAccessFile = new RandomAccessFile(new File(filename), "r");
            final FileChannel fileChannel = randomAccessFile.getChannel();
        ) {

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
