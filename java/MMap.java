import java.nio.channels.FileChannel;
import java.nio.MappedByteBuffer;
import java.nio.ByteOrder;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;

public class MMap {

    private static final Integer INT_SIZE_IN_BYTES = 4;

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
            final MappedByteBuffer metadataBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, INT_SIZE_IN_BYTES * 7);
            metadataBuffer.order(ByteOrder.LITTLE_ENDIAN);
            System.out.println("dim: " + metadataBuffer.getInt());
            System.out.println("hidden_dim: " + metadataBuffer.getInt());
            System.out.println("n_layers: " + metadataBuffer.getInt());
            System.out.println("n_heads: " + metadataBuffer.getInt());
            System.out.println("n_kv_heads: " + metadataBuffer.getInt());
            System.out.println("vocab_size: " + metadataBuffer.getInt());
            System.out.println("seq_len: " + metadataBuffer.getInt());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
